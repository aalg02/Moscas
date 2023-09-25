package com.mygdx.main.CONTROLADOR

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.mygdx.main.MODELO.Objeto
import com.mygdx.main.VISTA.pantalla
import kotlin.random.Random

class Comportamiento() {


    val imagenRana = Texture(Gdx.files.internal("mosca.png"))
    val posicionInicialX = 300f
    val posicionInicialY = 200f
    var moscas= ArrayList<Objeto>(10)
    var moscasEliminar = ArrayList<Objeto>()
    var fondo=pantalla()

    fun moscas(){
        for (i in 0 until 10) {
            val randomX = Random.nextFloat() * Gdx.graphics.width
            val randomY = Random.nextFloat() * Gdx.graphics.width
                moscas.add( Objeto(imagenRana,randomX,randomY))
        }
    }


//    fun movimiento (rana: Objeto): Boolean {
//
//        //han tocado la pantalla
//        if(Gdx.input.justTouched()) {
//            val pixelX = Gdx.input.x.toFloat()
//            val pixelY = Gdx.graphics.height - Gdx.input.y.toFloat()
//
//            val mitadAnchoPantalla = Gdx.graphics.width.toFloat() / 2
//            val mitadAltoPantalla = Gdx.graphics.height.toFloat() / 2
//
//
//
//            if (pixelX < mitadAnchoPantalla) {
//                mosca.direccionX = -1 // Cambia la dirección a izquierda
//
//            } else {
//                mosca.direccionX = 1 // Cambia la dirección a derecha
//
//
//            }
//
//            if (pixelY > mitadAltoPantalla) {
//                mosca.direccionY = 1 // Cambia la dirección a arriba
//
//
//            } else {
//                mosca.direccionY = -1 // Cambia la dirección a abajo
//
//
//            }
//
//        }
//
//        return true
//    }


    fun limPantalla(mosca: Objeto) {
        val altoPantalla = Gdx.graphics.height
        val anchoPantalla = Gdx.graphics.width

        if (mosca.getY() >= altoPantalla - mosca.getHeight() && mosca.direccionY == 1) {
            // Llegó al límite superior y se está moviendo hacia arriba
            mosca.direccionY = -1 // Cambia la dirección a abajo


        }

        if (mosca.getY() <= 0 && mosca.direccionY == -1) {
            // Llegó al límite inferior y se está moviendo hacia abajo
            mosca.direccionY = 1 // Cambia la dirección a arriba

        }

        if (mosca.getX() >= anchoPantalla - mosca.getWidth() && mosca.direccionX == 1) {
            // Llegó al límite derecho y se está moviendo hacia la derecha
            mosca.direccionX = -1 // Cambia la dirección a izquierda


        }

        if (mosca.getX() <= 0 && mosca.direccionX == -1) {
            // Llegó al límite izquierdo y se está moviendo hacia la izquierda
            mosca.direccionX = 1 // Cambia la dirección a derecha


        }
    }


    fun controlarMoscas(batch:SpriteBatch){
        for (mosca in moscas){
            mosca.moverse()
            mosca.render(batch)
            limPantalla(mosca)

        }
    }

    fun muerteMoscas(){


        for (mosca in moscas) {
            if (mosca.tocada()) {

                moscasEliminar.add(mosca)
            }

        }

        if(moscasEliminar.size >9) {
            moscas.removeAll(moscasEliminar)
            moscasEliminar.clear()
            moscas()
        }

    }



    fun juego(batch:SpriteBatch){

        fondo.dibujarlo(batch)
        controlarMoscas(batch)
        muerteMoscas()




    }

}