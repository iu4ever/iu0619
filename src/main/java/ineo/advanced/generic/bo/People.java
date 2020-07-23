package ineo.advanced.generic.bo;

public class People {
    private String name;
    private int age;
    public People() {
    }
    public People(String particular) {
        System.out.println(particular);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void show() {
        System.out.println("this is show method");
    }
}
