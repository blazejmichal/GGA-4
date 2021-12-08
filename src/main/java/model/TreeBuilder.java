package model;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TreeBuilder {

  private int size;
  private Set<Integer> numbers = Sets.newLinkedHashSet();
  private Node root;
  private List<Node> iterationToFill = Lists.newLinkedList();
  private Integer divider;

  public TreeBuilder(
      int size
  ) {
    this.size = size;
    this.divider = this.initializeDivider();
    this.build();
  }

  /**
   * Budowanie drzewa na podstawie danych wejsciowych przypisanych do pól.
   */
  public void build(
  ) {
    while (this.numbers.size() != this.size) {
      Random random = new Random();
      this.numbers.add(
          random.nextInt(this.size * 100)
      );
    }
    this.root = new Node(
        this.pickFromNumbers()
    );
    Node left = new Node(
        this.pickFromNumbers()
    );
    Node right = new Node(
        this.pickFromNumbers()
    );
    this.root.addChild(left);
    this.root.addChild(right);
    this.iterationToFill.add(left);
    this.iterationToFill.add(right);
    while (!this.numbers.isEmpty()) {
      this.fillIteration();
    }
  }

  /**
   * Wypełnianiamy węzły z danej wysokości (łącznie z każdej wysokości). Główna funkcja to
   * urozmaicenie drzewa.
   */
  private void fillIteration(
  ) {
    List<Node> newIterationToFill = Lists.newLinkedList();
    for (Node node : this.iterationToFill) {
      this.fillNode(node);
      newIterationToFill.addAll(
          node.getChildren()
      );
    }
    if (!newIterationToFill.isEmpty()) {
      this.iterationToFill = newIterationToFill;
    }
  }

  /**
   * Wypelnianie węzła dziećmi na zasadzie losowosci.
   */
  public void fillNode(
      Node node
  ) {
    if (this.numbers.isEmpty()) {
      return;
    }
    Random random = new Random();
    Boolean stop = random.nextBoolean();
    if (stop) {
      return;
    }
    Integer childrenAmount = this.numbers.size() > this.divider
        ? (random.nextInt(this.numbers.size() + 1) / this.divider)
        : 2;
    for (int i = 0; i < childrenAmount; i++) {
      if (this.numbers.isEmpty()) {
        return;
      }
      Node child = new Node(
          this.pickFromNumbers()
      );
      node.addChild(child);
    }
  }

  // Wartosc do dzielenia przy ustalaniu ilosci dzieci węzła. Główna funkcja to "urozmaicenie" drzewa/ilości gałęzi
  public int initializeDivider(
  ) {
    if (this.size == 1000) {
      return 100;
    } else if (this.size == 100000) {
      return 1000;
    } else if (this.size == 10000000) {
      return 10000;
    } else {
      return 10;
    }
  }

  /**
   * Pobieranie wartosci dla node'a z drzewa.
   */
  public int pickFromNumbers(
  ) {
    Optional<Integer> number = this.numbers
        .stream()
        .findFirst();
    if (!number.isPresent()) {
      System.out.println();
    }
    this.numbers.remove(
        Iterables.get(
            this.numbers,
            0
        )
    );
    return number.get();
  }

}
