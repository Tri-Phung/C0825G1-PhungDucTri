package mvc.repository;

import mvc.common.compare.DishCompareByName;
import mvc.entity.Dish;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DishRepository {

    private static List<Dish> dishes = new ArrayList<>();

    static {
        dishes.add(new Dish(1, "Gà chiến mắm", 200000, "Siêu ngon"));
    }

    public List<Dish> getDishes() {

        return dishes;
    }

    public void save(Dish dish) {
        dishes.add(dish);
    }
}
