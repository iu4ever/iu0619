package ineo.decorator.cake;

public class FlowerDecorator extends Decorator {
    /*
    我在创建了FlowerDecorator类之后，继承了Decorator类。
    然后编译器会提示我需要实现两个方法。一个是getRemark()，该方法来自于Decorator类
    另一个是getImpression()方法，该方法来自于Cake类

    注意：
    当我试着给Decorator里面也加上public abstract String getImpression();方法之后，编译器提示的两个方法都来自于Decorator类。
    但我还是先给他删掉。
     */

    /*
    我在实现了这两个方法之后，编译器还是报错，这是因为父类Decorator里面有构造方法注入Cake呢。但FlowerDecorator里面却没有，
    我们来给他加上
     */

    public FlowerDecorator(Cake cake) {
        //我加了这个构造器之后。父类里面的构造器是有参数的cake。所以此处加上的与父类相匹配的构造函数也是有参数的。
        // 调用父类的构造方法，可以获取Cake的实例了。就可以调用Cake实例的方法
        super(cake);
        super.remark = "一朵玫瑰花";
    }

    @Override
    public String getRemark() {
        //待会对比一下这俩
        //return super.cake.getRemark()+super.remark;
        return cake.getRemark()+"有"+super.remark;
    }

    // 实现了装饰器抽象类的getImpression方法。
    // 这是重点。我们通过构造方法传入的cake实例。对cake进行了装饰，增加了新的功能。
    @Override
    public String getImpression() {
        return super.cake.getImpression()+"，看到了一朵花。真的开心";
    }
}


