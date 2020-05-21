public class Lowercase_to_Uppercase {
    /**
     * @param character: a character
     * @return: a character
     */
    public char lowercaseToUppercase(char character) {
        // ASCII码中小写字母与对应的大写字母相差32
        return (char) (character - ('a' - 'A'));

    }
}