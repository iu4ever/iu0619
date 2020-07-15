package ineo.stream.InputStreamReader;

import java.io.*;
import java.util.Scanner;

public class Courage {
    public void aurora(){
        try {
            //这个方法里面实现我们的输入和输出字符流，我们从一个文件里面读取到东西，然后写入另一个新的文件吧
            System.out.println("请输入我们要读取的文件全名：");
            Scanner scanner = new Scanner(System.in);
            String originFilePath = scanner.nextLine().trim();
            File file = new File(originFilePath);
            //字节流走一波
            InputStream inputStream = new FileInputStream(file);
            //现在需要字符流了
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"UTF-8");
            OutputStream outputStream = new FileOutputStream(originFilePath.substring(0,originFilePath.lastIndexOf("\\")+1) + "new_" + file.getName());
            //我们定义了一个输出字符流之后发现他里面需要包裹一个OutputStream。所以我们来定义
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            //这个read。我们先来定义个byte吧
            char[] arr = new char[1024];
            //我们给这个read传一个byte数组的内存缓存区的话意味着，我们读到的东西会暂时保存到这个arr里面来
            //然后我们就发现还需要一个长度。
            /*int len = 0;
            while ((len=inputStreamReader.read(arr)) != -1) {
                //我们现在已经把我们要的东西放到了arr数组里面。我们要用这个东西干嘛嘞。要不直接输出吧。
                //那我们来定义一个输出流吧
                for (int i = 0; i < arr.length; i++) {
                    outputStreamWriter.write(arr[i]);

                    System.out.print(arr[i]);
                }
                outputStreamWriter.write("我爱你中国");
            }*/
            //我用上面有参数的read()输出的空字符串太多了。试试无参数的read()
            int letter = 0;
            while ((letter = inputStreamReader.read()) != -1) {
                outputStreamWriter.write((char)letter);
                System.out.print((char)letter);
            }
            //关闭流
            outputStreamWriter.close();
            outputStream.close();
            inputStreamReader.close();
            inputStream.close();

        } catch (FileNotFoundException e) {


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Courage courage = new Courage();
        courage.aurora();
    }
}
