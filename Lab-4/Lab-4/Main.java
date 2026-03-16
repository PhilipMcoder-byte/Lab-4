import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    System.out.println("Unsorted Array ---------------------------------------------------");
    ArrayList<Integer> integerList = Lab4.getList();
    Lab4.outputList(integerList);

    System.out.println("\n\nBubble sort results ----------------------------------------------");
    ArrayList<Integer> forBubble = new ArrayList<>(integerList);
    long startBubble = System.nanoTime();
    ArrayList<Integer> bubbleSortedList = Lab4.bubbleSort(forBubble);
    long endBubble = System.nanoTime();

    Lab4.outputList(bubbleSortedList);
    System.out.println("\n\nBubble Sort took: " + (endBubble - startBubble) / 1000000.0 + " ms");

    System.out.println("\n\nInsertion sort results -------------------------------------------");
    ArrayList<Integer> forInsertion = new ArrayList<>(integerList);
    long startInsertion = System.nanoTime();
    ArrayList<Integer> insertionSortedList = Lab4.insertionSort(forInsertion);
    long endInsertion = System.nanoTime();

    Lab4.outputList(insertionSortedList);
    System.out.println("\n\nInsertion Sort took: " + (endInsertion - startInsertion) / 1000000.0 + " ms");
  }
}

class Lab4 {
  public static ArrayList<Integer> insertionSort(ArrayList<Integer> integerList) {
    // Step 1 - Implementation for insertion sort
    for (int i = 1; i < integerList.size(); i++) {
      int key = integerList.get(i);
      int j = i - 1;
      while (j >= 0 && integerList.get(j) > key) {
        integerList.set(j + 1, integerList.get(j));
        j = j - 1;
      }
      integerList.set(j + 1, key);
    }
    return integerList;
  }

  public static ArrayList<Integer> bubbleSort(ArrayList<Integer> integerList) {
    // Step 2 - Implementation for bubble sort
    int n = integerList.size();
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (integerList.get(j) > integerList.get(j + 1)) {

          int temp = integerList.get(j);
          integerList.set(j, integerList.get(j + 1));
          integerList.set(j + 1, temp);
        }
      }
    }
    return integerList;
  }

  public static ArrayList<Integer> getList() {
    ArrayList<Integer> integerList = new ArrayList<>();
    String line;
    try (BufferedReader br = new BufferedReader(new FileReader("integers.txt"))) {
      while ((line = br.readLine()) != null) {
        integerList.add(Integer.parseInt(line.trim()));
      }
    } catch (IOException e) {
      System.out.println("File not found! Make sure 'integers.txt' is in the root folder.");
    }
    return integerList;
  }

  public static void outputList(ArrayList<Integer> integerList) {
    for (Integer val : integerList) {
      System.out.print(val + " ");
    }
  }
}