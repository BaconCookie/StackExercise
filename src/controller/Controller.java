package controller;

import data.Student;
import data.Student.DegreeProgram;
import stack.Stackable;
import Prog1Tools.IOTools;


//import static Prog1Tools.IOTools.readInteger;
//import static Prog1Tools.IOTools.readString;


/**
 * Created by laura on 12.01.17.
 */
public class Controller {

    private int action;
    private Stackable<Student> stack;

    public Controller() {
    }

    public void runStack() {
        action = 100;

        while (action != 0) {
            switch (action) {
                case 1:
                    stack.push(userInputStudent());
                    break;
                case 2:
                    System.out.println(stack.peek());
                    break;
                case 3:
                    stack.pop();
                    break;
                case 4:
                    stack.printAll();
                    break;
                case 5:
                    System.out.println("The current size of the stack is: " + stack.size());
                    break;
                case 6:
                    stack.clearAll();
                    System.out.println("Stack has been cleared");
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
            showMenu();
        }
    }
    /**
     * Method which shows the user menu
     */
    private void showMenu() {
        System.out.println();
        System.out.println("--> Please pick one option: <--");
        System.out.println(" 1   Add a student to the stack (push)");
        System.out.println(" 2   Take a look at the current top element from the stack (peek)");
        System.out.println(" 3   Delete the top element from the stack (pop)");
        System.out.println(" 4   Print the current stack");
        System.out.println(" 5   Print the size of the stack");
        System.out.println(" 6   Clear the complete stack");
        System.out.println(" 0   Exit");
        System.out.println("Your pick: ");
        action = IOTools.readInteger();
    }

    /**
     * Method to make it possible for the user to put in a student
     *
     * @return student which corresponds with the user input
     */
    private Student userInputStudent() {
        String forename = pickName("Forename of student: ");
        String surname = pickName("Surname of student: ");
        int studentNumber = pickStudentNumber("Student Number of student: ");
        DegreeProgram degreeProgram = pickDegreeProgram();
        int gender = pickGender("Gender (as integer) of student: ");

        Student student = new Student(forename, surname, studentNumber, degreeProgram, gender);
        return student;
    }
    private String pickName(String s) {
        return readString(s);
    }

    private int pickStudentNumber(String s) {
        return readInteger(s);
    }

    /**
     * Method which takes care of the Degree Program input
     * reads input as string, which is being converted to enum (if available)
     *
     * @return degreeProgram which is available and typed in command line
     */
    private DegreeProgram pickDegreeProgram() {
        try {
            System.out.println("Pick the Degree Program: ");
            System.out.println("ALGORITHMS, COMPUTER_SCIENCE, GEEKY_STUFF, MATHEMATICS, PROGRAMMING");
            DegreeProgram degreeProgram = DegreeProgram.valueOf(pickName("Your pick: ").toUpperCase());
            return degreeProgram;
        } catch (IllegalArgumentException exception) {
            System.out.println("Please be careful of correct spelling (not case sensitive) and try again:");
            return pickDegreeProgram();
        }
    }

    private int pickGender(String s) {
        return readInteger(s);
    }

}
