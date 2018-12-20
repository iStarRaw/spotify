package ilsa.spotify.models;

import java.util.ArrayList;
import java.util.List;

public class StringList {
	private List<String> lines;

	public StringList() {
		lines = new ArrayList<>();
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

	private void addSongToAlbum(Song song, Album album) {
		album.addSong(song);

	}

	public List<Item> makePlayList() {
		Album album = new Album();
		Song song = new Song();
		Advertisement advert = new Advertisement();
		List<Song> songs = new ArrayList<>();
		List<Advertisement> adverts = new ArrayList<>();

		for (String line : lines) {
			if (line.startsWith("CD ")) {
				album = saveAlbum(line);
			} else if (line.startsWith("SONG ")) {
				song = saveSong(line);
				addSongToAlbum(song, album);
				songs.add(song);

			} else if (line.startsWith("ADD ")) {
				advert = saveAdvert(line);
				adverts.add(advert);
			}
		}
		return mergeLists(songs, adverts);

	}

//	To perform this merge, iterate over all songs and after each song you add an
//	advertisement. You stop when the songs are exhausted. If the advertisements should
//	be exhausted before all your songs are exhausted, start from the first advertisement
//	again.
	public List<Item> mergeLists(List<Song> songs, List<Advertisement> adverts) {
		List<Item> playList = new ArrayList<>();
		int lengthNewList = songs.size() + adverts.size();

		for (int i = 0; i < lengthNewList; i++) {
			// You stop when the songs are exhausted.
			if (i < songs.size() - 1) {
				playList.add(songs.get(i));
//				If the advertisements should
//				be exhausted before all your songs are exhausted, start from the first advertisement
//				again.
				if (i > adverts.size()) {
					playList.add(adverts.get(i - adverts.size() - 1));
				}
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
