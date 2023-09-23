
package Controller;

import Model.ReportStudent;
import Model.Student;
import View.Validate;
import java.rmi.StubNotFoundException;
import java.util.ArrayList;
import java.util.Collections;


public class StudentManage {

    public void Menu() {
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");
        System.out.print("Enter your choice you want: ");
    }
    
    
    public  void createStudent(int count, ArrayList<Student> ls) {
        if(count > 10) {
            System.out.println("Do you want to continue(Y/N): ");
        }
        if(!Validate.checkInputYN()) {
            return;
        }
         while(true) {
            System.out.print("Enter id: ");
            String Id = Validate.checkInputString();
            System.out.print("Enter student name: ");
            String Name = Validate.checkInputString();
            
            
            if(!Validate.checkIdExist(ls, Id, Name)) {
                System.err.println("Id has exist student. Please input again");
                System.out.println("Enter again");
            }
             System.out.print("Enter semester: ");
             String semester = Validate.checkInputString();
             System.out.print("Enter name course: ");
             String course = Validate.checkInputCourse();
             if(Validate.checkExistStudent(ls, Id, Name, semester, course)) {
                 ls.add(new Student(Id, Name, semester, course));
                 count++;
                 System.out.println("Add student successful.");
                 return;
             }
             System.err.println("It is duplicate!!!!");
        }
    
   }
    
    public void FindAndSort(ArrayList<Student> ls) {
        if(ls.isEmpty()) {
            System.err.println("List is Empty");
            return;
        }
        ArrayList<Student> listStudentFindByName = listStudentFindByName(ls);
        if(listStudentFindByName.isEmpty()) {
            System.err.println("It is not exist.");
        } else {
            Collections.sort(listStudentFindByName);
            System.out.printf("%-20s%-20s%-20s\n", "Student name", "semester", "Course name");
            for (Student student : listStudentFindByName) {
                student.toString();
            }
        }
    } 
    
    public ArrayList<Student> listStudentFindByName(ArrayList<Student> ls) {
        ArrayList<Student> listStudentFindByName = new ArrayList<>();
        System.out.print("Enter name to search");
        String name = Validate.checkInputString();
        for (Student student : ls) {
            if(student.getStudentName().contains(name)) {
                listStudentFindByName.add(student);
            }
        }
        return listStudentFindByName;    
    }
    
    
    public void updateOrDelete(int count, ArrayList<Student> ls) {
        if(ls.isEmpty()) {
            System.err.println("List empty");
            return;
        }
        System.out.print("Enter id");
        String id = Validate.checkInputCourse();
        ArrayList<Student> listStudentFindByName = getListStudentById(ls, id);
        if(listStudentFindByName.isEmpty()) {
            System.err.println("Not found");
            return;
        } else {
            Student student = getStudentByListFound(listStudentFindByName);
            System.out.print("Do you want to Update(u) of Delete(d) : ");
            if(Validate.checkInputUD()) {
                System.out.print("Enter id");
                String idstudent = Validate.checkInputString();
                System.out.print("Enter name student: ");
                String name = Validate.checkInputString();
                System.out.print("Enter semester");
                String semester = Validate.checkInputString();
                System.out.print("Enter name course: ");
                String course = Validate.checkInputCourse();
                
                if(!Validate.checkChangeInformation(student, id, name, semester, course)) {
                    System.err.println("No change");
                }
                
                if(Validate.checkExistStudent(ls, id, name, semester, course)) {
                    student.setID(id);
                    student.setStudentName(name);
                    student.setSemester(semester);
                    student.setCourseName(course);
                    System.out.println("Update successful.");
                    
                }
                return;
            } else {
                ls.remove(student);
                count--;
                System.out.println("Delete successful");
                return;
            }
        }
    }
    
    
    
    public Student getStudentByListFound(ArrayList<Student> listStudentFindByName) {
        System.out.println("List student found");
        int count = 1;
        System.out.printf("%-15s%-15s%-15s%-15s\n", "Number", "Student Name", "Semester", "Course Name");
        for (Student student : listStudentFindByName) {
            System.out.printf("%-15d%-15s%-15s%-15s\n", count, student.getStudentName(), student.getSemester(), student.getCourseName());
            count++;
        }
        System.out.print("Enter student");
        int choice = Validate.checkInputIntLimit(1, listStudentFindByName.size());
        return listStudentFindByName.get(choice - 1);
    }
    
    
    public ArrayList<Student> getListStudentById(ArrayList<Student> ls, String id) {
        ArrayList<Student> getListStudentById = new ArrayList<>();
        for (Student student : ls) {
            if(id.equalsIgnoreCase(id)) {
                getListStudentById.add(student);
            }
        }
        return getListStudentById;
    }
    
    public void report(ArrayList<Student> ls) {
        if (ls.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        ArrayList<ReportStudent> lrs = new ArrayList<>();
        int size = ls.size();
        for(int i = 0; i < size; i++) {
            int total = 0;
            for (Student student : ls) {
                String id = student.getID();
                String courseName = student.getCourseName();
                String studentName = student.getStudentName();
                for (Student studentCountTotal : ls) {
                    if(id.equalsIgnoreCase(studentCountTotal.getID()) && courseName.equalsIgnoreCase(studentCountTotal.getCourseName())) {
                        total++;
                    }
                }
                if(Validate.checkReportExist(lrs, id, courseName, total)) {
                    lrs.add(new ReportStudent(student.getStudentName(), studentName, total));
                }
            }
        }
        
        for(int i = 0; i < lrs.size(); i++) {
            System.out.printf("%-15s|%-15s|%-10d\n", lrs.get(i).getStudentName(), lrs.get(i).getCourseName(), lrs.get(i).getTotalCourse());
        }
    }
   
}
