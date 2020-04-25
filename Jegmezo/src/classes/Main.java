package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main{
	private static HashMap<String,Field> fields = new HashMap<String,Field>();
	private static HashMap<String,CanMove> creatures = new HashMap<String,CanMove>();
	//private static HashMap<String,PolarBear> polarBears = new HashMap<String,PolarBear>();
	private static HashMap<String,Inventory> items = new HashMap<String,Inventory>();
	
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
	
	public static void WriteToFile(String result, File file) {
		 try {
			 FileWriter myWriter = new FileWriter(file);
			 myWriter.write(result);
			 myWriter.close();
		 } catch (IOException e) {
			 System.out.println("A kimeneti fajlal problema van.");
			 e.printStackTrace();
		 }
	}
	
	/*public static void Clear() {
		Game.Clear();
		fields.clear();
		creatures.clear();
		polarBears.clear();
	}*/
	
	/**
	 * @param data
	 */
	/**
	 * @param data
	 */
	public static void RunCommand(String data) {
		String[] command = data.split(" ");
		String fieldName;
		String creatureName;
		String itemName;
		String outputFileName;
		switch(command[0]) {
			case "SetLayer":
				fieldName = command[1];
				int layer = Integer.parseInt(command[2]);
				fields.get(fieldName).SetLayer(layer);
				break;
			case "AddCharacter":
				creatureName = command[1];
				fieldName = command[2];
				if(creatures.containsKey(creatureName))
					fields.get(fieldName).AddCreature(creatures.get(creatureName));
				break;
			case "PutOnDivingSuit":
				creatureName = command[1];
				creatures.get(creatureName).PutOnDivingSuit();
				break;
			case "EatFood":
				creatureName = command[1];
				creatures.get(creatureName).Eat();
				break;
			case "SomeoneDied":
				outputFileName = command[1];
				File outputFile = new File(outputFileName);
				if(Game.SomeoneDied()) {
					String deadPlayer = "nobody";
					for (String i : creatures.keySet()) {
					      if(creatures.get(i).IsDead())
					    	  deadPlayer = i;
					}
					WriteToFile("true " + deadPlayer, outputFile);
				}
				else
					WriteToFile("false", outputFile);
				break;
			/*case "Clear":
				Clear();
				break;*/
			case "MoveCharacter": 
				creatureName = command[1];
				fieldName = command[2];
				if(creatures.containsKey(creatureName))
					creatures.get(creatureName).Move(fields.get(fieldName));
				break;
			case "SetNumOfAction":
				creatureName = command[1];
				int actionNum = Integer.parseInt(command[2]);
				creatures.get(creatureName).SetNumOfAction(actionNum);
				break;
			case "PickUpItem":
				creatureName = command[1];
				itemName = command[2];
				creatures.get(creatureName).AddItem(items.get(itemName));
				Field field = creatures.get(creatureName).GetField();
				field.RemoveItem(items.get(itemName));
				break;
			case "SetCapacity":
				String fName=command[1];
				int capacity=Integer.parseInt(command[2]);
				fields.get(fName).SetCapacity(capacity);
				break;
			case"CreateItem":
				itemName=command[1];
				layer=Integer.parseInt(command[3]);
				switch(command[2]) {
				case "shovel":
					items.put(itemName, new Shovel(layer,true));
					break;
				case "gun":
					items.put(itemName, new Gun(layer,true));
					break;
				case "cartridge":
					items.put(itemName, new Cartridge(layer,true));
					break;
				case "flare":
					items.put(itemName, new Flare(layer,true));
					break;	
			case "UseAbility":
				creatureName=command[1];
				creatures.get(creatureName).UseAbility();
				break;
			case "createGame":
				ArrayList<Field> boardfield=(ArrayList<Field>) fields.values();
				Board board=new Board(boardfield);
				ArrayList<CanMove> cMove=(ArrayList<CanMove>) creatures.values();
				Game.SetBoard(board);
				Game.SetCanMove(cMove);
				break;
				
				//ez itt em tudom, hogy micsoda nekem ez conflict
	
	/*			item = command[2];
				if(creatures.containsKey(creatureName) && items.containsKey(item)){
					if(creatures.get(creatureName).field.hasItem(items.get(item))){
						creatures.get(creatureName).AddItem(items.get(item));
						creatures.get(creatureName).field.RemoveItem(items.get(item));
					}
				}
				break;*/ //
			case "FieldAddItem":
				itemName = command[1];
				fieldName = command[2];
				int layerlevel = Integer.parseInt(command[3]);
				fields.get(fieldName).AddItem(items.get(itemName));
				break;
			case "Dig":
				creatureName = command[1];
				itemName = command[2];
				if(items.containsKey(itemName) && creatures.containsKey(creatureName))
					items.get(itemName).Dig(creatures.get(creatureName));
				break;
			case "SetPlayerHp":
				creatureName = command[1];
				int hp = Integer.parseInt(command[2]);
				if(creatures.containsKey(creatureName))	creatures.get(creatureName).SetHp(hp);
				break;
			case "list":
				String object = command[1];
				String outFileName = command[2];
				File outFile = new File(outFileName);
				
				if(creatures.containsKey(object))	{
	
				/*	for (String i : creatures.keySet()) {
					      if(creatures.get(i).IsDead())
						    	  deadPlayer = i;
					}*/
					
					CanMove m = creatures.get(object);
					String winstring ;
					if(m.GetWin())	winstring="true";
					else	winstring="false";
					String itemstring="";
					ArrayList<Inventory> itemFromPlayer = m.GetItems();
					for(int i = 0 ; i < itemFromPlayer.size() ; i++) {
						if(items.containsValue(itemFromPlayer.get(i)))
							for(String s : items.keySet()) {
								if(items.get(s) == itemFromPlayer.get(i))	itemstring.concat(s); 
								if(i != itemFromPlayer.size())	itemstring.concat(",");
							}
					}
					String result;
					result = object + " attributes:\n" + "hp: " + m.GetHP() + "\n" + "numberOfAction: " + m.GetNumOfAction()
							+ "\n" + "maxHp: " + m.GetMaxHP() + "\n" + "win: " + winstring + "\n" + "items: " + itemstring + "\n";
					WriteToFile(result, outFile);
					
				}
				else if(fields.containsKey(object)) {
					Field f = fields.get(object);
					String visible ;
					if(f.visibleCapacity)	visible="true";
					else	visible="false";
					
					String itemstring = "";
					int c = 0 ;
					for(String s : items.keySet()) {
						
						if(f.hasItem(items.get(s)))	itemstring.concat(s); 
							if(f.GetItems().size()-1 != c )	itemstring.concat(",");
						
						c++;
					}
				
					String canmovestring = "";
					c = 0 ;
					ArrayList<CanMove> canmoves = f.GetCreatures();
					for(String s : creatures.keySet()) {
						if(creatures.get(s).GetField() == f )	canmovestring.concat(s);
						if(canmoves.size()-1 != c )	itemstring.concat(",");   //ha utolsó akkor nincs vessző 
						c++;
					}
					
					String neighbourString = "";
					c = 0 ;
					ArrayList<Field> neighbourfields = f.GetNeighbouringFields();
					for(String s : fields.keySet()) {
						for(int i = 0 ; i < neighbourfields.size() ; i++) {
							if(fields.get(s) == neighbourfields.get(i) )	neighbourString.concat(s);
						}
						
						if(canmoves.size()-1 != c )	itemstring.concat(",");   //ha utolsó akkor nincs vessző 
						c++;
					}
					String shelters;
					if(f.hasIglu)	shelters = "iglu";
					else	shelters= "";
					
					
					String result = object + " attributes:\n" + "capacity: " + f.capacity + "\n" + "snowLayer: " + f.GetLayer() + "\n"
							+ "visibleCapacity: " + visible + "\n" +"numOfPlayers: " + f.numOfPlayers + "\n" +
							"neighbourFields: " + neighbourString + "\n" + "canmoves: " + canmovestring + "\n" + "items: " + itemstring + "\n" +
							"shelter: " + shelters + "\n";
					WriteToFile(result, outFile);
					}
				break;
			case "CreateCharacter":
				String name = command[1];
				String type = command[2];
				switch(command[2]) {
					case "eskimo":
						Eskimo esk = new Eskimo();
						Game.AddCreature(esk);
						creatures.put(name, esk);
						break;
					case "explorer":
						Explorer exp = new Explorer();
						Game.AddCreature(exp);
						creatures.put(name, exp);
						break;
					case "polarbear":
						PolarBear pb = new PolarBear();
						Game.AddCreature(pb);
						creatures.put(name, pb);
						break;
					}
				break;
			case "StartStorm":
				fieldName = command[1];
				fields.get(fieldName).Storm();
				break;
			case "ThrowItem":
				creatureName = command[1];
				itemName = command[2];
				CanMove cm = creatures.get(creatureName);
				Inventory i = items.get(itemName);
				cm.RemoveItem(i);
				cm.GetField().AddItem(i);
				break;
			case "SetCurrentPlayer":
				creatureName = command[1];
				Game.SetCurrentPlayer(creatures.get(creatureName));
				break;
			case "FireGun":
				String p = command[1];
				creatures.get(p).FireGun();
				break;
			}
		}
	}
}