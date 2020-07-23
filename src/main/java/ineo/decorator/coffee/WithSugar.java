package ineo.decorator.coffee;

/*
另一个具体装饰器类，用来给咖啡加糖，一样的逻辑。
*/
public class WithSugar extends CoffeeDecorator{
    /**
     * 在构造方法中，初始化咖啡对象的引用
     *
     * @param decoratorCoffee
     */
    public WithSugar(Coffee decoratorCoffee) {
        super(decoratorCoffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 1;
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", Sugar";
    }
}
