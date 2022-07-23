package Two;

/**
 * @author ZJJ
 * #Description Test
 * #Date: 2022/5/31 10:30
 */
public class Test {
    public static void main(String[] args) {
        CheeseBurger cheeseBurger = new CheeseBurger();
        Cola cola = new Cola();
        FrenchFries frenchFries = new FrenchFries();
        CheeseBurgerComboMeal cheeseBurgerComboMeal = new CheeseBurgerComboMeal(cheeseBurger, cola, frenchFries);

    }
}
