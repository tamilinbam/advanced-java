package multithreading;

public class hello {
	public static void main(String[] args) {
		app a= new app ();
		Thread t1= new Thread(a);
		Thread t2= new Thread(a);
		t1.setName("number");
		t2.setName("char");
		t1.start();
		t2.start();
	}
}
