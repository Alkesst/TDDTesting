package StringCalculator;

public class StringCalculator {

    int add(String numbers){
        int parseInt;
        if (numbers.isEmpty())
            return 0;
        else if (numbers.length() < 3){
            parseInt = Integer.parseInt(numbers);
            if (parseInt < 0) {
                throw new NumberFormatException("Negative numbers are not allowed");
            } else if (parseInt > 1000){
                parseInt = 0;
            }
            return parseInt;
        }
        else{
            String delimiter = "[,\n]+";
            if (numbers.contains("//")){
                String[] delimiters = numbers.split("\n");
                if (delimiters[0].contains("[")) {
                    delimiter = delimiters[0].substring(3, delimiters[0].length() - 1);
                } else{
                    delimiter = delimiters[0].substring(2, delimiters[0].length());
                }
                numbers = delimiters[1];
            }
            String[] numbersToSum = numbers.split(delimiter);
            int result = 0;
            for (String aNum : numbersToSum) {
                parseInt = Integer.parseInt(aNum);
                if (parseInt < 0)
                    throw new NumberFormatException("Negative numbers are not allowed");
                else if (parseInt > 1000)
                    parseInt = 0;
                result += parseInt;
            }
            return result;
        }
    }
}
