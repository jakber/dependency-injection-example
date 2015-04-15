package com.videoplaza;

import static org.junit.Assert.assertEquals;

import com.google.inject.util.Providers;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Collections;

public class MovieListServiceTest {

   @Test
   public void testEmptyResult() throws IOException {
      final MovieResource movieResource = Mockito.mock(MovieResource.class);
      Mockito.when(movieResource.findByPrefix("dlsfkjfsgkjdslkgjdsfglkdfsjg")).thenReturn(Collections.EMPTY_LIST);
      final ScoreResource scoreResource = Mockito.mock(ScoreResource.class);
      Mockito.when(scoreResource.getScores(Collections.EMPTY_LIST)).thenReturn(Collections.EMPTY_LIST);
      final MovieListService movieListService = new MovieListService(movieResource, scoreResource);
      assertEquals(0, movieListService.listMovies("dlsfkjfsgkjdslkgjdsfglkdfsjg").size());
   }

   @Test
   public void testThreeResultsSortedByScore() {
   }

   @Test
   public void testElevenResultsCappedToTen() {

   }

}