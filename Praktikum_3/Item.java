package Praktikum_3;

public class Item {
    private String name, info;
    private int price;

    public Item(String name, int price, String info) {
        this.name = name;
        this.info = info;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public String getInfo() {
        return String.format("Item : %s\n\tDescription : %s\n\tPrice : %d", name, info, price);
    }
	public boolean hpPotion() {
		if(name.equalsIgnoreCase("Hp Potion")) {
            return true;
        }
        return false;
    }
    public static void descItem(Item items) {
        System.out.println();
        System.out.println("Name\t: " + items.getName());
        System.out.println("Price\t: " + items.getPrice());
        System.out.println();
    }
    
}
