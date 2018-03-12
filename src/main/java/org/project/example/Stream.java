package org.project.example;

import static java.util.Comparator.comparing;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.project.example.model.User;

public class Stream {

	public static void main(String[] args) {
		List<User> userlist = new ArrayList<>();
		userlist.add(new User(1, "Peter", "peter@example.com", 30));
		userlist.add(new User(2, "Richard", "richard@example.com", 35));
		userlist.add(new User(3, "Alice", "alice@example.com", 25));
		userlist.add(new User(4, "Prince", "prince@example.com", 40));

		// Filter + MAP
		userlist.stream().filter(user -> user.getAge() > 30).mapToInt(User::getAge).forEach(System.out::println);

		userlist.stream().filter(user -> user.getName().length() > 5).map(User::getEmail).forEach(System.out::println);

		// MapToInt + Average
		userlist.stream().mapToInt(User::getAge).average().ifPresent(System.out::println);
		System.out.println(userlist.stream().mapToInt(User::getAge).sum());

		// FindAny (get any on the list) + ifPresent (don't need to test null)
		userlist.stream().filter(user -> user.getAge() > 35).findAny().ifPresent(u -> System.out.println(u.getName()));

		// Order and get first
		userlist.stream().sorted(comparing(User::getAge)).findFirst()
				.ifPresent(u -> System.out.println("User " + u.getName() + " has " + u.getAge()));

		// Getting a collection from stream result
		List<User> result = userlist.stream().filter(user -> user.getAge() < 35).collect(Collectors.toList());
		result.forEach(u -> System.out.println(u.getEmail()));

		//Getting a map(key,value) form stream result
		Map<String, String> map = userlist.stream().filter(user -> user.getAge() < 35)
				.collect(Collectors.toMap(u -> u.getName(), u -> u.getEmail()));
		map.forEach((k,v) -> System.out.println(k));
		
		//Using parallel processing. Useful only on big lists (> some millions)
		userlist.parallelStream().filter(user -> user.getAge() > 35).findAny().ifPresent(u -> System.out.println(u.getName()));

		
		
	}
}
