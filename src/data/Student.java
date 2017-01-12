package data;


/**
 * Created by laura on 12.01.17.
 */
public class Student {

    @Override
    public String toString() {
        return "Student{" +
                "prename='" + prename + '\'' +
                ", surname='" + surname + '\'' +
                ", studentNumber=" + studentNumber +
                ", DegreeProgram=" + degreeProgram +
                ", gender=" + gender +
                '}';
    }

    public Student(String prename, String surname, int studentNumber, DegreeProgram degreeProgram, int gender) {
        this.prename = prename;
        this.surname = surname;
        this.studentNumber = studentNumber;                                                       //Matrikelnummer
        this.degreeProgram = degreeProgram;
        this.gender = gender;
    }


    private String prename;
    private String surname;
    private int studentNumber;
    private DegreeProgram degreeProgram;
    private int gender;


    public String getPrename() {
        return prename;
    }

    public void setPrename(String prename) {
        this.prename = prename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public DegreeProgram getDegreeProgram() {
        return degreeProgram;
    }

    public void setDegreeProgram(DegreeProgram degreeProgram) {
        this.degreeProgram = degreeProgram;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }


    public enum DegreeProgram {
        ALGORITHMS, COMPUTER_SCIENCE, GEEKY_STUFF, MATHEMATICS, PROGRAMMING
    }

}
