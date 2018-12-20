package ilsa.spotify.models;

/**
 * @author ilsadejager
 * An add has an advertiser (i.e. the company) and a length (minutes:seconds).
 * ADD ING Bank, 0:20
 *
 */
public class Advertisement extends Item {
	private final String PREFIX_ADD = "NEXT ADD: ";
	
	public Advertisement() {
		
	}
	
	public Advertisement(String company, String lengthString) {
		this.name = company;
		this.lengthString = lengthString;
	}
	
//	Next add: ING Bank (0:20)
	
	@Override
	public String toString() {
		StringBuilder addString = new StringBuilder();
		addString.append(PREFIX_ADD).append(name).append(" (").append(lengthString).append(")");
		
		return addString.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		return o instanceof Advertisement;
	}

}
