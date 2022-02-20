package it.unimi.di.prog2.esame.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EuroModel implements Subject<List<Squadra>> {

    private final List<Observer<List<Squadra>>> observers = new ArrayList<>();

    private final Map<String, Squadra> map = new HashMap<>(){{
        put("00",new Squadra("Italia",0,0,0));
        put("01",new Squadra("Turchia",0,0,0));
        put("10",new Squadra("Svizzera",0,1,0));
        put("11",new Squadra("Galles",0,1,0));
    }};

    @Override
    public void notifyObservers() {
        // TO-DO Auto-generated method stub
        for (Observer<List<Squadra>> observer : observers) {
            observer.update(this,new ArrayList<>(map.values()));
        }
    }

    @Override
    public void addObserver(Observer<List<Squadra>> obs) {
        // TO-DO Auto-generated method stub
        observers.add(obs);
    }

    @Override
    public List<Squadra> getState() {
        // TO-DO Auto-generated method stub
        return new ArrayList<>(map.values());
    }

    public Squadra getValue(String s) {
        return map.get(s);
    }

    public void goal(String string) {
        map.put(string, new Squadra(map.get(string).getName(), map.get(string).getNumGoal()+1,map.get(string).getPartita(),map.get(string).getWin()));
        
        Squadra S1 = map.get(string);
        int goalS1 = S1.getNumGoal();

        int avv = 0;

        if(string.charAt(1)=='0'){
            avv = 1;
        }
        
        Squadra S2 = map.get(string.charAt(0)+""+avv);
        int goalS2 = S2.getNumGoal();

        System.out.println(goalS1+"--"+goalS2);
        
        //int result = goalS1 > goalS2 ? goalS1 - goalS2 : goalS2 > goalS1;
        
        if (goalS1 > goalS2) {
            //setto a 3 giocatore 1
            map.put(string, new Squadra(map.get(string).getName(), map.get(string).getNumGoal(),map.get(string).getPartita(),3));
            map.put(string.charAt(0)+""+avv, new Squadra(map.get(string.charAt(0)+""+avv).getName(), map.get(string.charAt(0)+""+avv).getNumGoal(),map.get(string.charAt(0)+""+avv).getPartita(),0));
        
            //setto a 0 giocatore 2

        }else if(goalS1 == goalS2){
            //setto a 1 giocatore 1
            map.put(string, new Squadra(map.get(string).getName(), map.get(string).getNumGoal(),map.get(string).getPartita(),1));
            map.put(string.charAt(0)+""+avv, new Squadra(map.get(string.charAt(0)+""+avv).getName(), map.get(string.charAt(0)+""+avv).getNumGoal(),map.get(string.charAt(0)+""+avv).getPartita(),1));
        
            //setto a 1 giocatore 2
        }else{
            //setto a 0 giocatore 1
            map.put(string, new Squadra(map.get(string).getName(), map.get(string).getNumGoal(),map.get(string).getPartita(),0));
            map.put(string.charAt(0)+""+avv, new Squadra(map.get(string.charAt(0)+""+avv).getName(), map.get(string.charAt(0)+""+avv).getNumGoal(),map.get(string.charAt(0)+""+avv).getPartita(),3));
        
            //setto a 3 giocatore 2
        }
        
        notifyObservers();

    }

    public Squadra getSquadra(String string) {
        return new Squadra(map.get(string).getName(),map.get(string).getNumGoal(),map.get(string).getPartita(),map.get(string).getWin());
    }
}