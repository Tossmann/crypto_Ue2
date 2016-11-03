package src;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		System.out.println(VigenereCharacterDecryption.decryptOneCharacter("b", "c"));	

		// TODO Auto-generated method stub	
		VigenereEncryptionProcess vigenere = initialDialog();	
		System.out.println(VigenereCharacterEncryption.encryptOneCharacter("b", "y"));		
	}

	public static VigenereEncryptionProcess initialDialog(){
		System.out.println("Please enter your keyword!");
		Scanner sc = new Scanner(System.in);
		String keyword = sc.nextLine();
		System.out.println("Now please enter your plaintext.");
		String inputMessage = sc.nextLine();	
		
		return new VigenereEncryptionProcess(keyword, inputMessage);
	}

}
