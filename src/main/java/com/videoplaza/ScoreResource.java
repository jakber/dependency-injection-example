package com.videoplaza;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScoreResource {

   private final DB db;

   public ScoreResource() throws IOException {
      db = new DB();
   }

   public List<Double> getScores(List<String> movies) {
      final ArrayList<Double> scores = new ArrayList<Double>();
      for (String movie : movies) {
         scores.add(db.getScore(movie));
      }

      return scores;
   }
}
