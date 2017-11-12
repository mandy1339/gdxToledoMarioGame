package com.toledo.mario;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.toledo.mario.Screens.PlayScreen;

public class ToledoMarioGame extends Game {
	public static final int WIDTH = 480;	//480
	public static final int HEIGHT = 800;	//208
	public SpriteBatch batch;				// public so other screens can use this batch
	public PlayScreen playScreen;
	public TextureAtlas atlas;


	@Override
	public void create () {
		atlas = new TextureAtlas("vampire-and-foes.pack");
		batch = new SpriteBatch();
		playScreen = new PlayScreen(this);
		setScreen(playScreen);
	}

	@Override
	public void render () {
		super.render();			// Delegate render method to playscreen
	}
	
	@Override
	public void dispose () {

	}
}
