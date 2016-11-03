package src;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		VigenereEncryptionProcess vigenere = initialDialog();
		for(int i = 0; i < vigenere.getInputMessage().length(); i++){
		vigenere.setCipherText(VigenereCharacterEncryption.encryptOneCharacter(Character.toString(vigenere.getInputMessage().charAt(i)), Character.toString(vigenere.getKeyword().charAt(i % vigenere.getKeyword().length()))), i);
		}
		System.out.println(vigenere.getCiphertext());
	}

	public static VigenereEncryptionProcess initialDialog(){
		System.out.println("Please enter your keyword.");
		Scanner sc = new Scanner(System.in);
		String keyword = sc.nextLine();
		System.out.println("Now please enter your plaintext.");
		String inputMessage = sc.nextLine();	
		
		return new VigenereEncryptionProcess(keyword, inputMessage);
	}

}
