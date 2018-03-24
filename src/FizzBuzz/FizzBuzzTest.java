package FizzBuzz;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 Escribe, en el lenguaje de programación que desees, un programa que muestre en pantalla los números del 1 al 100,
 sustituyendo los múltiplos de 3 por el palabro “Fizz” y, a su vez, los múltiplos de 5 por “Buzz”.
  Para los guarismos que, al tiempo, son múltiplos de 3 y 5, utiliza el combinado “FizzBuzz”.
 */

public class FizzBuzzTest {
    private static String FIZZ_VALUE = "FIZZ";
    private static String BUZZ_VALUE = "BUZZ";
    private static String FIZZBUZZ_VALUE = "FIZZBUZZ";

    @Test
    @DisplayName("Fizz Tester")
    void shouldReturnFizzIfNumberIsDivisibleBy3(){
        FizzBuzz fb = new FizzBuzz(3);
        assertEquals(FIZZ_VALUE, fb.value);
    }

    @Test
    @DisplayName("Buzz Tester")
    void shouldReturnBuzzIfNumberIsDivisibleBy5(){
        FizzBuzz fb = new FizzBuzz(5);
        assertEquals(BUZZ_VALUE, fb.value);
    }

    @Test
    @DisplayName("FizzBuzz Tester")
    void shouldReturnFizzBuzzIfNumberIsDivisibleBy3And5(){
        FizzBuzz fb = new FizzBuzz(15);
        assertEquals(FIZZBUZZ_VALUE, fb.value);
    }
}
