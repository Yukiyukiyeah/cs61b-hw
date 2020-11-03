//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public class TestBody{

    /**
     *  Tests TestBody.
     */
    public static void main(String args[]){
        Body a = new Body(1,0,-1,-2,10,"jupiter.gif");
        Body b = new Body(3,3,2,3,5,"mercury.gif");

        double f1 = a.calcForceExertedByX(b);

        System.out.println(f1);
    }

}
