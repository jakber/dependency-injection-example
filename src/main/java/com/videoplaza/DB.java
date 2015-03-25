package com.videoplaza;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public class DB {
   List<String> titles = new ArrayList<>();
   Map<String, Double> scores = new HashMap<>();


   public DB() throws IOException {
      final BufferedReader reader = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream("/Users/jakob/Downloads/ratings.list.gz")
      )));
      skipToStartOfData(reader);
      readData(reader);
   }

   private void readData(BufferedReader reader) throws IOException {
      String line;
      while ((line = reader.readLine()) != null) {
         if (line.trim().isEmpty() || line.startsWith("------------------------------------------------------------------------------")) break;
         double score = Double.valueOf(line.substring(25, 32).trim());
         String title = line.substring(32).trim();
         titles.add(title);
         scores.put(title, score);
      }
   }

   private void skipToStartOfData(BufferedReader reader) throws IOException {
      String line;
      while ((line = reader.readLine()) != null) {
         if (line.startsWith("MOVIE RATINGS REPORT")) break;
      }
      reader.readLine();
      reader.readLine();
   }

   public List<String> listTitles() {
      return titles;
   }

   public double getScore(String movie) {
      return scores.get(movie);
   }

}
