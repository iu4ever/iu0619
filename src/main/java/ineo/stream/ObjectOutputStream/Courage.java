package ineo.stream.ObjectOutputStream;

import ineo.stream.ObjectOutputStream.bo.People;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Courage {
    public void aurora() {
        try {
            //我现在的最终目的是要把一个对象存入那个文件中。
            //我现在再试试定义路径那个复制过来的效果。C:\Users\niu\Desktop\Java\我的工作空间\2020-07-12-01测试文件.txt
            String filePath = "C:\\Users\\niu\\Desktop\\Java\\Repository\\neo\\MyWorkSpace\\2020-07-12-01测试文件.txt";
            //这个字段转义是IDEA的自带的功能吗还是。应该是吧。
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\niu\\Desktop\\Java\\Repository\\neo\\MyWorkSpace\\2020-07-12-01测试文件.txt");
            //那现在肯定要用ObjectOutputStream来包装这个FileOutputStream了呗
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            //既然已经包装起来了。那么我们去搞几个对象吧。
            People people_1 = new People(1, "邸雅琴");
            People people_2 = new People(2, "牛建业");
            objectOutputStream.writeObject(people_1);
            objectOutputStream.writeObject(people_2);

            //趁现在想起来了。关一下流
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Courage courage = new Courage();
        courage.aurora();
    }
}
