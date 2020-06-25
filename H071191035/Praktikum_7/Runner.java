public class Runner implements Runnable {
    private Integer number;
    private Thread thread;
    private Race race;

    Runner(Integer number) {
        this.number = number;
        thread = new Thread(this);
    }

    public String getName() {
        return String.format("Runner-%d", number);
    }

    public Runner joinRace(Race race) {
        if (this.race == null) {
            this.race = race;
            this.race.addParticipant();
        }
        return this;
    }
    
    public void start() {
        if (race == null) {
            System.out.printf("%s haven't entered any race...\n", this.getName());
        } else {
            if (race.getIsStart()) {
                thread.start();
            } else {
                System.out.printf("Hey %s the hasn't started yet\n", this.getName());
            }
        }
    }

    @Override
    public void run() {
        System.out.printf("%s is running...\n", getName());
        try {
            Thread.sleep(race.getTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // add winner
        if (race.getWinners().size() < 3) {
            race.getWinners().add(this.getName());            }
            // add loser 
        else {
            race.getLosers().add(this.getName());
        }
    }
}