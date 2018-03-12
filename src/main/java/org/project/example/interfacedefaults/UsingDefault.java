package org.project.example.interfacedefaults;

public class UsingDefault {

	public static void main(String[] args) {
		ClassThatImplementedInterfaceWithDefauls c = new ClassThatImplementedInterfaceWithDefauls();
		c.printDefault("This is the default method only implemented in interface");
		c.printNonDefault("This is the method implemented, that called the default method in interface");
		
	}
}
