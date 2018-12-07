package ilsa.spotify.models;

import java.time.Duration;

/**
 * @author ilsadejager A song has a track number, a title and a length
 *         (minutes:seconds). SONG 1, Don’t Panic, 2:17
 *
 */
public class Song {
	private int trackNumber;
	private String title;
	private String lengthString;
	private final String SEPERATOR = " ,";
	private final String PREFIX_SONG = "SONG";
	private int totalSecs = 0;
	private int minutes = (totalSecs % 3600) / 60;
	private int seconds = totalSecs % 60;
	private String timeString = "";
	

	public Song(int trackNumber, String title, String length) {
		this.trackNumber = trackNumber;
		this.title = title;
		this.lengthString = length;

		calculateSecs(this.lengthString);
		this.totalSecs = calculateSecs(lengthString);
		this.timeString  = String.format("%02d:%02d", minutes, seconds);

	}

	public Song() {

	}

	private int calculateSecs(String lengthString) {
		String[] parts = lengthString.split(":");
		int minutes = Integer.parseInt(parts[0]);
		int seconds = Integer.parseInt(parts[1]);

		return seconds + (minutes * 60);
	}

	@Override
	public String toString() {
		StringBuilder songString = new StringBuilder();
		songString.append(PREFIX_SONG).append(" ").append(trackNumber).append(SEPERATOR).append(title).append(SEPERATOR)
				.append(timeString);

		return songString.toString();

	}

}
