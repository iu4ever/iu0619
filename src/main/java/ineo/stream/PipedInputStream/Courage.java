package ineo.stream.PipedInputStream;

import ineo.stream.PipedOutputStream.PipedOutputThread;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Courage {

    public static void main(String[] args) throws IOException {
        //我们首先需要定义管道输入输出流然后再把两个流连起来
        PipedInputStream pipedInputStream = new PipedInputStream();
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        pipedInputStream.connect(pipedOutputStream);//都这儿了还try的干嘛，直接throws啊
        //我们定义流干嘛，不就是为了要给线程用吗。所以现在实例化线程
        PipedInputThread pipedInputThread = new PipedInputThread(pipedInputStream);
        PipedOutputThread pipedOutputThread = new PipedOutputThread(pipedOutputStream);
        new Thread(pipedInputThread).start();
        new Thread(pipedOutputThread).start();

    }
}
