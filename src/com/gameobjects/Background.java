package com.gameobjects;

import com.graphic.Color;
import com.graphic.Texture;
import com.math.Vector2f;
import com.math.Vector2i;

public class Background extends GameObject{

    public Background(Color color, Texture texture, Vector2f position, int width, int height, Vector2i texturePositionStart, Vector2i texturePositionEnd) {
        super(color, texture, position, width, height, texturePositionStart);
        this.texturePositionEnd = texturePositionEnd;
    }

}
