package com.elament.foodstampsplease;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.elament.foodstampsplease.stages.MainMenuStage;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    public static SpriteBatch batch;
    private Texture image;

    public enum GameState {
        MAIN_MENU,
        IN_GAME,
        GAME_OVER;

        Stage stage;
    }

    GameState gameState = GameState.MAIN_MENU;

    @Override
    public void create() {
        batch = new SpriteBatch();
        GameState.MAIN_MENU.stage = new MainMenuStage();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        if (gameState == GameState.MAIN_MENU) {
            gameState.stage.draw();
        }

    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
