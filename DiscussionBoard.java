package discussionboard;
import java.util.ArrayList;
import java.util.Scanner;
public class DiscussionBoard {

	private static ArrayList<String> board = new ArrayList<>();//Initializing array
    private static final int MAX_POSTS = 10;// Discussion board with max 10 posts
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		boolean program = true;
		while(program) {
			menu();
			int option = scn.nextInt();
			scn.nextLine();
			switch(option) {
			case 1:
				print_newMessage(scn);
				break;
			case 2:
				System.out.println("All the posts:");
				print_allPosts();
				break;
			case 3:
				System.out.println("Posts in reverse order:");
				print_inReverse();
				break;
			case 4:
				print_totalNumber();
				break;
			case 5:
				print_alluserPosts(scn);
				break;
			case 6:
				print_numberofVowels();
				break;
			case 7:
				search_caseSensitive(scn);
				break;
			case 8:
				search_caseInsensitive(scn);
				break;
			case 9:
				System.out.println("Program ended");
				program = false;
				break;
			default:
				System.out.println("Option is not on the menu try again");
			}
		}
	}	
	private static void menu() {
		System.out.println("\n Menu");
		System.out.println("(1) Post new message");
		System.out.println("(2) Print all posts");
		System.out.println("(3) Print all posts in reverse order");
		System.out.println("(4) Print number of posts entered so far");
		System.out.println("(5) Print all posts from a user");
		System.out.println("(6) Print the number of vowels across all posts");
		System.out.println("(7) Perform a search of posts containing a given word (case sensitive)");
		System.out.println("(8) Perform a search of posts containing a given word (case insensitive)");
		System.out.println("(9) End Program");
		}
	
	private static void print_newMessage(Scanner scn) {
		if (board.size() >= MAX_POSTS) {
            System.out.println("Error: The discussion board is full.");
            return;
        }
		System.out.println("Enter your name :");
		String name = scn.nextLine();
		System.out.println("Enter your post :");
		String post = scn.nextLine();
		board.add(name + " says:" + post);
        System.out.println("Post added to the discussion board.");
	}
	private static void print_allPosts() {
		if(board.isEmpty()) {
			System.out.println("The Discussion board is empty");
		}else {
			for (String post : board) {
                System.out.println(post);
		}
	}
	}
	private static void print_inReverse() {
		if(board.isEmpty()) {
			System.out.println("The Discussion board is empty");
		}else {
			for (int i = board.size()-1; i >= 0; i--) {
                System.out.println(board.get(i));
			}
		}
	}
	
	private static void print_totalNumber() {
		System.out.println("Total number of posts are: " + board.size());
	}
	private static void print_alluserPosts(Scanner scn) {
		System.out.println("Enter the name of the user:");
		String name = scn.nextLine().toLowerCase();
		boolean found = false;
		
		for(String post: board) {
			if(post.toLowerCase().startsWith(name + " says:")){
				System.out.println(post);
				found = true;
			}
		}
		if (!found){
				System.out.println("No posts by " + name + " found");
		}	
			}
		
	
	private static void print_numberofVowels() {
	    int vowels = 0;
	    for (String value : board) {
	        String[] mainPost = value.split(" says:", 2);
	        if (mainPost.length > 1) {
	            String post = mainPost[1].toLowerCase();
	            for (char vowel : post.toCharArray()) {
	                if (vowel == 'a' || vowel == 'e' || vowel == 'i' || vowel == 'o' || vowel == 'u') {
	                    vowels++;
	                }
	            }
	        }
	    }
	    System.out.println("Total number of vowels in the discussion posts: " + vowels);
	}
	private static void search_caseSensitive(Scanner scn) {
		System.out.println("Input the word for search(case sensitive)");
		String word = scn.nextLine();
		
		boolean found = false;
		
		for(String post: board) {
			if(post.contains(word)){
				System.out.println(post);
				found = true;
			}
		}
		if (!found){
			System.out.println("No posts with the word " + word +" were found in the board" );	
			}
		}
	
	private static void search_caseInsensitive(Scanner scn) {
		System.out.println("Input the word for search(case insensitive)");
		String word = scn.nextLine().toLowerCase();
		
		boolean found = false;
		
		for(String post: board) {
			if(post.contains(word)){
				System.out.println(post);
				found = true;
			}
		}
		if (!found){
			System.out.println("No posts with the word " + word +" were found in the board" );	
			}
		}
	

}
