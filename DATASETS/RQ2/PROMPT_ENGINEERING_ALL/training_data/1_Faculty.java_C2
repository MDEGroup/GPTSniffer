

import ch_10.exercise10_14.MyDate;


public class Faculty extends Employee {

    private double[] officeHours;
    private int rank;

    public int getRank() {
        return rank;
    }

    public Faculty(double[] officeHours, int rank) {
        super("Philadelphia,PA", 90_000.00, new MyDate());
        this.officeHours = officeHours;
        this.rank = rank;
    }


    public Faculty setRank(int rank) {
        this.rank = rank;
        return this;
    }

    public double[] getOfficeHours() {
        return officeHours;
    }

    public Faculty setOfficeHours(double[] officeHours) {
        this.officeHours = officeHours;
        return this;
    }

    @Override
    public String toString() {
        return "Faculty.class:{ " +
                "Name = " + this.getName() +
                " }";
    }

}
