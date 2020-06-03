package Praktikum_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Team {
    Random rand = new Random();

    private String name;
    private String playerName1, playerName2, playerName3, playerName4, playerName5;
    private List<Player> players = new ArrayList<>(); 

    

    // Player a1 = new Player(playerName1);
    // Player a2 = new Player(playerName2);
    // Player a3 = new Player(playerName3);
    // Player a4 = new Player(playerName4);
    // Player a5 = new Player(playerName5);
    public Team(String name) {
        this.name = name;
    }
    public void setTeam(int a) {
        if (a == 1) {
            playerName1 = "Upin";
            playerName2 = "Ipin";
            playerName3 = "Mail";
            playerName4 = "Jarjit";
            playerName5 = "Fizi";
        } else if (a == 2) {
            playerName1 = "Spongebob";
            playerName2 = "Squidward";
            playerName3 = "Patrick";
            playerName4 = "Sandy";
            playerName5 = "Plankton";
        } else if (a == 3) {
            playerName1 = "Doraemon";
            playerName2 = "Nobita";
            playerName3 = "Jayen";
            playerName4 = "Suneo";
            playerName5 = "Sizuka";
        }
        players.add(new Player(playerName1));
        players.add(new Player(playerName2));
        players.add(new Player(playerName3));
        players.add(new Player(playerName4));
        players.add(new Player(playerName5));
    }
        
    public String getName() {
        return name;
    }
    public void timStatus() {
        System.out.printf("============ TIM %s STATUS ============",name);
        for (int i = 0; i < players.size(); i++) {
            players.get(i).showStatus();
        }
    }
    public void buyItem() {
        int ran = ThreadLocalRandom.current().nextInt(0,4);
        players.get(ran).buy(players.get(ran), 2);
        System.out.printf("Tim %s buy Item\n",name);
    }
    public void timItem() {
        System.out.printf("============ TIM %s ITEM ============", name);
        for (int i = 0; i < players.size(); i++) {
            players.get(i).showItems();
        }
    }
    public String figthTeam(Team enemy) {
        //int getAngka = (int)(Math.random()*players.size());
        players.get((int)(Math.random()*players.size())).getDamage(enemy.players.get((int)(Math.random()*players.size())));
        System.out.println("Tim "+ enemy.name +" attack by " + name);
        return "Tim "+ name+" attack byyyyyy " + enemy.name;
        //return String.format("Tim %s attack by %s",name, enemy.name);
    }
}
