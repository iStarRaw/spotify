package ilsa.spotify.models;

/**
 * @author ilsadejager
 * An add has an advertiser (i.e. the company) and a length (minutes:seconds).
 * ADD ING Bank, 0:20
 *
 */
public class Advertisement extends Item {
	private final String PREFIX_ADD = "ADD";
	
	public Advertisement() {
		
	}
	
	public Advertisement(String company, String lengthString) {
		this.name = company;
		this.lengthString = lengthString;
	}
	
	
	@Override
	public String toString() {
		StringBuilder addString = new StringBuilder();
		addString.append(PREFIX_ADD).append(" ").append(name).append(SEPERATOR).append(lengthString);
		
		return addString.toString();
	}

}
