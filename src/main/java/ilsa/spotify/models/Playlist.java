package ilsa.spotify.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Playlist implements Player {
	private List<Song> songs;
	private List<Item> playList;
	private List<Advertisement> adverts;
	
	public Playlist() {
		playList = new ArrayList<>();
		adverts = new ArrayList<>();
		songs = new ArrayList<>();

	}
	
	@Override
	public void show() {
		System.out.println(this.toString());
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
	
	@Override
	public void shuffle() {
		// TODO Auto-generated method stub
		
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
	
	@Override
	public void play() {
		Song firstSong = (Song) playList.get(0);
		Advertisement firstAd = (Advertisement) playList.get(1);
		
		System.out.println(firstSong.toString());
		System.out.println(firstAd.toString());
		
		playList.remove(0);
		playList.remove(1);
		
		for (Iterator<Song> iterator = songs.iterator(); iterator.hasNext();) {
			Song song = iterator.next();
			if (song.equals(firstSong)) {
				iterator.remove();
			}
		}
		
	}

	@Override
	public void stop() {
		System.out.println("Thank you for playing, the application has stopped :-)");
		
	}

	
//	Through questions you ask the user to fill in all the necessary data for the CD and the
//	songs in the CD. To ease reading in, you may ask the user to specify the number of
//	songs he/she is going to enter.
	
//	After adding the CD+songs, add the songs to the playlist and introduce adds in
//	between the songs (for ease you can start at the first add again).
	
	@Override
	public void addCD() {
		System.out.println("PLEASE ENTER CD DETAILS.");
		System.out.print("CD\nArtist: ");
		Scanner input = new Scanner(System.in);
		String artist = input.next();

		System.out.print("Title: ");
		String name = input.next();

		input.nextLine();
		System.out.print("Release Year: ");
		int releaseDate = input.nextInt();

		Album album = new Album(artist, name, releaseDate);

		System.out.print("Total number of tracks: ");
		int trackTotal = input.nextInt();
		album.setTrackTotal(trackTotal);
		
		System.out.print("\nPLEASE ENTER SONG DETAILS.");
		for (int i = 0; i < trackTotal; i++) {
			int trackNumber = i+1;
			System.out.printf("\nTrack number: %d\n", trackNumber);
			
			input.nextLine(); //reset scanner
			
			System.out.print("Song title: ");
			String title = input.nextLine();
			
			System.out.print("Length (minutes:seconds): ");
			String length = input.next();
			
			Song song = new Song(trackNumber, title, length);
			album.addSong(song);
		}
		
//		After adding the CD+songs, add the songs to the playlist and introduce adds in
//		between the songs (for ease you can start at the first add again).
		playList.addAll(album.getSongs());
		
		for (int i = 0; i < playList.size() - 1; i++) {
			
		}
		
		playList.addAll(adverts);
		
		
		input.close();
		
	}
	
	
//	The playlist is shown on screen in the following format:
//	Album: U2’s Songs of Innocence
//	Track The Miracle (4:15)
//	Next add: ING Bank (0:20)
//	Album: U2’s Songs of Innocence
//	Track Every Breaking Wave (4:12)
//	Next add: Bol.com (0:15)
	public String toString() {
		StringBuilder playListString = new StringBuilder();
		
		for (Item item: playList) {
			System.out.println(item.toString());
		}
		
		return playListString.toString();
	}

}
