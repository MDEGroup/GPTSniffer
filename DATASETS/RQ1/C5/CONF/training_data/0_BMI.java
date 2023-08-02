public class BMI {
   private String name;
   private int age;
   private double weight; 
   private double height; 
   private double feet; 
   private double inches; 
   
   public BMI(String name, int age, double weight, double height) {
      this.name = name;
      this.age = age;
      this.weight = weight;
      this.height = height;
   }
   
   public BMI(String name, int age, double weight, double feet, double inches) {
      this.name = name;
      this.age = age;
      this.weight = weight;
      this.feet = feet;
      this.inches = inches;
      this.height = (feet * 12) + inches;
   }
   
   public double getBMI() {
      double bmi = weight / Math.pow(height, 2) * 703;
      return Math.round(bmi * 100) / 100.0;
   }
   
   public String getStatus() {
      double bmi = getBMI();
      if (bmi < 18.5)
         return "Underweight";
      else if (bmi < 25)
         return "Normal";
      else if (bmi < 30)
         return "Overweight";
      else
         return "Obese";
   }
   
   public String getName() {
      return name;
   }
   
   public int getAge() {
      return age;
   }
   
   public double getWeight() {
      return weight;
   }
   
   public double getHeight() {
      return height;
   }
   
   public double getFeet() {
      return feet;
   }
   
   public double getInches() {
      return inches;
   }
}
