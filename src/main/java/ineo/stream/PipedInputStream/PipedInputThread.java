package ineo.stream.PipedInputStream;

import ineo.stream.PipedInputStream.common.CommonUtils;

import java.io.IOException;
import java.io.PipedInputStream;

public class PipedInputThread implements Runnable {

    //首先他需要定义一个管道输入流
    private PipedInputStream pipedInputStream = null;

    public PipedInputThread(PipedInputStream pipedInputStream) {
        this.pipedInputStream = pipedInputStream;
    }

    //由于必须要覆盖run()方法。所以这里不能抛出，只能try-catch
    @Override
    public void run() {
        try {
            CommonUtils.sout("R:读取前没有数据,阻塞中...等待数据传过来再输出到控制台...");
            byte[] arr = new byte[1024];
            int len = pipedInputStream.read(arr);
            CommonUtils.sout("R:读取数据成功,阻塞解除...");
            while ((len = pipedInputStream.read(arr)) != -1) {
                String str = new String(arr,0,len);
                CommonUtils.sout(str);
            }
            //最后一定要记得关闭流啊
            pipedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("R:管道读取流失败!");
        }

    }
}
