import java.io.IOException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws Exception {
   // System.out.println(Roman.stringFromInt(85));
    System.out.println("Введите выражение:");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    System.out.println(calc(input));
  }
  public static String calc(String input) throws Exception {
    int res = 0;
    int operand1= 0, operand2 = 0;
    String[] tokens = input.split("[/*-+\\s]+");
    String operator = getoperator(input);
    if (tokens.length != 2 || operator == null)
      throw new IOException(
          " - формат математической операции не удовлетворяет заданию - два операнда и один оператор");
    else if (Roman.itsRoman(tokens[0]) && Roman.itsRoman(tokens[1])) {
      operand1 = Roman.getIntFromRoman(tokens[0]);
      operand2 = Roman.getIntFromRoman(tokens[1]);
    }
    else if (itsDigit(tokens[0]) && itsDigit(tokens[1])) {
      operand1 = Integer.parseInt(tokens[0]);
      operand2 = Integer.parseInt((tokens[1]));
    }

      // System.out.println(operand2);
     switch (operator) {
        case "*":
          res = operand1 * operand2;
          break;
        case "+":
          res = operand1 + operand2;
          break;
        case "-":
          res = operand1 - operand2;
          break;
        case "/":
          res = operand1 / operand2;
          break;
      }
    return Integer.toString(res);
  }
  //    static String[] validation(String input) throws Exception {
  //    int operand1, operand2;
  //      String[] tokens = input.split("[/*-+\\s]");
  //      String operator = getoperator(input);
  //      if (tokens.length != 2 || operator == null)
  //        throw new IOException (" - формат математической операции не удовлетворяет заданию - два
  //        операнда и один оператор");
  //      if(Character.isDigit(tokenw   ))
  //
  //      return tokens;
  //    }
  static String getoperator(String input) {
     String operator;
    if (input.contains("*"))
      operator = "*";
    else if (input.contains("/"))
      operator = "/";
    else if (input.contains("-"))
      operator = "-";
    else if (input.contains("+"))
      operator = "+";
    else
      operator = null;
    return operator;
  }
  static boolean itsDigit(String input) {
    boolean temp = true;
    for (int i = 0; i < input.length(); i++) {
      if (!Character.isDigit(input.toCharArray()[i]))
        temp = false;
    }
    return temp;
  }
}