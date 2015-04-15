package com.videoplaza;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import javax.inject.Singleton;
import java.io.IOException;

public class MovieModule extends AbstractModule {

   @Override
   protected void configure() {
      bind(DB.class).in(Singleton.class);
      bind(ScoreResource.class);
      bind(MovieListService.class);

   }

   @Provides
   @Singleton
   private MovieResource provideMovieResource(DB db) {
      try {
         return new MovieResource(db);
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }
}
