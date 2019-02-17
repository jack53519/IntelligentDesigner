package com.gameobjects;

import com.graphic.Color;
import com.graphic.Texture;
import com.math.Vector2f;
import com.math.Vector2i;
import org.joml.Matrix3x2f;
import org.lwjgl.opengl.GL;

public class Cube extends MovingObject implements DynamicObject {

    public Cube(Color color, Texture texture, Vector2f position, int width, int height, Vector2i texturePositionStart){
        super(color, texture, position, width, height, texturePositionStart);
    }

    @Override
    public void update() {
        Matrix3x2f transformation = new Matrix3x2f()
            .view(-10, +10, -10, +10) // <- like ortho2D in Matrix4f
            .translate(0, 0)  // <- multiply translation
            .rotate(0); // <- multiply rotation

        //TransformedVector = TranslationMatrix * RotationMatrix * ScaleMatrix * OriginalVector;
    }
}
