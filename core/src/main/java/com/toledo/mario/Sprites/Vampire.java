package com.toledo.mario.Sprites;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.toledo.mario.ToledoMarioGame;

/**
 * Created by armando on 11/10/17.
 */

public class Vampire extends Sprite {
    public World world;
    public Body body;
    private TextureRegion vampStandRight;

    public Vampire (World world, ToledoMarioGame game, float x, float y) {
        super(game.atlas.findRegion("vampire-animation"));
        this.world = world;
        defineVampire(x, y);
        vampStandRight = new TextureRegion(getTexture(), 0, 0, 16, 16);
        setBounds(0, 0, 16 / 32, 16 / 32);
        setRegion(vampStandRight);
    }

    public void defineVampire(float x, float y) {
        BodyDef bdef = new BodyDef();
        bdef.type = BodyDef.BodyType.DynamicBody;
        bdef.position.set(x / 32, y / 32);
        bdef.fixedRotation = true;
        body = world.createBody(bdef);

//        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(8f / 32);

//        fdef.shape = shape;
        body.createFixture(shape, 1.0f);
    }
}
