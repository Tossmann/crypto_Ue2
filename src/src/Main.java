package src;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		VigenereEncryptionProcess vigenere = initialDialog();	
		
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
