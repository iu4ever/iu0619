package ineo.stream.PrintWriter;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Courage {
    public static void main(String[] args) throws Exception
    {
        String filename = "C:\\Users\\niu\\Desktop\\Java\\我的工作空间\\PrintWriter.txt";
        /*
         * PrintWriter(Writer out)
         * Creates a new PrintWriter, without automatic line flushing.
         */
        PrintWriter pw = new PrintWriter(new FileWriter(filename));
        String[] words = new String[]{"hello", "world", "!"};

        for (int i = 0; i < words.length; i++)
        {
            /*
             * format(String format, Object... args)
             * Writes a formatted string to this writer using the specified format string and arguments.
             */
            pw.format("words: %s\n", words[i]);
        }
        /*
         * flush()
         * Flushes the stream.
         */
        pw.flush();
    }
}
