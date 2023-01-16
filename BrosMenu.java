import java.util.*;

public class BrosMenu {
    private FacilityDAO facilityDAO;
    private StudentDAO studentDAO;
    private BookingDAO bookingDAO;

    public BrosMenu() {
        this.facilityDAO = new FacilityDAO();
        this.studentDAO = new StudentDAO();
        this.bookingDAO = new BookingDAO(studentDAO, facilityDAO);
    }

    public void start() {
        int choice = this.menu();

        switch (choice) {
            case 1:
                this.listStudents();
                break;
            case 2:
                this.listFacilities();
                break;
            case 3:
                this.listBookings();
                break;
            case 4:
                this.listStudentBookings();
                break;
            case 5:

                break;
            case 6:

                break;
            case 7:
                return;
            default:
                break;

        }

    }

    public int menu() {
        Scanner sc = new Scanner(System.in);

        System.out.print("== BROS :: Main Menu ==\n" +
                "\n1. List all Students" +
                "\n2. List all Facilities" +
                "\n3. List all Bookings" +
                "\n4. List all Bookings by a student" +
                "\n5. Add a student" +
                "\n6. Book a Facility" +
                "\n7. Quit Application" +
                "\nEnter your choice >");

        return sc.nextInt();
    }

    public void listStudents() {

        ArrayList<Student> students = studentDAO.retrieveAll();

        if (students.size() <= 0) {
            System.out.println("There is no student");
        } else {
            System.out.println("== BROS :: List all Students == \n\nS/N\tUsername\tName\tE$");

            for (int i = 0; i < students.size(); i++) {
                System.out.println(
                        (i + 1) + "\t" + students.get(i).getUsername() + "\t" + students.get(i).getName() + "\t"
                                + students.get(i).geteDollars());
            }
        }

        System.out.println();
        this.start();
        return;
    }

    public void listFacilities() {

        ArrayList<Facility> facilities = facilityDAO.retrieveAll();

        if (facilities.size() <= 0) {
            System.out.println("There is no facility");
        } else {
            System.out.println("== BROS :: List all Facilities == \n\nS/N\tID\tDescription\tCapacity");

            for (int i = 0; i < facilities.size(); i++) {
                System.out.println(
                        (i + 1) + "\t" + facilities.get(i).getId() + "\t" + facilities.get(i).getDescription() + "\t"
                                + facilities.get(i).getCapacity());
            }
        }

        System.out.println();
        this.start();
        return;
    }

    public void listBookings() {

        ArrayList<Booking> bookings = bookingDAO.retrieveAll();

        if (bookings.size() <= 0) {
            System.out.println("There is no booking");
        } else {
            System.out.println(
                    "== BROS :: List all Facilities == \n\nFacility\tBooking DateTime\tStart DateTime\tDuration\tStudent");

            for (int i = 0; i < bookings.size(); i++) {
                System.out.println((i + 1) + "\t" + bookings.get(i).getFacility().getDescription() + "\t"
                        + bookings.get(i).getBookingDate() + "\t"
                        + bookings.get(i).getStartDate() + "\t" + bookings.get(i).getDuration() + "\t"
                        + bookings.get(i).getStudent().getName());
            }
        }

        System.out.println();
        this.start();
        return;
    }

    public void listStudentBookings() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username >");
        String username = sc.nextLine();

        Student std = null;
        for (Student student : studentDAO.retrieveAll()) {
            if (student.getUsername().equals(username)) {
                std = student;
                break;
            }
        }

        if (std == null) {
            System.out.println("The username is invalid");
        } else {
            ArrayList<Booking> userBookings = bookingDAO.retrieve(username);

            if (userBookings.size() > 0) {
                System.out.println(
                        "== BROS :: Bookings by " + std.getUsername()
                                + " == \n\nFacility\tBooking DateTime\tStart DateTime\tDuration");

                for (int i = 0; i < userBookings.size(); i++) {
                    System.out.println(
                            userBookings.get(i).getFacility().getDescription() + "\t"
                                    + userBookings.get(i).getBookingDate()
                                    + "\t" + userBookings.get(i).getStartDate() + "\t"
                                    + userBookings.get(i).getDuration());
                }
            } else {
                System.out.println("This student has not made any booking");
            }

        }

        System.out.println();
        this.start();
        return;
    }

}