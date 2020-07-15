package ineo.stream.BufferedInputStream;

import java.io.*;

public class Courage {

    public void aurora() {
        try {
            //我们先来定义两个文件
            File fileIn = new File("C:\\Users\\niu\\Desktop\\Java\\我的工作空间\\2020-07-12测试源图片.jpg");
            File fileOut = new File("C:\\Users\\niu\\Desktop\\Java\\我的工作空间\\2020-07-12测试输出图片.jpg");
            if (!fileOut.exists()) {
                fileOut.createNewFile();
            }
            //有了文件了。那肯定需要文件流啊
            FileInputStream fileInputStream = new FileInputStream(fileIn);
            FileOutputStream fileOutputStream = new FileOutputStream(fileOut);
            //但我觉得用的不爽，我想加缓存
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            //那我现在需要读取了
            byte[] arr = new byte[1024];
            int len = 0;
            while ((len = bufferedInputStream.read(arr)) != -1) {
                bufferedOutputStream.write(arr);
            }
            bufferedInputStream.close();
            bufferedOutputStream.close();
            fileInputStream.close();
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Courage courage = new Courage();
        courage.aurora();
    }
}
