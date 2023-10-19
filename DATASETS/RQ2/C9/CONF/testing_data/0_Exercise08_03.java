public class Student {
    private String name;
    private int numCorrectAnswers;

    public Student(String name, int numCorrectAnswers) {
        this.name = name;
        this.numCorrectAnswers = numCorrectAnswers;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumCorrectAnswers() {
        return this.numCorrectAnswers;
    }

    public void setNumCorrectAnswers(int numCorrectAnswers) {
        this.numCorrectAnswers = numCorrectAnswers;
    }

    @Override
    public String toString() {
        return this.name + " - " + this.numCorrectAnswers + " correct answers";
    }
}