import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] dates = {
                "01 03 18",
                "30 11 17",
                "01 01 19"
        };

        /*
        * We can approach this problem in multiple ways. We can either go through the string and
        * extract year, month and date and then compare them, or, we can use date formatters in java
        * and get the result. Using date formatters, we can also get a timestamp value and the max
        * timestamp will be our result. Let's check them both.
        * */

        /*
        * Using string tokenization
        * */
        System.out.println(maxDateTokens(dates));

        /*
        * Time for date formatters
        * */
        System.out.println(maxDateFromFormatter(dates));
    }

    // let's create a class for the first approach
    static class OurDate {
        int year;
        int month;
        int date;

        String dateString;

        public OurDate(String dateString) {
            this.dateString = dateString;
            // assign values right away
            init();
        }

        // extract year, month, date and assign them
        private void init() {
            String[] tokens = this.dateString.split(" ");
            // there should be 3 tokens
            this.date = Integer.parseInt(tokens[0]);
            this.month = Integer.parseInt(tokens[1]);
            this.year = Integer.parseInt(tokens[2]);
        }
    }

    public static String maxDateTokens(String[] dates) {
        ArrayList<OurDate> ourDateArrayList = new ArrayList<>();

        // populate the list
        for (String dateString : dates) {
            OurDate d = new OurDate(dateString);
            ourDateArrayList.add(d);
        }

        /*
        * now we need a comparator that'll help us get the max date. comparisons can be done this way -
        * check for the year. if years between two dates are same, then month and if they're same
        * check for dates
        * */
        Comparator<OurDate> dateComparator = (OurDate x, OurDate y) -> {
            if (x.year > y.year) {
                return 1;
            } else if (x.year == y.year) {
                if (x.month > y.month) {
                    return 1;
                } else if (x.month == y.month) {
                    if (x.date > y.date) {
                        return 1;
                    }
                }
            }

            // for everything else there's a mastercard ;)
            // a mastercard condition.
            return -1;
        };

        // get the maxDate based on the comparator
        String maxDate = ourDateArrayList.stream().max(dateComparator).get().dateString;
        return maxDate;
    }

    /*
    * Let's go for date formatters
    * */
    public static String maxDateFromFormatter(String[] dates) {
        long maxTimeStamp = 0;
        int maxDateIndex = 0;

        // init date formatter
        SimpleDateFormat formatter = new SimpleDateFormat("dd MM yy");

        // loop through the dates array
        for (int i = 0; i < dates.length; i++) {
            try {
                Date x = formatter.parse(dates[i]);

                // if the timestamp for this date is greater than the max value,
                // then update it, else leave it as it is
                if (x.getTime() > maxTimeStamp) {
                    maxTimeStamp = x.getTime();
                    maxDateIndex = i;
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return dates[maxDateIndex];
    }
}
