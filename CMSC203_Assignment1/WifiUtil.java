import java.util.Scanner;
public class WifiUtil {
	
	//this method asks the user if the step [method that called AskUser()]
	//worked. The reply is returned to the method that called AskUser()
	public static char AskUser() {
		char reply;
		Scanner in = new Scanner(System.in);
		System.out.println("Now are you able to connect with the internet? (y or n)");
		reply = in.next().charAt(0);
		return reply;
	}
	
	//this method tells the user to reboot the computer. It then calls
	//AskUser() and if the user replies 'y' (meaning that rebooting 
	//the computer solved the problem) a success message is
	//displayed and the program is terminated.
	public static void RebootC() {
		char response;
		System.out.println("First step: reboot your computer.");
		response = AskUser();
		if (response=='y') {
			System.out.println("Rebooting the computer seemed to work.");
			System.out.println("Problem solved!");
			System.exit(0);
		}
	}

	//this method tells the user to reboot the router. It then calls
	//AskUser() and if the user replies 'y' (meaning that rebooting 
	//the router solved the problem) a success message is
	//displayed and the program is terminated.
	public static void RebootR() {
		char response;
		System.out.println("Second step: reboot your router.");
		response = AskUser();
		if (response=='y') {
			System.out.println("Rebooting the router seemed to work.");
			System.out.println("Problem solved!");
			System.exit(0);
		}
		
	}
	
	//this method tells the user to check cable connections.
	//It then calls AskUser() and if the user replies 'y' 
	//(meaning that checking the cables solved the problem), 
	//a success message is displayed and the program is terminated.
	public static void CableConn() {
		char response;
		System.out.println("Third step: make sure the cables to your router are plugged in firmly and your router is getting power.");
		response = AskUser();
		if (response=='y') {
			System.out.println("Checking the router's cables seemed to work.");
			System.out.println("Problem solved!");
			System.exit(0);
		}
	}
	
	//this method tells the user to move the computer closer to the
	//router. It then calls AskUser() and if the user replies 'y' 
	//(meaning that moving the computer closer solved the problem), 
	//a success message is displayed and the program is terminated.
	public static void Closer() {
		char response;
		System.out.println("Fourth step: move your computer closer to your router.");
		response = AskUser();
		if (response=='y') {
			System.out.println("Moving your computer closer to the router seemed to work.");
			System.out.println("Problem solved!");
			System.exit(0);
		}
	}
	
	//this method tells the user to contact the ISP. It's the
	//last step. The method terminates the program in the end.
	public static void CntctISP() {
		System.out.println("Fifth step: Contact your ISP.\nMake sure your ISP is hooked up to your router.");
		System.exit(0);
	}
}
