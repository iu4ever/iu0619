package ineo.stream.ZipOutputStream;

import org.apache.http.util.TextUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Courage {

    public void aurora(){
        //我们现在这儿穿插一个小的知识点
        /*
        File file = new File("D:" +File.separator+"ZipOutputStream测试.txt");
        File.separator
        系统相关的默认名称分隔符。
        这个字段被初始化为包含系统属性<code>file.separator</code>值的第一个字符。
        在UNIX系统中，该字段的值为<code>'/'</code>;
        在Microsoft Windows系统中，它是<code>'\\'</code>。
         */

        try {
            //我们的要定义的文件名就不写死了。我们还是在控制台输入的方式获取吧。
            System.out.println("请输入需要压缩的源文件：");
            Scanner scanner = new Scanner(System.in);
            String oriFilePath = scanner.nextLine();
            oriFilePath = oriFilePath.trim();
            if (TextUtils.isEmpty(oriFilePath)) {
                throw new Exception("源文件名称输入错误，请重新输入！");
            }
            /*
            //没试过除了txt和md之外的格式能否打开，先就这样写吧。
            String suffix = "txt|md|docx|doc|xls";
            //Pattern pattern = Pattern.compile("[\\w]+[\\.]("+suffix+")");
            Pattern pattern = Pattern.compile("[\\.]("+suffix+")");
            Matcher mc=pattern.matcher(oriFilePath);//条件匹配
            boolean success = false;
            while(mc.find()){
                success = true;
            }
            这一段是正则表达式验证文件路径，虽然没搞懂但暂时就这样吧。
            */
            if (null == oriFilePath || "".equals(oriFilePath)) {
                throw new Exception("源文件名称输入错误，请重新输入！");
            }
            //定义了路径当然需要一个文件啦。
            File file = new File(oriFilePath);
            //现在需要FileInputStream
            FileInputStream fileInputStream = new FileInputStream(file);
            //这个输入流是要给一个zip写入东西。那么我们来一个zip
            //zip的参数是OutputStream。那我们需要个FileOutputStream
            //FileOutputStream需要一个file啊肯定。就是要写入的文件。那么我们去定义一个zip的文件。
            //那这个zipFile的路径我们就不获取了吧。直接获取上面的路径然后给拼接一下好了。
            /*
            搞笑！注意！！！！
            oriFilePath.lastIndexOf("\\")
            oriFilePath.split("\\\\")
            这两种写法真恶心。split的时候必须是4个\，而lastIndexOf的时候就是2个\。
             */
            /**split里面必须是正则表达式，"\\"的作用是对字符串转义*/
            //String [] paths = oriFilePath.split("\\\\");
            String zipFilePath = "";
            //String name = file.getName();
            //String substring = oriFilePath.substring(oriFilePath.lastIndexOf("\\")+1);
            //String substring = oriFilePath.substring(0, oriFilePath.lastIndexOf("\\"));
            String substring = oriFilePath.substring(0, oriFilePath.lastIndexOf("."));
            zipFilePath = substring + ".zip";
            if (null == zipFilePath || "".equals(zipFilePath)) {
                throw new Exception("zip文件路径获取错误！");
            }
            File zipFile = new File(zipFilePath);
            FileOutputStream fileOutputStream = new FileOutputStream(zipFile);
            ZipOutputStream zipOutputStream = null;
            //zipOutputStream = new ZipOutputStream(fileOutputStream);
            zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFile));
            //这个输出流我们需要把它搞到一个zip文件里面去呀。这个文件我们名字也已经获取了。那么我们这么做。
            /*
            累不累啊你！！！！！
            zipOutputStream.putNextEntry()方法中传的参数是new ZipEntry();
            但！！！ZipEntry类初始化的时候传的参数根本不是新的zip文件的名称。后缀名根本不是zip
            而是源文件的名称。是这个：2020-07-11测试文件.txt
            而不是这个2020-07-11测试文件.zip
             */
            //zipOutputStream.putNextEntry(new ZipEntry(zipFilePath));
            zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
            //记得read()遍历时候的那个问题吗，我们需要定义一个int类型的变量来用
            int temp = 0;
            while ((temp = fileInputStream.read()) != -1) {
                //读到了。我们要用把读到的东西写到一个输出流里面去
                zipOutputStream.write(temp);
            }
            //怕忘，先把流关闭加上
            fileInputStream.close();
            zipOutputStream.close();
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
