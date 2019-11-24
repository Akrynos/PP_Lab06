package pl.poznan.put.gol.game;

public class Generation {

    private Rules rules;
    private Cells aliveCells;

    public Generation(Rules rules, Cell... aliveCells) {
        this(rules, new Cells(aliveCells));
    }

    public Generation(Rules rules, Cells aliveCells) {
        this.rules = rules;
        this.aliveCells = aliveCells;
    }

    public void evolve() {
        Cells allCells = aliveCells.getNeighbors();
        Cells nextGen = new Cells();
        for (Cell cell : allCells){
            if(rules.inNextGeneration(isAlive(cell), countAliveNeighbors(cell))){
                nextGen.add(cell);
            } else continue;
        }
        this.aliveCells = nextGen;
    }

    public boolean isAlive(Cell cell) {
        if(aliveCells.contains(cell))return true;
        else return false;
    }

    public int countAliveNeighbors(Cell cell) {
        int neighborsCounter = 0;
        Cells neighbourhood = cell.neighbors();
        for (Cell temp : neighbourhood){
            if(aliveCells.contains(temp)){
                neighborsCounter++;
            }
        }
        return neighborsCounter;
    }

    public boolean extinct() {
        return aliveCells.isEmpty();
    }

    public Cells getAliveCells() {
        return aliveCells;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Generation)) {
            return false;
        }
        Generation other = (Generation) obj;
        return aliveCells.equals(other.aliveCells);
    }
}
