package ineo.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegularExpression {
    public static void main(String[] args) {
        /*if ((args.length < 2)) {
            System.out.println();
        }
        System.exit(0);*/

        for (int i = 0; i < args.length; i++) {
            Pattern p = Pattern.compile(args[i]);
            Matcher m = p.matcher(args[0]);
            if (m.find()) {
                System.out.println(m.group()+"at positions"+m.start()+"---"+(m.end() - 1));
            }
        }
    }
}
