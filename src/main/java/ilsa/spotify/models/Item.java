package ilsa.spotify.models;


abstract class Item {
	String name;
	String lengthString;
	
	int totalSecs = 0;
	int minutes = (totalSecs % 3600) / 60;
	int seconds = totalSecs % 60;
	String timeString = "";
		
	int calculateSecs(String lengthString) {
		String[] parts = lengthString.split(":");
		int minutes = Integer.parseInt(parts[0]);
		int seconds = Integer.parseInt(parts[1]);

		return seconds + (minutes * 60);
	}


}
