package com.toledo.mario.Tools;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.EllipseMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Ellipse;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by armando on 11/10/17.
 */

public class MapTools {
    // Get objects from map
    private static BodyDef bdef = new BodyDef();
    private static PolygonShape shape = new PolygonShape();
    private static CircleShape shape2 = new CircleShape();
    private static FixtureDef fdef = new FixtureDef();
    private static Body body;

    public static void parseWalls(World world, com.badlogic.gdx.utils.Array<com.badlogic.gdx.maps.objects.RectangleMapObject> objects) {
        // Get walls
        for (MapObject object : objects) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getWidth() / 2) / 32, (rect.getY() + rect.getHeight() / 2) / 32 ) ;
            body = world.createBody(bdef);
            shape.setAsBox(rect.getWidth() / 2 / 32, rect.getHeight() / 2 / 32);
            fdef.shape = shape;
            body.createFixture(fdef);
        }
    }

    public static void parseWeapons(World world, com.badlogic.gdx.utils.Array<com.badlogic.gdx.maps.objects.EllipseMapObject> objects) {
        // Weapon
        for (MapObject object : objects) {
            Ellipse ellipse = ((EllipseMapObject) object).getEllipse();
            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((ellipse.x + ellipse.width / 2) / 32, (ellipse.y + ellipse.height / 2) / 32);
            body = world.createBody(bdef);
            shape2.setRadius(ellipse.width / 2 / 32);
            fdef.shape = shape2;
            body.createFixture(fdef);
        }
    }

    public static void parseCoins(World world, com.badlogic.gdx.utils.Array<com.badlogic.gdx.maps.objects.EllipseMapObject> objects) {
        // Coin
        for (MapObject object : objects) {
            Ellipse ellipse = ((EllipseMapObject) object).getEllipse();
            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((ellipse.x + ellipse.width / 2) / 32, (ellipse.y + ellipse.height / 2) / 32);
            body = world.createBody(bdef);
            shape2.setRadius(ellipse.width / 2 / 32);
            fdef.shape = shape2;
            body.createFixture(fdef);
        }
    }
}
