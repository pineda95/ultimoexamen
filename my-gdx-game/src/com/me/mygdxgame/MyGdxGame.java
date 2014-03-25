
package com.me.mygdxgame;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

class Imagen extends Sprite
{
	Imagen(Texture texture)
	{
		super(texture);
	}
	InputListener l;
	void avanzar()
	{
		setX(getX()+0.01f);
		if(getX()>0.5f)
			setX(-0.5f);
	}
	
}

public class MyGdxGame implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;
	private Imagen imagen;
	private Image i;
	
	
	Stage s;
	ArrayList<Sprite>sprites=new ArrayList<Sprite>();
	ArrayList<Pelotita>Pelotitas=new ArrayList<Pelotita>();
	ArrayList<PelotitaMala>Pelotitasm=new ArrayList<PelotitaMala>();
	int rotacion=0;
	int frame=0;
	
	
	
	
	@Override
	public void create()
	{		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		
		camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		
		texture = new Texture(Gdx.files.internal("data/fondo2.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);
		
		sprite = new Sprite(region);
		sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth());
		sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
		sprite.setPosition(0,0);

		imagen = new Imagen(texture);
		imagen.setPosition(-0.5f,-0.5f);
		imagen.setSize(1.0f, 1.0f);
		
		s=new Stage();
		i=new Image(texture);
		s.addActor(i);
		
		Gdx.input.setInputProcessor(s);
		
		pausa pausar = new pausa();
		s.addActor(pausar);
		
		
		for(int i=0;i<5;i++)
			
		{
			sprites.add(new Sprite(texture));
			sprites.get(i).setX(i*0.2f-0.5f);
			sprites.get(i).setY(i*-0.2f-0.5f);
			sprites.get(i).setSize(1, 1);
		}
		for(int i=0;i<5;i++)
		{
			Pelotita p=new Pelotita((int)(Math.random()*1000%w),(int)(Math.random()*1000%h));
			s.addActor(p);
			Pelotitas.add(p);
			
			
		}
		Fin adios= new Fin();
		for(int i=0;i<5;i++)
		{
			PelotitaMala m =new PelotitaMala((int)(Math.random()*1000%w),(int)(Math.random()*1000%h),adios);
			s.addActor(m);
			Pelotitasm.add(m);
		}
		adios.setVisible(false);
		s.addActor(adios);

		
		inicio listener = new inicio();
		s.addActor(listener);
		
		

	
		
	}

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
	}

	@Override
	public void render() {	
		sprite.setRotation(rotacion);
		imagen.avanzar();
		
		Gdx.gl.glClearColor(1, 0, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		
		batch.setProjectionMatrix(camera.combined);
		if(!pausa.pausar)
		{
		s.act();
		}
		s.draw();
		/*if (frame % 100 ==0) s.addActor(new Pelotita(1,50));
		frame ++;/*/
	
		
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
