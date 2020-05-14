package _01_IntroToArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
	public static void main(String[] args) {
		//1. Create an array list of Strings
		//   Don't forget to import the ArrayList class
		ArrayList<String> names = new ArrayList<String>();
		//2. Add five Strings to your list
		names.add("Pepega");
		names.add("WeirdChamp");
		names.add("5Head");
		names.add("PogU");
		names.add("WideHard");
		
		//3. Print all the Strings using a standard for-loop
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
		
		//4. Print all the Strings using a for-each loop
		for(String s: names) {
			System.out.println(s);
		}
		//5. Print only the even numbered elements in the list.
		for (int i = 0; i < names.size(); i+=2) {
			System.out.println(i);
		}
		//6. Print all the Strings in reverse order.
		for (int i = names.size()- 1; i >= 0; i--) {
			System.out.println(names.get(i));
		}
		//7. Print only the Strings that have the letter 'e' in them.
		for (int i = 0; i < args.length; i++) {
			if(names.contains("e")) {
				System.out.println(names.get(i));
			}
		}
	}
}
