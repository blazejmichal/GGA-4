package model.binary;

import com.google.common.collect.Sets;
import java.util.Objects;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NodeBinary {

  private int value;
  private NodeBinary left;
  private NodeBinary right;
  private Set<NodeBinary> independentSet = Sets.newLinkedHashSet();

  public NodeBinary(int value) {
    this.value = value;
  }

  public void setLeft(NodeBinary left) {
    this.left = left;
  }

  public void setRight(
      NodeBinary right
  ) {
    this.right = right;
  }

  public void addToIndependentSet(
      NodeBinary node
  ) {
    if (
        node != null
    ) {
      if (
          this.independentSet == null
      ) {
        this.independentSet = Sets.newLinkedHashSet();
      }
      this.independentSet.addAll(
          node.getIndependentSet()
      );
    }
  }

  public void addToIndependentSet(
      Set<NodeBinary> nodes
  ) {
    for (NodeBinary node : nodes) {
      this.addToIndependentSet(
          node
      );
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
    NodeBinary nodeTwo = (NodeBinary) o;
    return value == nodeTwo.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return "NodeBinary{" + "value=" + value + '}';
  }

}
