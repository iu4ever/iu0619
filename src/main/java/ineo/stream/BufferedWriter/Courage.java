package ineo.stream.BufferedWriter;

import java.io.*;

public class Courage {
    public static void main(String[] args) {

        try {
            Reader reader = new FileReader("C:\\Users\\niu\\Desktop\\Java\\我的工作空间\\2020-07-13测试文件.txt");
            //我们先来定义一个BufferedReader,再给他传一个不同的FileReader
            BufferedReader bufferedReader = new BufferedReader(reader);
            /*int len = 0;
            while ((len = bufferedReader.read()) != -1) {
                System.out.println((char)len);
            }*/
            //读取一行
            //来搞一个Writer吧
            Writer writer = new FileWriter("C:\\Users\\niu\\Desktop\\Java\\我的工作空间\\BufferedWriter输出.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            String per = null;
            while ((per = bufferedReader.readLine()) != null) {
                System.out.println(per);
                bufferedWriter.write(per);
            }

            bufferedWriter.close();
            bufferedReader.close();
            writer.close();
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
