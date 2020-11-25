/**
 * Created by YukiTang on $(DATE).
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    // @source: StudentArrayDequeLauncher
    public void testStudentArray() {
        StudentArrayDeque<Integer> studentArrayDeque = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> arrayDeque = new ArrayDequeSolution<>();

        for(int i = 0; i < 10; i++) {
            Integer randomInt = StdRandom.uniform(0, 10);
            studentArrayDeque.addFirst(randomInt);
            arrayDeque.addFirst(randomInt);
            System.out.print(randomInt);
        }

        Integer size1 = studentArrayDeque.size();
        Integer size2 = arrayDeque.size();
        assertEquals("OhhhhNOOO! size: " + size1.toString() + "not equal to" + size2.toString(), size1, size2);


        Integer randomI = StdRandom.uniform(0, 10);
        Integer get1 = studentArrayDeque.get(randomI);
        Integer get2 = arrayDeque.get(randomI);
        assertEquals("Ohhhhh,NOOO!!! get: " + get1.toString() + "not equal to" + get2.toString(), get1, get2);

        Integer remove1 = 0;
        Integer remove2 = 0;
        for(int j = 0; j < 5; j++) {
            Double randomNumber = StdRandom.uniform();
            if(randomNumber < 0.5) {
                remove1 = studentArrayDeque.removeFirst();
                remove2 = arrayDeque.removeFirst();
                assertEquals("OhhhhhNo!! removeFirst:" + remove1.toString() + " not equal to " + remove2.toString(), remove1, remove2);
            }
            else{
                remove1 = studentArrayDeque.removeLast();
                remove2 = studentArrayDeque.removeLast();
                assertEquals("OHhhhNOO!!! removeLast: " + remove1.toString() + " not equal to " + remove2.toString(), remove1, remove2);
            }

        }

    }


}
