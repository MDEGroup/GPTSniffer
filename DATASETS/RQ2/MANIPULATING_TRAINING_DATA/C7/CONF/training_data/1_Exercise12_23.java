



public class WebScraper {

    public static void main(String[] args) {
        double total = 0, average = 0;
        int count = 0;
        try {

            URL url = new URL("https:
            try (Scanner in = new Scanner(url.openStream())) {
                while (in.hasNext()) {
                    double score;
                    String nxtStr = in.next();
                    if (Character.isDigit(nxtStr.charAt(0))) {
                        score = Double.parseDouble(nxtStr);
                        count++;
                        total += score;
                    }
                }
                System.out.println("The total is " + total);
                average = total / count;
                System.out.printf("The average score was %.2f%n", average);

            } catch (IOException ioe) {
                ioe.printStackTrace();
            }


        } catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
        }

    }
}
