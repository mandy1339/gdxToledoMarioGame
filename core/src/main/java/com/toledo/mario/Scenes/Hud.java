package com.toledo.mario.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
//import com.toledo.mario.ToledoMarioGame;
import com.toledo.mario.*;
import com.toledo.mario.*;
/**
 * Created by armando on 10/25/17.
 */

public class Hud {
    public Stage stage;
    private Viewport viewport;

    private Integer worldTimer;
    private float timeCount;
    private Integer score;

    public Hud(SpriteBatch batch) {
        worldTimer = 300;
        timeCount = 0;
        score = 0;

        FileHandle fh = Gdx.files.local("myfile.txt");

        fh.writeString("SCORE 99", true);

        viewport = new FitViewport(ToledoMarioGame.WIDTH, ToledoMarioGame.HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, batch);

        Table table = new Table();
        table.top();
        table.setFillParent(true);

        Label countdownLabel = new Label(String.format("%03d", worldTimer), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Label scoreLabel = new Label("TIME", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Label timeLabel = new Label(String.format("TIME", worldTimer), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Label levelLabel = new Label("1-1", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Label worldLabel = new Label("TOLEDO", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Label marioLabel = new Label("ARMANDO", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        // Top row
        table.add(marioLabel).expandX().padTop(10);
        table.add(worldLabel).expandX().padTop(10);
//        table.add(timeLabel).expandX().padTop(10);
//
//        table.row();
//
//        // 2nd row
//        table.add(scoreLabel).expandX();
//        table.add(levelLabel).expandX();
//        table.add(countdownLabel).expandX();

        // Add table to stage
        stage.addActor(table);
    }
}