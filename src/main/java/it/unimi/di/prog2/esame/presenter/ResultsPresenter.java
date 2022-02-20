package it.unimi.di.prog2.esame.presenter;

import java.util.List;

import it.unimi.di.prog2.esame.model.EuroModel;
import it.unimi.di.prog2.esame.model.Observer;
import it.unimi.di.prog2.esame.model.Squadra;
import it.unimi.di.prog2.esame.model.Subject;
import it.unimi.di.prog2.esame.view.GeneralDisplayView;

public class ResultsPresenter implements Observer<List<Squadra>>{

    private final GeneralDisplayView view;
    private final EuroModel model;

    public ResultsPresenter(GeneralDisplayView view, EuroModel model) {
        this.view = view;
        this.model = model;
        model.addObserver(this);
    }

    @Override
    public void update(Subject<List<Squadra>> subject, List<Squadra> state) {
        // TODO Auto-generated method stub
        for (int i = 0; i < 2; i++) {
            Squadra S1 = model.getSquadra(i+""+0);
            Squadra S2 = model.getSquadra(i+""+1);
            view.set(i,S1.getName()+" "+S1.getNumGoal()+" : "+S2.getNumGoal()+" "+S2.getName());
            //view.set(1,state.get(0).getName());
        }
        
        

    }
    
}

