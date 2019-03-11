import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Student {
    String nameOfTheStudent;
    double studentCGPA;
    int token;
    public Student(String nameOfTheStudent, double studentCGPA, int token) {
        this.nameOfTheStudent = nameOfTheStudent;
        this.studentCGPA = studentCGPA;
        this.token = token;
    }

    @Override
    public String toString() {
        return nameOfTheStudent;
    }
}

class MyComperator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.studentCGPA < o2.studentCGPA) {
            return 1;
        } else if (o1.studentCGPA > o2.studentCGPA) {
            return -1;
        } else if (o1.studentCGPA == o2.studentCGPA) {

            int nameVal = o1.nameOfTheStudent.compareTo(o2.nameOfTheStudent);

            if (nameVal != 0)
                return nameVal;

            else if (nameVal == 0) {//students having same name and same CGPA

                if (o1.token < o2.token) return -1;
                else return 1;
            }
        }
        return 0;
    }
}

public class QueueServing {
    public static void main(String[] args) {
        int testCases;
        Scanner scanner = new Scanner(System.in);


        testCases = scanner.nextInt();
        scanner.nextLine();
        Queue<Student> priQueue = new PriorityQueue<>(testCases, new MyComperator());
        for (int i = 0; i < testCases; i++) {
            String inputString = scanner.nextLine();
            boolean servedNow = hasToServed(inputString);
            if (servedNow) {

                Object obj = priQueue.poll();
                if (obj == null) {
                    System.out.println("EMPTY");
                }

            } else {
                if (!inputString.isEmpty() && inputString != null) {
                    String[] splittedString = inputString.split("\\s");
                    priQueue.add(new Student(splittedString[1], Double.parseDouble(splittedString[2]), Integer.parseInt(splittedString[3])));
                }
            }
        }

        if (priQueue.size() > 0) {
            for (Student student : priQueue) {
                System.out.println(student);
            }
        } else {
            System.out.println("EMPTY");
        }


    }

    private static boolean hasToServed(String input) {
        if (!input.isEmpty() && input != null) {
            if (input.equals("SERVED")) return true;
        }

        return false;
    }
}
