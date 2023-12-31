import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // System.out.println(Roman.stringFromInt(85));
    boolean go = true;
    while (go) {
      System.out.println("Введите выражение или нажмите ENTER :");
      Scanner scanner = new Scanner(System.in);
      String input = scanner.nextLine();
      if (input.isEmpty()) {
        go = false;
      } else {
        System.out.println(calc(input));
      }
    }
  }

  public static String calc(String input) {
    int res = 0;
    String error = "";
    // boolean error = false;
    Operand operand1 = new Operand();
    Operand operand2 = new Operand();
    String[] tokens = input.split("[/*+\\-\\s]+");
    String operator = getoperator(input);
    if (tokens.length != 2 || operator == null)
      try {
        throw new IOException();
      } catch (IOException e) {
        error +=
            "\033[91mERROR\033[0m - формат математической операции не удовлетворяет заданию - два операнда и один оператор";
      }
    else if (Roman.itsRoman(tokens[0]) && Roman.itsRoman(tokens[1])) {
      operand1.value = Roman.getIntFromRoman(tokens[0]);
      operand2.system = operand1.system = system.ROMAN;
      operand2.value = Roman.getIntFromRoman(tokens[1]);
    } else if (itsDigit(tokens[0]) && itsDigit(tokens[1])) {
      operand1.value = Integer.parseInt(tokens[0]);
      operand2.system = operand1.system = system.ARABIC;
      operand2.value = Integer.parseInt((tokens[1]));
    } else if ((Roman.itsRoman(tokens[0]) && !Roman.itsRoman(tokens[1]))
        || (!Roman.itsRoman(tokens[0]) && Roman.itsRoman(tokens[1]))) {
      try {
        throw new IOException();
      } catch (IOException e) {
        error += "\033[91mERROR\033[0m - используются одновременно разные системы счисления";
      }
    }
    if (error.isEmpty()) {
      if (operand1.Ok() && operand2.Ok()) {
        switch (Objects.requireNonNull(operator)) {
                    case "*" -> res = operand1.value * operand2.value;
                    case "+" -> res = operand1.value + operand2.value;
                    case "-" -> res = operand1.value - operand2.value;
                    case "/" -> res = operand1.value / operand2.value;
                }
            } else {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    error += "\033[91mERROR\033[0m - числа должны быть от 1 до 10.";
                }
            }
        }
        if(res < 1 && (operand1.system == system.ROMAN || operand2.system == system.ROMAN) )  try {
            throw new IOException();
        } catch (IOException e) {
            error += "\033[91mERROR\033[0m - в римской системе нет отрицательных чисел";
        }
    if (error.isEmpty()) {
        return (operand1.system == system.ROMAN )  ? Roman.stringFromInt(res):
                      Integer.toString(res);
        }
        else return error;
      }

      static String getoperator(String input) {
        String operator = null;
        int count = 0;
        if (input.contains("*")) {
          operator = "*";
          count++;
        }
        if (input.contains("/")) {
          operator = "/";
          count++;
        }
        if (input.contains("-")) {
          operator = "-";
          count++;
        }
        if (input.contains("+")) {
          operator = "+";
          count++;
        }
        if (count != 1)
          operator = null;
        return operator;
      }

      static class Operand {
        int value;
        system system;

        boolean Ok() {
          return value >= 1 && value <= 10;
        }
      }
      static boolean itsDigit(String input) {
        boolean temp = true;
        for (int i = 0; i < input.length(); i++) {
          if (!Character.isDigit(input.toCharArray()[i]))
            temp = false;
        }
        return temp;
      }

      enum system { ARABIC, ROMAN }
    }
