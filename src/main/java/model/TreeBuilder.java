package model;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
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
  private NodeTwo root;

  public TreeBuilder(int size) {
    this.size = size;
    this.build();
  }

  public void build() {
    while (this.numbers.size() != this.size) {
      Random random = new Random();
      this.numbers.add(
          random.nextInt()
      );
    }
    this.root = new NodeTwo(
        this.pickFromNumbers()
    );
    while (!this.numbers.isEmpty()) {
      this.fillNode(this.root);
    }
  }

  public void fillNode(NodeTwo node) {

    if (this.numbers.isEmpty()) {
      return;
    }
    Random random = new Random();
    if (random.nextBoolean()) {
      if (node.getLeft() == null) {
        NodeTwo leftNode = new NodeTwo(
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
        NodeTwo rightNode = new NodeTwo(
            this.pickFromNumbers()
        );
        node.setRight(rightNode);
      }
      this.fillNode(
          node.getRight()
      );
    }
  }

  public int pickFromNumbers() {
    try {
      int number = this.numbers.stream().findFirst().get();
      this.numbers.remove(Iterables.get(this.numbers, 0));
      return number;
    } catch (Exception e) {
      System.out.println("test");
      return 0;
    }
  }

}
