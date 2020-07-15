package ineo.stream.ObjectOutputStream.bo;

import java.io.Serializable;

public class People implements Serializable {

    private int id;
    private String name;

    public People(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
