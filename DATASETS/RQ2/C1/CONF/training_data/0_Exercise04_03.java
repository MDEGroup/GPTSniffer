import java.lang.Math;

public class CityArea {
   public static void main(String[] args) {
      // GPS coordinates for the four cities
      double atlantaLat = 33.8901000;
      double atlantaLong = -84.2782200;
      double orlandoLat = 28.4283959;
      double orlandoLong = -81.5197542;
      double savannahLat = 32.1081500;
      double savannahLong = -81.1746100;
      double charlotteLat = 35.2072400;
      double charlotteLong = -80.9567600;

      // Earth's radius in miles
      double radius = 3958.8;

      // Calculate the distances between each pair of cities using the haversine formula
      double atlantaOrlando = radius * Math.acos(Math.sin(Math.toRadians(atlantaLat)) * Math.sin(Math.toRadians(orlandoLat)) + Math.cos(Math.toRadians(atlantaLat)) * Math.cos(Math.toRadians(orlandoLat)) * Math.cos(Math.toRadians(atlantaLong - orlandoLong)));
      double atlantaSavannah = radius * Math.acos(Math.sin(Math.toRadians(atlantaLat)) * Math.sin(Math.toRadians(savannahLat)) + Math.cos(Math.toRadians(atlantaLat)) * Math.cos(Math.toRadians(savannahLat)) * Math.cos(Math.toRadians(atlantaLong - savannahLong)));
      double atlantaCharlotte = radius * Math.acos(Math.sin(Math.toRadians(atlantaLat)) * Math.sin(Math.toRadians(charlotteLat)) + Math.cos(Math.toRadians(atlantaLat)) * Math.cos(Math.toRadians(charlotteLat)) * Math.cos(Math.toRadians(atlantaLong - charlotteLong)));
      double orlandoSavannah = radius * Math.acos(Math.sin(Math.toRadians(orlandoLat)) * Math.sin(Math.toRadians(savannahLat)) + Math.cos(Math.toRadians(orlandoLat)) * Math.cos(Math.toRadians(savannahLat)) * Math.cos(Math.toRadians(orlandoLong - savannahLong)));
      double orlandoCharlotte = radius * Math.acos(Math.sin(Math.toRadians(orlandoLat)) * Math.sin(Math.toRadians(charlotteLat)) + Math.cos(Math.toRadians(orlandoLat)) * Math.cos(Math.toRadians(charlotteLat)) * Math.cos(Math.toRadians(orlandoLong - charlotteLong)));
      double savannahCharlotte = radius * Math.acos(Math.sin(Math.toRadians(savannahLat)) * Math.sin(Math.toRadians(charlotteLat)) + Math.cos(Math.toRadians(savannahLat)) * Math.cos(Math.toRadians(charlotteLat)) * Math.cos(Math.toRadians(savannahLong - charlotteLong)));

      // Use Heron's formula to calculate the area of the triangle formed by the three closest cities
      double s = (atlantaOrlando + atlantaSavannah + orlandoSavannah) / 2;
      double triangleArea = Math.sqrt(s * (s - atlantaOrlando) * (s - atlantaSavannah) * (s - orlandoSavannah));

      // Use the trapezoid formula to calculate the area of the trapezoid formed by the four cities
      double trapezoidArea = (atlantaCharlotte + charlotteSavannah) * triangleArea / 2;

      // Print the estimated area of the trapezoid
      System.out.println("Estimated area enclosed by the four cities: " + trapezoidArea + " square miles");
   } }