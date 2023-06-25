import java.util.HashMap;
import java.util.Map;

public class roman {
    static String[] roman = {"null", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    //Map<Integer, String> roman1= new HashMap<>[] ;
    static boolean itsRoman(String input) {
        boolean temp = false;
      for(String str:roman) {
          if(input.equals(str)) temp =  true;
      }
      return temp;
    }
    static int getIntFromRoman(String input) {
        int temp = 0;
        for(int i = 1; i < roman.length; i++) {
            if(input.equals(roman[i])) temp = i;
        }
        return  temp;
    }
}
