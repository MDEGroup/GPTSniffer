



public class Celsius2Fahrenheit{
	public static void main(String[]args) {
		double Celsius; 
		double Fahrenheit;
		
		System.out.println("Enter degrees in Celsius");
		Scanner input = new Scanner(System.in);
		Celsius = input.nextDouble();
		
		Fahrenheit = (9.0/5.0 * Celsius + 32);

		System.out.println(Fahrenheit);
		
		input.close();
	}
}
