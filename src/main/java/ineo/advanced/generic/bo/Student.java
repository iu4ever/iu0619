package ineo.advanced.generic.bo;

public class Student extends People{

    private String school;

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void study() {
        System.out.println("this is study method");
    }
}
