package com.videoplaza;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovieResource {

   private List<String> movies;

   public MovieResource(DB db) throws IOException {
      movies = db.listTitles();
   }

   public List<String> findByPrefix(String prefix) {
      int i = Math.abs(Collections.binarySearch(movies, prefix));
      final ArrayList<String> result = new ArrayList<>();
      while (movies.get(i).startsWith(prefix)) {
         result.add(movies.get(i));
         i++;
      }
      return result;
   }
}
