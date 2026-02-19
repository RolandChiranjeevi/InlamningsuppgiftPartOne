import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MorsecodeTest {
    @Test
    public void charToMorse_test() {
        Assertions.assertEquals(".-", Morsecode.textToMorse("A"));
        Assertions.assertEquals("--..", Morsecode.textToMorse("Z"));
        Assertions.assertEquals("...", Morsecode.textToMorse("S"));
        Assertions.assertEquals(".", Morsecode.textToMorse("E"));
    }

    @Test
    public void textToMorse_test() {
        Assertions.assertEquals("... --- ...", Morsecode.textToMorse("SOS"));
        Assertions.assertEquals(".... . .-.. .-.. ---", Morsecode.textToMorse("HELLO"));
        Assertions.assertEquals(".... . .-.. .-.. --- / .-- --- .-.", Morsecode.textToMorse("HELLO WOR"));
    }

    @Test
    public void textToMorseThrows_test() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Morsecode.textToMorse("HEJ!"));
    }

    @Test
    public void morseToText_simpleCases() {
        Assertions.assertEquals("A", Morsecode.morseToText(".-"));
        Assertions.assertEquals("SOS", Morsecode.morseToText("... --- ..."));
        Assertions.assertEquals("HELLO", Morsecode.morseToText(".... . .-.. .-.. ---"));
    }

    @Test
    public void morseToText_throwsOnInvalidToken() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Morsecode.morseToText("... --- ..-.-"));
    }

    @Test
    public void textToMorse_throwsOnNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Morsecode.textToMorse((String)null));
    }

    @Test
    public void textToMorse_throwsOnEmptyString() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Morsecode.textToMorse(""));
    }

    @Test
    public void morseToText_throwsOnNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Morsecode.morseToText((String)null));
    }

    @Test
    public void morseToText_throwsOnEmptyString() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Morsecode.morseToText(""));
    }
}