



public class Staff extends Employee {

    private String title;

    public Staff(String office, double salary, MyDate dateHired, String title) {
        super(office, salary, dateHired);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Staff setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public String toString() {
        return "Staff.class: { " +
                "Name= " + getName()  +
                '}';
    }
}
