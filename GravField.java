import java.util.Scanner; 
import java.lang.Math;

public class GravField															//Class called GravField. This class will simulate different fields (for exercise 7.1 we only need one field) only.
{
	public static PhysicsVector GField(Particle one, Particle two){				//Make new PhysicsVector called GField, taking values of m, r and G from main class ProjectileMotion.
        
        double G = (-6.67408) * Math.pow(10, -11);								//Declare G in GravField class as this is the only method that uses it...every other method calls to this one
        
        PhysicsVector distance = new PhysicsVector();							//Creating a new vector called distance
        distance = PhysicsVector.subtract(one.getPos(), two.getPos());			//vector called distance is equal to the position of first particle subtracted from the second particle
        double r = distance.magnitude(); 										//retrieves magnitude of distance vector							
        
        double m = two.getMass();												//retrieves mass of particle 2
		double g1 = (G*m)/(r*r);
		PhysicsVector g = new PhysicsVector();
        g = distance.getUnitVector();											//defines g equal to the unit vector of the distance
        g.scale(g1);															//then updates definition of g by scaling it by g1
		return g;
			
	}
}
