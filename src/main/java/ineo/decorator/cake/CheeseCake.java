package ineo.decorator.cake;

public class CheeseCake extends Cake {

    public CheeseCake() {
        super.remark = "乳酪蛋糕";
    }

    // 实现了Cake抽象类的getImpression吃乳酪蛋糕的感觉。
    @Override
    public String getImpression() {
        return "乳酪蛋糕，香甜感受";
    }
}
