package multi;

public class main1 extends Thread {
	public void run() {
		try {
			System.out.println("chatting");
			}
			catch(Exception e){
				System.out.println(e);
			}
			finally {
				System.out.println("end!!!");
			}
	}
}
