package question1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DependencyInjectionTest {
    @Test
    public void testMultiply() {
        Calculator calculator = new Calculator(5, 3);

        Properties props = new Properties();
        try (FileInputStream f = new FileInputStream("src/question1/config.txt")){
            props.load(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Class<?> c = null;
        try {
            c = Class.forName("question1." + props.getProperty("calculator_implementation"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Operation op = null;
        try {
            op = (Operation) c.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(15, calculator.returnResult(op));
    }

    @Test
    public void testDivide() {
        Calculator calculator = new Calculator(9, 3);

        Properties props = new Properties();
        try (FileInputStream f = new FileInputStream("src/question1/config.txt")){
            props.load(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Class<?> c = null;
        try {
            c = Class.forName("question1." + props.getProperty("calculator_implementation2"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Operation op = null;
        try {
            op = (Operation) c.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(3, calculator.returnResult(op));
    }
}
