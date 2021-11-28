import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {

        System.out.println("Task 1");
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.solution("aabaacaabb"));

        System.out.println("Task 2");
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.solution("22:22:21", "22:22:23"));

        System.out.println("Task 3");
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
