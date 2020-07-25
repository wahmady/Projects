
public class Planet{
	double xxPos;
	double yyPos;
	double xxVel;
	double yyVel;
	double mass;
	String imgFileName;

	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		this.xxPos = xP;
		this.xxVel = xV;
		this.yyVel = yV;
		this.yyPos = yP;
		this.mass = m;
		this.imgFileName = img;
	}
	public Planet(Planet P){
		this.xxPos = P.xxPos;
		this.xxVel = P.xxVel;
		this.yyVel = P.yyVel;
		this.yyPos = P.yyPos;
		this.mass = P.mass;
		this.imgFileName = P.imgFileName;
	}

	public double calcDistance(Planet P){
		double dx = this.xxPos - P.xxPos;
		double dy = this.yyPos - P.yyPos;
		double dist = (dx * dx) + (dy * dy);
		return Math.sqrt(dist);
		//figure out how to square root
	}

	public double calcForceExertedBy(Planet P){
		double g = 6.67 * Math.pow(10, -11);
		double force = ((g * this.mass * P.mass) / (this.calcDistance(Planet P)*this.calcDistance(Planet P)));
		return force;
	}
	public double calcForceExertedByX(Planet P){
		double dx = this.xxPos - P.xxPos;
		double forcebyx = (calcForceExertedBy(P) * dx) / calcDistance(P);
		return forcebyx;
	}
	public double calcForceExertedByY(Planet P){
		double dy = this.yyPos - P.yyPos;
		double forcebyy = (calcForceExertedBy(P) * dy) / calcDistance(P);
		return forcebyy;
	}
	public double calcNetForceExertedByX(Planet[] AllPlanets){
		double sum;
		for(int i = 0; i < AllPlanets.length; i++){
			if(AllPlanets[i] != this){
			sum = sum + this.calcForceExertedByX(AllPlanets[i]);
		}
	}
		return sum;
	}
	public double calcNetForceExertedByY(Planet[] AllPlanets){
		double sum;
		for(int i = 0; i < AllPlanets.length; i++){
			if(AllPlanets[i] != this){
			sum = sum + this.calcForceExertedByY(AllPlanets[i]);
		}
	}
		return sum;
	}

	public class void update(double dt, double fx, double fy){
		double accelerationx = fx / this.mass;
		double accelerationy =  fy / this.mass;

		double velocityx = this.xxVel + dt * accelerationx;
		double velocityy = this.yyVel + dt * accelerationy;
		double posx = this.xxPos + dt * velocityx;
		double posy = this.yyPos + dt * velocityy;
	}

	public class void draw(){
		
	}


	for(Planet p : AllPlanets){
		if(p.equals(this))
	}
 
//net force is force exerted by x;
//update is keeping coppying formulas
//Nbody: make an array of planets;
//
}