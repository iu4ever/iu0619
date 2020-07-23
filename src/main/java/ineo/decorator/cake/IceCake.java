package ineo.decorator.cake;

public class IceCake extends Cake{
    // 冰淇淋蛋糕的构造方法,修改冰淇淋蛋糕的描述。
    public IceCake() {
        super.remark = "冰淇淋蛋糕";
    }
    // 实现了Cake抽象类的getImpression吃冰淇淋蛋糕的感觉。。
    public String getImpression() {
        return "冰凉的感受很好";
    }
}
