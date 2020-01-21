package com.mygdx.game;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.Screen;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import static com.mygdx.game.GameScreen.punts;


public class EndGameScreen implements Screen {
    final Drop game;
    private TextureRegion region;
    OrthographicCamera camera;
    Sound endGame;
    boolean b = true;
    Texture main;


    public EndGameScreen(final Drop gam) {

        game = gam;
        endGame = Gdx.audio.newSound(Gdx.files.internal("gameOver.mp3"));
        main = new Texture(Gdx.files.internal("rainPicture.png"));

        camera = new OrthographicCamera();

        camera.setToOrtho(false, 800, 480);
        region = new TextureRegion(main,0,0,800,480);

    }
    @Override

    public void render(float delta) {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        game.batch.setProjectionMatrix(camera.combined);


        game.batch.begin();
        game.batch.draw(region,0,0);
        game.font.draw(game.batch, "Game Over, Puntuacion: " + punts, 100, 150);

        game.font.draw(game.batch, "Pulsa la pantalla para volver a empezar", 100, 100);
        game.batch.end();
        if (b) {
            endGame.play();
            b = false;
        }


        if (Gdx.input.isTouched()) {

            game.setScreen(new GameScreen(game));

            dispose();

        }

    }


    @Override

    public void resize(int width, int height) {

    }


    @Override

    public void show() {

    }


    @Override

    public void hide() {

    }


    @Override

    public void pause() {

    }


    @Override

    public void resume() {

    }


    @Override

    public void dispose() {

        endGame.dispose();

    }

}