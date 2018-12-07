package ilsa.spotify.transfer;

/**
 * @author ilsadejager
 * Please make your choice:
		1 - Show the current playlist
		2 – Add a new CD including songs
		3 – Play
		4 – Shuffle
		5 – Stop the program
 *
 */
public class Display {
	private static StringBuilder menu;
	private final static String SHOW_PLAYLIST = " 1 - Show the current playlist ";
	private final static String ADD_CD = " 2 – Add a new CD including songs";
	private final static String PLAY = " 3 – Play";
	private final static String SHUFFLE = " 4 – Shuffle";
	private final static String STOP = " 5 – Stop the program";
	
	
	public static void printMenu() {
		menu = new StringBuilder();
		menu.append("Please make your choice: \n");
		menu.append(SHOW_PLAYLIST).append("\n");
		menu.append(ADD_CD).append("\n");
		menu.append(PLAY).append("\n");
		menu.append(SHUFFLE).append("\n");
		menu.append(STOP).append("\n");
		
		System.out.println(menu.toString());
		
	}
	
	public static void printAddCD() {
	}
	
	public static void printPlayList() {
		
	}


	

}
