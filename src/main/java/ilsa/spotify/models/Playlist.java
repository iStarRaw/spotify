package ilsa.spotify.models;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
	private List<Song> songs;
	private List<Advertisement> adds;
	
	public Playlist() {
		songs = new ArrayList<>();
		adds = new ArrayList<>();
	}

}
