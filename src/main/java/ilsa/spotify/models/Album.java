package ilsa.spotify.models;

import java.util.ArrayList;
import java.util.List;


/**
 * @author ilsadejager
 * CD U2, Songs of Innocence, 2014
 *
 */
public class Album {
	private List<Song> songs;
	private int trackTotal = 0;
	private String artist;
	private String name;
	private int releaseYear;
	private final String PREFIX_CD = "CD";
	private final String SEPERATOR = ", ";
	
	public Album(String artist, String name, int releaseDate) {
		this.artist = artist;
		this.name = name;
		this.releaseYear = releaseDate;
		songs = new ArrayList<>();
	}
	
	public Album() {
		
	}
	
	public List<Song> getSongs() {
		return songs;
	}

	public int getTrackTotal() {
		return trackTotal;
	}

	public void setTrackTotal(int trackTotal) {
		this.trackTotal = trackTotal;
	}

	public void addSong(Song song) {
		songs.add(song);
		
	}
	
	@Override
	public String toString() {
		StringBuilder albumString = new StringBuilder();
		albumString.append(PREFIX_CD).append(" ").append(artist).append(SEPERATOR).append(name).append(SEPERATOR).append(releaseYear);
		
		return albumString.toString();
		
	}

}
