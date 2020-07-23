package ineo.advanced.generic;
import ineo.advanced.generic.interfacee.UserInterface;

public class User<T, Y, Z, B> implements UserInterface<String, B> {

    @Override
    public String testT(String s) {
        return s;
    }

    @Override
    public B testB(B b) {
        return b;
    }

    public static void main(String[] args) {
        User user = new User();
        System.out.println(user.testT("3sfdg"));
        System.out.println(user.testB(3));
        System.out.println(user.testB("dfhgu"));

    }

}
