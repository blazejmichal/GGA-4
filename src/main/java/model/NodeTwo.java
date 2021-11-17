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
public class NodeTwo {

  private int value;
  private NodeTwo left;
  private NodeTwo right;
//  private NodeTwo parent;
  private Set<NodeTwo> independentSet = Sets.newLinkedHashSet();

  public NodeTwo(int value) {
    this.value = value;
  }

  public void setLeft(NodeTwo left) {
    this.left = left;
//    left.setParent(this);
  }

  public void setRight(NodeTwo right) {
    this.right = right;
//    right.setParent(this);
  }

  public void addToIndependentSet(NodeTwo node) {
    if (node != null) {
      if (this.independentSet == null) {
        this.independentSet = Sets.newLinkedHashSet();
      }
      this.independentSet.addAll(
          node.getIndependentSet()
      );
    }
  }

  public void addToIndependentSet(List<NodeTwo> nodes) {
    for (NodeTwo node : nodes) {
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
    NodeTwo nodeTwo = (NodeTwo) o;
    return value == nodeTwo.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return "NodeTwo{" + "value=" + value + '}';
  }

}
