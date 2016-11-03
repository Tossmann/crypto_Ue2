package src;

public class VigenereCharacterDecryption extends  VigenerCharacterTranslation {
	public String translateCharacter(String inputCypherCharacter, String intpuKeyCharacter) {
		String plainCharacter = inputCypherCharacter.toUpperCase();
		String keyCharacter = intpuKeyCharacter.toUpperCase();

		int numberFromCypherCharacter = plainCharacter.hashCode();
		int numberFromKeyCharacter = keyCharacter.hashCode();

		int moveFor = super.getNumberYouHaveToMove(numberFromKeyCharacter);
		int newCipherCharacterNumber = keepHashCodesInAlphabeticLimits(numberFromCypherCharacter - moveFor);
		String newCipherCharacter = getStringFromHashCode(newCipherCharacterNumber);
		return newCipherCharacter;
	}
}