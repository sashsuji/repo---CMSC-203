import java.util.Scanner;
public class MovieDriver {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Movie film = new Movie();
		String title;
		char repeat = 'y';
		String rating;
		int numTix=0;
		int i;
		while (repeat=='y')
		{
			System.out.println("Movie Title: ");
			title = input.nextLine();
			film.setTitle(title);
			System.out.println("Movie Rating: ");
			rating = input.nextLine();
			film.setRating(rating);
			System.out.println("How many tickets were sold? ");
			numTix = input.nextInt();
			film.setSoldTickets(numTix);
			System.out.println(film.toString());
			System.out.println("Do you want to enter another film? (y or n)");
			repeat = input.next().charAt(0);
			input.nextLine();
		}
		System.out.println("Goodbye.");
		System.exit(0);
	}
}
