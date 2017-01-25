package model.entities;

import java.io.Serializable;

import levels.Direction2D;
import movements.Movement;

//This is the abstract super class of all entities in the game.
//It have only attribute of position in game.
public abstract class AbstractEntity implements Serializable{
	Position2D position;
	
	public AbstractEntity() {
		this.position = null;
	}
	
	public AbstractEntity(Position2D pos) {
		this.position = pos;
	}

	public Position2D getPosition() {
		return position;
	}

	public void setPosition(Position2D position) {
		this.position = position;
	}



	
}
