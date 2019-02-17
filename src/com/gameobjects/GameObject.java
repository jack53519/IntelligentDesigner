package com.gameobjects;

import com.graphic.Color;
import com.graphic.Renderer;
import com.graphic.Texture;
import com.math.Vector2f;
import com.math.Vector2i;

public abstract class GameObject {
    protected Vector2f position;
    protected final Texture texture;
    protected final Vector2i texturePositionStart;
    protected Vector2i texturePositionEnd;
    protected final float width, height;
    protected final Color color;

    public GameObject(Color color, Texture texture, Vector2f position, int width, int height, Vector2i texturePositionStart) {
        this.position = position;

        this.color = color;
        this.texture = texture;

        this.width = width;
        this.height = height;

        this.texturePositionStart = texturePositionStart;
        this.texturePositionEnd = new Vector2i(texturePositionStart.x+width, texturePositionStart.y+height);
    }

    public void render(Renderer renderer){
        renderer.drawTextureRegion(texture, position.x, position.y, texturePositionStart.x, texturePositionStart.y, width, height, color);
    }

    public void renderStreched(Renderer renderer){
        renderer.drawTextureRegion(position.x, position.y, position.x+width, position.y+height,
                (float)texturePositionStart.x/texture.getWidth(), (float)texturePositionStart.y/texture.getHeight(),
                (float)texturePositionEnd.x/texture.getWidth(), (float)texturePositionEnd.y/texture.getHeight(), color);
    }
}
