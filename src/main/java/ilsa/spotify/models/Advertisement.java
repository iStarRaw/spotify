package ilsa.spotify.models;

/**
 * @author ilsadejager An add has an advertiser (i.e. the company) and a length
 *         (minutes:seconds). ADD ING Bank, 0:20
 *
 */
public class Advertisement extends Item {

	public Advertisement() {

	}

	public Advertisement(String company, String lengthString) {
		this.name = company;
		this.lengthString = lengthString;
	}

	// ADD Rabobank, 0:15
	public String revertToFileFormat() {
		StringBuilder addString = new StringBuilder();
		addString.append("ADD ").append(this.name).append(", ").append(this.lengthString);
		return addString.toString();
	}

	// Next add: ING Bank (0:20)
	@Override
	public String toString() {
		StringBuilder addString = new StringBuilder();
		addString.append("NEXT ADD: ").append(name).append(" (").append(lengthString).append(")");

		return addString.toString();
	}

	@Override
	public boolean equals(Object other) {

		 if (!(other instanceof Advertisement)) {
		        return false;
		    }

		 Advertisement that = (Advertisement) other;

		    // Custom equality check here.
		    return this.name.equals(that.name)
		        && this.lengthString.equals(that.lengthString);
		
//		return o instanceof Advertisement;
	}

}
