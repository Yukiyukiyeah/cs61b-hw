import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by YukiTang on $(DATE).
 */
public class TestOffByN {
    static CharacterComparator offByN = new OffByN(5);

    @Test
    public void testEqualChars() {
        assertTrue(offByN.equalChars('a','f'));
        assertTrue(offByN.equalChars('f','a'));
        assertTrue(offByN.equalChars('e','j'));
        assertFalse(offByN.equalChars('a','e'));
        assertFalse(offByN.equalChars('z','a'));
        assertFalse(offByN.equalChars('a','a'));
    }
}
