package ilsa.spotify.models;

import java.time.Duration;

/**
 * @author ilsadejager
 * A song has a track number, a title and a length (minutes:seconds). 
 * SONG 1, Don’t Panic, 2:17
 *
 */
public class Song {
	private int trackNumber;
	private String title;
	private Duration length;
	private String lengthString;
	private final String SEPERATOR = " ,";
	private final String PREFIX_SONG = "SONG";
	
	public Song(int trackNumber, String title, String length) {
		this.trackNumber = trackNumber;
		this.title = title;
		this.lengthString = length;
		
		convertLengthToDuration();
		
	}

	private void convertLengthToDuration() {
		String[] result = lengthString.split(":");
		long minutesToAdd = Long.valueOf(result[0]).longValue();
		long secondsToAdd = Long.valueOf(result[1]).longValue();
		
		this.length.plusMinutes(minutesToAdd);
		this.length.plusSeconds(secondsToAdd);
	}
	
	public Song() {
		
	}
	

	@Override
	public String toString() {
		StringBuilder songString = new StringBuilder();
		songString.append(PREFIX_SONG).append(" ").append(trackNumber).append(SEPERATOR).append(title).append(SEPERATOR).append(length);
		
		return songString.toString();
		
	}
	
	

}
