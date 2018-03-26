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
            StringBuilder delimiter = new StringBuilder();
            delimiter.append("[");
            if (numbers.contains("//")){
                String[] delimiters = numbers.substring(2).split("\n");
                if (delimiters[0].contains("[")) {
                    String[] moreThanOneDelimiter = delimiters[0].substring(1).split("]");
                    for (String delimiterIn : moreThanOneDelimiter) {
                        if (delimiterIn.contains("["))
                            delimiter.append(delimiterIn.substring(1));
                        else
                            delimiter.append(delimiterIn);
                    }
                    //delimiter.append(delimiters[0].substring(1, delimiters[0].length() - 1));
                } else{
                    delimiter.append(delimiters[0].substring(0, delimiters[0].length()));
                }
                numbers = delimiters[1];
            } else {
                delimiter.append(",\n");
            }
            delimiter.append("]");
           String[] numbersToSum = numbers.split(delimiter.toString());
            int result = 0;
            for (String aNum : numbersToSum) {
                if (aNum.isEmpty()){
                    parseInt = 0;
                } else {
                    parseInt = Integer.parseInt(aNum);
                }
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
