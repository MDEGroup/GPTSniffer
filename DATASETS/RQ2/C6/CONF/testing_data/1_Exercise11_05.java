



public class nan{
    
    public static void main(String[] args) {
        Course course = new Course("Linear Algebra");
        String studentName = "Bob Bobberton";
        String studentName2 = "Tori Toriton";
        String studentName3 = "Kelly Kellyton";
        String studentName4 = "Tod Todderton";

        course.addStudent(studentName);
        course.addStudent(studentName2);
        course.addStudent(studentName3);
        course.addStudent(studentName4);

        course.dropStudent(studentName);

    }
}
