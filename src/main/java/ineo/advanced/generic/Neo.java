package ineo.advanced.generic;

import ineo.advanced.generic.bo.People;
import ineo.advanced.generic.bo.Student;

import java.util.List;
import java.util.Map;

public class Neo {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        //Generic_3.aurora();
        //虽然我声明类的时候是泛型类。但我们原来的无参构造方法还在，所以，可以实例化无泛型的类。
        /*Generic_3 generic_3 = new Generic_3();
        generic_3.persistence();*/
        //现在我们来测试泛型
        //可以实例，但我们因为没有在类里面写构造方法。
        //Generic_3<String> generic_3 = new Generic_3<String>();
        //generic_3.persistence();
        //但其实我们这样给泛型的T去set值是不太好的。因为我们要在实例化的时候就给T值的话最好写到构造方法里面去。我们去写构造方法
        /*
        当我们给写了构造方法之后发现
        Generic_3<String> generic_3 = new Generic_3<String>();
        上面的这个代码会报错。说明，泛型的这个实例化必须要给传参
         */
        Generic_3<String> generic_3 = new Generic_3<String>("我爱你中国");
        //generic_3.setKey("我就是我，不一样的烟火");
        System.out.println(generic_3.getKey());
        /*
        泛型在实例化的时候前面的声明必须有<>和里面的类型。但后面具体的类后面可以有这个<>也可以没有。
        Generic_3<String> generic_3 = new Generic_3<String>();

        这个特性叫做泛型的类型推断
         */
        Generic_3<String> generic_4 = new Generic_3("世界人民大团结万岁");
        System.out.println(generic_4.getKey());

        Generic_3 generic = new Generic_3("周杰伦");
        System.out.println(generic.key);
        Generic_3 generic1 = new Generic_3(1);
        System.out.println(generic1.key);


        People people = new People();
        people.setAge(18);
        people.setName("邸雅琴");
        Student student = new Student();
        student.setName("牛建业");
        student.setAge(20);
        Generic_3<People> generic2 = new Generic_3<People>(people);
        Neo neo = new Neo();
        neo.aurora(generic2);
        Generic_3<Student> generic_neo = new Generic_3<Student>(student);
        //此处传入的泛型参数为Generic_3<Student>。所以报错了。说明Generic_3<Student>不能被当做Generic_3<People>的子类
        //我们由此引入一个通配符
        //neo.aurora(generic_neo);

        People p = neo.getClassInstance_6(new People("从现在 拥抱未来").getClass());
        System.out.println(p);
        Object classInstance_6 = neo.getClassInstance_6(Class.forName("ineo.decorator.coffee"));
    }

    public void aurora(Generic_3<People> people){
        System.out.println(people.getKey().getAge()+" "+people.getKey().getName());
    }

    public void getClassInstance_1() {

    }

    public static <T> void getClassInstance_2(List<T> list) {

    }

    public static <T,S> void getClassInstance_3(List<T> list, Map<String,S> map) {

    }

    public static <T, E, V> boolean getClassInstance_4(T[] arr, List<E> list, Map<Integer, V> map) {

        return true;
    }

    public static <T> int getClassInstance_5(){

        return 1;
    }

    /**
     * 传入T的Class获取T的实例
     * @param tClass
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public <T> T getClassInstance_6(Class<T> tClass) throws IllegalAccessException, InstantiationException {
        T instance = tClass.newInstance();
        return instance;
    }

    /*
    我们试着对上面的方法进行定义。发现，当且仅当在返回值类型前面，声明了泛型，我们才能在后面的形参中使用该泛型定义符
    当然了我们也可以申明了之后不使用
     */
}
