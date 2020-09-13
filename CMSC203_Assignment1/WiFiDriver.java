// Assignment 1 WiFi Diagnosis
//CMSC203
//by Sash Sujith 9/11/2020


//Driver class
public class WiFiDriver {

	public static void main(String[] args) {
		header();
		//asks user to reboot computer. detailed descriptions of methods are in utility class
		WifiUtil.RebootC();
		//asks user to reboot router.
		WifiUtil.RebootR();
		//asks user to check cable connections
		WifiUtil.CableConn();
		//asks user to move computer closer to router
		WifiUtil.Closer();
		//asks user to contact ISP
		WifiUtil.CntctISP();
	}

	//prints the header
	public static void header() {
		System.out.println("If you have a problem with internet connectivity, this WiFi Diagnosis might work.\n");
	}
}