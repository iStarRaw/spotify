package ilsa.spotify.transfer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ilsa.spotify.models.Album;
import ilsa.spotify.models.Song;

public class StringFileIn {
	private List<String> lines;

	public StringFileIn() {
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
			
			Album album = new Album(artist,name,releaseDate);
			return album;
	}
	
	private Song saveSong(String line) {
		String[] words = line.split(",");
		int trackNumber = Integer.parseInt(words[0].substring(5));
		String title = words[1].trim();
		String length = words[2].trim();
		
		Song song = new Song(trackNumber, title, length);
		//TODO add song to album
		return song;
		
	}
	
	public void addSongToAlbum(Song song, Album album) {
		album.addSong(song);
		
	}

	// TODO doorlopen lines and splitten in CD, SONG & ADDS
	public void splitLines() {
		// if line starts with CDS
		for (String line : lines) {
			// if line starts with CD then add this line as CD
			if (line.startsWith("CD ")) {
				saveAlbum(line);
			} else if (line.startsWith("SONG ")) {
				saveSong(line);
				//TODO add song to album
			}
			
		}
		
		

	}
	
	@Override
	public String toString() {
		StringBuilder lineFile = new StringBuilder();
		  lines.forEach(  
		            (line)->lineFile.append(line).append("\n")  
		        );
		return lineFile.toString(); 
	}
	
}
