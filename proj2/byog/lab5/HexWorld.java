package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;

    private static final long SEED = 2873123;
    private static final Random RANDOM = new Random(SEED);

    /**
     *
     * @param s the size of hexagon
     * @param h the number of row from bottom
     * @return the length of each row
     */
    public static int rowLength(int s, int h) {
        int add;
        if (h >= s) {
            add = 2 * (s - 1) - h;
        } else {
            add = h;
        }
        return s + 2 * add;
    }

    /**
     *
     * @param s the size of hexagon
     * @param h the number of row from bottom
     * @return the offset from the left
     */
    public static int rowOffSet(int s, int h) {
        int offset;
        if (h >= s) {
            offset = h - s + 1;
        }
        else {
            offset = s - 1 - h;
        }
        return offset;
    }

    /** Picks a RANDOM tile with a 33% change of being
     *  a wall, 33% chance of being a flower, and 33%
     *  chance of being empty space.
     */
    private static TETile randomTile() {
        int tileNum = RANDOM.nextInt(11);
        switch (tileNum) {
            case 0: return Tileset.WALL;
            case 1: return Tileset.FLOWER;
            case 2: return Tileset.FLOOR;
            case 3: return Tileset.PLAYER;
            case 4: return Tileset.GRASS;
            case 5: return Tileset.LOCKED_DOOR;
            case 6: return Tileset.MOUNTAIN;
            case 7: return Tileset.SAND;
            case 8: return Tileset.TREE;
            case 9: return Tileset.UNLOCKED_DOOR;
            case 10: return Tileset.WATER;
            default: return Tileset.NOTHING;
        }
    }

    public static void addHexagon(int s, TETile[][] world, int positionX, int positionY) {
        TETile randomTile = randomTile();
        if (positionX + 2 * s > world.length || positionY + 2 * s > world[0].length) {
            throw new IllegalArgumentException("The hexagon cross the boundary of the world");
        }
        for (int y = 0; y < 2 * s - 1; y++) {
            int start = rowOffSet(s, y);
            int length = rowLength(s, y);
            for (int x = start; x < start + length; x++) {
                world[positionX + x][positionY + y] = TETile.colorVariant(randomTile, 100, 100, 100, RANDOM);
            }
        }
    }

    public static void drawHexColumns(int num, int s, int positionX, int positionY) {

    }

    public static void main (String[] args) {
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        TETile[][] newWorld = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                newWorld[x][y] = Tileset.NOTHING;
            }
        }

        addHexagon(3, newWorld, 2, 3);

        ter.renderFrame(newWorld);
    }

    @Test
    public void testRowLength() {
        assertEquals(3, rowLength(3, 0));
        assertEquals(5, rowLength(3, 1));
        assertEquals(7, rowLength(3, 2));
        assertEquals(5, rowLength(3, 3));
        assertEquals(3, rowLength(3, 4));
        assertEquals(4, rowLength(4, 6));
        assertEquals(6, rowLength(4, 5));
    }

    @Test
    public void testRowOffset() {
        assertEquals(2, rowOffSet(3, 0));
        assertEquals(1, rowOffSet(3, 1));
        assertEquals(0, rowOffSet(3, 2));
        assertEquals(1, rowOffSet(3, 3));
        assertEquals(2, rowOffSet(3, 4));
        assertEquals(3, rowOffSet(4, 6));
        assertEquals(2, rowOffSet(4, 5));

    }

}
