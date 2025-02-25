package org.woehlke.computer.kurzweil.simulated.evolution.model.census;

import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.model.cell.LifeCycleStatus;

import java.io.Serializable;

/**
 * Holds Data how many Cells per LifeCycleStatus and how many Cells in the whole Population for this Generation.
 * <p>
 * &copy; 2006 - 2008 Thomas Woehlke.
 *
 * @author Thomas Woehlke
 * @see <a href="https://thomas-woehlke.blogspot.com/2016/01/mandelbrot-set-drawn-by-turing-machine.html">Blog Article</a>
 * @see <a href="https://github.com/Computer-Kurzweil/simulated-evolution">Github Repository</a>
 * @see <a href="https://java.woehlke.org/simulated-evolution/">Maven Project Repository</a>
 */
@Log4j2
@ToString
@Getter
@Setter
@EqualsAndHashCode
public class SimulatedEvolutionPopulationCensus implements Serializable {

    static final long serialVersionUID = 242L;

    private int youngCells;
    private int youngAndFatCells;
    private int adultCells;
    private int hungryCells;
    private int oldCells;
    private int deadCells;
    private int population;

    private long worldIteration;
    private long generationYoungest;
    private long generationOldest;

    public void countStatusOfOneCell(LifeCycleStatus status, long generation) {
        population++;
        status.countStatus(this);
        upgradeGenerationBoundaries(generation);
    }

    private void upgradeGenerationBoundaries(long generation) {
        if (generation < generationOldest) {
            generationOldest = generation;
        }
        if(generation > generationYoungest) {
            generationYoungest = generation;
        }
    }

    public SimulatedEvolutionPopulationCensus(long worldIteration) {
        this.worldIteration = worldIteration;
        this.generationOldest = worldIteration;
        this.generationYoungest = 0L;
    }

    public void incrementYoungCells(){
        youngCells++;
    }
    public void incrementYoungAndFatCells(){
        youngAndFatCells++;
    }

    public void incrementFullAgeCells(){
        adultCells++;
    }
    public void incrementHungryCells(){
        hungryCells++;
    }
    public void incrementOldCells(){
        oldCells++;
    }
    public void incrementDeadCells(){
        deadCells++;
    }

    public void incrementPopulation(){
        population++;
    }
}
