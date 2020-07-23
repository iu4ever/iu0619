package ineo.string;

public class StringBufferDemo {
    public static void main(String[] args) {
        MyString myString = new MyString();
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 70; i++) {

            /*Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 3; j++) {
                        myString.append(1);
                        stringBuffer.append("1");
                        stringBuilder.append("1");
                        System.out.println("执行append后：" + myString.getNumber() + " " + stringBuffer.length() + " " + stringBuilder.length());
                    }
                }
            });
            System.out.println("现在执行的是线程"+thread.getName());
            thread.start();*/

            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 70; j++) {
                        myString.append(1);
                        stringBuffer.append("1");
                        stringBuilder.append("1");
                        if (myString.getNumber() != stringBuffer.length() || stringBuilder.length() != stringBuffer.length()) {
                            System.out.println("执行append后：" + myString.getNumber() + " " + stringBuffer.length() + " " + stringBuilder.length());
                        }
                    }
                }
            }).start();

            /**
             * 可不可以解释一下为什么这两种写法会出现不同的执行结果。一个乱序一个顺序。
             * gaosiao。！！第二个deBug的时候和直接run的时候出现的结果也不一样。
             */
        }
    }

}
