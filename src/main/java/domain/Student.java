package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studentname;
    private int fee;
    private String course;

    public Student(){

    }
    public Student(Long id,String studentname,int fee,String course){
        super();
        this.id=id;
        this.studentname=studentname;
        this.course=course;
        this.fee=fee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentname='" + studentname + '\'' +
                ", fee=" + fee +
                ", course='" + course + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return fee == student.fee && Objects.equals(id, student.id) && Objects.equals(studentname, student.studentname) && Objects.equals(course, student.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentname, fee, course);
    }

}
