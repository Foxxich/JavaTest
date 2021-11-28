import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution3 {
    public String solution3(String S) {

        ArrayList<String> list = new ArrayList<>();
        String[] arrOfStr = S.split("\n");

        int counter = 0;
        int result = 0;

        for (String a : arrOfStr) {
            String date = a.substring(0,10);
            if(Integer.parseInt(date.substring(0,4)) < 1995) {
                Pattern pattern = Pattern.compile("\\w+");
                Matcher matcher = pattern.matcher(a);
                while (matcher.find()) {
                    if(counter == 3) {
                        if(Integer.parseInt(matcher.group()) < (240 * Math.pow(2, 10))) {
                            list.add(a);
                        }
                    }
                    counter++;
                }
                counter = 0;
            }
        }

        for (String s : list) {
            if (s.endsWith("tgz")
                    || s.endsWith("zip")
                    || s.endsWith("rar")) {
                result++;
            }
        }

        if(result == 0) {
            return "NO FILES";
        } else {
            return String.valueOf(result);
        }
    }

}