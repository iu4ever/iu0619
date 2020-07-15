package ineo.stream.ObjectInputStream;

import ineo.stream.ObjectOutputStream.bo.People;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Courage {
    public void aurora(){
        try {
            //现在我要去读刚刚存进去那个文件里的东西，
            //C:\Users\niu\Desktop\Java\我的工作空间\2020-07-12-01测试文件.txt
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\niu\\Desktop\\Java\\我的工作空间\\2020-07-12-01测试文件.txt");
            //我又需要ObjectInputStream
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            //这儿我们没法出判断文件里面有多少个people 。所以只能全部循环
            while (true) {
                People people = (People) objectInputStream.readObject();
                System.out.println(people);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //这儿因为EOFException已经包括在IOException中了。所以去掉算了
        //为什么要写这个呢。因为上面的while(true)什么狗东西啊。
        //所以，只能靠异常机制来中断程序了。正确的做法应该是吧people放到ArrayList中去。然后就可以判断ArrayList的长度了吧。
        //catch (EOFException e) {
        //
        //}


    }

    public static void main(String[] args) {
        Courage courage = new Courage();
        courage.aurora();
    }
}
