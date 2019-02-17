package com;

import com.gameobjects.Background;
import com.graphic.Color;
import com.graphic.GameWindow;
import com.graphic.Renderer;

import static org.lwjgl.glfw.GLFW.*;

import com.graphic.Texture;
import com.math.Vector2f;
import com.math.Vector2i;
import com.settings.Settings;

public class IntelligentDesigner {
    private GameWindow gameWindow;
    private Texture texturePack;
    private Renderer renderer;
    private Background background;


    private void startGame() {

        Settings settings = new Settings(700,16f/9f,true);
        gameWindow = new GameWindow(settings);
        renderer = new Renderer();
        renderer.init();

        /* Load texture */
        texturePack = Texture.loadTexture("resources/example.png");

        background = new Background(Color.WHITE, texturePack, new Vector2f(0,0), settings.getWindowWidth()*2, settings.getWindowHeight()*2, new Vector2i(0,0), new Vector2i(200, 200));
        // Run the rendering loop until the user has attempted to close
        // the window or has pressed the ESCAPE key.
        gameLoop();

        renderer.dispose();
        gameWindow.destroy();
    }

    public void gameLoop() {
        while(!glfwWindowShouldClose(gameWindow.getWindow())) {
            gameWindow.input();
            render();
            gameWindow.update();
        }
    }

    public void render(){
        /* Clear drawing area */
        renderer.clear();

        /* Draw game objects */
        renderer.begin();
        texturePack.bind();

        background.render(renderer);

        renderer.end();
    }


    public static void main(String[] args) {
        IntelligentDesigner intelligentDesigner = new IntelligentDesigner();
        intelligentDesigner.startGame();
    }


}