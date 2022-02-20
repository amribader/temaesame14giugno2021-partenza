package it.unimi.di.prog2.esame.presenter;


import it.unimi.di.prog2.esame.model.EuroModel;
import it.unimi.di.prog2.esame.model.Observer;
import it.unimi.di.prog2.esame.model.Squadra;
import it.unimi.di.prog2.esame.model.Subject;
import it.unimi.di.prog2.esame.view.MatchView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MatchPresenter implements Observer<List<Squadra>> {

  private final MatchView view;
  private final int gameNumber;
  private final EuroModel model;

  public MatchPresenter(@NotNull final MatchView view, int gameNumber, EuroModel model) {
    this.view = view;
    this.gameNumber = gameNumber;
    this.model = model;
    view.addHandlers(this);
    model.addObserver(this);
    //TODO completare
  }


  public final void goal(int i) {
    System.out.println(String.format("Partita %d: la squadra %d ha fatto un goal", gameNumber, i));
    model.goal(gameNumber+""+i);
    
    //TODO completare
  }

  @Override
  public void update(Subject<List<Squadra>> subject, List<Squadra> state) {
    //int i = 0;
    //for (Squadra squadra : state) {
    //view.set(i++,squadra.getName());
    //}
    view.set(0,model.getValue(gameNumber+""+0).getName()+"  "+model.getValue(gameNumber+""+0).getNumGoal());
    view.set(1,model.getValue(gameNumber+""+1).getName()+"  "+model.getValue(gameNumber+""+1).getNumGoal());
  }
}
