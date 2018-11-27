package pl.falcor.settings;

import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.Assert.assertEquals;

@Test
public class SettingsReaderTest {

    public void shouldReturnEnglishLanguageSettingOfTheGameAsChosenByUser(){

        ByteArrayInputStream inputStream = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(inputStream);
        SettingsReader settingsReader = new SettingsReader();
        Settings settings = new Settings(settingsReader.setLanguage());

        String language = settings.getGameLocale().getDisplayLanguage();

        assertEquals(language, "English");
    }

    public void shouldReturnPolishLanguageSettingOfTheGameAsChosenByUser(){

        ByteArrayInputStream inputStream = new ByteArrayInputStream("2\n".getBytes());
        System.setIn(inputStream);
        SettingsReader settingsReader = new SettingsReader();
        Settings settings = new Settings(settingsReader.setLanguage());

        String language = settings.getGameLocale().getDisplayLanguage();

        assertEquals(language, "polski");
    }

    public void shouldReturnRespectiveMessageWhileOptionBeyondListFirstChosenByUSer(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayInputStream inputStream = new ByteArrayInputStream("0\n2\n".getBytes());
        System.setOut(new PrintStream(outputStream));
        System.setIn(inputStream);
        SettingsReader settingsReader = new SettingsReader();
        Settings settings = new Settings(settingsReader.setLanguage());

        String language = settings.getGameLocale().getDisplayLanguage();
        String[] result = outputStream.toString().split("\n");

        assertEquals(language, "polski");
        assertEquals(result[result.length - 5], "Chose option number from the list");
    }
}