import java.lang.Math;
import java.util.ArrayList;

public class Body{
    static final double G = 6.67e-11;

    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;

    public Body(double xP, double yP, double xG, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xG;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Body(Body b){
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Body b){
        return Math.sqrt(Math.pow((this.xxPos - b.xxPos),2) + Math.pow((this.yyPos - b.yyPos),2));
    }

    public double calcForceExertedBy(Body b){
        return G*this.mass*b.mass/Math.pow(calcDistance(b),2);
    }

    public double calcForceExertedByX(Body b){
        return calcForceExertedBy(b)*(b.xxPos - this.xxPos)/calcDistance(b);
    }

    public double calcForceExertedByY(Body b){
        return calcForceExertedBy(b)*(b.yyPos - this.yyPos)/calcDistance(b);
    }

    public double calcNetForceExertedByX(Body[] bs){
        double Force = 0;
        for(Body b:bs){
            if(this.equals(b)!=true){
                Force += calcForceExertedByX(b);
            }
        }
        return Force;
    }

    public double calcNetForceExertedByY(Body[] bs){
        double Force = 0;
        for(Body b:bs){
            if(this.equals(b)!=true){
                Force += calcForceExertedByY(b);
            }
        }
        return Force;
    }

    public void update(double dt, double fX, double fY){
        this.xxVel += fX/this.mass*dt;
        this.yyVel += fY/this.mass*dt;
        this.xxPos += dt*this.xxVel;
        this.yyPos += dt*this.yyVel;
    }

    public void draw(){
        StdDraw.picture(this.xxPos, this.yyPos, String.format("images/%s",this.imgFileName));
    }

}