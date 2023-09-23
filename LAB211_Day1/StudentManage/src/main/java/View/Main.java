
package View;

import Controller.StudentManage;
import Model.Student;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> ls = new ArrayList<>();
        Validate validation = new Validate();
        StudentManage sm = new StudentManage();
        ls.add(new Student("1", "Linh", "Spring", "java"));
        ls.add(new Student("2", "Phong", "Fall", "c/c++"));
        ls.add(new Student("3", "Huy", "Summer", ".net"));
        int count = 3;
        while(true) {
            sm.Menu();
            int choice = validation.checkInputIntLimit(1, 5);
            switch(choice) {
                case 1:
                    sm.createStudent(count, ls);
                    break;
                case 2:
                    sm.FindAndSort(ls);
                    break;
                case 3:
                    sm.updateOrDelete(count, ls);
                    break;
                case 4:
                    sm.report(ls);
                    break;
                case 5:
                    return;
            }
                    
            
        }
                
                
    }
}
