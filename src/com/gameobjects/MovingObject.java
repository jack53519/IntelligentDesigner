package com.gameobjects;

import com.graphic.Color;
import com.graphic.Renderer;
import com.graphic.Texture;
import com.math.Vector2f;
import com.math.Vector2i;

public abstract class MovingObject extends GameObject {
    Vector2f UL, UR, LL, LR;
    public MovingObject(Color color, Texture texture, Vector2f position, int width, int height, Vector2i texturePositionStart){
        super(color, texture, position, width, height, texturePositionStart);
    }

    @Override
    public void render(Renderer renderer){
        renderer.drawTextureRegion(UL, UR, LL, LR, texturePositionStart.x, texturePositionStart.y, texturePositionEnd.x, texturePositionEnd.y, color);
    }
}
