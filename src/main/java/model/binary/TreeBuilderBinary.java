package model.binary;

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
public class TreeBuilderBinary {

  private int size;
  private Set<Integer> numbers = Sets.newLinkedHashSet();
  private NodeBinary root;

  public TreeBuilderBinary(int size) {
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
          random.nextInt()
      );
    }
    this.root = new NodeBinary(
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
      NodeBinary node
  ) {
    if (this.numbers.isEmpty()) {
      return;
    }
    Random random = new Random();
    if (random.nextBoolean()) {
      if (node.getLeft() == null) {
        NodeBinary leftNode = new NodeBinary(
            this.pickFromNumbers()
        );
        node.setLeft(leftNode);
      }
      this.fillNode(
          node.getLeft()
      );
    }
    if (this.numbers.isEmpty()) {
      return;
    }
    if (random.nextBoolean()) {
      if (node.getRight() == null) {
        NodeBinary rightNode = new NodeBinary(
            this.pickFromNumbers()
        );
        node.setRight(rightNode);
      }
      this.fillNode(
          node.getRight()
      );
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
            0)
    );
    return number.get();
  }

}
