package daemon;

public class main {
	public static void main(String[]args) {
		main2 m2 = new main2();
		main2 m3 = new main2();
		main2 m4 = new main2();
		
		m2.setDaemon(true);
		m2.start();
		m3.start();
		m4.start();
		
	}
}
