package ineo.decorator.cake;

public abstract class Cake {

    //Cake是一个抽象类，扮演的是抽象构建(Component)角色，它已经实现了getRemark()方法。但没有实现getImpression，必须被子类实现。
    String remark = "蛋糕";

    public String getRemark() {
        return remark;
    }

    public abstract String getImpression();
}
