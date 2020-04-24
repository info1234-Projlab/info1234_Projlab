package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main{
	private static HashMap<String,Field> fields = new HashMap<String,Field>();
	private static HashMap<String,Player> players = new HashMap<String,Player>();
	private static HashMap<String,PolarBear> polarBears = new HashMap<String,PolarBear>();
	
	public static void main(String args[]) {
		String inputFileName = GetInputFile();
		File inputFile = new File(inputFileName);
		ReadFromFile(inputFile);
	}
	
	public static String GetInputFile() {
		System.out.println("Kerlek add meg a tesztfajl nevet!");
		Scanner in = new Scanner(System.in);
		String fileName = in.nextLine();
		in.close();
		return fileName;
	}
	
	public static void ReadFromFile(File file) {
		try {
			Scanner myReader = new Scanner(file);
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
	
	public static void WriteToFile(String result) {
		 try {
			 FileWriter myWriter = new FileWriter("test_results.txt");
			 myWriter.write(result);
			 myWriter.close();
		 } catch (IOException e) {
			 System.out.println("A kimeneti fajlal problema van.");
			 e.printStackTrace();
		 }
	}
	
	public static void Clear() {
		Game.Clear();
		fields.clear();
		players.clear();
		polarBears.clear();
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
		case "SomeoneDied":
			if(Game.SomeoneDied()) {
				String deadPlayer = "nobody";
				for (String i : players.keySet()) {
				      if(players.get(i).IsDead())
				    	  deadPlayer = i;
				}
				WriteToFile("true " + deadPlayer);
			}
			else
				WriteToFile("false");
			break;
		case "Clear":
			Clear();
			break;
		}
	}
}