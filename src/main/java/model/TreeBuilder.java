package model;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
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

  public TreeBuilder(
      int size
  ) {
    this.size = size;
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
    while (!this.numbers.isEmpty()) {
      this.fillNode(this.root);
    }
  }

  /**
   * Rekurencyjne wypelnianie poddrzew na zasadzie losowosci.
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
    Integer childrenAmount = random.nextInt(
        this.numbers.size() + 1
    );
    for (int i = 0; i < childrenAmount; i++) {
      if (this.numbers.isEmpty()) {
        return;
      }
      Node child = new Node(
          this.pickFromNumbers()
      );
      node.addChild(child);
    }
    for (Node child : node.getChildren()) {
      this.fillNode(child);
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
