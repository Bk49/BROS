public class Student {
    private String username;
    private String name;
    private int eDollars;

    public Student(String username, String name, int eDollars) {
        this.username = username;
        this.name = name;
        this.eDollars = eDollars;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int geteDollars() {
        return eDollars;
    }

    public void seteDollars(int eDollars) {
        this.eDollars = eDollars;
    }  
}
