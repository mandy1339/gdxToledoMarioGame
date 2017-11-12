package test_pckg;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.toledo.mario.Scenes.Controls;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by armando on 11/7/17.
 */
public class ControlsTest extends GameTest {
    Controls controls;
    Body player = mock(Body.class);                 // mocking argument to constructor
    SpriteBatch batch = mock(SpriteBatch.class);    // mocking argument to constructor


    @Test
    public void hudConstTest() throws Exception {
        controls = new Controls(batch, player);
        assertNotNull(controls);
    }
}
