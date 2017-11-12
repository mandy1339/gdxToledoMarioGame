package test_pckg;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.toledo.mario.Scenes.Hud;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by armando on 11/7/17.
 */
public class HudTest extends GameTest{
    SpriteBatch batch = mock(SpriteBatch.class);
    Hud hud;

    @Test
    public void appCreationTest() throws Exception {
        //Hud hud = new Hud();
        assertNotNull(application);
    }


    @Test
    public void hudConstTest() throws Exception {
        hud = new Hud(batch);
        assertNotNull(batch);
    }
}