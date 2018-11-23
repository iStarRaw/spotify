package ilsa.spotify;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ilsa.spotify.models.Album;
import ilsa.spotify.transfer.Display;
import ilsa.spotify.transfer.StringFile;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
    	final URL FILE_SPOTIFY = App.class.getClassLoader().getResource("spotify.txt");
    	
    	List<URL> fileBook = new ArrayList<>();
    	
    	fileBook.add(FILE_SPOTIFY);
    	
    	
    	for (URL file : fileBook) {
    		try {
				readFile(FILE_SPOTIFY);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Not able to find your file.");
				e.printStackTrace();
			}
    		
    	}
    		
    	Display.printMenu();
    	Scanner input = new Scanner(System.in);
    	int choice = input.nextInt();
    	
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

	private static void readFile(URL file) throws FileNotFoundException{
//			List<String> line = calculateDimensions(file);
//			StringFile sf = new StringFile(dimensions);
//			
//			try (Scanner readLine = new Scanner(new FileReader(file.getFile()))) {
//
//				while (readLine.hasNextLine()) {
//					
//					for (int row = 0; row < sf.getMyMultiStringArray().length; row++) {
//						for (int column = 0; column < sf.getMyMultiStringArray()[row].length; column++) {
//							if (readLine.hasNext()) {
//							sf.getMyMultiStringArray()[row][column] = readLine.next();
//							}
//						}
//					}
//				}
//			}
//			return sf;
//		}
		
	}
}
