package com.videoplaza;

import com.google.inject.Inject;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class Healthcheck {
   private final MovieResource movieResource;
   private final ScoreResource scoreResource;

   @Inject
   public Healthcheck(MovieResource movieResource, ScoreResource scoreResource) {
      this.movieResource = movieResource;
      this.scoreResource = scoreResource;
   }

   public boolean isHealthy() {
      try {
         return checkScores() && checkTitles();
      } catch (Exception e) {
         return false;
      }
   }

   private boolean checkTitles() {
      final List<String> titles = movieResource.findByPrefix("\"1000");
      return titles.size() == 67;
   }

   private boolean checkScores() {
      final List<Double> scores = scoreResource.getScores(Arrays.asList("\"Power Rangers Zeo\" (1996) {Instrument of Destruction (#1.12)}"));
      return scores.size() == 1 && scores.get(0).equals(9.6);
   }

   public void showErrors(PrintStream err) {
      try {
         if (!checkScores()) {
            err.println("\tscores DB unavailable");
         }
         if (!checkTitles()) {
            err.println("\ttitles DB unavailable");
         }
      } catch (Exception e) {
         e.printStackTrace(err);
      }
   }
}
