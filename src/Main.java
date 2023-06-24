import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println("Введите выражение:");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    System.out.println(calc(input));
  }
  public static String calc(String input) {
    int res = 0;
    // Scanner scanner = new Scanner();
    String[] tokens = validation(input);
    int operand1 = Integer.parseInt(tokens[0]);
    // System.out.println(operand1);
    char operator = tokens[1].charAt(0);
    // System.out.println(operator);
    int operand2 = Integer.parseInt(tokens[2]);
    // System.out.println(operand2);
    switch (operator) {
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
    return Integer.toString(res);
  }
    static String[] validation(String input) {
        String[] tokens = input.split("[\\s*]");
        if (tokens.length != 3) {
            System.out.println(
                    "throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        return tokens;
    }

}