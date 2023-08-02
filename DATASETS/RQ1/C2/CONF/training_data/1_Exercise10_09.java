

import java.util.Arrays;
import java.util.Objects;


public class Exercise10_09 {
    public static void main(String[] args) {
        Course statistics = new Course("Statistics 341");
        statistics.addStudent("Jillian Frometorgai");
        statistics.addStudent("Shrezen Maticut");
        statistics.addStudent("Phi Wazi");
        statistics.dropStudent("Jillian Frometorgai");

        System.out.println("Students in the course " + statistics.getCourseName() + " are: ");
        for (String s : statistics.getStudents()) {
            if (Objects.nonNull(s)) {
                System.out.print(s + " ");
            }
        }
    }
}

class Course {
    private String courseName;
    private String[] students = new String[100];
    private int numberOfStudents;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(String student) {
        if (student.length() < (numberOfStudents + 1)) {
            students = Arrays.copyOf(students, students.length * 2);
        }
        students[numberOfStudents] = student;
        numberOfStudents++;
        System.out.println("Added student: " + student + " to the course: " + getCourseName());
    }

    public String[] getStudents() {
        return students;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public String getCourseName() {
        return courseName;
    }

    
    public void dropStudent(String student) {
        for (int i = 0; i < numberOfStudents; i++) {
            if (students[i].equals(student)) {
                students[i] = null;
                break;
            }
        }
        System.out.println("Dropped student: " + student + " has been dropped from " + getCourseName());
    }

    
    protected void clear() {
        Arrays.fill(students, null);
    }


}