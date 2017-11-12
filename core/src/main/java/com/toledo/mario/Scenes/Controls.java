package com.toledo.mario.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.toledo.mario.ToledoMarioGame;

/**
 * Created by armando on 10/26/17.
 */

public class Controls {
    public Stage stage;
    public Viewport viewport;
    public TextButton button1;
    public SpriteBatch batch;
    public Sprite backgroundSprite;
    public Texture backgroundTex;
    int horizontalForce;
    int verticalForce;
    Body player;



    //  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -
    // CONSTRUCTOR
    public Controls(SpriteBatch theBatch, Body player) {
        this.batch = theBatch;
        this.player = player;
        horizontalForce = 0;
        verticalForce = 0;

        backgroundTex = new Texture("ui-layer.png");
        backgroundSprite = new Sprite(backgroundTex);
        viewport = new FitViewport(ToledoMarioGame.WIDTH, ToledoMarioGame.HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, batch);
        //stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        Skin mySkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

        // BUTTON RIGHT
        button1 = new TextButton("->", mySkin);
        button1.addListener(new InputListener(){

            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                horizontalForce= 0;

            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                horizontalForce = 1;
//                camera.translate(100, 0)
//                camera.position.x += 100;
                return true;
            }
        });
        button1.setTransform(true);
        button1.setScale(0.4f);
        button1.setWidth(120);
        //button1.setSize(30, 30);
        button1.setPosition(140, 30);

        Table table1 = new Table();
        table1.bottom();
        Label scoreLabel = new Label("WHAT'S HAPPENING", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        table1.add(scoreLabel);
        table1.add(button1);
        Label label2 = new Label("WHAT'S HAPPENING 2222", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        table1.add(label2);


        // BUTTON LEFT
        TextButton button2 = new TextButton("<-", mySkin);
        button2.setWidth((Gdx.graphics.getWidth()));
        button2.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                horizontalForce= 0;
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                horizontalForce = -1;
//                camera.translate(100, 0)
//                camera.position.x += 100;
                return true;
            }
        });
        button2.setTransform(true);
        button2.setScale(0.4f);
        button2.setWidth(120);
        button2.setPosition(70, 30);


        // BUTTON UP
        TextButton button3 = new TextButton("^", mySkin);
        button3.setWidth((Gdx.graphics.getWidth()));
        button3.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                verticalForce= 0;
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                verticalForce = 1;
//                camera.translate(100, 0)
//                camera.position.x += 100;
                return true;
            }
        });
        button3.setTransform(true);
        button3.setScale(0.4f);
        button3.setWidth(120);
        button3.setPosition(105, 60);

        // BUTTON DOWN
        TextButton button4 = new TextButton("v", mySkin);
        button4.setWidth((Gdx.graphics.getWidth()));
        button4.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                verticalForce= 0;
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                verticalForce = -1;
//                camera.translate(100, 0)
//                camera.position.x += 100;
                return true;
            }
        });
        button4.setTransform(true);
        button4.setScale(0.4f);
        button4.setWidth(120);
        button4.setPosition(105, 20);


        stage.addActor(button1);
        stage.addActor(button2);
        stage.addActor(button3);
        stage.addActor(button4);
    }
    // CONSTRUCTOR
    //  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -


    public void movePlayer(){
        player.setLinearVelocity(horizontalForce * 10, verticalForce * 10);
    }

    public void drawUi(){
        batch.begin();
        backgroundSprite.draw(batch);
        batch.end();
        stage.draw();
    }
}
