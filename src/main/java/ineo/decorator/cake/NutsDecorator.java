package ineo.decorator.cake;

public class NutsDecorator extends Decorator{

    // 传入一个cake实例，也就是前面所实现的Cake的子类
    public NutsDecorator(Cake cake) {
        // 调用父类的构造方法，可以获取Cake的实例了。就可以调用Cake实例的方法
        super(cake);
        super.remark = "一颗果仁";
    }

    @Override
    public String getRemark() {
        return cake.getRemark() + "还有" + super.remark;
    }
    // 实现了装饰器抽象类的getImpression方法。
    // 这是重点。我们通过构造方法传入的cake实例，对cake进行了装饰，增加了新的功能。
    @Override
    public String getImpression() {
        return super.cake.getImpression() + "," + "看到一顆果仁，哈哈";
    }
}
