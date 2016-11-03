package src;

public class VigenereCharacterDecryption {
	static int numberFromBeginning = 'A';
	static int numberFromEnding = 'Z';
	static int lengthOfAlphabet = numberFromEnding - numberFromBeginning + 1;

	private static String getStringFromHashCode(int inputHashCode) {
		return Character.toString((char)inputHashCode);
	}
	
	private static int keepHashCodesInAlphabeticLimits(int inputHashCode) {
		if (inputHashCode < numberFromBeginning)
			return numberFromEnding - (numberFromBeginning - inputHashCode) +1 ;
		return inputHashCode;
	}
	
	private static int getNumberYouHaveToMove(int inputHashCode) {
		return inputHashCode - numberFromBeginning;
	}
	
	public  static String decryptOneCharacter(String inputCypherCharacter, String intpuKeyCharacter) {
		String plainCharacter = inputCypherCharacter.toUpperCase();
		String keyCharacter = intpuKeyCharacter.toUpperCase();

		int numberFromCypherCharacter = plainCharacter.hashCode();
		int numberFromKeyCharacter = keyCharacter.hashCode();

		int moveFor = getNumberYouHaveToMove(numberFromKeyCharacter);
		int newCipherCharacterNumber = keepHashCodesInAlphabeticLimits(numberFromCypherCharacter - moveFor);
		String newCipherCharacter = getStringFromHashCode(newCipherCharacterNumber);
		return newCipherCharacter;
	}
}