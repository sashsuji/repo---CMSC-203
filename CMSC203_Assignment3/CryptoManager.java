//CMSC 203 Assignment #3: Encryption
//This Java program is designed to to encrypt and decrypt a phrase using
//either the Caesar cipher or the Bellaso cipher.
//Programmer: Sash Sujith

public class CryptoManager {
//declaration of bounds(ASCII codes 32-95) and range(64).	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	//takes a look at each character of the text to be encrypted
	//and if any character is not within the bounds, false is
	//returned. otherwise all good!
	public static boolean stringInBounds (String plainText) {
		for (int i=0;i<(plainText.length());i++) {
			char c = plainText.charAt(i);
			if(c<=(LOWER_BOUND-1) || c>=(UPPER_BOUND+1))
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	//takes each character of string to be encrypted and adds
	//ASCII code of the "key." if the new character is above
	//upper bound, range is subtracted from it until it is
	//within the range. then, it is added to the encrypted
	//string.
	public static String encryptCaesar(String plainText, int key) {
		String caesarEncrypted = "";
		for (int i=0;i<plainText.length();i++) {
			int encryptedIntChar = plainText.charAt(i)+key;
			while (encryptedIntChar>UPPER_BOUND) 
			{
				encryptedIntChar = encryptedIntChar - RANGE;
			}
			caesarEncrypted+=(char)encryptedIntChar;
		}
		return caesarEncrypted;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	//first loads each character of string to be encrypted
	//into a char array that is the size of the length
	//of plainText.
	//takes each character of string to be encrypted and adds
	//ASCII code of the corresponding letter of the "key word." 
	//if the new character is above upper bound, RANGE is 
	//subtracted from it until it is within the range. 
	//then, it is added to the encrypted string.
	public static String encryptBellaso(String plainText, String bellasoStr) {
		
		char [] bellasoStrLocal = new char[plainText.length()];
		
		String bellasoEncrypted = "";
		
		for (int j = 0; j<plainText.length(); j++)
		{
			int index = (j % bellasoStr.length());
			bellasoStrLocal[j] = bellasoStr.charAt(index);
		}
		
		for (int i = 0; i<plainText.length(); i++) {
			int shift = bellasoStrLocal[i];
			int charInt = plainText.charAt(i) + shift;
			while (charInt>UPPER_BOUND)
			{
				charInt= charInt - RANGE;
			}
			bellasoEncrypted = bellasoEncrypted + (char)(charInt);
			
		}
		return bellasoEncrypted;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	//takes each character of string to be decrypted and subtracts
	//ASCII code of the "key." if the new character is lower than
	//lower bound, range is added to it until it is
	//within the range. then, it is added to the decrypted
	//string.
	public static String decryptCaesar(String encryptedText, int key) {
		String caesarDecrypted = "";
		for (int i=0;i<encryptedText.length();i++) {
			int decryptedIntChar = encryptedText.charAt(i)-key;
			while (decryptedIntChar<LOWER_BOUND) 
			{
				decryptedIntChar = decryptedIntChar + RANGE;
			}
			caesarDecrypted+=(char)decryptedIntChar;
		}
		return caesarDecrypted;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	//first loads each character of encrypted string
	//into a char array that is the size of the length
	//of encryptedText.
	//takes each character of string to be decrypted and subtracts
	//ASCII code of the "key." if the new character is lower than
	//lower bound, range is added to it until it is
	//within the range. then, it is added to the decrypted
	//string.
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		
		char [] bellasoStrLocal = new char[encryptedText.length()];
		
		String bellasoDecrypted = "";
		
		for (int j = 0; j<encryptedText.length(); j++)
		{
			int index = (j % bellasoStr.length());
			bellasoStrLocal[j] = bellasoStr.charAt(index);
		}
		
		for (int i = 0; i<encryptedText.length(); i++) {
			int shift = bellasoStrLocal[i];
			int charInt = encryptedText.charAt(i) - shift;
			while (charInt<LOWER_BOUND)
			{
				charInt= charInt + RANGE;
			}
			bellasoDecrypted = bellasoDecrypted + (char)(charInt);
			
		}
		return bellasoDecrypted;
	}
}
