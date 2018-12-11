package ilsa.spotify.transfer;

import java.util.ArrayList;
import java.util.List;

import ilsa.spotify.models.Advertisement;
import ilsa.spotify.models.Album;
import ilsa.spotify.models.Song;

public class StringList {
	private List<String> lines;

	public StringList() {
		lines = new ArrayList<>();
	}

	public List<String> getLines() {
		return lines;
	}

	// TODO doorlopen lines and splitten in CD, SONG & ADDS
	public void splitLines() {
		Album album = null;
		List<Advertisement> adverts = new ArrayList<>();
		
		// if line starts with CDS
		for (String line : lines) {
			// if line starts with CD then add this line as CD
			if (line.startsWith("CD ")) {
				album = saveAlbum(line);
			} else if (line.startsWith("SONG ")) {
				Song song = saveSong(line);
				album.addSong(song);

			} else if (line.startsWith("ADD ")) {
				Advertisement adv = saveAdvertisement(line);
				adverts.add(adv);
				
			}
		}
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
		String length = words[2].trim();

		Song song = new Song(trackNumber, title, length);
		// TODO add song to album
		return song;

	}

	private Advertisement saveAdvertisement(String line) {
		String[] words = line.split(",");

		Advertisement adv = new Advertisement();
		return adv;
	}

	public void addSongToAlbum(Song song, Album album) {
		album.addSong(song);

	}

	@Override
	public String toString() {
		StringBuilder lineFile = new StringBuilder();
		lines.forEach((line) -> lineFile.append(line).append("\n"));
		return lineFile.toString();
	}

}
