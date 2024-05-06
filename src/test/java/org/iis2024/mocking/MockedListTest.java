package org.iis2024.mocking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MockedListTest {

  @Test
  void simpleMockingExamples() {
    // STEP 1: create mock object
    List<String> mockedList = mock(List.class);

    // STEP 2: using the mock object
    mockedList.add("green");
    mockedList.add("blue");
    mockedList.add("green");
    mockedList.clear();

    // STEP 3: verify the calls to the mocked object
    verify(mockedList).add("blue");
    verify(mockedList, times(2)).add("green");
    verify(mockedList).clear();

    verify(mockedList, times(3)).add(anyString());
    verify(mockedList, never()).add("red");
    verify(mockedList, never()).size();
    verify(mockedList, atLeastOnce()).add("blue");
    verify(mockedList, atLeast(1)).add(anyString());
  }

  @Test
  void simpleStubbingExamples() {
    // STEP 1: create mock object
    List<String> mockedList = mock(List.class);

    // STEP 2: stubbing
    mockedList.add("green");
    mockedList.add("blue");
    when(mockedList.size()).thenReturn(2);

    // STEP 3: verify the calls to the mocked object
    verify(mockedList, times(2)).add(anyString());

    assertEquals(2, mockedList.size());
  }
}
