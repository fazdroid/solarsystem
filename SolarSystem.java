import java.util.Scanner; 
import java.lang.Math;

public class SolarSystem{

	public static void main(String[] args){
		
		double sunmass = 1;
		double earthmass = (5.974) * Math.pow(10, 24);							//declared constants at start of method
		double moonmass = 1;
		double r = 6380000;
		
		double time = 0;
       Scanner sc = new Scanner(System.in);

		System.out.println("Enter a value for the time step, delta t");
		double dt = sc.nextDouble();
    
		System.out.println("Enter a value for the total time (in days)");
		double timeSeconds = sc.nextDouble();
        double totalTime =60*60*24*timeSeconds;									//is this the right way of converting totalTime from seconds to days?
        
		PhysicsVector sunposition = new PhysicsVector();						//declared initial position vectors of each particle
		PhysicsVector earthposition = new PhysicsVector();
		PhysicsVector moonposition = new PhysicsVector();
		
		PhysicsVector sunvelocity = new PhysicsVector();						//declared initial velocity vectors of each particle
		PhysicsVector earthvelocity = new PhysicsVector();
		PhysicsVector moonvelocity = new PhysicsVector();
		
		
		
        
		Particle[] ssystem = new Particle[3];									//creating an array of size 3, as the simulation simulates 3 bodies
        ssystem[0] = new Particle(sunposition, sunvelocity, sunmass);			//declaring each component in the array with its properties
        ssystem[1] = new Particle(earthposition, earthvelocity, earthmass);
        ssystem[0] = new Particle(moonposition, moonvelocity, moonmass);
        PhysicsVector [] Acc = new PhysicsVector [3];							//creating a new acceleration vector
        
        
																				// For some number of steps (i.e. dt)
		do
		{
			for(int i = 0; i < ssystem.length; i++)
				{
					for(int j = 0; j < ssystem.length; j++)
						{
                            if(i!=j){											//if i=j, r = 0, therefore g = infinity. This if statement prevents that
                            													// Acceleration of the i'th plannet due to the j'th plannet
                                Acc[i].increaseBy(GravField.GField(ssystem[i],ssystem[j]));
                            }
                            ssystem[i].eulerUpdate(Acc[i],dt);
						};
				};

            time+=dt;															//repeats dt until it's equal to time
		}
        while(totalTime>time);													//repeats update loop until program hits totalTime
        
		
		/*
		PhysicsVector velocity = new PhysicsVector(x, y, 0);					//Declared initial velocity vector as input from scanner
		
		
		PhysicsVector a = new PhysicsVector();									//Declared initial acceleration as blank PhysicsVector (like a template)
		a = GravField.GField(m, r + position.getY(), G);						//The acceleration is set to the PhysicsVector called GField that belongs to the class GravField. It needs to pass the arguments m, r, G (no need for double G etc as already stated in GravField.java). It is position.getY rather than getPosY because I haven't made the particle yet. The code is using line 15.
		Particle p = new Particle(position, velocity, a);						//Declared new particle called P, has properties of position, velocity and a.				
		while (p.getPosY()>=0)													//Loop started - as long as the Y component of the particle p's position is positive, run whatever code is in the loop.
		{
			System.out.println(p.getPosX() + " " + p.getPosY());				//Prints out position of particle before calculating the new position.
			p.eulerUpdate(a, t);												//Runs the method to update the position.
			a = GravField.GField(m, r + p.getPosY(), G);						//Need to reset acceleration as we have a new position from the eulerUpdate. With this line of code we update the acceleration and then it repeats this everytime the position changes as it is in the while loop. Changes from getY to getPosY because the particles position is private inside the particle class. There needs to be a separate method inside Particle to retrieve its position (and velocity).
			System.out.println(p.getPosX() + " " + p.getPosY());				//Prints out new position of particle after calculating eulerUpdate.
			System.out.println();
		}
		
		System.out.println(p.getPosX());
		*/
	}
}
