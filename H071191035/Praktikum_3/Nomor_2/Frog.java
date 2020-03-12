/**
 * Nomor 2 (Tambahan)
 */
class Frog {

    private String color;
    private int jump;

    public Frog(String color, int jump) {
        this.color = color;
        this.jump = jump;
    }

    public boolean compare(Frog frog) {
        return jump > frog.jump ? true : false;
    }

    // getter
    public static int getMax(Frog frogs[]) {
    
        int max = frogs[0].jump;

        for (int i = 1; i < frogs.length; i++) {
            max = frogs[i].jump > max ? frogs[i].jump : max;
        }

        return max;
    
    }

    public boolean getRun(Field field) {

        if (field != null) {
            return true;
        }
        
        return false;
    
    }

    public void getProcess(Field field) {

        if(getRun(field)) {

            int steppingStone = 0;
            
            for(int i = 0; i < field.getBambooHeight().length; i++) {
                
                if(jump - (field.getBambooHeight(i) - steppingStone) > 0) {
                    System.out.printf("The %s frog managed to jump over bamboo number %d\n\n", color, i + 1);
                } else {   
                    System.out.printf("The %s frog failed to jump over bamboo number %d\n\n", color, i + 1);
                    break;
                }
            }
        }
        else {
            System.out.println("Field doesn't exist...");
        }
    }
}