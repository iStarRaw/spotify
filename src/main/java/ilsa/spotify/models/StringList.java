package ilsa.spotify.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringList {
	private List<String> lines;
	private List<Advertisement> adverts;

	public StringList() {
		lines = new ArrayList<>();
		adverts = new ArrayList<>();
	}

	public List<String> getLines() {
		return lines;
	}

	private Album saveAlbum(String line) {
		String[] words = line.split(",");
		String artist = words[0].substring(3);
		String name = words[1].trim();
		int releaseDate = Integer.parseInt(words[2].trim());

		Album album = new Album(artist, name, releaseDate);
		return album;
	}

	private Song saveSong(String line) {
		String[] words = line.split(",");
		int trackNumber = Integer.parseInt(words[0].substring(5));
		String title = words[1].trim();
		String lengthString = words[2].trim();

		Song song = new Song(trackNumber, title, lengthString);
		return song;

	}

	private Advertisement saveAdvert(String line) {
		String[] words = line.split(",");
		String company = words[0].substring(4);
		String lengthString = words[1].trim();

		Advertisement advert = new Advertisement(company, lengthString);
		return advert;

	}

	private void addSongToAlbum(Item song, Album album) {
		album.addSong((Song) song);

	}

	public List<Item> makePlayList() {
		Album album = new Album();
		Item song = new Song();
		Item advert = new Advertisement();
		List<Song> songs = new ArrayList<>();
//		List<Advertisement> adverts = new ArrayList<>();

		for (String line : lines) {
			if (line.startsWith("CD ")) {
				album = saveAlbum(line);
			} else if (line.startsWith("SONG ")) {
				song = saveSong(line);
				addSongToAlbum(song, album);
				((Song) song).setAlbum(album);
				songs.add((Song) song);

			} else if (line.startsWith("ADD ")) {
				advert = saveAdvert(line);
				adverts.add((Advertisement) advert);
			}
		}
		System.out.println(Arrays.toString(adverts.toArray())); //hier is lijst goed
		return mergeLists(songs, adverts);

	}

	/**
	 * all songs that have not been played yet should be written back to file. In
	 * addition, all adds, whether played or not should also be written back to file
	 * again. Similarly to the original file, the CDs/songs should go first. Then
	 * the adds (mind you, all adds should be written back to file, also those that
	 * have been played).
	 * 
	 * @param playlist
	 */
	public List<String> makeFormatForFile(Playlist player) {
		System.out.println(adverts.isEmpty());
		Album thisCD = null;
		Album tempCD = null;
//		List<String> adverts = new ArrayList<>();
		List<Item> playlist = player.getPlayList();
		List<Advertisement> adverts = player.getAdverts();
		
		List<String> linesToWrite = new ArrayList<>();
		linesToWrite.add("CDS");
//		adverts.add("ADDS");

		for (Item item : playlist) {
			if (item instanceof Song) {

				thisCD = ((Song) item).getAlbum();
				boolean isSameAlbum = thisCD.equals(tempCD);

				if (tempCD == null) {
					linesToWrite.add(thisCD.revertToFileFormat());
				} else if (!isSameAlbum) {
					linesToWrite.add(thisCD.revertToFileFormat());
				}
				Song tempSong = (Song)item;
				linesToWrite.add(tempSong.revertToFileFormat());

			} 
//			else if (item instanceof Advertisement) {
//				Advertisement tempAdd = (Advertisement)item;
//				adverts.add(tempAdd.revertToFileFormat());
//
//			}
			tempCD = thisCD;
			
		}
		
		linesToWrite.add("ADDS");
		System.out.println(adverts.isEmpty()); // true hier terwijl hij false moet zijn!!!
		
		
		for (int i = 0; i < adverts.size(); i++) {
			linesToWrite.add(adverts.get(i).revertToFileFormat());
		}
		
//		linesToWrite.addAll(adverts);
		System.out.println(Arrays.toString(linesToWrite.toArray()));
		return linesToWrite;

	}

//	To perform this merge, iterate over all songs and after each song you add an
//	advertisement. You stop when the songs are exhausted. If the advertisements should
//	be exhausted before all your songs are exhausted, start from the first advertisement
//	again.
	public List<Item> mergeLists(List<Song> songs, List<Advertisement> adverts) {
		List<Item> playList = new ArrayList<>();
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
		return playList;

	}

	@Override
	public String toString() {
		StringBuilder lineFile = new StringBuilder();
		lines.forEach((line) -> lineFile.append(line).append("\n"));
		return lineFile.toString();
	}

}
