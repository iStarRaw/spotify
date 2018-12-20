package ilsa.spotify.models;


/**
 * @author ilsadejager A song has a track number, a title and a length
 *         (minutes:seconds). SONG 1, Don’t Panic, 2:17
 *
 */
public class Song extends Item {
	private int trackNumber;
	private Album album;
	
	private final String PREFIX_TRACK = "TRACK: ";

	public Song(int trackNumber, String title, String lengthString) {
		this.trackNumber = trackNumber;
		this.name = title;
		this.lengthString = lengthString;

	}

	public Song() {
		
	}
	
	public Album getAlbum() {
		return this.album;
	}
	
	public void setAlbum(Album album) {
		this.album = album;
	}

	@Override
	public String toString() {
		StringBuilder songString = new StringBuilder();
		songString.append(PREFIX_TRACK).append(this.name).append(" (")
				.append(this.lengthString).append(")");

		return songString.toString();

	}
	
	@Override
	public boolean equals(Object o) {
		return o instanceof Song;
	}
	
}
