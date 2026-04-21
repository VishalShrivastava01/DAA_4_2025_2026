import java.util.*;

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name);
    }
}

public class StudentManager {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        students.add(new Student(id, name));
        System.out.println("Student added successfully!");
    }

    static void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        int key = sc.nextInt();

        for (Student s : students) {   
            if (s.id == key) {
                System.out.println("Student found:");
                s.display();
                return;
            }
        }

        System.out.println("Student not found.");
    }


    public static void main(String[] args) {
        while (true) {
            System.out.println("===== Student Record Manager =====");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    searchStudent();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
