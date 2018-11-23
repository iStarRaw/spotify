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
	private String artist;
	private String name;
	private String releaseDate;
	private final String PREFIX_CD = "CD";
	private final String SEPERATOR = " ,";
	
	public Album(String artist, String name, String releaseDate) {
		this.artist = artist;
		this.name = name;
		this.releaseDate = releaseDate;
		songs = new ArrayList<>();
	}
	
	public Album() {
		
	}
	
	@Override
	public String toString() {
		StringBuilder albumString = new StringBuilder();
		albumString.append(PREFIX_CD).append(" ").append(artist).append(SEPERATOR).append(name).append(SEPERATOR).append(releaseDate);
		
		return albumString.toString();
		
	}

}
