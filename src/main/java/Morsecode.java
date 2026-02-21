import java.util.HashMap;
import java.util.Map;

public class Morsecode {
    // Vi har en Hashmap, som vi också reverserar för att kunna återanvända den med en for.eachloop.
// morseMap har key Character och value String, medans alphabetMap har tvärtom.
    private static final Map<Character,String> morseMap = new HashMap<>();
    private static final Map<String,Character> alphabetMap = new HashMap<>();
    static {
        morseMap.put('A', ".-");
        morseMap.put('B', "-...");
        morseMap.put('C', "-.-.");
        morseMap.put('D', "-..");
        morseMap.put('E', ".");
        morseMap.put('F', "..-.");
        morseMap.put('G', "--.");
        morseMap.put('H', "....");
        morseMap.put('I', "..");
        morseMap.put('J', ".---");
        morseMap.put('K', "-.-");
        morseMap.put('L', ".-..");
        morseMap.put('M', "--");
        morseMap.put('N', "-.");
        morseMap.put('O', "---");
        morseMap.put('P', ".--.");
        morseMap.put('Q', "--.-");
        morseMap.put('R', ".-.");
        morseMap.put('S', "...");
        morseMap.put('T', "-");
        morseMap.put('U', "..-");
        morseMap.put('V', "...-");
        morseMap.put('W', ".--");
        morseMap.put('X', "-..-");
        morseMap.put('Y', "-.--");
        morseMap.put('Z', "--..");
        morseMap.put(' ', "/");
// For.eachloop som vänder på hashmapen. Eller rättare sagt, den iterar genom får orginalhashmap, och sen svarar den med keys/values för alphabetMap.
        for (Map.Entry<Character, String> entry : morseMap.entrySet()) {
            alphabetMap.put(entry.getValue(), entry.getKey());
        }
    }
    // Metod för att översätta bokstäver till morse. Vi sparar vår input i upperCase och sen söker vi igenom vår Hashmap och svarar med resultatet.
    public static String letterToMorse(char c) {
        char upperCase = Character.toUpperCase(c);
        String morseCode = morseMap.get(upperCase);
        if (morseCode == null) {
// Felhantering som vid de fall vi får null, dvs ett värde som inte finns i våran hashmap.
            throw new IllegalArgumentException("There is no support for that character at the time being. Only A-Z is allowed! "+ c);
        }
        return morseCode;
    }
    // Metod för att översätta text/bokstav till morsekod.
    public static String textToMorse(String text) {
        if(text == null || text.isEmpty()) {
// Felhantering i de fall vi har ett tomt textfält.
            throw new IllegalArgumentException("Text cannot be empty!");
        }
// Skapandet av en StringBuilder och ny boolean för att använda för att bygga ihop, och stänga loopen.
        StringBuilder sb = new StringBuilder();
        boolean first = true;
// for.eachloop för att ta emot text, konvertera till stora bokstäver för att synka med hashmapen, och sen ge oss character/bokstaven.
        for(char c : text.toUpperCase().toCharArray()) {
            String morseCode = morseMap.get(c);
            if(morseCode == null) {
// Felhantering som ovan, om inte det finns ett värde i vår hashmap så visas nedan felmeddelande.
                throw new IllegalArgumentException("No morsecode for this character! "+c);
            }
// If-formel som loopas så länge !first är false, loopen bygger på nytt tecken med ett space mellan varje tecken. och sparar i vår StringBuilder.
            if(!first) {
                sb.append(" ");
            }
// Om det inte finns fler tecken i vår text, så avslutas loopen...
            sb.append(morseCode);
            first = false;
        } // forts. och vi returnerar får StringBuilder och skapar en printvänlig version.
        return sb.toString();
    }
    // Metod som hanterar morsekod till text.
    public static String morseToText(String morse) {
        if (morse == null || morse.isEmpty()) {
// Felhantering för att hantera de fall morseinputen är tom.
            throw new IllegalArgumentException("Morse code can not be empty!");
        }
// Ny StringBuilder för att hantera resultatet av översättningen av text till morse.
        StringBuilder result = new StringBuilder();
// En stringArray tokens, som trimmar och splittar på inputen i strängen morse. Den sparas i tokens.
        String [] tokens = morse.trim().split(" +");

// For.eachloop för att gå igenom hashmapen alphabetMap och söka efter values.
        for (String token : tokens) {
            Character ch = alphabetMap.get(token);
// Vi skapar en Char-variabel ch, där vi sparar vår value från alphabetMap.
            if (ch == null) {
// Felhantering vid de fall det inte finns någon value i vår alphabetMap.
                throw new IllegalArgumentException("Unknown morsecode: "+token);
            }
            result.append(ch);
        }
// Vår stringbuilder som sparar, sen returneras det en printvänlig version
        return result.toString();
    }
}