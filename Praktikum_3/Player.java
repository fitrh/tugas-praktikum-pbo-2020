package Praktikum_3;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

public class Player {
    Scanner pew = new Scanner(System.in);
    private String name;
    private int level;
    private double damage;
    private double hp;
    private int money;
    private List<Item> items;
    
    public Player(String name) {
        this.name = name;
        hp = 100;
        level = 1;
        money = 1000; 
        damage = ThreadLocalRandom.current().nextInt(2,10);
        items = new ArrayList<>();
        items.add(new Item("Hp Potion", 20, "+20 Hp"));
        items.add(new Item("Hp Potion", 20, "+20 Hp"));
    }
    public List<Item> getItem() {
        return items;
    }
    public String getName() {
        return name;
    }
    public void showStatus() {
        System.out.println("+-----------------------------+");
        System.out.println("Name " + name);
        System.out.println("Level " + level);
        System.out.println("HP " + hp);
        System.out.println("Attack Power " + damage);
        System.out.println("Money " + money);
        System.out.println("+-----------------------------+\n");
    }
    public void sell(int count){
        //int jual = items.get(count).getPrice();
        System.out.println("sell this item?");
        String answer = pew.next().toLowerCase();
        if(answer.equals("y")){
            items.remove(count);
            money += 15;
        }
        
    }
    public void showItems() {
        System.out.println();
        for (int i = 0; i < items.size(); i++) {
            Item.descItem(items.get(i));
        }
        System.out.println();
    }
    public String getDamage(Player enemy) {
        double crit = ThreadLocalRandom.current().nextInt(10,100);
        if(crit <= enemy.hp) {
            enemy.hp -= (damage + (crit/2));
            System.out.printf("Critical!!!! %s received %f damage\n", enemy.name , (damage +(crit/2)));
            return String.format("Critical!!!! %s received %f damage", enemy.name , (damage +(crit/2)));
        }
        enemy.hp -= damage;
        System.out.println(enemy.name + " received " + damage + " damage by " + name);
        return enemy.name + " received " + damage + " damage by " + name;
        //return String.format("%s received %d damage by %s", enemy.name , damage, name);
    }
    public boolean dead(Player player) {
        if(player.hp <= 0) {
            return true;
        } else {
            return false;
        }
    }
    public void healing(Player player) {
        if(!dead(player)) {
            if((player.hp + 20) >= 100){
                player.hp = 100;
                System.out.println("Hp max!");
            }else{
                for (int i = 0; i < items.size(); i++) {
                    if(items.get(i).hpPotion()){
                        
                        player.hp += 20;
                        break;
                    }else if(i == items.size()-1){
                        System.out.println("no Hp potion");
                    }
                }
            }
        }
    }
    public void buy(Player player, int count){
        if(!dead(player)){
            if(money >= 20){
                for (int i = 0; i < count; i++) {
                    items.add(new Item("Hp Potion", 20, "+20 Hp"));
                    money -= 20;
                }
            }else{
                System.out.println("cari uang lagi bro");
            }
        }

    }
}