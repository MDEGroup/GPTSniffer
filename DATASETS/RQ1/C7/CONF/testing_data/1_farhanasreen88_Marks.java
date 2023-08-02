public class Marks {
    private int[] marks;
    private int numdata;

    public Marks() {
        numdata = 0;
    }

    public Marks(int num) {
        marks = new int[num];
        numdata = num;
    }

    public void createData(int num) {
        marks = new int[num];
        numdata = num;
    }

    public float calcAvg() {
        float sum = 0;
        for (int i = 0; i < numdata; i++) {
            sum += marks[i];
        }
        float avg = sum / numdata;
        return avg;
    }

    public void setMark(int mark, int index) throws Exception {
        if (mark < 0)
            throw new Exception("Mark is incorrect");

        this.marks[index] = mark;
    }

    public float getMark(int index) {
        return marks[index];
    }
}
