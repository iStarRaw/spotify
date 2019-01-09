package ilsa.spotify.models;

/**
 * @author ilsadejager A song has a track number, a title and a length
 *         (minutes:seconds). SONG 1, Don’t Panic, 2:17
 *
 */
public class Song extends Item {
	private int trackNumber;
	private Album album;

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

	// SONG 1, Don't Panic, 2:17
	public String revertToFileFormat() {
		StringBuilder songString = new StringBuilder();
		songString.append("SONG ").append(this.trackNumber).append(", ").append(this.name).append(", ")
				.append(this.lengthString);
		return songString.toString();
	}

	@Override
	public String toString() {
		StringBuilder songString = new StringBuilder();
		songString.append("TRACK: ").append(this.name).append(" (").append(this.lengthString).append(")");

		return songString.toString();

	}

	@Override
	public boolean equals(Object other) {

		 if (!(other instanceof Song)) {
		        return false;
		    }

		    Song that = (Song) other;

		    // Custom equality check here.
		    return this.name.equals(that.name)
		        && this.lengthString.equals(that.lengthString);
		
		
//		return o instanceof Song;
	}

}
