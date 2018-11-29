package pl.falcor.ox.settings;

import org.testng.annotations.Test;
import pl.falcor.ox.board.BoardDimension;
import pl.falcor.ox.game.Player;
import pl.falcor.ox.board.Sign;

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
        Player[] players = new Player[]{new Player("Staś", Sign.X), new Player("Nel", Sign.O)};
        BoardDimension boardDimension = new BoardDimension(5);

        Settings settings = new Settings(setLocale, players, boardDimension);

        assertEquals(settings.getGameLocale().getDisplayLanguage(), "polski");
        assertEquals(settings.getPlayers()[0].getName(), "Staś");
        assertEquals(settings.getPlayers()[1].getName(), "Nel");
    }
}