package com.videoplaza;

public class Movie implements Comparable<Movie> {
   private final String title;
   private final double score;

   public Movie(String title, double score) {
      this.title = title;
      this.score = score;
   }

   public double getScore() {
      return score;
   }

   public String getTitle() {
      return title;
   }

   @Override
   public int compareTo(Movie o) {
      return Double.compare(score, o.score);
   }
}
