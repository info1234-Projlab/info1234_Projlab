package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main{
	private static HashMap<String,Field> fields = new HashMap<String,Field>();
	private static HashMap<String,Player> players = new HashMap<String,Player>();
	private static HashMap<String,PolarBear> polarBears = new HashMap<String,PolarBear>();
	
	public static void main(String args[]) {
		String inputFileName = GetInputFile();
	
		try {
		   File inputFile = new File(inputFileName);
		   Scanner myReader = new Scanner(inputFile);
		   while (myReader.hasNextLine()) {
		      String command = myReader.nextLine();
		      RunCommand(command);
		   }
		   myReader.close();
		}catch (FileNotFoundException e) {
		    System.out.println("A fajl nem talalhato.");
		    e.printStackTrace();
		}
	}
	
	public static String GetInputFile() {
		System.out.println("Kerlek add meg a tesztfajl nevet!");
		Scanner in = new Scanner(System.in);
		String fileName = in.nextLine();
		in.close();
		return fileName;
	}
	
	public static void RunCommand(String data) {
		String[] command = data.split(" ");
		String fieldName;
		String creatureName;
		switch(command[0]) {
		case "SetLayer":
			fieldName = command[1];
			int layer = Integer.parseInt(command[2]);
			fields.get(fieldName).SetLayer(layer);
			break;
		case "AddCharacter":
			creatureName = command[1];
			fieldName = command[2];
			if(players.containsKey(creatureName))
				fields.get(fieldName).AddCreature(players.get(creatureName));
			else if(polarBears.containsKey(creatureName))
				fields.get(fieldName).AddCreature(polarBears.get(creatureName));
			break;
		case "PutOnDivingSuit":
			creatureName = command[1];
			players.get(creatureName).PutOnDivingSuit();
			break;
		case "EatFood":
			creatureName = command[1];
			players.get(creatureName).Eat();
			break;
	}

	}
	
}