package etc;

public class People {

    public String name;
    public int money;

    public People(String name, int money) {
        this.name = name;
        this.money = money;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", money=" + money;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }
}
