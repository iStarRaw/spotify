package ilsa.spotify.transfer;

import java.util.ArrayList;
import java.util.Arrays;
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
		for (String line : lines) {
			// if line starts with CD then add this line as CD
			if (line.startsWith("CD ")) {
				saveAlbum(line);
			}
			
		}
		
		
		// for the next lines with SONG make new Song & addSong to CD

	}

	private void saveAlbum(String line) {
		String[] words = line.split(",");
			String artist = words[0].substring(3);
			String name = words[1].trim();
			int releaseDate = Integer.parseInt(words[2].trim());
			
			Album album = new Album(artist,name,releaseDate);
			System.out.println(album.toString());
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
