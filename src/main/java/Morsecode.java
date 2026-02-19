import java.util.HashMap;
import java.util.Map;

public class Morsecode {
    private static final Map<Character, String> morseMap = new HashMap();
    private static final Map<String, Character> alphabetMap = new HashMap();

    public static String textToMorse(String text) {
        if (text != null && !text.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            boolean first = true;

            for(char c : text.toUpperCase().toCharArray()) {
                String morseCode = (String)morseMap.get(c);
                if (morseCode == null) {
                    throw new IllegalArgumentException("No morsecode for this character! " + c);
                }

                if (!first) {
                    sb.append(" ");
                }

                sb.append(morseCode);
                first = false;
            }

            return sb.toString();
        } else {
            throw new IllegalArgumentException("Text cannot be empty!");
        }
    }

    public static String morseToText(String morse) {
        if (morse != null && !morse.isEmpty()) {
            StringBuilder result = new StringBuilder();
            String[] tokens = morse.trim().split(" +");

            for(String token : tokens) {
                Character ch = (Character)alphabetMap.get(token);
                if (ch == null) {
                    throw new IllegalArgumentException("Unknown morsecode: " + token);
                }

                result.append(ch);
            }

            return result.toString();
        } else {
            throw new IllegalArgumentException("Morse code can not be empty!");
        }
    }

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

        for(Map.Entry<Character, String> entry : morseMap.entrySet()) {
            alphabetMap.put((String)entry.getValue(), (Character)entry.getKey());
        }

    }
}