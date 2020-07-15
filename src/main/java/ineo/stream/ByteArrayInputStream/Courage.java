package ineo.stream.ByteArrayInputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class Courage {
    public void aurora(){
        //创建一个可以增长的byte类型的内存数组
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write('a');
        byteArrayOutputStream.write(1);
        byte[] arr = new byte[3];
        arr[0] = 2;
        arr[1] = 0;
        arr[2] = 'b';
        byteArrayOutputStream.write(arr,0,3);
        //需要参数，我们的参数是一个byte类型的数组。这个数组我们通过ByteArrayOutputStream来创建吧。当然给可以其他的也可以
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        /*
        天哪这种写法不对！！
        97遍历了没输出
        1遍历了输出了
        2遍历了没输出
        0遍历了输出了
        98遍历了没输出
        然后输出了一个-1
        注意：    ！！！这个read()方法每进入一次都要累加1。没事别随便进入这个read方法。
         */
        //如下的写法是错误的。
        /*while (byteArrayInputStream.read()!=-1){
            System.out.println(byteArrayInputStream.read());
        }*/
        //得这样写
        int temp = 0;
        while ((temp = byteArrayInputStream.read())!=-1){
            System.out.println(temp);
        }
    }

    public static void main(String[] args) {
        Courage courage = new Courage();
        courage.aurora();
    }
}
