package ilsa.spotify;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ilsa.spotify.models.Album;
import ilsa.spotify.models.Playlist;
import ilsa.spotify.models.Song;
import ilsa.spotify.transfer.Display;
import ilsa.spotify.transfer.StringFileIn;

public class App {
	final static URL FILE_SPOTIFY = App.class.getClassLoader().getResource("spotify.txt");

	public static void main(String[] args) {

		List<URL> fileBook = new ArrayList<>();
		fileBook.add(FILE_SPOTIFY);

		for (URL file : fileBook) {
			try {
				StringFileIn sf = readFile(file);
				sf.splitLines();

			} catch (FileNotFoundException e) {
				System.out.println("Not able to find your file.");
				e.printStackTrace();
			}

		}

		Display.printMenu();
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();

		switch (choice) {
		case 1:
			showPlaylist();
			break;
		case 2:
			addNewCD();
			break;
		case 3:
			play();
			break;

		case 4:
			shuffle();

			break;
		case 5:
			stop();

			break;
		}

	}

//	When the user selects play, the first song in the playlist is shown on screen, similarly
//	to in Option 1. Also, the add that immediately follows the song is shown on screen
//	(again similarly to Option 1).
//	Subsequently, the song and the add are removed from the playlist. Also remove the
//	song from the datastructure containing the songs. all songs that have not been
//	played yet should be written back to file. In addition, all adds, whether played or not
//	should also be written back to file again.
//	Similarly to the original file, the CDs/songs should go first. Then the adds (mind you,
//	all adds should be written back to file, also those that have been played).
	private static void play() {
		// TODO Auto-generated method stub

	}

//	The playlist is shown on screen in the following format:
//		Album: U2’s Songs of Innocence
//		Track The Miracle (4:15)
//		Next add: ING Bank (0:20)
//		Album: U2’s Songs of Innocence
//		Track Every Breaking Wave (4:12)
//		Next add: Bol.com (0:15)
	private static void showPlaylist() {
		// TODO Auto-generated method stub

	}

//	Through questions you ask the user to fill in all the necessary data for the CD and the
//	songs in the CD. To ease reading in, you may ask the user to specify the number of
//	songs he/she is going to enter.
//	After adding the CD+songs, add the songs to the playlist and introduce adds in
//	between the songs (for ease you can start at the first add again).
	private static void addNewCD() {
		System.out.print("CD\nArtist: ");
		Scanner input = new Scanner(System.in);
		String artist = input.next();

		System.out.print("Title: ");
		String name = input.next();

		input.nextLine();
		System.out.print("Release Year: ");
		int releaseDate = input.nextInt();

		Album album = new Album(artist, name, releaseDate);

		System.out.print("\nYOU CAN ENTER THE SONGS HERE. (0 WHEN READY).\n\nSONGS");
		int trackNumber = 0;
		
		do {
			System.out.print("\nTrack number: ");
			trackNumber = input.nextInt();
			
			System.out.print("Song title: ");
			String title = input.next();
			
			System.out.print("Length (minutes:seconds): ");
			String length = input.next();
			
			Song song = new Song(trackNumber, title, length);
			album.addSong(song);
			
		} while (trackNumber != 0);

	}

//	Instead of taking the first song in the playlist, you need to shuffle the playlist. You
//	should do this by using appropriate functionality in the Collections class. After
//	shuffling the playlist, you take the two entries at the top and display those (similar to
//	Option 3).
//	Subsequently, the top 2 entries are removed the playlist. Also remove the song from
//	the datastructure containing the songs.
//	Hint 1: using any other way for shuffling will not give you points.
//	Hint 2: it might be that after shuffling songs and adds do not follow a nice pattern
//	anymore (which is OK!)
	
//	Both for option 3 and 4 there is one more step to take: all songs that have not been
//	played yet should be written back to file. In addition, all adds, whether played or not
//	should also be written back to file again.
//	Similarly to the original file, the CDs/songs should go first. Then the adds (mind you,
//	all adds should be written back to file, also those that have been played).
	private static void shuffle() {
		// TODO Auto-generated method stub

	}

	private static void stop() {
		// TODO Auto-generated method stub

	}
	
	private static StringFileIn readFile(URL file) throws FileNotFoundException {
		StringFileIn sf = new StringFileIn();

		try (Scanner readLine = new Scanner(new FileReader(file.getFile()))) {
			while (readLine.hasNextLine()) {
				sf.getLines().add(readLine.nextLine());
			}
			System.out.println(sf.toString());
		}
		return sf;

	}

}
