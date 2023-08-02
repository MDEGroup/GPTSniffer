try {
    int decimal = bin2Dec("1010");
    System.out.println(decimal); // Output: 10
    decimal = bin2Dec("1234");
    System.out.println(decimal);
} catch (NumberFormatException e) {
    System.out.println(e.getMessage()); // Output: Invalid binary string: 1234
}