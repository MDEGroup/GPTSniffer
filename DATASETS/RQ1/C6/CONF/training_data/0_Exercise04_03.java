import java.lang.Math;

public class CityArea {
   public static void main(String[] args) {
      
      double atlantaLat = 33.8901000;
      double atlantaLong = -84.2782200;
      double orlandoLat = 28.4283959;
      double orlandoLong = -81.5197542;
      double savannahLat = 32.1081500;
      double savannahLong = -81.1746100;
      double charlotteLat = 35.2072400;
      double charlotteLong = -80.9567600;

      
      double radius = 3958.8;

      
      double atlantaOrlando = radius * Math.acos(Math.sin(Math.toRadians(atlantaLat)) * Math.sin(Math.toRadians(orlandoLat)) + Math.cos(Math.toRadians(atlantaLat)) * Math.cos(Math.toRadians(orlandoLat)) * Math.cos(Math.toRadians(atlantaLong - orlandoLong)));
      double atlantaSavannah = radius * Math.acos(Math.sin(Math.toRadians(atlantaLat)) * Math.sin(Math.toRadians(savannahLat)) + Math.cos(Math.toRadians(atlantaLat)) * Math.cos(Math.toRadians(savannahLat)) * Math.cos(Math.toRadians(atlantaLong - savannahLong)));
      double atlantaCharlotte = radius * Math.acos(Math.sin(Math.toRadians(atlantaLat)) * Math.sin(Math.toRadians(charlotteLat)) + Math.cos(Math.toRadians(atlantaLat)) * Math.cos(Math.toRadians(charlotteLat)) * Math.cos(Math.toRadians(atlantaLong - charlotteLong)));
      double orlandoSavannah = radius * Math.acos(Math.sin(Math.toRadians(orlandoLat)) * Math.sin(Math.toRadians(savannahLat)) + Math.cos(Math.toRadians(orlandoLat)) * Math.cos(Math.toRadians(savannahLat)) * Math.cos(Math.toRadians(orlandoLong - savannahLong)));
      double orlandoCharlotte = radius * Math.acos(Math.sin(Math.toRadians(orlandoLat)) * Math.sin(Math.toRadians(charlotteLat)) + Math.cos(Math.toRadians(orlandoLat)) * Math.cos(Math.toRadians(charlotteLat)) * Math.cos(Math.toRadians(orlandoLong - charlotteLong)));
      double savannahCharlotte = radius * Math.acos(Math.sin(Math.toRadians(savannahLat)) * Math.sin(Math.toRadians(charlotteLat)) + Math.cos(Math.toRadians(savannahLat)) * Math.cos(Math.toRadians(charlotteLat)) * Math.cos(Math.toRadians(savannahLong - charlotteLong)));

      
      double s = (atlantaOrlando + atlantaSavannah + orlandoSavannah) / 2;
      double triangleArea = Math.sqrt(s * (s - atlantaOrlando) * (s - atlantaSavannah) * (s - orlandoSavannah));

      
      double trapezoidArea = (atlantaCharlotte + charlotteSavannah) * triangleArea / 2;

      
      System.out.println("Estimated area enclosed by the four cities: " + trapezoidArea + " square miles");
   } }