package ineo.stream.FileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Courage {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("C:\\Users\\niu\\Desktop\\Java\\我的工作空间\\2020-07-13测试文件.txt");
            int read = fileReader.read();
            FileWriter fileWriter = new FileWriter("C:\\Users\\niu\\Desktop\\Java\\我的工作空间\\FileWriter输出.txt");
            while ((read = fileReader.read()) != -1) {
                System.out.print((char)read);
                fileWriter.write((char)read);
            }
            fileWriter.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
