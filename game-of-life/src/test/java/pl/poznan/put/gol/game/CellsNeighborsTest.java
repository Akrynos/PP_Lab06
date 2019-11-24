package pl.poznan.put.gol.game;

import org.junit.Test;

import static org.junit.Assert.*;

public class CellsNeighborsTest {

    @Test
    public void testNoNeighbors() {
        Cells cells = new Cells();
        assertTrue(cells.getNeighbors().isEmpty());
    }

    @Test
    public void testSingleNeighbors() {
        Cells cells = new Cells();
        cells.add(new ConwaysCell(0, 0));
        assertEquals(8, cells.getNeighbors().size());

        Cells expected = new Cells();
        expected.addAll(new ConwaysCell(0, 0).neighbors());
        assertEquals(expected, cells.getNeighbors());

        cells.add(new ConwaysCell(3, 3));
        assertEquals(16, cells.getNeighbors().size());
        expected.addAll(new ConwaysCell(3, 3).neighbors());
        assertEquals(expected, cells.getNeighbors());
    }

    @Test
    public void testOverlappingNeighbors() {
        Cells cells = new Cells();
        cells.add(new ConwaysCell(0, 0));
        cells.add(new ConwaysCell(0, 2));
        assertEquals(13, cells.getNeighbors().size());

        Cells expected = new Cells();
        expected.addAll(new ConwaysCell(0, 0).neighbors());
        expected.addAll(new ConwaysCell(0, 2).neighbors());
        assertEquals(expected, cells.getNeighbors());
    }

    @Test
    public void testNeighbors() {
        ConwaysCell cell = new ConwaysCell(7, 6);
        Cells cells = new Cells();
        for (int a = 6; a <= 8; a++) {
            for (int b = 5; b <= 7; b++) {
                if (!(a == 7 && b == 6)) {
                    cells.add(new ConwaysCell(a, b));
                }
            }
        }
    assertEquals(cells, cell.neighbors());
    }

    @Test
    public void testGetNeighbors() {
        Cells testing = new Cells (new ConwaysCell(7, 6), new ConwaysCell(0, 0));
        Cells cells = new Cells();
        for (int a = 6; a <= 8; a++) {
            for (int b = 5; b <= 7; b++) {
                if (!(a == 7 && b == 6)) {
                    cells.add(new ConwaysCell(a, b));
                }
            }
        }
        for (int a = -1; a <= 1; a++) {
            for (int b = -1; b <= 1; b++) {
                if (!(a == 0 && b == 0)) {
                    cells.add(new ConwaysCell(a, b));
                }
            }
        }
        assertEquals(cells, testing.getNeighbors());
    }
}
