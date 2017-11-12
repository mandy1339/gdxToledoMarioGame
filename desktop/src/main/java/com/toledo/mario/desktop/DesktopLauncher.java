package com.toledo.mario.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.toledo.mario.ToledoMarioGame;

public class DesktopLauncher {
	public static ToledoMarioGame toledoMarioGame;

	public static void main (String[] arg) {
		toledoMarioGame = new ToledoMarioGame();
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = ToledoMarioGame.WIDTH;
		config.height = ToledoMarioGame.HEIGHT;
		new LwjglApplication(toledoMarioGame, config);
	}
}
