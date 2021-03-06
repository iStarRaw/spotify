package ilsa.spotify.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Playlist implements Player {
	private List<Song> songs;
	private List<Item> playList;
	private List<Advertisement> adverts;
	private List<Album> albums;

	public Playlist() {
		playList = new ArrayList<>();
		adverts = new ArrayList<>();
		songs = new ArrayList<>();
		albums = new ArrayList<>();

	}

	public List<Item> getPlayList() {
		return playList;
	}

	public void setPlayList(List<Item> playList) {
		this.playList = playList;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public List<Advertisement> getAdverts() {
		return adverts;
	}

	@Override
	public void show() {
		if (!playList.isEmpty()) {
			System.out.println(this.toString());
		} else {
			System.out.println("Your playlist is empty.\n");
		}
	}

	/**
	 * TODO Instead of taking the first song in the playlist, you need to shuffle the
	 * playlist. You should do this by using appropriate functionality in the
	 * Collections class. After shuffling the playlist, you take the two entries at
	 * the top and display those (similar to Option 3). Subsequently, the top 2
	 * entries are removed the playlist. Also remove the song from the datastructure
	 * containing the songs. Hint 1: using any other way for shuffling will not give
	 * you points. Hint 2: it might be that after shuffling songs and adds do not
	 * follow a nice pattern anymore (which is OK!)
	 * 
	 * Both for option 3 and 4 there is one more step to take: all songs that have
	 * not been played yet should be written back to file. In addition, all adds,
	 * whether played or not should also be written back to file again. Similarly to
	 * the original file, the CDs/songs should go first. Then the adds (mind you,
	 * all adds should be written back to file, also those that have been played).
	 */
	@Override
	public void shuffle() {
		// TODO Auto-generated method stub

	}

	/**
	 * When the user selects play, the first song in the playlist is shown on
	 * screen, similarly to in Option 1. Also, the add that immediately follows the
	 * song is shown on screen (again similarly to Option 1). Subsequently, the song
	 * and the add are removed from the playlist. Also remove the song from the
	 * datastructure containing the songs. 
	 * TODO all songs that have not been played yet
	 * should be written back to file. In addition, all adds, whether played or not
	 * should also be written back to file again. Similarly to the original file,
	 * the CDs/songs should go first. Then the adds (mind you, all adds should be
	 * written back to file, also those that have been played).
	 */
	@Override
	public void play() {
		int indexFirstSong = 0;
		
		System.out.println("adverts in play: " + Arrays.toString(adverts.toArray()));

		if (playList.isEmpty()) {
			System.out.println("Your playlist is empty.\n");
		} else {
			for (Item item : playList) {
				if (item instanceof Song) {
					System.out.println(item.toString());
					indexFirstSong = playList.indexOf(item);

					playList.remove(indexFirstSong);
					removeFromSongs((Song) item);

					int indexAfterFirstSong = indexFirstSong;
					Item itemAfterFirstSong = playList.get(indexAfterFirstSong);

					if (itemAfterFirstSong instanceof Advertisement) {
						System.out.println(itemAfterFirstSong.toString() + "\n");
						this.playList.remove(indexAfterFirstSong);
					}
					break;
				}
			}
		}
	}

	private void removeFromSongs(Song firstSong) {
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

	/**
	 * Through questions you ask the user to fill in all the necessary data for the
	 * CD and the songs in the CD. To ease reading in, you may ask the user to
	 * specify the number of songs he/she is going to enter. After adding the
	 * CD+songs, add the songs to the playlist and introduce adds in between the
	 * songs (for ease you can start at the first add again).
	 */
	@Override
	public void addCD() {
		emptyPlayList();
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
		albums.add(album);

		System.out.print("Total number of tracks: ");
		int trackTotal = input.nextInt();
		album.setTrackTotal(trackTotal);

		System.out.print("\nPLEASE ENTER SONG DETAILS.");
		for (int i = 0; i < trackTotal; i++) {
			int trackNumber = i + 1;
			System.out.printf("\nTrack number: %d\n", trackNumber);

			input.nextLine(); // reset scanner

			System.out.print("Song title: ");
			String title = input.nextLine();

			System.out.print("Length (minutes:seconds): ");
			String length = input.next();

			Song song = new Song(trackNumber, title, length);
			album.addSong(song);
			song.setAlbum(album);

		}
		songs.addAll(album.getSongs());
		mergeToPlayList();

	}

	private void emptyPlayList() {
		deleteSongs();
		moveAndDeleteAdverts();

	}

	private void deleteSongs() {
		for (Iterator<Item> iterator = playList.iterator(); iterator.hasNext();) {
			Item item = iterator.next();
			if (item instanceof Song) {
				iterator.remove();
			}
		}
	}

	private void moveAndDeleteAdverts() {
		for (Iterator<Item> iterator = playList.iterator(); iterator.hasNext();) {
			Item item = iterator.next();
			if (item instanceof Advertisement) {
				adverts.add((Advertisement) item);
				iterator.remove();
			}
		}
	}

	/**
	 * You stop when the songs are exhausted. If the advertisements should be
	 * exhausted before all your songs are exhausted, start from the first
	 * advertisement again.
	 * 
	 */
	public void mergeToPlayList() {
		int lastIndexAdverts = adverts.size() - 1;
		int count = 0;

		for (int i = 0; i < songs.size(); i++) {
			playList.add(songs.get(i));

			if (i < adverts.size()) {
				playList.add(adverts.get(i));
			} else {
				int indexAdvertToGet = i - lastIndexAdverts + count;
				Item advertToAdd = (Advertisement) playList.get(indexAdvertToGet);
				playList.add(advertToAdd);
				count++;
			}
		}
	}

	public String toString() {
		StringBuilder playListString = new StringBuilder();
		Album thisAlbum = null;
		Album tempAlbum = null;

		for (Item item : playList) {
			
			if (item instanceof Song) {
				thisAlbum = ((Song) item).getAlbum();
				boolean isSameAlbum = thisAlbum.equals(tempAlbum);

				if (tempAlbum == null) {
					playListString.append(thisAlbum.toString());
					playListString.append("\n");
				} else if (!isSameAlbum) {
					playListString.append(thisAlbum.toString());
					playListString.append("\n");
				}
			}
			playListString.append(item.toString());
			playListString.append("\n");
			tempAlbum = thisAlbum;

		}
		return playListString.toString();

	}

}
