package ineo.stream.FileInputStream;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class Courage {
    //既然是FileInputStream那么我们是要从一个文件中获取一些东西到程序中。我们还是用FileOutputStream一个文件吧。
    public void aurora(){
        try {
            System.out.println("请输入我们需要获取的文件全名称：");
            Scanner scanner = new Scanner(System.in);
            String filePath = scanner.nextLine();
            if (null == filePath || "".equals(filePath)) {
                throw new Exception("文件路径解析不正确，请输入正确的文件全名称：");
            }
            File file = new File(filePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            //我们来new一个byte类型的数组来保存我们的获取到的内容
            byte[] arr = new byte[1024];
            //然后把我们的数组传给read()方法
            int len = fileInputStream.read(arr);
            String str = new String(arr, 0, len);
            System.out.println(str);
            //最后一定要关闭流啊。！！！
            fileInputStream.close();
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
