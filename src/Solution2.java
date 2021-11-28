import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

class Solution2 {

    public int solution(String S, String T) throws ParseException {
        SimpleDateFormat myFormat = new SimpleDateFormat("hh:mm:ss");
        int counter = 0;
        Date startDate;
        Date endDate;

        startDate = myFormat.parse(S);
        endDate = myFormat.parse(T);

        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.setTime(endDate);

        if (countUniqueCharacters(calendarEnd.get(Calendar.HOUR_OF_DAY) +
                String.valueOf(calendarEnd.get(Calendar.MINUTE)) +
                calendarEnd.get(Calendar.SECOND)) < 3) {
            counter++;
        }

        long diffInMillis = Math.abs(endDate.getTime() - startDate.getTime());
        long diff = TimeUnit.SECONDS.convert(diffInMillis, TimeUnit.MILLISECONDS);
        while (diff > 0) {
            endDate.setTime(endDate.getTime() - 1000);

            String hours = String.valueOf(calendarEnd.get(Calendar.HOUR_OF_DAY));
            String minute = String.valueOf(calendarEnd.get(Calendar.MINUTE));
            String second = String.valueOf(calendarEnd.get(Calendar.SECOND));
            if(second.length() == 1) {
                second = "0" + second;
            }
            String fullDate = hours + minute + second;
            long result = countUniqueCharacters(fullDate);
            if(result < 3) {
                counter++;
            }
            diff--;
        }
        return counter;
    }

    public static long countUniqueCharacters(String input) {
        return input.chars()
                .distinct()
                .count();
    }

}
