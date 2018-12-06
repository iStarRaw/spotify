package ilsa.spotify.transfer;

import java.util.ArrayList;
import java.util.List;

import ilsa.spotify.models.Album;

public class StringFile {
	private List<String> lines;

	public StringFile() {
		lines = new ArrayList<>();
	}
	
	

	public List<String> getLines() {
		return lines;
	}



	// TODO doorlopen lines and splitten in CD, SONG & ADDS
	public void splitLines() {
		// if line starts with CDS
		// if line starts with CD then add this line as CD
		
		// for the next lines with SONG make new Song & addSong to CD

	}
	
	@Override
	public String toString() {
		StringBuilder lineFile = new StringBuilder();
		  lines.forEach(  
		            (line)->lineFile.append(line).append("\n")  
		        );
		return lineFile.toString(); 
	}
	
}
