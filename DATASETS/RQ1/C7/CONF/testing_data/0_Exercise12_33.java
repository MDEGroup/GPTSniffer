
public class WebCrawler {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a URL: ");
    String url = input.nextLine();
    crawler(url); 
  }

  public static void crawler(String startingURL) {
    Queue<String> queue = new LinkedList<>();
    Set<String> set = new HashSet<>();

    queue.offer(startingURL);
    while (!queue.isEmpty()) {
      String urlString = queue.poll();
      if (!set.contains(urlString)) {
        set.add(urlString);
        System.out.println("Craw " + urlString);

        String word = "Computer Programming";
        if (containsWord(urlString, word)) {
          System.out.println("The word \"" + word + "\" is found at " + urlString);
          return;
        }

        for (String s : getSubUrls(urlString)) {
          if (!set.contains(s)) {
            queue.offer(s);
          }
        }
      }
    }
  }

  public static boolean containsWord(String urlString, String word) {
    try {
      URL url = new URL(urlString);
      Scanner input = new Scanner(url.openStream());
      while (input.hasNext()) {
        String line = input.nextLine();
        if (line.contains(word)) {
          return true;
        }
      }
      input.close();
    } catch (Exception ex) {
      System.out.println("Error: " + ex.getMessage());
    }
    return false;
  }

  public static ArrayList<String> getSubUrls(String urlString) {
    ArrayList<String> list = new ArrayList<>();
    try {
      URL url = new URL(urlString);
      Scanner input = new Scanner(url.openStream());
      int current = 0;
      while (input.hasNext()) {
        String line = input.nextLine();
        current = line.indexOf("http:", current);
        while (current > 0) {
          int endIndex = line.indexOf("\"", current);
          if (endIndex > 0) { 
            list.add(line.substring(current, endIndex));
            current = line.indexOf("http:", endIndex);
          } else {
            current = -1;
          }
        }
      }
      input.close();
    } catch (Exception ex) {
      System.out.println("Error: " + ex.getMessage());
    }
    return list;
  }
}
