package org.project.example.interfacedefaults;

public class ClassThatImplementedInterfaceWithDefauls implements InterfaceWithDefaults {

	@Override
	public void printNonDefault(String s) {
		printDefault(s); //NEW: It's possible to call the default method of interface.
	}

	/**
	 * It's optional to implement a Default method in interface
	 * public void printDefault(String s) { System.out.println(s); }
	 */

}
