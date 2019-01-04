package ilsa.spotify;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

		Scanner input = new Scanner(System.in);
		String fileName = "spotify.txt";
		String fileNameEmpty = "newSpotify";
		Playlist player = new Playlist();

		final URL FILE_SPOTIFY = App.class.getClassLoader().getResource(fileName);
		
		String dirName = System.getProperty("user.home");
		final File dir = new File (dirName);
		final File actualFile = new File (dir, fileNameEmpty);
		
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
					System.out.println("in try catch");
					writeFile(player, actualFile);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
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
	 * 
	 * @throws IOException
	 */
	private static void writeFile(Playlist player, File file) throws IOException {
		System.out.println("in writeFile");
		StringList sList = new StringList();

		List<String> listToExport = sList.makeFormatForFile(player.getPlayList());
		
		System.out.println("filename is: " + file);
		
		try (FileWriter writer = new FileWriter(file)) {
			for (int i = 0; i < listToExport.size(); i++) {
				//TODO waar is de RABOBANK advertentie????
				writer.write("\n");
			}
		}

	}

}
