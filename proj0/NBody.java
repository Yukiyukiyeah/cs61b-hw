public class NBody{
    public static double readRadius(String filename){
        In in = new In(filename);
        int num = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String filename){
        In in = new In(filename);
        int num = in.readInt();
        Planet[] planets = new Planet[num];
        double radius = in.readDouble();
        for(int i = 0; i<num; i++){
            planets[i] = new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
        }
        return planets;
    }


    public static void main(String[] args){
        // read
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        double radius = readRadius(filename);
        Planet[] Planets = readPlanets(filename);
        System.out.println(radius);
        System.out.println(Planets[0].xxPos);
        int num = Planets.length;

        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-radius,radius);
        StdDraw.clear();

        // StdAudio.play("audio/2001.mid");

        int time = 0;
        while (time<=T){
            double xForces[] = new double[num];
            double yForces[] = new double[num];
            for(int i=0;i<num;i++){
                xForces[i] = Planets[i].calcNetForceExertedByX(Planets);
                yForces[i] = Planets[i].calcNetForceExertedByY(Planets);
            }
            for(int i=0;i<num;i++){
                Planets[i].update(dt,xForces[i],yForces[i]);
                System.out.println(xForces[i]);
            }
            StdDraw.picture(0,0,"images/starfield.jpg");
            for(Planet b:Planets){
                b.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time+=dt;
        }

        StdOut.printf("%d\n",Planets.length);
        StdOut.printf("%.2e\n",radius);
        for(int i = 0; i < Planets.length; i++){
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    Planets[i].xxPos, Planets[i].yyPos, Planets[i].xxVel,
                    Planets[i].yyVel, Planets[i].mass, Planets[i].imgFileName);
        }

    }
}