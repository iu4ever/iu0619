package ineo.advanced.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Generic_2 {
    private static String name = Generic_2.class.getName();
    private static Logger log = Logger.getLogger(name);// <= (2)
    public static void simple() {
        List<String> stringArrayList = new ArrayList<String>();
        List<Integer> integerArrayList = new ArrayList<Integer>();

        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerArrayList.getClass();

        if(classStringArrayList.equals(classIntegerArrayList)){
            log.info("类型测试，类型相同");//.d("泛型测试","类型相同");
        }
    }

    public static void main(String[] args) {
        simple();
    }
}
