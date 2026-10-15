package src;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    static boolean studentIdExists(ArrayList<Student> students, int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Student Performance Tracking ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Exit");
            System.out.println("4. Search Student");
            System.out.println("5. Update Student");
            System.out.println("6. Delete Student");
            System.out.println("7. Sort Students by Marks");
            System.out.println("8. Performance Report");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    if (id <= 0) {
                        System.out.println("ID must be positive.");
                        break;
                    }

                    if (studentIdExists(students, id)) {
                        System.out.println("Student ID already exists.");
                        break;
                    }

                    sc.nextLine();

                    System.out.print("Enter name: ");
                    String name = sc.nextLine().trim();

                    if (name.isEmpty()) {
                        System.out.println("Name cannot be empty.");
                        break;
                    }

                    System.out.print("Enter marks: ");
                    double marks = sc.nextDouble();

                    if (!Double.isFinite(marks) || marks < 0 || marks > 100) {
                        System.out.println("Marks must be between 0 and 100.");
                        break;
                    }

                    students.add(new Student(id, name, marks));
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        System.out.println("\nStudent Records:");

                        for (Student student : students) {
                            System.out.println(student);
                        }

                        System.out.println("Total Students: " + students.size());
                    }
                    break;

                case 3:
                    System.out.println("Exiting application...");
                    sc.close();
                    return;

                case 4:
                    System.out.print("Enter student ID to search: ");
                    int searchId = sc.nextInt();

                    boolean found = false;

                    for (Student student : students) {
                        if (student.getId() == searchId) {
                            System.out.println("Student found:");
                            System.out.println(student);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter student ID to update: ");
                    int updateId = sc.nextInt();

                    Student studentToUpdate = null;

                    for (Student student : students) {
                        if (student.getId() == updateId) {
                            studentToUpdate = student;
                            break;
                        }
                    }

                    if (studentToUpdate == null) {
                        System.out.println("Student not found.");
                        break;
                    }

                    sc.nextLine();

                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine().trim();

                    if (newName.isEmpty()) {
                        System.out.println("Name cannot be empty.");
                        break;
                    }

                    System.out.print("Enter new marks: ");
                    double newMarks = sc.nextDouble();

                    if (!Double.isFinite(newMarks)
                            || newMarks < 0 || newMarks > 100) {
                        System.out.println("Marks must be between 0 and 100.");
                        break;
                    }

                    studentToUpdate.setName(newName);
                    studentToUpdate.setMarks(newMarks);

                    System.out.println("Student updated successfully!");
                    break;

                case 6:
                    System.out.print("Enter student ID to delete: ");
                    int deleteId = sc.nextInt();

                    Student studentToDelete = null;

                    for (Student student : students) {
                        if (student.getId() == deleteId) {
                            studentToDelete = student;
                            break;
                        }
                    }

                    if (studentToDelete == null) {
                        System.out.println("Student not found.");
                    } else {
                        students.remove(studentToDelete);
                        System.out.println("Student deleted successfully!");
                    }
                    break;

                case 7:
                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                        break;
                    }

                    students.sort(
                        Comparator.comparingDouble(Student::getMarks)
                                  .reversed()
                    );

                    System.out.println("Students sorted by marks:");

                    for (Student student : students) {
                        System.out.println(student);
                    }
                    break;

                case 8:
                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                        break;
                    }

                    double totalMarks = 0;
                    int passed = 0;

                    Student highest = students.get(0);
                    Student lowest = students.get(0);

                    for (Student student : students) {
                        double studentMarks = student.getMarks();
                        totalMarks += studentMarks;

                        if (studentMarks >= 40) {
                            passed++;
                        }

                        if (studentMarks > highest.getMarks()) {
                            highest = student;
                        }

                        if (studentMarks < lowest.getMarks()) {
                            lowest = student;
                        }
                    }

                    double average = totalMarks / students.size();

                    System.out.println("\n=== Performance Report ===");
                    System.out.println("Total students: " + students.size());
                    System.out.printf("Average marks: %.2f%n", average);
                    System.out.println("Passed: " + passed);
                    System.out.println(
                        "Failed: " + (students.size() - passed)
                    );
                    System.out.println("Highest scorer: " + highest);
                    System.out.println("Lowest scorer: " + lowest);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
