/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        
        // players
        Player p1 = new Player("Joergen", "Ranger", 100);
        Player p2 = new Player("Sven", "Mage", 100);
        Player p3 = new Player("Bengt", "Swordsman", 50);
        Player p4 = new Player("WaterSheep", "Shopkeeper", 100);

        // items
        Item item1 = new Item("Energy Potion", "Restore 50 amount of energy", "Energy Potions", 50, 20);
        Item item2 = new Item("Rod Of Discord", "Create a discord inside enemy's head, damage 30", "Magic", 30,  70);
        Item item3 = new Item("Phantasm", "This bow shoots regular arrow first then followed by another 5 phantom arrows, damage 55", "Range", 55, 45);
        Item item4 = new Item("Meowmere", "Legendary powerful sword that shoots nyan cats as projectiles, damage 300", "Melee", 300, 200);

        // add items to p4 (as Shopkeeper)
        p4.addItem(item1);
        p4.addItem(item2);
        p4.addItem(item3);
        p4.addItem(item4);

        // show p4 status & items
        p4.showStatus();
        p4.showItems();

        // buying interactions
        // p1 buy item1 from p4
        p1.buy(item1);
        p1.showItems();
        p1.showStatus();

        // show p4 status & items after p1 bought item1
        p4.showStatus();
        p4.showItems();

        // add item2 to p2
        p2.buy(item2);
        p2.showItems();
        p2.showStatus();

        // add item3 & item1 to p3
        p3.buy(item3);
        p3.buy(item1);
        p3.showItems();
        p3.showStatus();

        // show p4 status & items after p2 bought item2 and p3 bought item3
        p4.showStatus();
        p4.showItems();

        // fighting interactions
        p3.attack(p2);

        p3.showStatus();
        p2.showStatus();

        item2.use(p2);
        p2.attack(p3);
        p2.attack(p3);
        p2.attack(p3);
        p2.showStatus();

        p3.showStatus();
        
        // restore hp
        p3.healing(65);
        p3.showStatus();

        p2.healing(50);
        p2.showItems();
        p2.showStatus();
    }

}