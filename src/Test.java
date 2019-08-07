import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Test {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");format.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date end = format.parse("23:30:00");
        Date start = format.parse("00:29:00");
        Date newDate = new Date(end.getTime()+start.getTime());
        long diff = start.getTime()+end.getTime();
        System.out.println(format.format(new Date(diff)));
    }
}
