package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SetTask {

  private ArrayList<Integer> vertices = new ArrayList<>();
  private HashMap<pair, Integer> edges = new HashMap<>();
  private HashSet<ArrayList<Integer>> independentSets = new HashSet<>();

  public void run() {
    int numOfVertices = 4, numOfEdges = 0;
    for (int i = 1; i <= numOfVertices; i++) {
      this.vertices.add(i);
    }
    HashSet<Integer> SolnSet = new HashSet<>();
    this.findAllIndependentSets(1, numOfVertices, SolnSet);
    ArrayList<Integer> Max = new ArrayList<>();
    for (ArrayList<Integer> i : independentSets) {
      System.out.println(i);
      if (i.size() > Max.size()) {
        Max = i;
      }
    }
    System.out.println("Maximal Independent Set = "
        + Max);
  }

  public void findAllIndependentSets(
      int currentVertice,
      int setSize,
      HashSet<Integer> SolnSet
  ) {
    for (int i = currentVertice; i <= setSize; i++) {
      if (checkSafety(vertices.get(i - 1), SolnSet)) {
        SolnSet.add(vertices.get(i - 1));
        findAllIndependentSets(
            i + 1,
            setSize,
            SolnSet
        );
        SolnSet.remove(vertices.get(i - 1));
      }
    }
    independentSets.add(new ArrayList<Integer>(SolnSet));
  }

  public boolean checkSafety(
      int vertex,
      HashSet<Integer> SolnSet
  ) {
    for (int i : SolnSet) {
      if (this.edges.containsKey(new pair(i, vertex)))
      {
        return false;
      }
    }
    return true;
  }

  static class pair {

    int first, second;

    pair(int first, int second) {
      this.first = first;
      this.second = second;
    }

    @Override
    public String toString() {
      return "(" + first + "," + second + ")";
    }
  }
}