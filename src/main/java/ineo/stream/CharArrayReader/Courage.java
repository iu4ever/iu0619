package ineo.stream.CharArrayReader;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

public class Courage {
    public void aurora(){
        try {
            //定义了这个之后发现他需要参数。参数是char类型的数组。那我们现在先直接new一个char类型的数组试试让它读
            //CharArrayReader charArrayReader = new CharArrayReader(new char[]{'a','b','c'});
            /*int read = 0;
            while ((read = charArrayReader.read()) != -1) {
                System.out.print((char)read);
            }*/
            //好吧。可以读出来，那直接注掉，不用了。
            CharArrayWriter charArrayWriter = new CharArrayWriter();
            String lyrics = "I am a big big girl";
            charArrayWriter.write(lyrics.toCharArray());
            char[] chars = charArrayWriter.toCharArray();
            CharArrayReader charArrayReader = new CharArrayReader(chars);
            int read = 0;
            while ((read = charArrayReader.read()) != -1) {
                System.out.print((char)read);
            }
            charArrayReader.close();
            charArrayWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Courage courage = new Courage();
        courage.aurora();
    }
}
