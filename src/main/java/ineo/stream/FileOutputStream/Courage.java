package ineo.stream.FileOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Courage {
    public void aurora(){
        try {
            System.out.println("请输入要写入内容的文件全名称：");
            Scanner scanner = new Scanner(System.in);
            String filePath = scanner.nextLine();
            if (null == filePath || "".equals(filePath)) {
                throw new Exception("请输入一个有效的文件全名称：");
            }
            File file = new File(filePath);
            //我们再来创建一个FileOutputStream
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            //fileOutputStream的write方法需要的参数可以是int和byte。我们就用byte数组吧。
            byte [] arr = "never mind I will find someone like you".getBytes();
            fileOutputStream.write(arr);
            System.out.println("写入文件成功！");
            //最后一定要关闭流
            fileOutputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Courage courage = new Courage();
        courage.aurora();
    }
}
