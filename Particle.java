import java.util.Scanner; 
import java.lang.Math;

public class Particle															//Class called Particle. This class will simulate different particles (for exercise 7.1 we only need one particle) only.
{
	private PhysicsVector position = new PhysicsVector();						//Creates a PhysicsVector called position. It's a blank PhysicsVector which is ready to write over later on. This is just to delcare the property called position.
	private PhysicsVector velocity = new PhysicsVector();						//Creates a PhysicsVector called velocity. It's a blank PhysicsVector which is ready to write over later on. This is just to delcare the property called velocity.
	private double mass = 0;
	// PhysicsVector acceleration = new PhysicsVector();							//Creates a PhysicsVector called acceleration. It's a blank PhysicsVector which is ready to write over later on. This is just to delcare the property called acceleration.
	
	 public double getPosY(){													//Makes new method (rather than getting it from PhysicsVector class) of returning the Y component of the particles position because the position is private (above).
		return position.getY();	
    }
	
    public double getPosX(){													//Makes new method (rather than getting it from PhysicsVector class) of returning the X component of the particles position because the position is private (above).
    	return position.getX();
    }
    public double getMass(){													//Makes new method (rather than getting it from PhysicsVector class) of returning the X component of the particles position because the position is private (above).
        return mass;
    }
    
    public PhysicsVector getPos(){													//Makes new method (rather than getting it from PhysicsVector class) of returning the X component of the particles position because the position is private (above).
        return position;
    }
    
	
	public Particle(){															//Creates new particle constructor which contains all properties of the particle.
		position = new PhysicsVector();											//Declares position as a new PhysicsVector.
		velocity = new PhysicsVector();											//Declares velocity as a new PhysicsVector.
		// acceleration = new PhysicsVector();										//Declares acceleration as a new PhysicsVector.
		}
		
		
	 public Particle(PhysicsVector p, PhysicsVector v, PhysicsVector a){		
		position = new PhysicsVector(p);
		velocity =  new PhysicsVector(v);
		// acceleration =  new PhysicsVector(a);
	 	}
	 	
	 public Particle(PhysicsVector p, PhysicsVector v, double m){		
		position = new PhysicsVector(p);
		velocity =  new PhysicsVector(v);
		mass = m;
	 	}

	 	
	 	
		public void eulerUpdate(PhysicsVector a, double TimeStep)				//Public method so that ProjectileMotion can use it.
	{
		position = PhysicsVector.add(position, PhysicsVector.scale(TimeStep, velocity));
		velocity = PhysicsVector.add(velocity, PhysicsVector.scale(TimeStep, a));
	}
	
		public void eulercramerUpdate(PhysicsVector a, double TimeStep)
	{
		velocity = PhysicsVector.add(velocity, PhysicsVector.scale(TimeStep, a));
		position = PhysicsVector.add(position, PhysicsVector.scale(TimeStep, velocity));
	}
	
	/*
		public void eulerrichardUpdate(double m, double r, double G, double TimeStep)			//use of other algorithms provides choice and different levels of accuracy
	{
		PhysicsVector velocitymid = new PhysicsVector();
		PhysicsVector positionmid = new PhysicsVector();
		PhysicsVector amid = new PhysicsVector();
		
		PhysicsVector a = GravField.GField(m, r + position.getY(), G);	
		velocitymid = PhysicsVector.add(velocity, PhysicsVector.scale(0.5*TimeStep, a));
		positionmid = PhysicsVector.add(position, PhysicsVector.scale(0.5*TimeStep, velocity));
		amid = GravField.GField(m, r + positionmid.getY(), G);																	
		
		velocity = PhysicsVector.add(velocity, PhysicsVector.scale(TimeStep, amid));
		position = PhysicsVector.add(position, PhysicsVector.scale(TimeStep, velocitymid));
	}	
	*/
		
	
	
	
	
	
	
	/**
		public void verletUpdate(PhysicsVector a, double TimeStep)
	{
		position = PhysicsVector.add(position, PhysicsVector.scale(TimeStep, velocity), PhysicsVector.scale(0.5 * TimeStep * TimeStep, a));
		velocity = PhysicsVector.add(velocity, PhysicsVector.scale(0.5 * TimeStep, a));
	}
		**/
	
	
}
