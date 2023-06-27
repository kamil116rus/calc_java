import java.io.IOException;
import java.util.Objects;
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
        Operand operand1 = new Operand();
        Operand operand2 = new Operand();
        String[] tokens = input.split("[/*-+\\s]+");
        String operator = getoperator(input);
        if (tokens.length != 2 || operator == null)
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println((
                    "- формат математической операции не удовлетворяет заданию - два операнда и один оператор"));
            }
        if (Roman.itsRoman(tokens[0]) && Roman.itsRoman(tokens[1])) {
            operand1.value = Roman.getIntFromRoman(tokens[0]);
            operand2.system = operand1.system = system.ROMAN;
            operand2.value = Roman.getIntFromRoman(tokens[1]);
        }
        if (itsDigit(tokens[0]) && itsDigit(tokens[1])) {
            operand1.value = Integer.parseInt(tokens[0]);
            operand2.system = operand1.system = system.ARABIC;
            operand2.value = Integer.parseInt((tokens[1]));
        }
        if ((Roman.itsRoman(tokens[0]) && !Roman.itsRoman(tokens[1]))
            || (!Roman.itsRoman(tokens[0]) && Roman.itsRoman(tokens[1]))) {
            throw new IOException(" - либо арабские цисла , либо римскиею");
        }
        switch (Objects.requireNonNull(operator)) {
                case "*" -> res = operand1.value * operand2.value;
                case "+" -> res = operand1.value + operand2.value;
                case "-" -> res = operand1.value - operand2.value;
                case "/" -> res = operand1.value / operand2.value;
            }
    return operand1.system == system.ROMAN ? Roman.stringFromInt(res):Integer.toString(res);
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
    static String getoperator(String  input) {
        String operator;
        if(input.contains("*")) operator = "*";
        else if(input.contains("/")) operator = "/";
        else if (input.contains("-")) operator = "-";
        else if (input.contains("+")) operator = "+";
        else  operator = null;
        return operator;
    }


    static class Operand {
        int value;
        system system;
    }
    static boolean itsDigit(String input) {
        boolean temp = true;
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.toCharArray()[i]))
                temp = false;
        }
        return temp;
    }


     enum system {
        ARABIC, ROMAN
    }
}

