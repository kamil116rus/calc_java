public class Roman {
  static String[] roman = {"null", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
  // Map<Integer, String> roman1= new HashMap<>[] ;
  static boolean itsRoman(String input) {
    boolean temp = false;
    for (String str : roman) {
      if (input.equals(str)) {
        temp = true;
        break;
      }
    }
    return temp;
  }
  static int getIntFromRoman(String input) {
    int temp = 0;
    for (int i = 1; i < roman.length; i++) {
      if (input.equals(roman[i]))
        temp = i;
    }
    return temp;
  }
  static String stringFromInt(int value) { // работает правильно до 390, выше покажет не правильно
    StringBuilder temp = new StringBuilder();
    while (value > 0) {
      if (value >= 100 && value < 390) {
        temp.append("C");
        value -= 100;
      } else if (value >= 90) {
        temp.append("XC");
        value -= 90;
      } else if (value >= 50) {
        temp.append("L");
        value -= 50;
      } else if (value >= 40) {
        temp.append("Xl");
        value -= 40;
      } else if (value >= 10) {
        temp.append("X");
        value -= 10;
      } else if (value == 9) {
        temp.append("IX");
        value -= 9;
      } else if (value >= 5) {
        temp.append("V");
        value -= 5;
      } else if (value == 4) {
        temp.append("IV");
        value -= 4;
      } else {
        temp.append("I");
        value -= 1;
      }
    }
    return temp.toString();
  }
}
