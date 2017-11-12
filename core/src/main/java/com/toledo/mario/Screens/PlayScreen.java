package com.toledo.mario.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.EllipseMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Ellipse;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.toledo.mario.Scenes.Controls;
import com.toledo.mario.Scenes.Hud;
import com.toledo.mario.Sprites.Vampire;
import com.toledo.mario.ToledoMarioGame;
import com.toledo.mario.Tools.MapTools;

/**
 * Created by armando on 10/25/17.
 */

public class PlayScreen implements Screen {

    // -    -   -   -   -   -   -   -   -   -   -   -   -   -   -
    // INSTANCE DATA
    private ToledoMarioGame game;
    private Hud hud;

    private Controls controls;
    Sprite sprite1;
    Texture tex;
    private OrthographicCamera cam;
    private Viewport viewport;
    private Viewport extendViewport;
    private TmxMapLoader maploader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer orthoMapRender;
    private World world;
    private Body player;
    private Sprite sprite2;
    private Body player2;
    private Box2DDebugRenderer b2dr;
    public Vampire vampire;

    private TextureAtlas atlas;
    // INSTANCE DATA
    // -    -   -   -   -   -   -   -   -   -   -   -   -   -   -




    // -   -   -   -   -   -   -   -   -   -   -   -   -   -
    // CONSTRUCTOR
    public PlayScreen(ToledoMarioGame game) {
        this.game = game;

        world = new World(new Vector2(0, 0), false);	// Vector has acceleration
        b2dr = new Box2DDebugRenderer();					// To print debug edge lines
        vampire = new Vampire(world, game, 500f, 200f);
        vampire.setSize(16f, 16f);
        player = vampire.body;
        player2 = createPlayer(500f, 500f);
        sprite2 = new Sprite(new Texture("loving-vampire2.png"));
        sprite2.setScale(.5f);
        sprite2.setPosition(ToledoMarioGame.WIDTH/2 - 16, ToledoMarioGame.HEIGHT/2 + 200 - 16);

        //player = createPlayer(32, 140);

        // Init cam
        cam = new OrthographicCamera();
        //viewport = new StretchViewport(game.WIDTH, game.HEIGHT, cam);
        //viewport = new FillViewport(game.WIDTH, game.HEIGHT, cam);
        viewport = new FitViewport(game.WIDTH, game.HEIGHT, cam);
        //extendViewport = new ExtendViewport(game.WIDTH, game.HEIGHT);

        //viewport.setScreenPosition(viewport.getScreenX(), viewport.getScreenY() + 700);
        //viewport = new ScreenViewport(cam);

        atlas = new TextureAtlas("vampire-and-foes.pack");


        // Init hud / controls
        hud = new Hud(game.batch);
        controls = new Controls(game.batch, player2);

        // Tiled map
        maploader = new TmxMapLoader();
        map = maploader.load("maps/toledo-mario-map-3.tmx");

        orthoMapRender = new OrthogonalTiledMapRenderer(map);

        cam.position.set(viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 2, 0);   // Center the viewport


        // Parse the map objects
        MapTools.parseWalls(world, map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class));
        MapTools.parseWeapons(world, map.getLayers().get(3).getObjects().getByType(EllipseMapObject.class));
        MapTools.parseCoins(world, map.getLayers().get(4).getObjects().getByType(EllipseMapObject.class));


    }
    // CONSTRUCTOR
    // -   -   -   -   -   -   -   -   -   -   -   -   -   -




    @Override
    public void show() {

    }




    // -   -   -   -   -   -   -   -   -   -   -   -   -   -
    // HANDLE INPUT
    public void handleInput(float dt) {
//        if(Gdx.input.isTouched()) {
//            cam.position.x += 100 * dt;
//        }


    }
    // HANDLE INPUT
    // -   -   -   -   -   -   -   -   -   -   -   -   -   -



    // -   -   -   -   -   -   -   -   -   -   -   -   -   -
    // UPDATE
    public void update(float dt) {
        handleInput(dt);
        cam.update();

//        vampire.setPosition(player.getPosition().x * 32, player.getPosition().y * 32);
//        vampire.setCenter(player.getPosition().x * 32, player.getPosition().y * 32);


//        vampire.setX(player.getPosition().x * 32);
//        vampire.setY(player.getPosition().y * 32);
        orthoMapRender.setView(cam);
        //player.setLinearVelocity(3 * 25, 3 * 25);
        controls.movePlayer();


        System.out.print(player2.getPosition().x * 32 + " " + player2.getPosition().y * 32);
        System.out.print("        " + sprite2.getX() + " " + sprite2.getY());
        System.out.println(

        );
        world.step(1/ 60f, 6, 2);					// Calculate how smooth the motion is
        cam.position.x = (float)(player2.getPosition().x * 32);
        cam.position.y = (float)(player2.getPosition().y * 32 - 200);
//        cam.position.y = (float)(cam.position.y + (player.getPosition().y * 32 - cam.position.y) * .1);
        cam.update();
    }
    // UPDATE
    // -   -   -   -   -   -   -   -   -   -   -   -   -   -




    // -   -   -   -   -   -   -   -   -   -   -   -   -   -
    // RENDER
    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        game.batch.setProjectionMatrix(cam.combined);

        orthoMapRender.render();
        hud.stage.draw();   // Draw hud
        hud.stage.draw();   // Draw hud
        controls.drawUi();


        game.batch.begin();
        vampire.draw(game.batch);
        sprite2.draw(game.batch);
        game.batch.end();
        b2dr.render(world, cam.combined.scl(32));

    }
    // RENDER
    // -   -   -   -   -   -   -   -   -   -   -   -   -   -



    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    public Body createPlayer(float x, float y) {
        System.out.println("CREATED PLAYER");
        Body pBody;
        BodyDef def = new BodyDef();				// Need this to define body properties
        def.type = BodyDef.BodyType.DynamicBody;	// Dynamic == moves
        def.position.set(x / 32, y / 32);					// set position of body
        def.fixedRotation = true;					// prevent rotation interference from forces

        pBody = world.createBody(def);				// Create the pbody in the world
        CircleShape shape = new CircleShape();
        shape.setRadius(8f / 32);
        //PolygonShape shape = new PolygonShape();	// Create a shape to give to body later
        //shape.setAsBox(32/2 / PPM, 32/2 / PPM);		// Divide by pixels per minute
        pBody.createFixture(shape, 1.0f);			// Give shape to body
        shape.dispose();							// Dispose shape right after using it
        return pBody;
    }

    // GET_PLAYER()
    public Body getPlayer() {
        return player;
    }

    // GET_HUD()
    public Hud getHud() {
        return hud;
    }

    public TextureAtlas getAtlas() { return atlas; }
}
