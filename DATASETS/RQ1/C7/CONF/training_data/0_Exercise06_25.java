public static String convertMillis(long millis) {
    
    long totalSeconds = millis / 1000;

    
    int hours = (int) (totalSeconds / 3600);

    
    int minutes = (int) ((totalSeconds % 3600) / 60);

    
    int seconds = (int) (totalSeconds % 60);

    
    return hours + ":" + minutes + ":" + seconds;
}
