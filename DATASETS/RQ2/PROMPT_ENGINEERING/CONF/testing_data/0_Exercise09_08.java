public class FanTest {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setSpeed(3);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true);

        Fan fan2 = new Fan();
        fan2.setSpeed(2);
        fan2.setRadius(5);
        fan2.setColor("blue");
        fan2.setOn(false);

        System.out.println("Fan 1 details: ");
        System.out.println("Speed: " + fan1.getSpeed());
        System.out.println("Radius: " + fan1.getRadius());
        System.out.println("Color: " + fan1.getColor());
        System.out.println("Fan is on? " + fan1.isOn());

        System.out.println("\nFan 2 details: ");
        System.out.println("Speed: " + fan2.getSpeed());
        System.out.println("Radius: " + fan2.getRadius());
        System.out.println("Color: " + fan2.getColor());
        System.out.println("Fan is on? " + fan2.isOn());
    }
}

class Fan {
    private int speed;
    private boolean on;
    private double radius;
    private String color;

    public Fan() {
        speed = 1;
        on = false;
        radius = 5;
        color = "white";
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int newSpeed) {
        speed = newSpeed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean status) {
        on = status;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double newRadius) {
        radius = newRadius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String newColor) {
        color = newColor;
    }
}