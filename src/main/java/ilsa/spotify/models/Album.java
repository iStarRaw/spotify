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
	
	//CD U2, Songs of Innocence, 2014
	public String revertToFileFormat() {
		StringBuilder cdString = new StringBuilder();
		cdString.append("CD ").append(artist).append(", ").append(name).append(", ").append(releaseYear);
		return cdString.toString();
	}
	
	
	//Album: U2’s Songs of Innocence
	@Override
	public String toString() {
		StringBuilder albumString = new StringBuilder();
		albumString.append("ALBUM: ").append(artist).append("'s ").append(name).append(" from ").append(releaseYear);
		
		return albumString.toString();
		
	}
	
	@Override
	public boolean equals(Object other) {
		
		 if (!(other instanceof Album)) {
		        return false;
		    }

		    Album that = (Album) other;

		    // Custom equality check here.
		    return this.getSongs().equals(that.getSongs())
		        && this.name.equals(that.name);
		
		
//		return o instanceof Album;
	}

}
