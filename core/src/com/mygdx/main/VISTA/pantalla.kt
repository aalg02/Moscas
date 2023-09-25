package com.mygdx.main.VISTA

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class pantalla() {

    var foto= Texture(Gdx.files.internal("fondo.jpg"))


    fun dibujarlo(batch: SpriteBatch){
        batch.begin()
        batch.draw(foto,0f,0f,Gdx.graphics.width.toFloat(), Gdx.graphics.height.toFloat())
        batch.end()
    }
}