


public class TemperatureConverter{
    public static void main(String[] args) {
        System.out.print("Celsius     ");
        System.out.print("Fahrenheit     ");
        System.out.print("|     Fahrenheit     ");
        System.out.println("Celsius   ");
        System.out.print("-------------------------------------------------------");
        double celsius = 40.0;
        double fahrenheit = 120.0;

        while (celsius >= 31.0 && fahrenheit >= 30.0) {
            System.out.println();
            System.out.printf("%-12.1f%-14.1f", celsius, celsiusToFahrenheit(celsius));
            System.out.printf(" |%10.1f%15.2f", fahrenheit, fahrenheitToCelsius(fahrenheit));

            celsius -= 1.0;
            fahrenheit -= 10.0;

        }
    }

    
    public static double celsiusToFahrenheit(double celsius) {
        return (9.0 / 5) * celsius + 32;
    }

    
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (5.0 / 9) * (fahrenheit - 32);
    }
}