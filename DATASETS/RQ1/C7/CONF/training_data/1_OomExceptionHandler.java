
public class OomExceptionHandler implements Thread.UncaughtExceptionHandler {

  private static final String FILENAME = "out-of-memory.hprof";

  public static void install(Context context) {
    Thread.UncaughtExceptionHandler defaultHandler = Thread.getDefaultUncaughtExceptionHandler();
    if (defaultHandler instanceof OomExceptionHandler) {
      return;
    }
    OomExceptionHandler oomHandler = new OomExceptionHandler(defaultHandler, context);
    Thread.setDefaultUncaughtExceptionHandler(oomHandler);
  }

  private final Thread.UncaughtExceptionHandler defaultHandler;
  private final Context context;

  public OomExceptionHandler(Thread.UncaughtExceptionHandler defaultHandler, Context context) {
    this.defaultHandler = defaultHandler;
    this.context = context.getApplicationContext();
  }

  @Override public void uncaughtException(Thread thread, Throwable ex) {
    if (containsOom(ex)) {
      File heapDumpFile = new File(context.getFilesDir(), FILENAME);
      try {
        Debug.dumpHprofData(heapDumpFile.getAbsolutePath());
      } catch (Throwable ignored) {
      }
    }
    defaultHandler.uncaughtException(thread, ex);
  }

  private boolean containsOom(Throwable ex) {
    if (ex instanceof OutOfMemoryError) {
      return true;
    }
    while ((ex = ex.getCause()) != null) {
      if (ex instanceof OutOfMemoryError) {
        return true;
      }
    }
    return false;
  }
}
