package ineo.stream.DataInputStream;

import java.io.*;

public class Courage {
    public static void borealis() throws IOException{
        //我来在这个方法里Read吧
        String str = "C:\\Users\\niu\\Desktop\\Java\\我的工作空间\\2020-07-11测试文件.txt";
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(str));
        String s = dataInputStream.readUTF();
        System.out.println(s);
        dataInputStream.close();

    }
    public static void australis() throws IOException{
        //
        String str = "C:\\Users\\niu\\Desktop\\Java\\我的工作空间\\2020-07-11测试文件.txt";
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(str));
        dataOutputStream.writeUTF("上面的readUTF()要和这儿的writeUTF()配合使用的。否则汇报异常。");
        //他给我在写入上面的这句话“上面的readUTF()要和这儿的writeUTF()配合使用的。否则汇报异常。”的时候把原来里面的内容给删了。~
        //是相当于重新建了一个吗？
        dataOutputStream.close();

    }

    public static void main(String[] args) throws IOException{
        //要先调用writeUTF()的方法。再调用readUTF()的方法。
        australis();
        borealis();
    }

}
