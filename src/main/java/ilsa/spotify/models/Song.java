package ilsa.spotify.models;


/**
 * @author ilsadejager A song has a track number, a title and a length
 *         (minutes:seconds). SONG 1, Don’t Panic, 2:17
 *
 */
public class Song extends Item {
	private int trackNumber;
	private String title;
	
	private final String PREFIX_SONG = "SONG";

	public Song(int trackNumber, String title, String length) {
		this.trackNumber = trackNumber;
		this.name = title;
		this.lengthString = length;

		calculateSecs(this.lengthString);
		this.totalSecs = calculateSecs(lengthString);
		this.timeString  = String.format("%02d:%02d", minutes, seconds);

	}

	public Song() {

	}

	@Override
	public String toString() {
		StringBuilder songString = new StringBuilder();
		songString.append(PREFIX_SONG).append(" ").append(trackNumber).append(SEPERATOR).append(title).append(SEPERATOR)
				.append(timeString);

		return songString.toString();

	}

}
