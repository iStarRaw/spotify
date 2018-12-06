package ilsa.spotify;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ilsa.spotify.transfer.StringFile;

public class App {
	public static void main(String[] args) {
		final URL FILE_SPOTIFY = App.class.getClassLoader().getResource("spotify.txt");

		List<URL> fileBook = new ArrayList<>();
		fileBook.add(FILE_SPOTIFY);
		
		

		for (URL file : fileBook) {
			try {
				StringFile sf = readFile(file);
				
				
			} catch (FileNotFoundException e) {
				System.out.println("Not able to find your file.");
				e.printStackTrace();
			}

		}
		
		

//		Display.printMenu();
//		Scanner input = new Scanner(System.in);
//		int choice = input.nextInt();
//
//    	switch (choice) {
//		case 1:
//			showPlaylist();
//			break;
//		case 2:
//			addNewCD();
//			break;
//		case 3:
//			play();
//			break;
//			
//		case 4:
//			shuffle();
//			
//			break;
//		case 5:
//			stop();
//			
//			break;
//    	}

	}

	private static StringFile readFile(URL file) throws FileNotFoundException {
		StringFile sf = new StringFile();

		try (Scanner readLine = new Scanner(new FileReader(file.getFile()))) {
			while (readLine.hasNextLine()) {
				sf.getLines().add(readLine.nextLine());
			}
			System.out.println(sf.toString());
		}
		return sf;

	}
}
