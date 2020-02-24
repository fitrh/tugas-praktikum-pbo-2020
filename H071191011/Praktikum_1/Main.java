class Main
{
	public static void main(String[] args) {
		Lampu lampu = new Lampu();

		System.out.println("new Lampu()");
		System.out.println(lampu.getState());

		lampu.turnOn();
		System.out.println("lampu.turnOn()");
		System.out.println(lampu.getState());

		lampu.turnOn();
		System.out.println("lampu.turnOn()");
		System.out.println(lampu.getState());
		
		lampu.turnOff();
		System.out.println("lampu.turnOff()");
		System.out.println(lampu.getState());

		lampu.turnOff();
		System.out.println("lampu.turnOff()");
		System.out.println(lampu.getState());

		lampu.turnOn();
		System.out.println("lampu.turnOn()");
		System.out.println(lampu.getState());

		lampu.turnOn();
		System.out.println("lampu.turnOn()");
		System.out.println(lampu.getState());
	}
}
