package com.elament.foodstampsplease.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.elament.foodstampsplease.Main;
import org.w3c.dom.Text;

import javax.swing.*;

public class MainMenuStage extends Stage {
    private Table table=new Table();
    private Image largeStamp;
    private boolean introDone=false;
    TextButton.TextButtonStyle buttonStyle=new TextButton.TextButtonStyle();
    NinePatchDrawable buttonBackground;


    public MainMenuStage() {
        super(new ScreenViewport(), Main.batch);
        build();
    }

    @Override
    public void draw() {
        rebuild();
        act();
        super.draw();
    }


    public void rebuild(){
        table.clear();
        this.clear();

        this.getViewport().update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);

        if (!introDone) {
            table.add(largeStamp).prefSize(Gdx.graphics.getHeight() * 0.8f, Gdx.graphics.getHeight() * 0.8f);
        } else {

        }


        table.setFillParent(true);
        addActor(table);


    }
    public void build(){
        buttonBackground=new NinePatchDrawable(new NinePatch(new Texture("button9patch.png")));
        largeStamp=new Image(new Texture("purplestamp.png"));
        largeStamp.addAction(Actions.sequence(Actions.delay(0.5f),Actions.fadeOut(0.5f),Actions.run(()->{introDone=true;})));
        rebuild();

    }

}

