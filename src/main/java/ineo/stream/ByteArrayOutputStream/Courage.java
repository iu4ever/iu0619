package ineo.stream.ByteArrayOutputStream;

import java.io.*;
import java.util.Scanner;

public class Courage {
    public void aurora(){
        try {
            //在内存中创建了可以增长的内存数组
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            //先来定义一个文件的位置吧
            String filePath = "";
            System.out.println("请输入要测试的文件全名：");
            Scanner scanner = new Scanner(System.in);
            filePath = scanner.nextLine();
            //初始化一个文件
            if(null == filePath || "".equals(filePath)){
                throw new Exception("文件名称无法解析,请检查输入的文件路径是否有误！");
            }
            File file = new File(filePath);
            //我们的FileInputStream需要一个file或者String类型的文件路径。我们此处给他传一个file
            FileInputStream fileInputStream = new FileInputStream(file);
            //既然是字节流。那么fileInputStream读出来的东西一定是0/1，是int类型的东西
            //不能这样写
            /*while (fileInputStream.read() != -1){
                byteArrayOutputStream.write(fileInputStream.read());
            }*/
            int temp = 0;
            while ((temp = fileInputStream.read()) != -1){
                byteArrayOutputStream.write(temp);
                System.out.print(Character.toChars(temp));
            }
            byte [] arr = byteArrayOutputStream.toByteArray();
            /*
            FileInputStream和FileOutputStream可以直接读写文件（即可以完成copy），
            但是如果需要在控制台打印读到的字符，需要用InputStreamReader转换流包起来转成字符。
            ！！！！所以下面的三个输出都不知道输出了什么狗东西
             */
            //System.out.println(new String(arr));
            //System.out.println(byteArrayOutputStream.toByteArray());
            //System.out.println(byteArrayOutputStream.toString());
            //最后一步一定要关闭流
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
