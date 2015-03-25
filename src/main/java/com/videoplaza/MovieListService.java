package com.videoplaza;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovieListService {
   private MovieResource movieResource = new MovieResource();
   private ScoreResource scoreResource = new ScoreResource();

   public MovieListService() throws IOException {
   }

   public List<Movie> listMovies(String prefix) {
      final List<String> movies = movieResource.findByPrefix(prefix);
      final List<Double> scores = scoreResource.getScores(movies);
      final ArrayList<Movie> result = new ArrayList<>(movies.size());
      for (int i = 0; i < movies.size(); i++)
         result.add(new Movie(movies.get(i), scores.get(i)));

      Collections.sort(result);
      Collections.reverse(result);

      return result.subList(0, Math.min(result.size(), 10));
   }


}
