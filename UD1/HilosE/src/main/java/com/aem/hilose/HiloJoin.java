
public class HiloJoin extends Thread {
	
	@Override
	public void run() {
		System.out.println("En el HiloJoin ...");
		try {
			this.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
