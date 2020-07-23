package ineo.decorator.cake;

public class Client {
    public static void main(String[] args) {
        // 用果仁，花包装乳酪蛋糕。
        Cake nutsFlowerChocolateCake = new NutsDecorator(new FlowerDecorator(
                new CheeseCake()));
        System.out.println("remark:" + nutsFlowerChocolateCake.getRemark());
        // 吃蛋糕的感受已经发生了改变。
        System.out.println("impression:"
                + nutsFlowerChocolateCake.getImpression());
    }
}
