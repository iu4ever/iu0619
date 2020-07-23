package ineo.decorator.coffee;

/*
咖啡对象的装饰器类，同样实现Coffee接口，定义一个Coffe对象的引用，在构造器中进行初始化。并且将getCost（）
和getIntegredients()方法转发给被装饰对象。
*/
public abstract class CoffeeDecorator implements Coffee{

    //我定义了Coffee类型的DecoratorCoffee之后。再用构造器注入该对象
    /*protected Coffee decoratedCoffee;
    public CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }*/

    /*
    我定义了一个final类型的Coffee之后，编译器报错：Variable 'decoratorCoffee' might not have been initialized
    我可以给decoratorCoffee一个初始化的值。protected final Coffee decoratorCoffee = null;
    但这样给了初始化的值以后，再生成构造器的时候，构造器不会自动包装这个decoratorCoffee。会生成一个无参的构造器
    public CoffeeDecorator() {
    }
    所以我们还是不要这样初始化了。
     */
    protected final Coffee decoratorCoffee;

    /**
     * 在构造方法中，初始化咖啡对象的引用
     */
    public CoffeeDecorator(Coffee decoratorCoffee) {
        this.decoratorCoffee = decoratorCoffee;
    }

    /**
     * 装饰器父类中直接转发"请求"至引用对象
     */
    @Override
    public double getCost() {
        return decoratorCoffee.getCost();
    }

    @Override
    public String getIngredients() {
        return decoratorCoffee.getIngredients();
    }
}
