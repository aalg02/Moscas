package com.mygdx.main.MODELO

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch

open class Objeto(var imagen: Texture, private var posicionInicialX: Float, private var posicionInicialY: Float) {
    private var x: Float = posicionInicialX
    private var y: Float = posicionInicialY
    private var width: Float = imagen.width.toFloat()
    private var height: Float = imagen.height.toFloat()
    private var velocidad: Float = 4f
    var direccionX = 1
    var direccionY = 1
     var tiempomuerte:Float = 0.0f

    open fun update(deltaTime: Float) {
        // Actualizar lógica del objeto, si es necesario
    }

    open fun render(batch: SpriteBatch) {
        batch.begin()
        batch.draw(imagen, x, y)
        batch.end()
    }

    fun setImg(img :Texture){
        imagen=img
    }

    fun setPosition(x: Float, y: Float) {
        this.x = x
        this.y = y
    }
    fun moverse() {
        x += direccionX * velocidad
        y += direccionY * velocidad
    }

    fun tocada() :Boolean{

        if (Gdx.input.justTouched()) {
            var pixelX = Gdx.input.x.toFloat()
            var pixelY = Gdx.graphics.height - Gdx.input.y.toFloat()

            if (pixelX >= getX() && pixelX <= getX() + getWidth() &&
                pixelY >= getY() && pixelY <= getY() + getHeight()) {
                setImg(Texture(Gdx.files.internal("sangre.png")))
                direccionX=0
                direccionY=0
                tiempomuerte=0f;
                return true

            }

        }
        return false
    }
    fun getX(): Float {
        return x
    }

    fun getY(): Float {
        return y
    }

    fun getWidth(): Float {
        return width
    }

    fun getHeight(): Float {
        return height
    }
}
