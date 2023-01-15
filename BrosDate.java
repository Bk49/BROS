import java.util.Calendar;

public class BrosDate {
    private Calendar date;

    public BrosDate(int day, int month, int year, int hour, int minute) {
        Calendar temp = Calendar.getInstance();
        temp.clear();
        temp.set(year, month, day, hour, minute);
        this.date = temp;
    }

    @Override
    public String toString() {
        return String.format("%02d", date.get(Calendar.DAY_OF_MONTH)) + "/"
                + String.format("%02d", date.get(Calendar.MONTH)) + "/"
                + date.get(Calendar.YEAR) + " "
                + String.format("%02d", date.get(Calendar.HOUR_OF_DAY)) + ":"
                + String.format("%02d", date.get(Calendar.MINUTE));
    }

    public String getDateStr() {
        return this.date.toString();
    }

    public Calendar getDate() {
        return this.date;
    }

    public void setDate(int day, int month, int year, int hour, int minute) {
        Calendar temp = Calendar.getInstance();
        temp.clear();
        temp.set(year, month, day, hour, minute);
        this.date = temp;
    }
}
