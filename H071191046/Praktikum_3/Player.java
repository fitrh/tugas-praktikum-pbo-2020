import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class Player {
    private String name;
    private String role;
    private int level;
    private double damage;
    private double hp;
    private double energy;
    private int money;
   private List<Item> items;

    public Player (String name, String role) {
        items = new ArrayList<>();
        this.name = name;
        this.role = role;
        level = 1;
        damage = 10;
        hp = 100;
        energy = 100;
        money  = 10000;
    }
    public String getName() {
        return name;
    }
    public String getRole() {
        return role;
    }
    public int getLevel() {
        return level;
    }
    public void showStatus() {
        System.out.println("Name : " + name);
        System.out.println("Role : " + role);
        System.out.println("Level : " + level);
        System.out.println("Damage : " + damage);
        System.out.println("Hp : " + hp);
        System.out.println("Energy : " + energy);
        System.out.println("Money : " + money);
    }
    public void showItems() {
        for(int i = 0; i < items.size(); i++) {
            items.get(i).descItem();
        }
    }
    public void healing () {
        if (money >= 50) {
            hp += 10;
            money -= 50;
        } else {
            System.out.println("UANG" + name + "TIDAK MENCUKUPI");
        }
    }
    public void attack (Player player) {
        player.hp -= damage;
        energy -= 10;
    }
    public boolean mati(Player enemy) {
        if (enemy.hp <= 0) {
            System.out.println(enemy.name + " DAH MATI HUHUHU");
            return true;
        }else {
            return false;
        }
    }
    public void buy() {
        System.out.println("ITEM 1");
        System.out.println("Deadly Blade");
        System.out.println("Price : 100");
        System.out.println("");
        System.out.println("ITEM 2");
        System.out.println("Malefic Roar");
        System.out.println("Price : 120");
        System.out.println("");
        System.out.println("ITEM 3");
        System.out.println("Golden Staff");
        System.out.println("{Price : 150}");
        System.out.println("");

        Scanner sc = new Scanner(System.in);
        System.out.println("SELECT ITEM");
        int mana = sc.nextInt();

        if (mana == 1) {
            System.out.println("Deadly Blade Successfully Purchased");
            items.add(new Item("Deadly Blade", 100, "-"));
            money -= 100;
        } else if (mana == 2) {
            System.out.println("Malefic Roar Successfully Purchased");
            items.add(new Item("Malefic Roar", 120, "-"));
            money -= 120;
        } else if (mana == 3) {
            System.out.println("Golden Staff Successfully Purchased");
            items.add(new Item("Golden Staff", 150, "-"));
            money -= 150;
        }
    }
}