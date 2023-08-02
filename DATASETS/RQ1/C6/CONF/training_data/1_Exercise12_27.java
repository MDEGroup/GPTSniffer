


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FileRenamer{
    private static final Pattern PATTERN = Pattern.compile("Exercise\\d_\\d");
    private static final String PREFIX = "Exercise";
    private static Logger logger = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Usage: java FileRenamer*");
            return;
        }
        if (!args[0].equals("*")) {
            System.out.println("Usage: java FileRenamer*");
            return;
        }

        File file = new File(".");
        if (file.list().length > 0) {
            ArrayList<File> files = new ArrayList<>(Arrays.asList(file.listFiles()));
            for (File f : files) {
                if (!f.getName().equalsIgnoreCase("Exercise12_27.java")) {
                    ArrayList<String> lines = new ArrayList<>();
                    try (Scanner fileIn = new Scanner(f)) {
                        while (fileIn.hasNextLine()) {
                            lines.add(fileIn.nextLine().trim());
                        }
                        lines = handleRename(lines);

                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                    try (PrintWriter printWriter = new PrintWriter(f)) {
                        for (String line : lines) {
                            printWriter.println(line);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

            }
        } else {
            System.out.println("The current directory is empty.");
        }

    }

    private static ArrayList<String> handleRename(ArrayList<String> lines) {
        ArrayList<String> nuList = new ArrayList<>();
        for (String line : lines) {
            if (PATTERN.matcher(line).matches()) { 
                
                StringBuffer stringBuffer = new StringBuffer(line.substring(line.lastIndexOf('e') + 1));
                stringBuffer.insert(0, 0);
                stringBuffer.insert(stringBuffer.length() - 1, 0); 
                nuList.add(PREFIX + stringBuffer.toString());
                logger.log(Level.INFO, PREFIX + stringBuffer.toString());
            } else {
                nuList.add(line);
            }

        }
        return nuList;
    }
}
