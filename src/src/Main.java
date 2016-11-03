package src;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Vigenere vigenere = initializiationWithDialog();
		System.out.println(vigenere.getProcessedMessage());
	}

	public static Vigenere initializiationWithDialog(){
		Scanner sc = new Scanner(System.in);
		boolean askForCommand = true;
		String encrptionOrDecryption = "";
		while (askForCommand) {
			System.out.println("Type 'en' for encryption and 'de' for decryption:");
			encrptionOrDecryption = sc.nextLine();
			askForCommand = !isInputCommand(encrptionOrDecryption);
		}
		System.out.println("Please enter your keyword.");
		String keyString = sc.nextLine();
		System.out.println("Now please enter your plaintext.");
		String inputMessage = sc.nextLine();	
		return new Vigenere(keyString, inputMessage, encrptionOrDecryption);
	}
	
	private static boolean isInputCommand(String input) {
		return (input.equals("en") || input.equals("de"));
	}

}
