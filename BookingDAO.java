import java.util.ArrayList;
import java.util.Arrays;

public class BookingDAO {
    private ArrayList<Booking> bookingList;

    public BookingDAO(StudentDAO students, FacilityDAO facilities) {
        this.bookingList = new ArrayList<>(Arrays.asList(
                new Booking(students.retrieve("raini"), facilities.retrieve("F005"), new BrosDate(28, 9, 2016, 16, 5),
                        new BrosDate(14, 11, 2016, 15, 0), 2),
                new Booking(students.retrieve("hyun"), facilities.retrieve("F006"), new BrosDate(28, 9, 2016, 16, 5),
                        new BrosDate(14, 11, 2016, 15, 0), 2),
                new Booking(students.retrieve("aaron"), facilities.retrieve("F003"), new BrosDate(29, 9, 2016, 16, 6),
                        new BrosDate(15, 11, 2016, 13, 0), 1),
                new Booking(students.retrieve("aaron"), facilities.retrieve("F003"), new BrosDate(29, 9, 2016, 16, 6),
                        new BrosDate(18, 11, 2016, 18, 0), 2),
                new Booking(students.retrieve("simi"), facilities.retrieve("F001"), new BrosDate(30, 9, 2016, 17, 0),
                        new BrosDate(19, 11, 2016, 10, 0), 3)));
    }

    public ArrayList<Booking> retrieveAll() {
        if (bookingList == null) {
            bookingList = new ArrayList<>();
        }
        return bookingList;
    }

    public ArrayList<Booking> retrieve(String username){
        ArrayList<Booking> returnData = new ArrayList<>();
        
        for(Booking booking: bookingList){
            if(booking.getStudent().getName().equals(username)){
                returnData.add(booking);
            }
        }

        return returnData;
    }

    public boolean add(Booking newBooking){
        for(Booking booking: bookingList){
            if(!booking.overlaps(newBooking)){
                return false;
            }
        }

        bookingList.add(newBooking);
        return true;
    }

    
}
