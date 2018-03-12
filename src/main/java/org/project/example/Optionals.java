package org.project.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.project.example.model.User;

public class Optionals {

	public static void main(String[] args) {
		List<User> userlist = new ArrayList<>();
		userlist.add(new User(1, "Peter", "peter@example.com", 30));
		userlist.add(new User(2, "Richard", "richard@example.com", 35));
		userlist.add(new User(3, "Alice", "alice@example.com", 25));
		userlist.add(new User(4, "Prince", "prince@example.com", 40));

		// Get an optional object from stream		
		Optional<User> optional = userlist.stream().filter(u -> u.getAge() > 35).findAny();

		User user = null;
		
		// This way it can throw an NullPointerException is User is null
		user = optional.get();
		
		// This way it will return the User or null if optional is void
		user = optional.orElse(null);
		
		// This way only execute the command if User is not null
		optional.ifPresent(u -> System.out.println(u.getName()));
		
		
		
	}

}
