public class Solution1 {

    public static long countUniqueCharacters(String input) {
        return input.chars()
                .distinct()
                .count();
    }

    public static boolean isAUsedThreeTimes(String input) {
        for (int i = 0; i < input.length() - 2; i++) {
            if (input.charAt(i) == 'a' && input.charAt(i+1) == 'a'
                && input.charAt(i+2) == 'a') {
                return true;
            }
        }
        return false;
    }

    public static int countLetterA(String input) {
        int counter = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'a') {
                counter++;
            }
        }
        return counter;
    }

    public static int countLettersExceptA(String input) {
        int counter = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != 'a') {
                counter++;
            }
        }
        return counter;
    }

    public int solution(String s) {
        if(isAUsedThreeTimes(s)) {
            return -1;
        } else if (countUniqueCharacters(s) == 1 && s.length() >= 2 && s.charAt(0) == 'a') {
            return 0;
        } else if (s.length() == countLettersExceptA(s)) {
            return s.length() * 2 + 2;
        } else {
            int a = countLetterA(s);
            int result;
            if(a % 2 == 1) {
                result = s.length() - a - a/2;
                result *= 2;
                result += 1;
            } else {
                result = s.length() - a - a/2;
                result *= 2;
                result += 2;
            }
            return result;
        }
    }

}
