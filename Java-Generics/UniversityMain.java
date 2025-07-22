abstract class CourseType {
    String name;
    CourseType(String name) { this.name = name; }
    public String toString() { return name; }
}

class ExamCourse extends CourseType {
    ExamCourse(String name) { super(name); }
}

class AssignmentCourse extends CourseType {
    AssignmentCourse(String name) { super(name); }
}

class ResearchCourse extends CourseType {
    ResearchCourse(String name) { super(name); }
}

import java.util.*;

class Course<T extends CourseType> {
    private List<T> courseList = new ArrayList<>();
    void addCourse(T course) { courseList.add(course); }
    List<T> getCourses() { return courseList; }

    static void showCourses(List<? extends CourseType> courses) {
        for (CourseType c : courses) System.out.println(c);
    }
}

public class UniversityMain {
    public static void main(String[] args) {
        Course<ExamCourse> examCourses = new Course<>();
        examCourses.addCourse(new ExamCourse("Data Structures"));
        examCourses.addCourse(new ExamCourse("Algorithms"));

        Course.showCourses(examCourses.getCourses());
    }
}
