package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main{
	private static HashMap<String,Field> fields = new HashMap<String, Field>();
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
		switch(command[0]) {
		case "SetLayer":
			String fieldName = command[1];
			int layer = Integer.parseInt(command[2]);
			fields.get(fieldName).SetLayer(layer);
			break;
		case "":
			
		}

	}
	
}