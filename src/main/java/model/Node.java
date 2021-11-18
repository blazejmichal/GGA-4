package model;

import com.google.common.collect.Sets;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Node {

  private int value;
  private Node left;
  private Node right;
//  private Node parent;
  private Set<Node> independentSet = Sets.newLinkedHashSet();

  public Node(int value) {
    this.value = value;
  }

  public void setLeft(Node left) {
    this.left = left;
//    left.setParent(this);
  }

  public void setRight(Node right) {
    this.right = right;
//    right.setParent(this);
  }

  public void addToIndependentSet(Node node) {
    if (node != null) {
      if (this.independentSet == null) {
        this.independentSet = Sets.newLinkedHashSet();
      }
      this.independentSet.addAll(
          node.getIndependentSet()
      );
    }
  }

  public void addToIndependentSet(Set<Node> nodes) {
    for (Node node : nodes) {
      this.addToIndependentSet(node);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Node nodeTwo = (Node) o;
    return value == nodeTwo.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return "Node{" + "value=" + value + '}';
  }

}
