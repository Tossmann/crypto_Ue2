package src;

public class VigenereEncryptionProcess {

	private static String keyword;
	private static String inputMessage;
	private static String cipherText = "";
	private static boolean whichIsLonger = false; // true = keyword is longer than plaintext
	
	public VigenereEncryptionProcess(String keyword, String inputMessage){
		this.inputMessage = inputMessage;
		this.keyword = keyword;
	}
	
	public static String createCipher(){
		for(int i = 0; i < inputMessage.length(); i++){
			if(checkIfFifthSymbol(i)) addEmptySpace(i);
			//cipherText += vigenere(inputMessage.charAt(i), keyword.charAt(i));
		}
		return cipherText;
	}
	
	public static void addEmptySpace(int index){
		if(checkIfFifthSymbol(index)) cipherText += " ";
	}
	
	public static Boolean checkIfFifthSymbol(int index){
		if(index != 0 && index % 5 == 0) return true;
		else return false;	
	}
	
	public static void isKeyLongerThanMessage(){
		if(inputMessage.length() >= keyword.length()) whichIsLonger = true;
	}
}
