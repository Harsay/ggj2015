package com.ggj2015.model;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.ggj2015.Assets;

public class Knife {

	private Sprite sprite;
	
	private float x, y;
	private float velX, velY;
	private float width, height;
	private float friction = 0.98f;
	
	private float velAtStart = 1500;
	
	public float timeToStop = 0.5f;
	public float timeInAir = 0;
	
	private Player owner;
	
	public Knife(float x, float y){
		this.x = x;
		this.y = y;
		sprite = new Sprite(Assets.knifeTexture);
		width = sprite.getWidth();
		height = sprite.getHeight();
	}
	
	public void setOwner(Player owner){
		this.owner = owner;
	}
	
	public void throwIt(){
		if(owner != null){
			int dir = owner.getDir();
			owner.throwing = true;
			
			setX(owner.getCenterX()-width/2);
			setY(owner.getCenterY()-height/2);
			
			if(dir == 0){
				velX = -(float) (velAtStart / Math.sqrt(2));
				velY = (float) (velAtStart / Math.sqrt(2));
				sprite.setRotation(-45);
			}else if(dir == 1){
				velX = 0;
				velY = velAtStart;
				sprite.setRotation(-90);
			}else if(dir == 2){
				velX = (float) (velAtStart / Math.sqrt(2));
				velY = (float) (velAtStart / Math.sqrt(2));
				sprite.setRotation(-135);
			}else if(dir == 3){
				velX = -velAtStart;
				velY = 0;
				sprite.setRotation(0);
			}else if(dir == 4){
				// CENTER
			}else if(dir == 5){
				velX = velAtStart;
				velY = 0;
				sprite.setRotation(180);
			}else if(dir == 6){
				velX = -(float) (velAtStart / Math.sqrt(2));
				velY = -(float) (velAtStart / Math.sqrt(2));
				sprite.setRotation(45);
			}else if(dir == 7){
				velX = 0;
				velY = -velAtStart;
				sprite.setRotation(90);
			}else if(dir == 8){
				velX = (float) (velAtStart / Math.sqrt(2));
				velY = -(float) (velAtStart / Math.sqrt(2));
				sprite.setRotation(135);
			}
			
			owner = null;
			
		}
	}
	
	
	
	public float getFriction() {
		return friction;
	}

	public void setFriction(float friction) {
		this.friction = friction;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
		sprite.setX(x);
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
		sprite.setY(y);
	}

	public float getVelX() {
		return velX;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelY(float velY) {
		this.velY = velY;
	}

	public Sprite getSprite(){
		return sprite;
	}
	
	public Player getOwner(){
		return owner;
	}
	
	
}
