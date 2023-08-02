
public class SortCities {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the name of the first city: ");
        String city1 = scanner.nextLine();

        System.out.print("Enter the name of the second city: ");
        String city2 = scanner.nextLine();

        System.out.print("Enter the name of the third city: ");
        String city3 = scanner.nextLine();

        
        String temp;

        if (city1.compareTo(city2) > 0) {
            temp = city1;
            city1 = city2;
            city2 = temp;
        }

        if (city2.compareTo(city3) > 0) {
            temp = city2;
            city2 = city3;
            city3 = temp;
        }

        if (city1.compareTo(city2) > 0) {
            temp = city1;
            city1 = city2;
            city2 = temp;
        }

        
        System.out.printf("The cities in alphabetical order are %s, %s, and %s\n", city1, city2, city3);

        scanner.close();
    }
}
