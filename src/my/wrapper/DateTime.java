/*
 * DataTime: a wrapper class for a datetime value
 */

package my.wrapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 *
 * @author Sandro
 */
public class DateTime {
  private final Calendar datetime;
  SimpleDateFormat dateFormat;

  public DateTime() {
    datetime = Calendar.getInstance();
    dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
  }
  
  public void fromString(String s) throws ParseException{
    datetime.setTime(dateFormat.parse(s));
  }

  @Override
  public String toString() {
    return dateFormat.format(datetime.getTime());
  }
  
}
