public class Planet{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public double G = 6.67*10e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos  = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){
        double dis_x = p.xxPos - this.xxPos;
        double dis_y = p.yyPos - this.yyPos;
        return Math.sqrt(dis_x * dis_x + dis_y*dis_y);
    }

    public double calcForceExertedBy(Planet p){
        double dis_square = this.calcDistance(p) * this.calcDistance(p);
        return G*this.mass*p.mass/dis_square;
    }

    public double calcForceExertedByX(Planet p){
        return (p.xxPos - this.xxPos)*this.calcForceExertedBy(p)/this.calcDistance(p);
    }

    public double calcForceExertedByY(Planet p){
        return (p.yyPos - this.yyPos)*this.calcForceExertedBy(p)/this.calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] ps){
        double res = 0;
        for (Planet p: ps){
            res += this.calcForceExertedByX(p);
        }
        return res;
    }

    public double calcNetForceExertedByY(Planet[] ps){
        double res = 0;
        for (Planet p: ps){
            res += this.calcForceExertedByY(p);
        }
        return res;
    }

    public void update(double dt, double fX, double fY){
        double ax = fX/this.mass;
        double ay = fY/this.mass;
        this.xxVel += ax * dt;
        this.yyVel += ay * dt;
        this.xxPos += this.xxVel * dt;
        this.yyPos += this.yyVel * dt;
    }
}