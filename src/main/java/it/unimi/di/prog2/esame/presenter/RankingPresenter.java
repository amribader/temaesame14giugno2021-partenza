package it.unimi.di.prog2.esame.presenter;

import java.util.Comparator;
import java.util.List;

import it.unimi.di.prog2.esame.model.EuroModel;
import it.unimi.di.prog2.esame.model.Observer;
import it.unimi.di.prog2.esame.model.Squadra;
import it.unimi.di.prog2.esame.model.Subject;
import it.unimi.di.prog2.esame.view.GeneralDisplayView;

public class RankingPresenter implements Observer<List<Squadra>> {

    private final GeneralDisplayView view;
    private final EuroModel model;

    public RankingPresenter(GeneralDisplayView view, EuroModel model) {
        this.view = view;
        this.model = model;
        model.addObserver(this);
    }

    @Override
    public void update(Subject<List<Squadra>> subject, List<Squadra> state) {
        // TODO Auto-generated method stub
        state.sort(Comparator.comparing(Squadra::getWin).reversed());

        //model.diffGol()

        int i = 0;
        for (Squadra squadra : state) {
            //System.out.println(squadra);
            view.set(i++,squadra.getWin()+"  "+squadra.getName());
        }
        //view.set(0,state.get(0).getName());

    }
    
}
