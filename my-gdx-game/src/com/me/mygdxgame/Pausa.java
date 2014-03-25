package com.me.mygdxgame;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class Pausa extends InputListener {

    pausa stop;
	Pausa(pausa p){
		super ();
		stop = p;
		
	}@Override
public boolean touchDown(InputEvent event, float x , float y, int pointer,int button ){
	
	pausa.pausar = !pausa.pausar;	
	System.out.println("juego pausado ");
	return true;
	
}

}


