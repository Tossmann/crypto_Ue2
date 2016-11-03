package src;

import java.util.Random;

public class Vigenere {
	String keyString;
	String inputMessage;
	String outputMessage;
	boolean isKeyWordLongerThanText = false; 
	boolean shouldDoEnryption;

	public Vigenere(String inputKeyword, String inputMessage, String inputEncryptionOrDecryption){
		this.inputMessage = inputMessage;
		this.keyString = inputKeyword;
		determineWhichProcess(inputEncryptionOrDecryption);
	}

	private void determineWhichProcess(String input) {
		if(input.equals("en"))
			shouldDoEnryption = true;
		else if (input.equals("de"))
			shouldDoEnryption = false;
	}
	
	private void fillUpWithRandomLetters(int amountOfLettersNeeded){
		Random random = new Random();
		for (int i = 0; i < amountOfLettersNeeded; i++) {
			inputMessage += Character.toString((char)((int)'A' + random.nextInt(25)));
		}
	}
	
	private int howManyLettersNeedsToBeAdded() {
		int whatIsStillThere =  inputMessage.length() % 5; 
		if (whatIsStillThere != 0)
			return 5 - whatIsStillThere;
		return whatIsStillThere;
	}
	
	private void fillinputMessageUpToBlocksOfFive() {
		fillUpWithRandomLetters(howManyLettersNeedsToBeAdded());
	}
	
	private void processMessage() {
		trimSpacesInKeywordAndInputText();
		fillinputMessageUpToBlocksOfFive();
		enOrDecryptMessage();
	}

	private String translateOneLetter(String letterOfInputMessage, String letterOfKeyString) {
		if (shouldDoEnryption)
			return VigenereCharacterEncryption.encryptOneCharacter(letterOfInputMessage, letterOfKeyString);
		else 
			return VigenereCharacterDecryption.decryptOneCharacter(letterOfInputMessage, letterOfKeyString);
	}
	
	private void enOrDecryptMessage() {
		outputMessage = "";
		for(int i = 0; i < inputMessage.length(); i++){
			String currentLetterOfInputMessage = Character.toString(inputMessage.charAt(i));
			String currentLetterOfKeyString = Character.toString(keyString.charAt(i % keyString.length()));
			String translatedLetter = translateOneLetter(currentLetterOfInputMessage,currentLetterOfKeyString);
			if (checkIfFifthSymbol(i+1))
				outputMessage += translatedLetter + " ";
			else 
				outputMessage += translatedLetter;
		}
	}

	public String getProcessedMessage(){
		processMessage();
		
		return outputMessage;
	}

	private void addEmptySpace(int index){
		if(checkIfFifthSymbol(index)) outputMessage += " ";
	}

	private Boolean checkIfFifthSymbol(int index){
		if(index != 0 && index % 5 == 0) 
			return true;
		else 
			return false;	
	}

	private void trimSpacesInKeywordAndInputText(){
		keyString = keyString.replace(" ", "");
		inputMessage = inputMessage.replace(" ", "");
	}
}
