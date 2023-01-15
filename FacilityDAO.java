import java.util.ArrayList;
import java.util.Arrays;

public class FacilityDAO {
    private ArrayList<Facility> facilityList;

    public FacilityDAO() {
        this.facilityList = new ArrayList<>(Arrays.asList(
                new Facility("F001", "Room 2-1", 4),
                new Facility("F002", "Room 2-2", 6),
                new Facility("F003", "Room 2-3", 8),
                new Facility("F004", "Room 2-4", 10),
                new Facility("F005", "Room 2-5", 12),
                new Facility("F006", "Room 2-6", 14),
                new Facility("F007", "Room 2-7", 16)));
    }

    public ArrayList<Facility> retrieveAll() {
        return facilityList;
    }

    public Facility retrieve(String facilityId) {
        return facilityList.stream().filter(facility -> facilityId.equals(facility.getId())).findAny().orElse(null);
    }
}