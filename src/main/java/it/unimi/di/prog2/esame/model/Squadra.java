package it.unimi.di.prog2.esame.model;

public class Squadra {
    private final String name;
    private final int numGoal;
    private final int partita;
    private final int win;

    public Squadra(String name, int numGoal, int partita,int win) {
        this.name = name;
        this.numGoal = numGoal;
        this.partita = partita;
        this.win = win;
    }

    public int getPartita() {
        return partita;
    }

    public String getName() {
        return name;
    }

    public int getNumGoal() {
        return numGoal;
    }


    public int getWin() {
        return win;
    }

    @Override
    public String toString() {
        return "Squadra [name=" + name + ", numGoal=" + numGoal + "]";
    }
    
}
