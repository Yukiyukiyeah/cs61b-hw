/**
 * Created by YukiTang on $(DATE).
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    private static String message = "";
    @Test
    // @source: StudentArrayDequeLauncher
    public void testStudentArray() {
        StudentArrayDeque<Integer> studentArrayDeque = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> arrayDeque = new ArrayDequeSolution<>();

        for(int i = 0; i < 10; i++) {
            Integer randomInt = StdRandom.uniform(0, 5);
            if(randomInt < 2.5) {
                studentArrayDeque.addFirst(randomInt);
                arrayDeque.addFirst(randomInt);
                message += "\naddFirst(" + randomInt + ")";
            }else{
                studentArrayDeque.addLast(randomInt);
                arrayDeque.addLast(randomInt);
                message += "\naddLast(" + randomInt + ")";
            }
        }

        Integer size1 = studentArrayDeque.size();
        Integer size2 = arrayDeque.size();
        assertEquals(size1, size2);


        Integer randomI = StdRandom.uniform(0, 5);
        Integer get1 = studentArrayDeque.get(randomI);
        Integer get2 = arrayDeque.get(randomI);
        assertEquals(get1, get2);

        Integer remove1 = 0;
        Integer remove2 = 0;
        for(int j = 0; j < 10; j++) {
            Double randomNumber = StdRandom.uniform();
            if(randomNumber < 0.5) {
                remove1 = studentArrayDeque.removeFirst();
                remove2 = arrayDeque.removeFirst();
                message += "\nremoveFirst()";
                assertEquals(message, remove1, remove2);
            }
            else{
                remove1 = studentArrayDeque.removeLast();
                remove2 = arrayDeque.removeLast();
                message += "\nremoveLast()";
                assertEquals(message, remove1, remove2);
            }

        }

    }


}
