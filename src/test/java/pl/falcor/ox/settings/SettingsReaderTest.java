package pl.falcor.ox.settings;

import org.testng.annotations.Test;
import pl.falcor.ox.domain.Player;

import java.io.ByteArrayInputStream;
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

    public void shouldReturnMatchingPlayersNameAfterBeingSetByUser() {

        ByteArrayInputStream inputStream = new ByteArrayInputStream("Johnny\nSara\n".getBytes());
        System.setIn(inputStream);
        SettingsReader settingsReader = new SettingsReader();

        Player[] players = settingsReader.setPlayerNames(Settings.NUMBER_OF_PLAYERS);

        assertEquals(players[0].getName(), "Johnny");
        assertEquals(players[1].getName(), "Sara");
    }
}