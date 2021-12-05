package model;

import com.google.common.collect.Sets;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Algorithm {

  private Node root;
  private Set<Node> maximalIndependentSet = Sets.newHashSet();
  private int maximalIndependentSetSize = 0;
  private Long timeInMilliseconds = 0L;

  public Algorithm(
      Node root
  ) {
    this.root = root;
    long start = System.currentTimeMillis();
    this.maximalIndependentSetSize = this.run(this.root);
    this.timeInMilliseconds = System.currentTimeMillis() - start;
    this.maximalIndependentSet = this.root.getIndependentSet();
  }

  public int run(
      Node node
  ) {
    if (node.getIndependentSet().size() != 0) {
      return node.getIndependentSet().size();
    }
    if (node.getChildren().size() == 0) {
      node.getIndependentSet().add(node);
      return node.getIndependentSet().size();
    }
    int childSum = 0;
    int grandchildSum = 0;
    for (Node child : node.getChildren()) {
      childSum += this.run(child);
      for (Node grandChild : child.getChildren()) {
        grandchildSum += this.run(grandChild);
      }
    }
    int result = Math.max(grandchildSum + 1, childSum);
    if (grandchildSum + 1 > childSum) {
      node.addIndependentSetNode(node);
    }
    node.addIndependentSetNodes(
        node.getChildrenIndependentSet()
    );
    node.setIndependentSetSize(result);
    return result;
  }

}
