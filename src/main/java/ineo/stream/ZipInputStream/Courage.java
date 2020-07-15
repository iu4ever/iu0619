package ineo.stream.ZipInputStream;

import java.io.*;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * 我们需要返回来看一下如果把字节流包装成字符流输出
 */
public class Courage {
    public void aurora() {
        try {
            System.out.println("请输入要写入内容的压缩文件全名称：");
            Scanner scanner = new Scanner(System.in);
            String zipFilePath = scanner.nextLine();
            if (null == zipFilePath || "".equals(zipFilePath)) {
                throw new Exception("文件路径解析错误，请检查输入的文件路径是否有错！");
            }
            //有了文件路径的话我们需要一个文件
            File file = new File(zipFilePath);
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file));
            //有了zipInputStream了。我们可以读取zip文件的内容了。但是我们在读取的时候还需要验证。
            //怎么验证呢，我们需要一个ZipEntry
            ZipEntry zipEntry = null;
            byte[] arr = new byte[1024];
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                //现在我们可以用我们的zipInputStream来读取东西了
                //我们在读取的时候这样吧。我们来个byte数组吧。是的。这个数组就是昨天我们说过的一个字节类型的内存缓存区
                //read()给传一个byte类型的数组的时候，会把读到的内容缓存进该数组。
                //但是我们要传byte数组的话又需要一个int类型的长度。这个长度就是我们read()方法的返回值。
                //是的。而且。我们这个read()记得吗，不能判断了之后再用。会当成遍历了两遍的。
                String noZipFile = zipFilePath.substring(0, zipFilePath.lastIndexOf("."))+".md";
                //懒得判断了。直接用吧
                FileOutputStream fileOutputStream = new FileOutputStream(noZipFile);
                int len = 0;
                while ((len = zipInputStream.read(arr)) != -1) {
                    //如果我们此时System.out.println(len)，那输出的就是缓存进arr中的字节长度。
                    //而如果我们此时遍历System.out.println(arr[i])，那么得到的就是缓存进数组中的字节
                    //嘻嘻，但我们现在不打印。我们来把读到的这些东西输出到一个文件吧。
                    //不用管上面的两个while。上面的两个while就是做了两次判断。只不过是每读一次判断一次的判断而已。
                    //我们要创建输出流得有文件名啊。来，搞个文件名。
                    fileOutputStream.write(arr);
                    //哈哈。试了一下，输出的文件Typora可以打开，但UE竟然打不开。那么们试着给他包装一下然后输出。
                    //算了算了，把这些东西做完再返回来看这个。
                }
                fileOutputStream.close();
            }
            //最后一定要关闭流
            zipInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Courage courage = new Courage();
        courage.aurora();
    }

}
