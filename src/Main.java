import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }
    public static String calc(String input) throws Exception {
        int res = 0;
        int operand1, operand2;
        String[]tokens = input.split("[/*-+\\s]");
        String operator = getoperator(input);
        if (tokens.length != 2 || operator == null)
            throw new IOException (" - формат математической операции не удовлетворяет заданию - два операнда и один оператор");
        else if(roman.itsRoman(tokens[0]) && roman.itsRoman(tokens[1])) {
            operand1 = roman.getIntFromRoman(tokens[0]);
            operand2 = roman.getIntFromRoman(tokens[1]);
        } else if()

            // System.out.println(operand2);
            return Integer.toString(switch (operator)) {
            case 42:
                res = operand1 * operand2;
                break;
            case 43:
                res = operand1 + operand2;
                break;
            case 45:
                res = operand1 - operand2;
                break;
            case 47:
                res = operand1 / operand2;
                break;
        }
    }
    //    static String[] validation(String input) throws Exception {
//    int operand1, operand2;
//      String[] tokens = input.split("[/*-+\\s]");
//      String operator = getoperator(input);
//      if (tokens.length != 2 || operator == null)
//        throw new IOException (" - формат математической операции не удовлетворяет заданию - два операнда и один оператор");
//      if(Character.isDigit(tokenw   ))
//
//      return tokens;
//    }
    static String getoperator(String  input) {
        String operator;
        if(input.contains("*")) operator = "*";
        else if(input.contains("/")) operator = "/";
        else if (input.contains("-")) operator = "-";
        else if (input.contains("+")) operator = "+";
        else  operator = null;
        return operator;
    }



}