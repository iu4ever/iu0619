package ineo.advanced.compare.comparable;

import org.jetbrains.annotations.NotNull;

public class People implements Comparable{
    String name;
    int age;
    int id;

    public People(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return "People{name='" + name + "',age=" + age + ",id=" + id + "}";
    }

    @Override
    public int compareTo(@NotNull Object o) {
        /*People o = (People)o1;
        return this.age < o.age ? -1 : this.age == o.age ? 0 : 1;*/
        People p = (People) o;
        if (this.id < p.id) {
            return -1;
        } else if (this.id == p.id) {
            return 0;
        } else {
            return 1;
        }
    }
}
