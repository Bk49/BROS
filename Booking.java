import java.util.Calendar;

public class Booking {
    private Student student;
    private Facility facility;
    private BrosDate startDate;
    private BrosDate bookingDate;
    private int duration;

    public Booking(Student student, Facility facility, BrosDate startDate, BrosDate bookingDate, int duration) {
        this.student = student;
        this.facility = facility;
        this.startDate = startDate;
        this.bookingDate = bookingDate;
        this.duration = duration;
    }

    public boolean overlaps(Booking another) {

        // Initialize the date in this Booking (dateHere) and date in another Booking
        // (dateOther)
        Calendar dateHere = this.startDate.getDate();
        Calendar dateOther = this.startDate.getDate();

        // Check if both are at the same facility, day, month and year
        if (this.facility.getId() == another.getFacility().getId() &&
                dateHere.get(Calendar.YEAR) == dateOther.get(Calendar.YEAR)
                && dateHere.get(Calendar.MONTH) == dateOther.get(Calendar.MONTH)
                && dateHere.get(Calendar.DAY_OF_MONTH) == dateOther.get(Calendar.DAY_OF_MONTH)) {

            // Initialize the hour of dateHere and dateOther as hourHere and hourOther
            // respectively
            int hourHere = dateHere.get(Calendar.HOUR_OF_DAY);
            int hourOther = dateOther.get(Calendar.HOUR_OF_DAY);

            // Check if same start time, if true then it overlapped
            if (hourHere == hourOther) {
                return true;
            } else if (hourHere > hourOther) {
                // If the hour in this
                // Booking is greater than the other, check if the other if added with the
                // duration will overlap or not
                int temp = hourOther + duration;
                if (temp > hourHere) {
                    return true;
                }
            } else {
                // Here holds the vice versa of else if
                int temp = hourHere + duration;
                if (temp > hourOther) {
                    return true;
                }
            }

        }

        // No overlap if not even on the same day, month and year
        // Also returns this if the else if and else case does not applies
        return false;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public BrosDate getStartDate() {
        return startDate;
    }

    public void setStartDate(BrosDate startDate) {
        this.startDate = startDate;
    }

    public BrosDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(BrosDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
