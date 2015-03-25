package com.videoplaza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MovieApp {

   public static void main(String[] args) throws IOException {
      final Healthcheck healthcheck = new Healthcheck();
      final MovieListService movieListService = new MovieListService();

      final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      String line;
      while ((line = bufferedReader.readLine()) != null) {
         if (!healthcheck.isHealthy()) {
            System.err.println("Service is unhealthy: ");
            healthcheck.showErrors(System.err);
         } else {
            for (Movie movie : movieListService.listMovies(line)) {
               System.out.println("\t" + movie.getScore() + "\t" + movie.getTitle());
            }
         }
      }
   }
}
