/**
 * Nomor 3 (tambahan)
 */
public class Pokemon {

    private String name, type;
    private int attackPower, defense;
    private int hp;
    private boolean isDead;

    // constructor
    public Pokemon() {
        name = "Unnamed";
        type = "Powerless";
        isDead = true;
    }

    public Pokemon(String name, String type, int attackPower , int defense) {
        this.name = name;
        this.type = type;
        this.attackPower = attackPower;
        this.defense = defense;
        hp = 100;
    }

    // getter 
    public void strikes(Pokemon enemy) {

        System.out.printf("%s is attacking %s...\n\n", name, enemy.name);
            
            if (type.equalsIgnoreCase("water") && enemy.type.equalsIgnoreCase("ligthning")) {
                enemy.hp = enemy.hp - Math.abs(enemy.defense - ((attackPower)*(20/100)));
            } else if (type.equalsIgnoreCase("earth") && enemy.type.equalsIgnoreCase("water")) {
                enemy.hp = enemy.hp - Math.abs(enemy.defense - ((attackPower)*(20/100)));
            } else if (type.equalsIgnoreCase("fire") && enemy.type.equalsIgnoreCase("water")) {
                enemy.hp = enemy.hp - Math.abs(enemy.defense - ((attackPower)*(20/100)));
            } else if (type.equalsIgnoreCase("lightning") && enemy.type.equalsIgnoreCase("earth")) {
                enemy.hp = enemy.hp - Math.abs(enemy.defense - ((attackPower)*(20/100)));
            } else {
                enemy.hp = enemy.hp - Math.abs(enemy.defense - (attackPower));
            }
        
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getAttackPower() {
        return attackPower;
    }

    // other method
    public void isDead(Pokemon pokemon) {

        isAlive(pokemon);

        String name = pokemon.name;

        if (isDead) {
            System.out.printf("HP = %d\n%s is dead...\n\n", pokemon.hp, name);
        } else {
            System.out.printf("HP = %d\n%s is alive...\n\n", pokemon.hp, name);
        }

    }

    // when die
    private boolean isAlive(Pokemon pokemon) {

        if(pokemon.hp <= 0) {
            pokemon.hp = 0;
            isDead = true;
        } else {
            isDead = false;
        }

        return isDead;

    }

    // description
    public void desc() {
        System.out.printf("Name \t= %s\n", name);
        System.out.printf("Type \t= %s\n", type);
        System.out.printf("HP \t= %d\n", hp);
        System.out.printf("Defense = %d\n", defense);
        System.out.printf("Attack \t= %d\n\n", attackPower);
    }

    public static void main(String[] args) {
        
        Pokemon pikachu = new Pokemon("Pikachu", "Lightning", 50, 25);
        Pokemon drainase = new Pokemon("Drainase", "Water", 100, 50);

        pikachu.desc();
        drainase.desc();

        // 1st attack
        drainase.strikes(pikachu);
        pikachu.isDead(pikachu);

        // 2nd attack
        drainase.strikes(pikachu);
        pikachu.isDead(pikachu);
    }

}