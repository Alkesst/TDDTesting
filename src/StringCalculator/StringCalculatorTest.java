package StringCalculator;

import org.junit.jupiter.api.Test;

/*
 * @author Alejandro Garau Madrigal.
 * @version 1.0
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    @Test
    void testAddEmptyNumber(){
        StringCalculator sc = new StringCalculator();
        assertEquals(0, sc.add(""));
    }

    @Test
    void testAddWithOneNumber(){
        StringCalculator sc = new StringCalculator();
        assertEquals(1, sc.add("1"));
    }

    @Test
    void testAddWithTwoNumbers(){
        StringCalculator sc = new StringCalculator();
        assertEquals(3, sc.add("1,2"));
    }

    @Test
    void testAddWithMoreThanTwoNumbers(){
        StringCalculator sc = new StringCalculator();
        int resultOfTheSum = 15;
        String numbersToSum = "5,5,5";
        assertEquals(resultOfTheSum, sc.add(numbersToSum));
    }

    @Test
    void testAddReceivingAStringUsingLineBreaks(){
        StringCalculator sc = new StringCalculator();
        int resultOfTheSum = 23;
        String numbersToSum = "10\n8,5";
        assertEquals(resultOfTheSum, sc.add(numbersToSum));
    }

    @Test
    void testAddReceivingOneStringWithLineBreak(){
        StringCalculator sc = new StringCalculator();
        String forceException = "1\n";
        assertThrows(
                NumberFormatException.class
          ,
                () -> sc.add(forceException)
        );
    }

    @Test
    void testAddReceiveAStringWithANewDelimiter(){
        StringCalculator sc = new StringCalculator();
        String numbersToSum = "//;\n2;3;5";
        int resultOfTheSum = 10;
        assertEquals(resultOfTheSum, sc.add(numbersToSum));
    }

    @Test
    void testAddReceiveANegativeNumber(){
        StringCalculator sc = new StringCalculator();
        String numbersToSum = "//;;;\n-5;;;-2";
        NumberFormatException exception = assertThrows(
                NumberFormatException.class
                ,
                () -> sc.add(numbersToSum)
        );
        assertEquals("Negative numbers are not allowed", exception.getMessage());
    }

    @Test
    void testAddIgnoreNumbersBiggerThan1000(){
        StringCalculator sc = new StringCalculator();
        String numbersToSum = "1001,2";
        int resultOfTheSum = 2;
        assertEquals(resultOfTheSum, sc.add(numbersToSum));
    }

    @Test
    void testAddDelimitersHaveLengthGreaterThanOne(){
        StringCalculator sc = new StringCalculator();
        String numbersToSum = "//[;__]\n200;__14;__6";
        int resultOfTheSum = 220;
        assertEquals(resultOfTheSum, sc.add(numbersToSum));
    }

    @Test
    void testAddMoreThanOneDelimiter(){
        StringCalculator sc = new StringCalculator();
        String numbersToSum = "//[#][_]\n200_20#10";
        int resultOfTheSum = 230;
        assertEquals(resultOfTheSum, sc.add(numbersToSum));
    }

    @Test
    void testAddMoreThanOneDelimiterOfLengthBiggerThanOne(){
        StringCalculator sc = new StringCalculator();
        String numbersToSum = "//[###][___]\n200___10###8";
        int resultOfTheSum = 218;
        assertEquals(resultOfTheSum, sc.add(numbersToSum));
    }

}
