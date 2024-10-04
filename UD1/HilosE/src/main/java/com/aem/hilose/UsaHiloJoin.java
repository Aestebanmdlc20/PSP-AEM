package com.aem.hilose;
public class UsaHiloJoin {
	
	public static void main (String[] args) throws InterruptedException {
		HiloJoin hs = new HiloJoin();
		hs.start();
		hs.join();
		
		System.out.println("Termin� de ejecutarse UsaHiloJoin");
	}

}
