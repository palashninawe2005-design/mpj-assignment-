
class Student {
    String name;
    int grade;


    public Student(String studentName, int studentGrade) {
        name = studentName;
        grade = studentGrade;
    }


    public void introduce() {
        System.out.println("Hi, I'm " + name + " and I am in grade " + grade + ".");
    }
}

public class Main {
    public static void main(String[] args) {
        // 4. Object Creation: Creating actual instances of the Student class
        Student student1 = new Student("Alice", 10);
        Student student2 = new Student("Bob", 12);

        // Calling the method on our objects
        student1.introduce();
        student2.introduce();
    }
}
