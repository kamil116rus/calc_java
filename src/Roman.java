public class Roman {
    static String[] roman = {"null", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    // Map<Integer, String> roman1= new HashMap<>[] ;
    static boolean itsRoman(String input) {
        boolean temp = false;
        for (String str : roman) {
            if (input.equals(str))
                temp = true;
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
        String temp = new String();
        while (value > 0) {
            if (value == 100) {
                temp += "C";
                value -= 100;
            }
            if (value >= 90) {
                temp += "XC";
                value -= 90;
            }
            if (value >= 50) {
                temp += "L";
                value -= 50;
            }
            if (value >= 40) {
                temp += "Xl";
                value -= 40;
            }
            while (value >= 10) {
                temp += "X";
                value -= 10;
            }
            if (value >= 9) {
                temp += "IX";
                value -= 9;
            }
            if (value >= 5) {
                temp += "V";
                value -= 5;
            }
            if (value >= 4) {
                temp += "IV";
                value -= 4;
            }
            if (value >= 1) {
                temp += "I";
                value -= 1;
            }
        }
        return temp;
    }
}
