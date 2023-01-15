import java.util.ArrayList;
import java.util.Arrays;

public class StudentDAO {
    private ArrayList<Student> studentList;

    public StudentDAO() {
        this.studentList = new ArrayList<>(Arrays.asList(
                new Student("raini", "Rainie Yang", 20),
                new Student("hyun", "Hyun Bin", 30),
                new Student("aaron", "Aaron Yang", 40),
                new Student("simi", "Shiela Sim", 50)));
    }

    public Student retrieve(String username) {
        return studentList.stream().filter(student -> username.equals(student.getName())).findAny().orElse(null);
    }

    public ArrayList<Student> retrieveAll() {
        return studentList;
    }

    public void add(String username, String name, int eDollars) {
        studentList.add(new Student(username, name, eDollars));
    }
}
