package ilsa.spotify;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import ilsa.spotify.models.Display;
import ilsa.spotify.models.Playlist;
import ilsa.spotify.models.Song;
import ilsa.spotify.models.StringList;

public class App {

	public static void main(String[] args) {

//		System.out.println("Please give your file name: ");
		Scanner input = new Scanner(System.in);
//		String fileName = input.next();
		String fileName = "spotify.txt";
		String fileNameEmpty = "newSpotify";
		Playlist player = new Playlist();

		final URL FILE_SPOTIFY = App.class.getClassLoader().getResource(fileName);
		final URL FILE_WRITE = App.class.getClassLoader().getResource(fileNameEmpty);

		try {
			StringList sList = readFile(FILE_SPOTIFY);
			player.setPlayList(sList.makePlayList());
			System.out.println(player.toString());

			// opslaan als current playlist
//			player = 

			// show()

		} catch (FileNotFoundException e) {
			System.out.println("Not able to find your file.");
			e.printStackTrace();
		}

		int choice = 0;

		do {
			Display.printMenu();

			choice = input.nextInt();

			switch (choice) {
			case 1:
				player.show();
				break;
			case 2:
				player.addCD();
				break;
			case 3:
				player.play();
//				all songs that have not been
//				played yet should be written back to file. In addition, all adds, whether played or not
//				should also be written back to file again.
//				Similarly to the original file, the CDs/songs should go first. Then the adds (mind you,
//				all adds should be written back to file, also those that have been played).
				try {
					writeFile(player, FILE_WRITE);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				player.shuffle();
				break;
			case 5:
				player.stop();
				break;
			}

		} while (choice != 5);

	}

	private static StringList readFile(URL file) throws FileNotFoundException {
		StringList sList = new StringList();

		try (Scanner readLine = new Scanner(new FileReader(file.getFile()))) {
			while (readLine.hasNextLine()) {
				sList.getLines().add(readLine.nextLine());
			}
		}
		return sList;

	}

	/**
	 * all songs that have not been played yet should be written back to file. In
	 * addition, all adds, whether played or not should also be written back to file
	 * again. Similarly to the original file, the CDs/songs should go first. Then
	 * the adds (mind you, all adds should be written back to file, also those that
	 * have been played).
	 */
	private static void writeFile(Playlist player, URL file) throws FileNotFoundException {
		StringList sList = new StringList();
		
		System.out.println("Dit is de playList: " + Arrays.toString(player.getPlayList().toArray()));
		
		for (int i = 0; i < player.getPlayList().size(); i++) {
			sList.getLines().add(player.getPlayList().get(i).toString());
		}
		
		sList.makeCorrectFormat();
		
		sList.writeFile();
		
		
	}

	
}
