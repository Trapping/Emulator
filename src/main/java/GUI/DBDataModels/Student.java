package GUI.DBDataModels;

public class Student {
    private int Code;
    private String LastName;
    private String Name;
    private String FathersName;
    private int JCode;
    private int EnterYear;
    private int GCode;
    private String GroupName;
    private int Course;

    public Student(int code, String lastName, String name, String fathersName, int JCode, int enterYear, int GCode, String groupName, int course) {
        Code = code;
        LastName = lastName;
        Name = name;
        FathersName = fathersName;
        this.JCode = JCode;
        EnterYear = enterYear;
        this.GCode = GCode;
        GroupName = groupName;
        Course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Code=" + Code +
                ", LastName='" + LastName + '\'' +
                ", Name='" + Name + '\'' +
                ", FathersName='" + FathersName + '\'' +
                ", JCode=" + JCode +
                ", EnterYear=" + EnterYear +
                ", GCode=" + GCode +
                ", GroupName='" + GroupName + '\'' +
                ", Course=" + Course +
                '}';
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFathersName() {
        return FathersName;
    }

    public void setFathersName(String fathersName) {
        FathersName = fathersName;
    }

    public int getJCode() {
        return JCode;
    }

    public void setJCode(int JCode) {
        this.JCode = JCode;
    }

    public int getEnterYear() {
        return EnterYear;
    }

    public void setEnterYear(int enterYear) {
        EnterYear = enterYear;
    }

    public int getGCode() {
        return GCode;
    }

    public void setGCode(int GCode) {
        this.GCode = GCode;
    }

    public String getGroupName() {
        return GroupName;
    }

    public void setGroupName(String groupName) {
        GroupName = groupName;
    }

    public int getCourse() {
        return Course;
    }

    public void setCourse(int course) {
        Course = course;
    }
}
