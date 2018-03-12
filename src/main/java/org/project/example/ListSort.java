package org.project.example;

import static java.util.Comparator.comparing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.project.example.model.User;

public class ListSort {

	public static void main(String[] args) {

		List<String> words = new ArrayList<>();
		words.add("alura online");
		words.add("casa do código");
		words.add("caelum");

		Comparator<String> comparador = new ComparadorDeStringPorTamanho();

		// NEW: Interface List now has a .sort Method
		words.sort(comparador);

		// OLD: Anonymous class
		words.sort(new Comparator<String>() {
			public int compare(String s1, String s2) {
				return Integer.compare(s1.length(), s2.length());
			}
		});
		
		// NEW: Lambda functions
		words.sort((String s1, String s2) -> {return Integer.compare(s1.length(), s2.length());});
		
		words.sort((s1, s2) -> s1.length() - s2.length());
		
		words.sort(Comparator.comparing(s -> s.length()));
		
		words.sort(Comparator.comparing(String::length));
		
		// Comparator as import static
		words.sort(comparing(String::length));
		
		words.sort(String::compareTo);
		
		words.sort(String.CASE_INSENSITIVE_ORDER);
		
		
		// Example using classes
		List<User> userlist = new ArrayList<>();
		userlist.add(new User(1,"Peter","peter@example.com"));
		userlist.add(new User(2,"Richard","richard@example.com"));
		userlist.add(new User(3,"Alice","alice@example.com"));
		
		// Sort and Comparator with Lambdas
		userlist.sort(comparing(User::getName));
		userlist.forEach(user -> System.out.println(user.getName()));
		
		userlist.sort(comparing(User::getId));
		userlist.forEach(user -> System.out.println(user.getName()));
		
		userlist.sort(comparing(User::getId).reversed());
		userlist.forEach(user -> System.out.println(user.getName()));
				
		
		
	}

}

class ComparadorDeStringPorTamanho implements Comparator<String> {
	public int compare(String s1, String s2) {
		return Integer.compare(s1.length(), s2.length());
	}
}
