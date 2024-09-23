package main;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class JavaUtils {
    public static boolean hasExpiredOrNotCreated(Map<String, Object> jsonObject) throws ParseException {
        if (jsonObject.get("token") == null || "0".equals(jsonObject.get("dueDate"))) {
            return true;
        }

        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date dueDate = formatter.parse(jsonObject.get("dueDate").toString());

        return dueDate.before(now);
    }


    public static String setDueDate(int expiryTimeInSeconds) {
        Date now = new Date();
        long duration = expiryTimeInSeconds * 1000L;
        Date newDueDate = new Date(now.getTime() + duration);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); // Tarih formatı eklendi
        return formatter.format(newDueDate);
    }
}
