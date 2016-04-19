import java.util.Iterator;
import java.util.List;

import enumarate.Builder;
import enumarate.Type;
import enumarate.Wood;

public class FindGuitarTester {
	public static void main(String[] args) {
		// Set up Rick’s guitar inventory
		Inventory inventory = new Inventory();
		initializeInventory(inventory);
		
		//Erin will search by GuitarSpec instead of a full guitar
		//Guitar whatErinLikes = new Guitar("", 0, Builder.FENDER, "Stratocastor", Type.ELECTRIC, Wood.ALDER, Wood.ALDER);
		GuitarSpec whatErinLikes = new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, Wood.ALDER, Wood.ALDER);
		
		/* This function didn't do exactly what customer want.
		*  Which is give buyers all matching guitars that they want.
		*/  
//		System.out.println("--- Search first matching guitar ---");
//		Guitar guitar = inventory.searchForFirstMatching(whatErinLikes);
//		if (guitar != null) {
//			System.out.println("Erin, you might like this " + guitar.getBuilder() + " " + guitar.getModel() + " "
//					+ guitar.getType() + " guitar:\n " + guitar.getBackWood() + " back and sides,\n "
//					+ guitar.getTopWood() + " top.\nYou can have it for only $" + guitar.getPrice() + "!");
//		} else {
//			System.out.println("Sorry, Erin, we have nothing for you.");
//		}
		
		/* This function do exactly what customer (guitar shop owner) want.
		*/  
//		System.out.println("");
//		System.out.println("--- Search all matching guitar ---");
//		List<Guitar> matchingGuitars = inventory.searchAllInventory(whatErinLikes);
//		if (!matchingGuitars.isEmpty()) {
//			System.out.println("Erin, you might like these guitars:");
//			for (Iterator<Guitar> i = matchingGuitars.iterator(); i.hasNext();) {
//				Guitar guitar = (Guitar) i.next();
//				System.out.println(" We have a " + guitar.getBuilder() + " " + guitar.getModel() + " "
//						+ guitar.getType() + " guitar:\n " + guitar.getBackWood() + " back and sides,\n "
//						+ guitar.getTopWood() + " top.\n You can have it for only $" + guitar.getPrice() + "!\n ----");
//			}
//		} else {
//			System.out.println("Sorry, Erin, we have nothing for you.");
//		}
		
		/* Improve the system by encapsulation.
		 * Replace all general attributes of a guitar by GuitarSpec Object
		 */
		System.out.println("");
		System.out.println("--- Search all matching guitar by using GuitarSpec ---");
		List<Guitar> matchingGuitars = inventory.searchAllInventory(whatErinLikes);
		if (!matchingGuitars.isEmpty()) {
			System.out.println("Erin, you might like these guitars:");
			for (Iterator<Guitar> i = matchingGuitars.iterator(); i.hasNext();) {
				Guitar guitar = (Guitar) i.next();
				GuitarSpec spec = guitar.getSpec();
				System.out.println(" We have a " + spec.getBuilder() + " " + spec.getModel() + " "
						+ spec.getType() + " guitar:\n " + spec.getBackWood() + " back and sides,\n "
						+ spec.getTopWood() + " top.\n You can have it for only $" + guitar.getPrice() + "!\n ----");
			}
		} else {
			System.out.println("Sorry, Erin, we have nothing for you.");
		}
	}

	private static void initializeInventory(Inventory inventory) {
		inventory.addGuitar("V95693", 1499.95, Builder.FENDER, "Stratocastor", Type.ELECTRIC, Wood.ALDER, Wood.ALDER);
		inventory.addGuitar("V9512", 1549.95, Builder.FENDER, "Stratocastor", Type.ELECTRIC, Wood.ALDER, Wood.ALDER);
	}
}