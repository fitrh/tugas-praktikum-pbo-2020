import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Race {
	private Random rand;
	private boolean isStart;
	private int time;
	private int participant;
	private List<String> winners = Collections.synchronizedList(new ArrayList<>());
	private List<String> losers = Collections.synchronizedList(new ArrayList<>());

	Race() {
		this.isStart = false;
		this.time = 0;
		this.participant = 0;
		this.rand = new Random();
	}

	// getter
	public boolean getIsStart() {
		return this.isStart;
	}

	public int getTime() {
		return this.time;
	}

	public int getParticipant() {
		return this.participant;
	}

	public List<String> getWinners() {
		return this.winners;
	}
	
	public List<String> getLosers() {
		return this.losers;
	}

	// add
	public void addParticipant() {
		this.participant++;
	}

	public void start() {
		if (participant >= 3) {
			System.out.println("\nTHE RACE STARTS\n");
			time = participant*1000;
			isStart = true;
		} else {
			System.out.println("The race cannot be started, runners are not enough\n");
		}
	}

	public void result() {
		this.isStart = false;
		while (true) {
			if (winners.size() + losers.size() == participant) {
				System.out.println("\nTHE RACE IS OVER\n");
				String[] ranks = {"1st", "2nd", "3rd"};
				// show winners
				for (int i = 0; i < ranks.length; i++) {
					System.out.printf("%s : %s | %s\n", ranks[i], this.winners.get(i), this.happyFace());
				}
				System.out.println();
				// show losers
				for (String name : losers) {
					System.out.printf("%s is lost | %s\n", name, this.sadFace());
				}
				return;
			}
		}
	}

	// nothing useful down here
	public String happyFace() {
		String[] faces = {
			":D", "^_^", "^o^", ":)", ">:)"
		};
		return faces[rand.nextInt(faces.length)];
	}

	public String sadFace() {	
		String[] faces = {
			"T_T", "x_X", "-_-", ">:(", ":(", "T^T"
		};
		return faces[rand.nextInt(faces.length)];
	}
}