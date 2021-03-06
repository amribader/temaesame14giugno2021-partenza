package it.unimi.di.prog2.esame;

import it.unimi.di.prog2.esame.model.EuroModel;
import it.unimi.di.prog2.esame.presenter.MatchPresenter;
import it.unimi.di.prog2.esame.presenter.RankingPresenter;
import it.unimi.di.prog2.esame.presenter.ResultsPresenter;
import it.unimi.di.prog2.esame.view.MatchView;
import it.unimi.di.prog2.esame.view.GeneralDisplayView;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    //TO-DO da completare

    primaryStage.setTitle("Euro 2020");

    EuroModel model = new EuroModel();

    MatchView[] games = new MatchView[2];

    GeneralDisplayView display = new GeneralDisplayView(2);
    GeneralDisplayView classifica = new GeneralDisplayView(4);

    GridPane gridPane = new GridPane();
    gridPane.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
    gridPane.setPadding(new Insets(10, 10, 10, 10));
    for (int i = 0; i < 2; i++) {
      games[i] = new MatchView();
      gridPane.add(games[i], i, 0);
    }
    gridPane.add(display, 0, 1);
    GridPane.setColumnSpan(display, GridPane.REMAINING);
    gridPane.add(classifica, 0, 2);
    GridPane.setColumnSpan(classifica, GridPane.REMAINING);


    new MatchPresenter(games[0], 0, model);
    new MatchPresenter(games[1], 1, model);

    new RankingPresenter(classifica,model);
    new ResultsPresenter(display,model);
    Scene scene = new Scene(gridPane);

    primaryStage.setScene(scene);
    primaryStage.show();

    //HINT: una volta definito il modello sarà utile lanciare una notifica in modo che le
    //      viste si aggiornino a stato iniziale
    model.notifyObservers();

  }
}
