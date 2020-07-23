package ineo.decorator.coffee;

/*
咖啡接口，定义了获取花费和配料的接口。
*/
public interface Coffee {
    /** 获取价格 */
    double getCost();
    /** 获取配料 */
    String getIngredients();
}
