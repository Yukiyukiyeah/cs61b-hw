/**
 * Created by YukiTang on $(DATE).
 */
public class TestPlanet {
    /**
     *  Tests Planet.
     */
    public static void main(String[] args) {
        checkPlanet();
    }

    /**
     *  Checks whether or not two Doubles are equal and prints the result.
     *
     *  @param  expected    Expected double
     *  @param  actual      Double received
     *  @param  label       Label for the 'test' case
     *  @param  eps         Tolerance for the double comparison.
     */
    private static void checkEquals(double actual, double expected, String label, double eps) {
        if (Math.abs(expected - actual) <= eps * Math.max(expected, actual)) {
            System.out.println("PASS: " + label + ": Expected " + expected + " and you gave " + actual);
        } else {
            System.out.println("FAIL: " + label + ": Expected " + expected + " and you gave " + actual);
        }
    }


    /**
     *  Checks the Planet class to make sure calcForceExertedBy works.
     */
    private static void checkPlanet() {
        System.out.println("Checking Planet...");

        Planet p1 = new Planet(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
        Planet p2 = new Planet(2.0, 1.0, 3.0, 4.0, 4e11, "jupiter.gif");

        checkEquals(p1.calcForceExertedByX(p2), 133.4, "calcForceExertedByX()", 0.01);
        checkEquals(p2.calcForceExertedByX(p1), -133.4, "calcForceExertedByX()", 0.01);
        checkEquals(p1.calcForceExertedByY(p2), 0.0, "calcForceExertedByY()", 0.01);
        checkEquals(p2.calcForceExertedByY(p1), 0.0, "calcForceExertedByY()", 0.01);
    }

}
