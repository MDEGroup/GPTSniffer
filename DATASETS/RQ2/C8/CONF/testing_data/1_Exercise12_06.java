public class HexStringChecker {  public static void main(String[] args) {    String hex1 = "AF71Z";    String hex2 = "AB8C";    try {       System.out.println("The decimal value for hex1 number "          + hex1 + " is " + Hex2Dec.hexToDecimal(hex1.toUpperCase()));    } catch (NumberFormatException nfe) {      System.out.println(nfe);    }    try {      System.out.println("The decimal value for hex2 number "          + hex2 + " is " + Hex2Dec.hexToDecimal(hex2.toUpperCase()));    } catch (NumberFormatException nfe) {      System.out.println(nfe);    }  }}