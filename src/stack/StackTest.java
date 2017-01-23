package stack;

import data.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by laura on 13.01.17.
 */
public class StackTest {

    private Stackable<Student> stackEmptyAfterSetup = new Stack<>();
    private Stackable<Student> stackCont3StudentsAfterSetup = new Stack<>();
    private Student s1;
    private Student s2;
    private Student s3;


    @Before
    public void setUp() throws Exception {

        s1 = new Student("Zen", "Buddy", 666777, Student.DegreeProgram.GEEKY_STUFF, 8);
        s2 = new Student("Anna", "Wei", 890066, Student.DegreeProgram.MATHEMATICS, 0);
        s3 = new Student("Klaus", "Mueller", 334455, Student.DegreeProgram.COMPUTER_SCIENCE, 1);

        stackCont3StudentsAfterSetup.push(s1);
        stackCont3StudentsAfterSetup.push(s2);
        stackCont3StudentsAfterSetup.push(s3);

    }

    @After
    public void tearDown() throws Exception {

        stackEmptyAfterSetup.clearAll();

        stackCont3StudentsAfterSetup.clearAll();
    }

    @Test
    public void push() throws Exception {

        int expectedEmptySize = 0;
        int expectedAfterOnePushSize = 1;
        int expectedContainsStudentsSize = 3;
        Student expectedStudentOnTop = s3;

        assertEquals(expectedEmptySize, stackEmptyAfterSetup.size());

        stackEmptyAfterSetup.push(s3);
        assertEquals(expectedAfterOnePushSize, stackEmptyAfterSetup.size());
        assertEquals(expectedStudentOnTop, stackEmptyAfterSetup.peek());

        assertEquals(expectedContainsStudentsSize, stackCont3StudentsAfterSetup.size());
        assertEquals(expectedStudentOnTop, stackCont3StudentsAfterSetup.peek());
    }

    @Test
    public void pop() throws Exception {
        int expectedAfterOnePopSize = 2;
        stackCont3StudentsAfterSetup.pop();
        Student expectedStudentOnTop = s2;

        assertEquals(expectedAfterOnePopSize, stackCont3StudentsAfterSetup.size());
        assertEquals(expectedStudentOnTop, stackCont3StudentsAfterSetup.peek());

    }

    @Test
    public void peek() throws Exception {

        Student expectedStudentOnTop = s3;
        assertEquals(expectedStudentOnTop, stackCont3StudentsAfterSetup.peek());

    }

    @Test
    public void size() throws Exception {
        int expectedEmptySize = 0;
        int expectedContainsStudentsSize = 3;

        assertEquals(expectedEmptySize, stackEmptyAfterSetup.size());
        assertEquals(expectedContainsStudentsSize, stackCont3StudentsAfterSetup.size());

    }

    @Test
    public void empty() throws Exception {

        assertEquals(true, stackEmptyAfterSetup.empty());
    }

    @Test
    public void clearAll() throws Exception {
        boolean expectedClear = true;
        stackCont3StudentsAfterSetup.clearAll();

        assertEquals(expectedClear, stackCont3StudentsAfterSetup.empty());

    }


}