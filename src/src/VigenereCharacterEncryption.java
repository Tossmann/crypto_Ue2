package src;

public class VigenereCharacterEncryption extends  VigenerCharacterTranslation {	
	public String translateCharacter(String inputCypherCharacter, String intpuKeyCharacter) {
		String plainCharacter = inputCypherCharacter.toUpperCase();
		String keyCharacter = intpuKeyCharacter.toUpperCase();

		int numberFromCypherCharacter = plainCharacter.hashCode();
		if (!isLetterInAlphabet(numberFromCypherCharacter))
			return ("?");
		int numberFromKeyCharacter = keyCharacter.hashCode();

		int moveFor = super.getNumberYouHaveToMove(numberFromKeyCharacter);
		int newCipherCharacterNumber = keepHashCodesInAlphabeticLimits(numberFromCypherCharacter + moveFor);
		String newCipherCharacter = getStringFromHashCode(newCipherCharacterNumber);
		return newCipherCharacter;
	}
}
