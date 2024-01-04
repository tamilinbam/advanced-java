package multi;

public class main extends Thread {
	public void run() {
		try {
		System.out.println("opening instagram");
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally {
			System.out.println("end!!!");
		}
	}
}
