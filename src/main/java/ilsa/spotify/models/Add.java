package ilsa.spotify.models;



/**
 * @author ilsadejager
 * An add has an advertiser (i.e. the company) and a length (minutes:seconds).
 * ADD ING Bank, 0:20
 *
 */
public class Add {
	private String advertiser;
	private int length;
	private final String PREFIX_ADD = "ADD";
	private final String SEPERATOR = " ,";
	
	public Add() {
		
	}
	
	public Add(String advertiser, int length) {
		this.advertiser = advertiser;
		this.length = length;
	}
	
	public String toString() {
		StringBuilder addString = new StringBuilder();
		addString.append(PREFIX_ADD).append(" ").append(advertiser).append(SEPERATOR).append(length);
		
		return addString.toString();
	}

}
