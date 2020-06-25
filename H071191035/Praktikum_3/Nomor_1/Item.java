/**
 * Nomor 1
 */
public class Item {

    private String name, info, type;
    private int price, effect;
    private Player owner;

    public Item(String name, String info, String type, int effect, int price) {
        this.name = name;
        this.info = info;
        this.type = type;
        this.effect = effect;
        this.price = price;
    }

    // setter
    public void setOwner(Player player) {
        owner = player;
    }

    // getter
    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public int getPrice() {
        return price;
    }
    
    public String getType() {
        return type;
    }

    public Player getOwner() {
        return owner;
    }

    private int findItem() {
        
        if (owner == null) {
            return -1;
        }        

        Item[] items = owner.getItem();

        for (int i = 0; i < items.length; i++) {
            
            if (items[i] == this) {
                return i;
            }

        }
        return -1;
    }

    public void use(Player owner) {

        if (type.equals("Energy Potions")) {
            owner.addEnergy(effect);
            System.out.printf("%s used %s...\n\n", owner.getName(), name);
            destroy();
        } else if(type.equals("Melee")) {
            owner.addDamage(effect);
            System.out.printf("%s used %s...\n\n", owner.getName(), name);
        } else if(type.equals("Range")) {
            owner.addDamage(effect);
            System.out.printf("%s used %s...\n\n", owner.getName(), name);
        } else if(type.equals("Magic")) {
            owner.addDamage(effect);
            System.out.printf("%s used %s...\n\n", owner.getName(), name);
        }

    }

    public void sell() {
        owner.addMoney(price);
        destroy();
    }

    public void destroy() {
        if (findItem() >= 0) {
            owner.removeItem(findItem());
        }
    }

}