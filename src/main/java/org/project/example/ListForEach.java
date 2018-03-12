package org.project.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ListForEach {
	
	public static void main(String[] args) {

		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");
		
		//NEW: The Consumer determine what a forEach should do
		Consumer<String> consumidor = new StringConsumer();
		
		//NEW: Interface List now has a .forEach Method
		palavras.forEach(consumidor);
		
		//OLD: Using Anonymous Class
		palavras.forEach(new Consumer<String>() {
		    public void accept(String s) {
		        System.out.println(s);
		    }
		});
		
		//NEW: Using lambdas (long version, more than 1 line)
		palavras.forEach((String palavra) -> {System.out.println(palavra);});
		
		//NEW: Using lambdas (short version, just one line, implicit Type)
		palavras.forEach(palavra -> System.out.println(palavra));
		
		//NEW: Using lambdas (very short version, just one method invocation with one unique parameter)
		palavras.forEach(System.out::println);
		
				
		//Other use cases
		palavras.forEach(palavra -> System.out.println(palavra.substring(0, 5)));
		
		
		
			
		
	}
}
class StringConsumer implements Consumer<String> {
    public void accept(String s) {
        System.out.println(s);
    }
}
