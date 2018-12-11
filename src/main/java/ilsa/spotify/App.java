package ilsa.spotify;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ilsa.spotify.models.Playlist;
import ilsa.spotify.transfer.Display;
import ilsa.spotify.transfer.StringList;

public class App {
	final static URL FILE_SPOTIFY = App.class.getClassLoader().getResource("spotify.txt");

	public static void main(String[] args) {

		List<URL> fileBook = new ArrayList<>();
		fileBook.add(FILE_SPOTIFY);

		for (URL file : fileBook) {
			try {
				StringList sf = readFile(file);
				sf.splitLines();

			} catch (FileNotFoundException e) {
				System.out.println("Not able to find your file.");
				e.printStackTrace();
			}

		}

		Display.printMenu();
		
		Playlist player = new Playlist();
		
		
		
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();

		switch (choice) {
		case 1:
			player.show();
			break;
		case 2:
			player.addCD();
			break;
		case 3:
			player.play();
			break;

		case 4:
			player.shuffle();

			break;
		case 5:
			player.stop();

			break;
		}
		
		input.close();

	}

	
	private static StringList readFile(URL file) throws FileNotFoundException {
		StringList sf = new StringList();

		try (Scanner readLine = new Scanner(new FileReader(file.getFile()))) {
			while (readLine.hasNextLine()) {
				sf.getLines().add(readLine.nextLine());
			}
			System.out.println(sf.toString());
		}
		return sf;

	}

}
