public class ThreeDeePoint extends Point {
    private int z;

    // public ThreeDeePoint(int x, int y, int z) {
    //     this.setX(x);
    //     this.setY(y);

    //     this.z = z;
    // }

    public ThreeDeePoint(int x, int y, int z) {
        super(x, y);

        this.z = z;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public String toString() {
        return "(" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")"; 
    }

    public double distanceFromOrigin() {
        return Math.sqrt(this.getX()*this.getX()+this.getY()*this.getY()+z*z);
    }
}
