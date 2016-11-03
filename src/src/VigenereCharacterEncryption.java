package src;

public class VigenereCharacterEncryption {
	static int numberFromBeginning = 'A';
	static int numberFromEnding = 'Z';
	static int lengthOfAlphabet = numberFromEnding - numberFromBeginning + 1;

	private static String getStringFromHashCode(int inputHashCode) {
		return Character.toString((char)inputHashCode);
	}

	private static boolean isHashCodeInAlphabeticLimits(int inputHashCode) {
		return inputHashCode > numberFromEnding;
	}
	
	private static int keepHashCodesInAlphabeticLimits(int inputHashCode) {
		if (isHashCodeInAlphabeticLimits(inputHashCode)) 
			return inputHashCode - lengthOfAlphabet;
		return inputHashCode;
	}
	
	private static int getNumberYouHaveToMove(int inputHashCode) {
		return inputHashCode - numberFromBeginning;
	}
	
	public  static String encryptOneCharacter(String inputPlainCharacter, String intpuKeyCharacter) {
		String plainCharacter = inputPlainCharacter.toUpperCase();
		String keyCharacter = intpuKeyCharacter.toUpperCase();

		int numberFromPlainCharacter = plainCharacter.hashCode();
		int numberFromKeyCharacter = keyCharacter.hashCode();

		int moveFor = getNumberYouHaveToMove(numberFromKeyCharacter);
		int newCipherCharacterNumber = keepHashCodesInAlphabeticLimits(numberFromPlainCharacter + moveFor);
		String newCipherCharacter = getStringFromHashCode(newCipherCharacterNumber);
		return newCipherCharacter;
	}
}
