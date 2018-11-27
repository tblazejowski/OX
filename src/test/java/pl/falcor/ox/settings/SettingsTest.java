package pl.falcor.ox.settings;

import org.testng.annotations.Test;
import pl.falcor.ox.domain.Player;

import java.util.Locale;

import static org.testng.Assert.assertEquals;

@Test
public class SettingsTest {

    public void shouldReturnDefaultLanguageOfGameSettings() {

        Settings settings = new Settings();

        String language = settings.getGameLocale().getDisplayLanguage();

        assertEquals(language, "English");
    }

    public void shouldReturnSetOptionsForTheGameSettings() {

        Locale setLocale = new Locale("pl", "PL");
        Player[] players = new Player[]{new Player("Staś"), new Player("Nel")};

        Settings settings = new Settings(setLocale, players);

        assertEquals(settings.getGameLocale().getDisplayLanguage(), "polski");
        assertEquals(settings.getPlayers()[0].getName(), "Staś");
        assertEquals(settings.getPlayers()[1].getName(), "Nel");
    }
}