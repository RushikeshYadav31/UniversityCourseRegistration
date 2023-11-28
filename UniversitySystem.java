package university_course_system;
import java.util.*;

public class UniversitySystem {

    private List<Student> students;
    private List<Course> courses;
    private List<Enrollment> enrollments;

    public UniversitySystem() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
        enrollments = new ArrayList<>();
    }

    public void registerStudent(Student student) {
        students.add(student);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void enrollStudentInCourse(Student student, Course course) {
        Enrollment enrollment = new Enrollment(student, course);
        enrollments.add(enrollment);
    }

    public void updateEnrollmentDetails(Student student, Course course, String updatedDetails) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudent().equals(student) && enrollment.getCourse().equals(course)) {
                enrollment.getCourse().setCourseName(updatedDetails);
                System.out.println("Enrollment updated successfully ");
              //  return;
            }
        }
        System.out.println("Enrollment NOT found for the given student and course.");
    }

    public void deleteEnrollment(Student student, Course course) {
        Enrollment enrollRemove = null;
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudent().equals(student) && enrollment.getCourse().equals(course)) {
                enrollRemove = enrollment;
                break;
            }
        }
        if (enrollRemove != null) {
            enrollments.remove(enrollRemove);
            System.out.println("Enrollment deleted successfully.");
        } else {
            System.out.println("Enrollment not found for the given student and course.");
        }
    }

    public List<Course> getCoursesForStudent(Student student) {
        List<Course> studentCourses = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudent().equals(student)) {
                studentCourses.add(enrollment.getCourse());
            }
        }
        return studentCourses;
    }

    public static void main(String[] args) {
        UniversitySystem universitySystem = new UniversitySystem();

        Student s1 = new Student(1, "ABC");
        Student s2 = new Student(2, "PQR");

        Course course1 = new Course(101, "JAVA");
        Course course2 = new Course(102, "MySQL");

        universitySystem.registerStudent(s1);
        universitySystem.registerStudent(s2);

        universitySystem.addCourse(course1);
        universitySystem.addCourse(course2);

        universitySystem.enrollStudentInCourse(s1, course1);
        universitySystem.enrollStudentInCourse(s1, course2);
        universitySystem.enrollStudentInCourse(s2, course1);

        System.out.println("Courses enrolled by " + s1.getStudName());
        List<Course> student1Courses = universitySystem.getCoursesForStudent(s1);
        for (Course course : student1Courses) {
            System.out.println(course.getCourseName());
        }

        System.out.println("Update enrollment !!");
        universitySystem.updateEnrollmentDetails(s1, course1, "Updated for MySQL");

        System.out.println("Delete enrollment !!");
        universitySystem.deleteEnrollment(s1, course1);

        System.out.println("Courses enrolled by " + s1.getStudName() + " after deletion:");
        student1Courses = universitySystem.getCoursesForStudent(s1);
        for (Course course : student1Courses) {
            System.out.println(course.getCourseName());
        }
    }
}


