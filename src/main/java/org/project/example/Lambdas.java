package org.project.example;

public class Lambdas {

	public static void main(String[] args) {

		// OLD: Anonymous class
		new Thread(new Runnable() {
		    @Override
		    public void run() {
		        System.out.println("Executando um Runnable");
		    }

		}).start();
		
		// NEW: Lambda
		new Thread(() -> System.out.println("Executando um Runnable")).start();
		
		
	}

}
