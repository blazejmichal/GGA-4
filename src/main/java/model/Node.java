package model;

import com.google.common.collect.Lists;
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
  private List<Node> children = Lists.newArrayList();
  private Set<Node> independentSet = Sets.newLinkedHashSet();
  private Integer independentSetSize = 0;

  public Node(
      int value
  ) {
    this.value = value;
  }

  public Boolean addChild(
      Node child
  ) {
    if (this.children == null) {
      this.children = Lists.newLinkedList();
    }
    this.getChildren().add(child);
    return Boolean.TRUE;
  }

  public Boolean addChildren(
      List<Node> children
  ) {
    if (this.children == null) {
      this.children = Lists.newLinkedList();
    }
    this.getChildren().addAll(children);
    return Boolean.TRUE;
  }

  public List<Node> getGrandChildren(
  ) {
    List<Node> grandChildren = Lists.newLinkedList();
    for (Node child : this.getChildren()) {
      grandChildren.addAll(
          child.getChildren()
      );
    }
    return grandChildren;
  }

  public boolean addIndependentSetNode(
      Node node
  ) {
    if (this.independentSet == null) {
      this.independentSet = Sets.newLinkedHashSet();
    }
    this.independentSet.add(node);
    return Boolean.TRUE;
  }

  public boolean addIndependentSetNodes(
      Set<Node> nodes
  ) {
    if (this.independentSet == null) {
      this.independentSet = Sets.newLinkedHashSet();
    }
    this.independentSet.addAll(nodes);
    return Boolean.TRUE;
  }

  public boolean addIndependentSetNodes(
      List<Node> nodes
  ) {
    if (this.independentSet == null) {
      this.independentSet = Sets.newLinkedHashSet();
    }
    this.independentSet.addAll(nodes);
    return Boolean.TRUE;
  }

  public Set<Node> getChildrenIndependentSet(
  ) {
    Set<Node> independentSet = Sets.newLinkedHashSet();
    for (Node child : this.getChildren()) {
      independentSet.addAll(
          child.getIndependentSet()
      );
    }
    return independentSet;
  }

  @Override
  public boolean equals(
      Object o
  ) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Node node = (Node) o;
    return value == node.value;
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
