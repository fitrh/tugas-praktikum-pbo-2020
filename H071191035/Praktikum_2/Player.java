/**
 * Nomor 1
 */
public class Player {

    private String name;
    private int hp;
    private int attackPower;
    private int defense;

    public Player(String name, int defense) {
        this.name = name;
        this.defense = defense;
        hp = 100;
    }

    public Player(String name, int attackPower, int defense) {
        this.name = name;
        this.attackPower = attackPower;
        this.defense = defense;
        hp = 100;
    }

    // setter
    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    // getter
    public void getDamage(Player enemy) {
        hp = hp - Math.abs((defense - enemy.getAttackPower()));
    }

    public int getAttackPower() {
        return attackPower;
    }

    // description
    public void status(){
        System.out.printf("%s status\n", name);
        System.out.printf("Hp \t= %d\n", hp);
        System.out.printf("Defense = %d\n", defense);
        System.out.printf("Attack  = %d\n\n", attackPower);
    }

    public static void main(String[] args) {
        
        int defense = 15;
        int attack = 30;

        Player player1 = new Player("Mino", attack, defense);
        Player player2 = new Player("Hilda", defense);

        player2.setAttackPower(35);

        player1.getDamage(player2);
        player2.getDamage(player1);

        player1.status();
        player2.status();

    }

}