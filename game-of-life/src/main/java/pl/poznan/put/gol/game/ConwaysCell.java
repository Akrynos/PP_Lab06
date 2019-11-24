package pl.poznan.put.gol.game;

import java.util.Objects;

public class ConwaysCell implements Cell {

    protected int i;
    protected int j;

    public ConwaysCell(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public Cells neighbors() {
        Cells cells = new Cells();
        for (int a = this.i - 1; a <= this.i + 1; a++) {
            for (int b = this.j - 1; b <= this.j + 1; b++) {
                if (!(a == this.i && b == this.j)) {
                    //System.out.println("added: " + a + " " + b);
                    cells.add(new ConwaysCell(a, b));
                }
            }
        }
        return cells;
    }

    @Override
    public String toString() {
        return "c(" + i + ":" + j + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConwaysCell that = (ConwaysCell) o;
        return i == that.i &&
                j == that.j;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }
}
