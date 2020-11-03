public class NBody{
    public static double readRadius(String filename){
        In in = new In(filename);
        int num = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Body[] readBodies(String filename){
        In in = new In(filename);
        int num = in.readInt();
        Body[] bodies = new Body[num];
        double radius = in.readDouble();
        for(int i = 0; i<num; i++){
            bodies[i] = new Body(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
        }
        return bodies;
    }


    public static void main(String[] args){
        // read
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        double radius = readRadius(filename);
        Body[] Bodies = readBodies(filename);
        int num = Bodies.length;

        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-radius,radius);
        StdDraw.clear();

        StdAudio.play("audio/2001.mid");

        int time = 0;
        while (time<=T){
            double xForces[] = new double[num];
            double yForces[] = new double[num];
            for(int i=0;i<num;i++){
                xForces[i] = Bodies[i].calcNetForceExertedByX(Bodies);
                yForces[i] = Bodies[i].calcNetForceExertedByY(Bodies);
            }
            for(int i=0;i<num;i++){
                Bodies[i].update(dt,xForces[i],yForces[i]);
            }
            StdDraw.picture(0,0,"images/starfield.jpg");
            for(Body b:Bodies){
                b.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time+=dt;
        }

        StdOut.printf("%d\n",Bodies.length);
        StdOut.printf("%.2e\n",radius);
        for(int i = 0; i < Bodies.length; i++){
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    Bodies[i].xxPos, Bodies[i].yyPos, Bodies[i].xxVel,
                    Bodies[i].yyVel, Bodies[i].mass, Bodies[i].imgFileName);
        }

    }
}