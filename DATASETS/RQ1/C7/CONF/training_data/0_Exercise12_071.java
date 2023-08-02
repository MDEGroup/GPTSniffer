try {
    int decimal = bin2Dec("1010");
    System.out.println(decimal); 
    decimal = bin2Dec("1234");
    System.out.println(decimal);
} catch (NumberFormatException e) {
    System.out.println(e.getMessage()); 
}
