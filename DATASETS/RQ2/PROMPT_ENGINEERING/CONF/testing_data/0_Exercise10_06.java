public class PrimeNumbers {
    public static void main(String[] args) {
        StackOfIntegers primeStack = new StackOfIntegers(); // Creating a stack to store prime numbers
        
        // Loop through numbers from 2 to 119
        for (int i = 2; i < 120; i++) {
            if (isPrime(i)) {
                primeStack.push(i); // If it's prime, push it onto the stack
            }
        }
        
        System.out.println("Prime numbers less than 120 in decreasing order:");
        
        // Pop and display prime numbers from the stack in reverse order
        while (!primeStack.isEmpty()) {
            System.out.print(primeStack.pop() + " ");
        }
    }
    
    // Method to check if a number is prime
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false; // It's not prime if it's divisible by any number other than 1 and itself
            }
        }
        
        return true; // It's prime if it's not divisible by any number other than 1 and itself
    }
}