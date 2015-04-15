package com.videoplaza;

import com.google.inject.Inject;

import javax.inject.Provider;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScoreResource {

   private final DB db;
   private final Provider<MovieListService> movieListService;

   @Inject
   public ScoreResource(final DB db, Provider<MovieListService> movieListService) throws IOException {

      this.db = db;
      this.movieListService = movieListService;
   }

   public List<Double> getScores(List<String> movies) {
      final ArrayList<Double> scores = new ArrayList<Double>();
      for (String movie : movies) {
         scores.add(db.getScore(movie));
      }

      return scores;
   }
}
