package model.entities;

//This is the super class of all the box targets in the game.
//The SolidiEntity has Position (from AbstractEntity).
public abstract class BoxTarget extends UnsolidEntity {

	public BoxTarget() {
		super();
	}
	
	public BoxTarget(Position2D pos) {
		super(pos);
	}
}
