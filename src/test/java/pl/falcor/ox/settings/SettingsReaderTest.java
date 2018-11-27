package pl.falcor.ox.settings;

import org.testng.annotations.Test;
import pl.falcor.ox.domain.Player;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;

import static org.testng.Assert.assertEquals;

@Test
public class SettingsReaderTest {

    public void shouldReturnEnglishLanguageSettingOfTheGameAsChosenByUser(){

        ByteArrayInputStream inputStream = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(inputStream);
        SettingsReader settingsReader = new SettingsReader();

        Locale.setDefault(settingsReader.setLanguage());
        String language = Locale.getDefault().getDisplayLanguage();

        assertEquals(language, "English");
    }

    public void shouldReturnPolishLanguageSettingOfTheGameAsChosenByUser(){

        ByteArrayInputStream inputStream = new ByteArrayInputStream("2\n".getBytes());
        System.setIn(inputStream);
        SettingsReader settingsReader = new SettingsReader();

        Locale.setDefault(settingsReader.setLanguage());
        String language = Locale.getDefault().getDisplayLanguage();

        assertEquals(language, "polski");
    }

    public void shouldReturnSpecificMessageWhileOptionBeyondListFirstChosenByUSer() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayInputStream inputStream = new ByteArrayInputStream("0\n2\n".getBytes());
        System.setOut(new PrintStream(outputStream));
        System.setIn(inputStream);
        SettingsReader settingsReader = new SettingsReader();

        String language = settingsReader.setLanguage().getDisplayLanguage();
        String[] result = outputStream.toString().split("\n");

        assertEquals(language, "polski");
        assertEquals(result[result.length - 4], "Please chose option number from the list");
    }

    public void shouldReturnSpecificMessageWhileTextInputFirstByUser() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayInputStream inputStream = new ByteArrayInputStream("some text\n2\n".getBytes());
        System.setOut(new PrintStream(outputStream));
        System.setIn(inputStream);
        SettingsReader settingsReader = new SettingsReader();

        String language = settingsReader.setLanguage().getDisplayLanguage();
        String[] result = outputStream.toString().split("\n");

        assertEquals(language, "polski");
        assertEquals(result[result.length - 1], "Please provide a number.");
    }

    public void shouldReturnMatchingPlayersNameAfterBeingSetByUser() {

        ByteArrayInputStream inputStream = new ByteArrayInputStream("Johnny\nSara\n".getBytes());
        System.setIn(inputStream);
        SettingsReader settingsReader = new SettingsReader();

        String[] playerNames = settingsReader.setPlayerNames(Settings.NUMBER_OF_PLAYERS);

        assertEquals(playerNames[0], "Johnny");
        assertEquals(playerNames[1], "Sara");
    }
}