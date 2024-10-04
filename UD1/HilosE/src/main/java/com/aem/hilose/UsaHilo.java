package com.aem.hilose;
public class UsaHilo {
	
	public static void main (String[] args) throws InterruptedException {
		HiloSimple hs = new HiloSimple();
		hs.start();
				
		System.out.println("Termin� de ejecutarse UsaHilo");
	}

}
