package ControllersViews;

public class User {
    private String name;
    private String rollNum;
    private String password;

    //main constructor of user class
    public User(String name, String rollNum, String password) {
        this.name = name;
        this.rollNum = rollNum;
        this.password = password;
    }
    //constructor without password
    public User(String name, String rollNum) {
        this.name = name;
        this.rollNum = rollNum;
    }
    //constructor of user class without password and name in case we want to create obj without password and name field
    public User(String rollNum) {
        this.rollNum = rollNum;
    }

    //Empty constructor
    public User() {
        this.name = null;
        this.rollNum = null;
        this.password = null;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getrollNum() {
        return rollNum;
    }

    public void setrollNum(String rollNum) {
        this.rollNum = rollNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //default tostring method
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", rollNum='" + rollNum + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUserIncomeTaxDetails(){
        return "Details of user are : " +
                "name='" + name + '\'' +
                ", rollNum='" + rollNum + '\'' +
                ", password='" + password + '\'';
    }
}
