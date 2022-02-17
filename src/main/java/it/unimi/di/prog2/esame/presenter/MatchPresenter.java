package it.unimi.di.prog2.esame.presenter;


import it.unimi.di.prog2.esame.view.MatchView;
import org.jetbrains.annotations.NotNull;

public class MatchPresenter {

  private final MatchView view;
  private final int gameNumber;

  public MatchPresenter(@NotNull final MatchView view,
                       int gameNumber) {
    this.view = view;
    this.gameNumber = gameNumber;
    view.addHandlers(this);

    //TODO completare
  }


  public final void goal(int i) {
    System.err.println(String.format("Partita %d: la squadra %d ha fatto un goal", gameNumber, i));

    //TODO completare
  }
}
