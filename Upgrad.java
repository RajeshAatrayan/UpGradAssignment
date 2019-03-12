import java.util.*;


class Student implements Comparable < Student >
{
  int priorityNumber;
  String studentName;
  double cgpa;

  public Student (String studname, double cgpa, int id)
  {
    super ();
    this.priorityNumber = id;
    this.studentName = studname;
    this.cgpa = cgpa;
  }

  public int getPriorityNumber ()
  {
    return priorityNumber;
  }

  public String getStudentName ()
  {

    return studentName;
  }

  public double getCgpa ()
  {
    return cgpa;
  }

  public int compareTo (Student s)
  {

    if (Double.compare (this.cgpa, s.cgpa) != 0)
    {
      return -Double.compare (this.cgpa, s.cgpa);
    }

    else if (this.studentName.compareTo(s.studentName) != 0)
    {
      if (this.studentName.compareTo(s.studentName) > 0)
      return 1;

      else
      return -1;
    }

    else
    return Integer.compare (this.priorityNumber, s.priorityNumber);

  }

}



class QueueStudent
{
  public static void main (String[]args)
  {
    Scanner input = new Scanner (System.in);
    int totalEvents = Integer.parseInt (input.nextLine ());
    PriorityQueue < Student > priorityOfStudent = new PriorityQueue < Student > ();

    while (totalEvents > 0)
    {
      String str = input.next ();

      if (str.compareTo ("SERVED") == 0)
      {
        Student s = priorityOfStudent.poll ();
      }

      else
      {
        String name = input.next ();
        double cgpa = input.nextDouble ();
        int priorityNumber = input.nextInt ();
        Student stud = new Student (name, cgpa, priorityNumber);
        priorityOfStudent.add (stud);
      }

      totalEvents--;
    }

    if (priorityOfStudent.isEmpty ())
    System.out.println ("EMPTY");

    else
    {
      while (!priorityOfStudent.isEmpty ())
      {
        Student s = priorityOfStudent.poll ();
        System.out.println (s.studentName);
      }
    }

  }

}
