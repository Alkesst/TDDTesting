package FizzBuzz;

public class FizzBuzz {
    protected String value;

    public FizzBuzz(int number){
        if (number % 3 == 0 && number % 5 == 0){
            value = "FIZZBUZZ";
        }
        else if (number % 3 == 0){
            value = "FIZZ";
        } else if (number % 5 == 0){
            value = "BUZZ";
        }
    }
}
