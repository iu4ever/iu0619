package ineo.advanced.generic;

import ineo.advanced.generic.bo.People;
import ineo.decorator.coffee.Coffee;

public class Someone<T, Y, Z> extends People {
    private T t;
    private Y y;
    private Z z;
    public Someone() {
    }
    public Someone(T t, Y y, Z z) {
        this.t = t;
        this.y = y;
        this.z = z;
    }
    @Override
    public String getName() {
        return super.getName();
    }
    @Override
    public void setName(String name) {
        super.setName(name);
    }
    public T getT() {
        return t;
    }
    public void setT(T t) {
        this.t = t;
    }
    public Y getY() {
        return y;
    }
    public void setY(Y y) {
        this.y = y;
    }
    public Z getZ() {
        return z;
    }
    public void setZ(Z z) {
        this.z = z;
    }
    public static void main(String[] args) {
        Someone<String, Integer, Coffee> someone = new Someone<String, Integer, Coffee>("冷", 1, new Coffee() {
            @Override
            public double getCost() {
                return 12.5;
            }
            @Override
            public String getIngredients() {
                return "巧克力+牛奶+冰块";
            }
        });
        someone.setName("邸雅琴");
        System.out.println(someone.getName() + "点了" + someone.getY() + "杯" + someone.getT() + "的咖啡,花了" + someone.getZ().getCost() + "块钱。原料是：" + someone.getZ().getIngredients());
    }
}

