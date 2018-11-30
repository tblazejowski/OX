package pl.falcor.ox.game;

import org.testng.annotations.Test;
import pl.falcor.ox.board.Sign;
import pl.falcor.ox.settings.Settings;

import java.io.ByteArrayInputStream;

import static org.testng.Assert.assertEquals;

@Test
public class GameTest {

    public void shouldInitializeGameWithChosenSettings(){

        ByteArrayInputStream inputStream = new ByteArrayInputStream("2\nStaś\nGrażyna\n1\n2\n3\n".getBytes());
        System.setIn(inputStream);
        Game game = new Game();

        game.initializeGame();

        assertEquals(game.getSettings().getGameLocale().getDisplayLanguage(), "polski");
        assertEquals(game.getSettings().getPlayers()[0].getName(), "Staś");
        assertEquals(game.getSettings().getPlayers()[0].getSign(), Sign.O);
        assertEquals(game.getSettings().getBoardDimension().getDimension(), 3);
    }
}