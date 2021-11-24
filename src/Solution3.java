import java.text.ParseException;
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
            String line = a;
            String date = line.substring(0,10);
            if(Integer.parseInt(date.substring(0,4)) < 1995) {
                Pattern pattern = Pattern.compile("\\w+");
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    if(counter == 3) {
                        if(Integer.parseInt(matcher.group()) < (240 * Math.pow(2, 10))) {
                            list.add(line);
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

    public static void main(String[] args) throws ParseException {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.solution3(("1988-08-29        956 system.zip\n" +
                "1976-09-16     126976 old-photos.tgz\n" +
                "1987-02-03     118784 logs.rar\n" +
                "1961-12-04  703594496 very-long-filename.rar\n" +
                "1980-08-03          2 DELETE-THIS.TXT\n" +
                "2014-08-23        138 important.rar\n" +
                "2001-08-26     595968 MOONLIGHT-SONATA.FLAC\n" +
                "1967-11-30     245760 archive.rar\n" +
                "1995-10-13        731 file.tgz")));
    }
}