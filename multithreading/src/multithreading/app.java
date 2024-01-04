package multithreading;

public class app implements Runnable {
	public void run() {
		if (Thread.currentThread().getName().equals("number")) {
			numberprint();
		}
		else {
			charprint();
		}
	}
	public void numberprint() {
		for(int i = 1;i<=5;i++) {
			System.out.println(i);
		}
	}
	public void charprint() {
		for(int i='A';i<='E';i++) {
			System.out.println(i);
		}
	}
}
