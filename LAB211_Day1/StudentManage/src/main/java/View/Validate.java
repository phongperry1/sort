
package View;

import Model.ReportStudent;
import Model.Student;
import java.util.ArrayList;
import java.util.Scanner;


public class Validate {
    public static int checkInputIntLimit(int min, int max) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if(result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input in rage " + min + " and " + max);
                System.out.println("Enter again");
            }
        }
    }
    
    public static String checkInputString() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String result = sc.nextLine().trim();
            if(result.isEmpty()) {
                System.err.println("String is not empty");
                System.out.println("Enter again");
            } else {
                return result;
            }
        }
    }
    
    public static boolean checkInputYN() {
        while(true) {
            String result = checkInputString();
            if(result.equalsIgnoreCase("Y")) {
                return true;
                
            }
            if(result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y (or Y) or n(or N)");
            System.out.println("Enter again");
        }
    }
    
    public static boolean checkInputUD() {
        while(true) {
            String result = checkInputString();
            if(result.equalsIgnoreCase("U")) {
                return true;
            } 
            if(result.equalsIgnoreCase("D")) {
                return false;
            }
            System.err.println("Please input u (or U) or d (or D)");
            System.out.println("Enter again");
        }
    }
    
    
    public static String checkInputCourse() {
        while(true) {
            String result = checkInputString();
            if(result.equalsIgnoreCase("java") || result.equalsIgnoreCase(".net") || result.equalsIgnoreCase("c/c++")) {
                return result;
            }
            System.err.println("Only three courses: Java, .net and c/c++");
            System.out.println("Enter again: ");
        }
    }
    
    public static boolean checkExistStudent(ArrayList<Student> ls , String id , String studentName, String semester, String courseName) {
        int size = ls.size();
        for (Student student : ls) {
            if(id.equalsIgnoreCase(student.getID()) && studentName.equalsIgnoreCase(student.getStudentName()) && semester.equalsIgnoreCase(student.getSemester()) && courseName.equalsIgnoreCase(student.getCourseName())) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean checkReportExist(ArrayList<ReportStudent> lrs, String name, String course, int total ) {
        for (ReportStudent report : lrs) {
            if(name.equalsIgnoreCase(report.getStudentName()) && course.equalsIgnoreCase(report.getCourseName()) && total == report.getTotalCourse()) {
                return false;
            }
        }
        return true;
    }
    
    
    public static boolean checkIdExist(ArrayList<Student> ls , String id, String name) {
        for (Student student : ls) {
            if(id.equalsIgnoreCase(student.getID()) && !name.equalsIgnoreCase(student.getStudentName())) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean checkChangeInformation(Student student, String id, String name, String semester, String course) {
        if(id.equalsIgnoreCase(student.getID()) && name.equalsIgnoreCase(student.getStudentName()) && semester.equalsIgnoreCase(student.getSemester()) && course.equalsIgnoreCase(student.getCourseName())) {
            return false;
        }
        return true;
    }
}