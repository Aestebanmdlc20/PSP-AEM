
public class HiloIsAlive extends Thread {
	
	@Override
	public void run() {
		System.out.println("En el HiloIsAlive ...");
		try {
			this.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
