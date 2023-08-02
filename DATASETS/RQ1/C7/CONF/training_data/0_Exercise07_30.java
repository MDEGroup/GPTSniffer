public static boolean isConsecutiveFour(int[] values) {
if (values.length < 4) { 
return false;
}
for (int i = 0; i <= values.length - 4; i++) {
if (values[i] == values[i+1] && values[i+1] == values[i+2] && values[i+2] == values[i+3]) {
return true;
}
}
return false;
}


    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the number of values: ");
    int size = input.nextInt();
    int[] values = new int[size];
    System.out.print("Enter the values: ");
    for (int i = 0; i < size; i++) {
    values[i] = input.nextInt();
    }
    if (isConsecutiveFour(values)) {
    System.out.println("The list has consecutive fours");
    } else {
    System.out.println("The list does not have consecutive fours");
    }
    }
