package Homework_7;

//        1. Расширить задачу про котов и тарелки с едой
//        2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20)
//        3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true
//        4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы)
//        5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль
//        6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку

import static java.lang.System.*;

class Plate {
    public int food;
    public Plate(int food) {
        this.food = food;
    }
    boolean decreaseFood(int n) {
        int diff = food - n;
        if (diff < 0) return false;

        food -= n;
        return true;
    }
    void addFood(int food) {
        this.food += food;
    }
    void info() {
        out.println("plate: " + food);
    }
}
class Cat {
    private String name;
    private int appetite;
    private boolean hungry;

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.hungry = true;
    }

    void info() {
        String isHungry = !hungry ? "сыт" : "голоден";
        out.println(name + ": " + isHungry);
    }

    void eat(Plate plate) {
        if (hungry && plate.decreaseFood(appetite))
            hungry = false;
    }
}
public class Homework_7 {
    public static
    void main(String[] args) {
        Cat[] cats = {new Cat("Vasya", 50), new Cat("Pushok", 50), new Cat("Snezhok", 25), new Cat("Kuzma", 5), new Cat("Murzik", 10)};
// здесь вводим наполнение миски и программа автоматический определит какой из котов сможет наесться а какой нет.
        Plate plate = new Plate( 50);

        for (Cat cat : cats) {
            cat.eat(plate);
            cat.info();
        }
    }
}