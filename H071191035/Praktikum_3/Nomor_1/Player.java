import java.util.ArrayList;
import java.util.List;
/**
 * Nomor 1
 */
public class Player {

    private String name, role;
    private int level, money;
    private double damage, energy, hp;
    private List<Item> items = new ArrayList<>();

    public Player(String name, String role, int money) {
        this.name = name;
        this.role = role;
        this.money = money;
        level = 1;
        damage = 10.0;
        energy = 100.0;
        hp = 100.0;
    }

    public void addDamage(double damage) {
        this.damage += damage;
    }

    public void addEnergy(double energy) {
        this.energy += energy;
    }

    // getter
    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public int getMoney() {
        return money;
    }

    public int getLevel() {
        return level;
    }

    public double getDamagePower() {
        return damage;
    }

    public double getEnergy() {
        return energy;
    }

    public double getHp() {
        return hp;
    }
    
    public void addMoney(int money) {
        this.money += money;
    }

    public void addItem(Item item) {
        items.add(item);
        item.setOwner(this);
    }

    public Item[] getItem() {
        Item[] itemList = new Item[items.size()];
        return items.toArray(itemList);
    }

    public void removeItem(int a) {
        Item item = items.get(a);
        items.remove(a);
        item.setOwner(null);
    }

    public void showStatus() {

        if (hp <= 0) {
            hp = 0;
        }

        System.out.printf("These are %s's status :\n\n", name);
        System.out.printf("Name \t: %s\n", name);
        System.out.printf("Role \t: %s\n", role);
        System.out.printf("Money \t: %d\n", money);
        System.out.printf("Level \t: %d\n", level);
        System.out.printf("Damage \t: %.1f\n", damage);
        System.out.printf("Energy \t: %.1f\n", energy);
        System.out.printf("HP \t: %.1f\n\n", hp);
    }

    public void showItems() {
        System.out.printf("These are %s's item(s) :\n\n", name);
        
        for (Item item : items) {
            System.out.printf("Name \t: %s\n", item.getName());
            System.out.printf("Info \t: %s\n", item.getInfo());
            System.out.printf("Type \t: %s\n", item.getType());
            System.out.printf("Price \t: %d gold\n", item.getPrice());
            System.out.println("------------------");
        }

        System.out.printf("%s has %d item(s) in total\n", name, items.size());
        System.out.println("------------------\n");
    }

    public boolean attack(Player enemy) {

        if(energy < 10) {
            System.out.printf("%s has no energy to attack %s\n\n", name, enemy.name);
            return false;
        } else {
            getDamage();
            System.out.printf("%s is attacking %s...\n", name, enemy.name);
            System.out.printf("%s's energy(-%d)\n", name, 10);
            System.out.printf("%s's HP(-%.0f)\n\n", enemy.name, damage);
            enemy.hp -= damage;
            energy -= 10;
            return true;
        }

    }

    public boolean healing(double restored) {
        if (hp <= 0) {
            System.out.printf("Can't heal, %s is already dead...\n\n", name);
            return false;
        } else {

            hp += restored;

                if (hp > 100) {
                    System.out.printf("%s is healing itself...\n%s's HP(+%.1f)\n\n", name, name, restored);
                    hp = 100;        
                    return true;
                } else {
                    System.out.printf("%s is healing itself...\n%s's HP(+%.1f)\n\n", name, name, restored);
                    return true;
                }
            
        }
    }

    public boolean buy(Item item) {
        
        if (money < item.getPrice()) {
            System.out.printf("%s want to buy %s but\n", name, item.getName());
            System.out.printf("Insufficient money for %s\n\n", name);
            return false;
        } else {
            System.out.printf("%s bought by %s\n", item.getName(), name);
            System.out.printf("%s's money(-%d)\n\n", name, item.getPrice());
            items.add(item);
            money -= item.getPrice();  
            item.sell();
            return true;
        }

    }

    public String getDamage() {
        return "a fight is happening...";
    }

}