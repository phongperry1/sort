
package Model;


public class Student implements Comparable<Student>{
    private String ID;
    private String StudentName;
    private String semester;
    private String CourseName;

    public Student() {
    }

    public Student(String ID, String StudentName, String semester, String CourseName) {
        this.ID = ID;
        this.StudentName = StudentName;
        this.semester = semester;
        this.CourseName = CourseName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    @Override
    public String toString() {
        return "Student " + "ID : " + ID + "; StudentName : " + StudentName + "; semester : " + semester + "; CourseName : " + CourseName;
    }

    @Override
    public int compareTo(Student o) {
        return o.StudentName.compareTo(this.StudentName);
    }
    
    
    
}
