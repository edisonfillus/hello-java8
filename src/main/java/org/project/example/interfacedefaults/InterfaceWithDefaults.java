package org.project.example.interfacedefaults;

public interface InterfaceWithDefaults {

	/**
	 * NEW: Java 8 Interfaces can accept method implementations on Interfaces. 
	 * This methods don't need to be implemented on Classes that implemented the interface.
	 * Permit to evolve interfaces without breaking the current implementations
	 * OBS: It can define or use attributes, to this, it still needs an Abstract Class
	 * @param s
	 */
	default void printDefault(String s) {
		System.out.println(s);
	}
	
	void printNonDefault(String s) ;
	
}
