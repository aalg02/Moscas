package com.mygdx.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.main.CONTROLADOR.Comportamiento;

public class main extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Comportamiento comportamiento;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		comportamiento=new Comportamiento();
		comportamiento.moscas();
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		comportamiento.juego(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
