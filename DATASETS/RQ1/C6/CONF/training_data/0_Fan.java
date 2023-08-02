--------------------------------
|            Fan               |
--------------------------------
| - SLOW: int = 1              |
| - MEDIUM: int = 2            |
| - FAST: int = 3              |
| - speed: int = SLOW          |
| - on: boolean = false        |
| - radius: double = 5.0       |
| - color: String = "blue"     |
--------------------------------
| + getSpeed(): int            |
| + setSpeed(speed: int): void |
| + isOn(): boolean            |
| + setOn(on: boolean): void   |
| + getRadius(): double        |
| + setRadius(radius: double): void |
| + getColor(): String         |
| + setColor(color: String): void |
| + Fan()                      |
| + toString(): String         |
--------------------------------
 public class Fan {
    
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;

    
    private int speed;
    private boolean on;
    private double radius;
    private String color;

    
    public Fan() {
        speed = SLOW;
        on = false;
        radius = 5.0;
        color = "blue";
    }

    
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    
    public String toString() {
        if (on) {
            return "speed=" + speed + ", color=" + color + ", radius=" + radius;
        } else {
            return "color=" + color + ", radius=" + radius + ", fan is off";
        }
    }
}