package ineo.stream.PipedOutputStream;

import ineo.stream.PipedInputStream.common.CommonUtils;

import java.io.IOException;
import java.io.PipedOutputStream;

public class PipedOutputThread implements Runnable{

    private PipedOutputStream pipedOutputStream = null;

    public PipedOutputThread(PipedOutputStream pipedOutputStream){
        this.pipedOutputStream = pipedOutputStream;
    }

    //还是前面那句话，这儿因为要覆盖run()方法。所以只能try-catch。不能throws。暂时不知道为啥。先就这样
    @Override
    public void run() {
        try {
            CommonUtils.sout("\"W:开始将数据写入:但等个5秒让我们观察...\"");
            Thread.sleep(5000);//这个意味着释放了CPU的执行权5s
            //向管道写入数据，同时解除管道上的阻塞状态
            pipedOutputStream.write("W: writePiped 数据...".getBytes());
            pipedOutputStream.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("W:WriteThread写入失败...");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("W:WriteThread写入失败...");
        }

    }
}
