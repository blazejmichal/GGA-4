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
//      grandchildSum += child.getChildren().stream()
//                            .reduce(0, (subtotal, grandChild) -> subtotal.getIndependentSet().size()
//                                + this.run(grandChild));
//                            .reduce(grandChild -> this.run(grandChild), 0);

    }
//    node.getChildren().forEach(child -> {
//      childSum += this.run(child);
//      grandchildSum += child.getChildren().stream().reduce((p, c) -> p + this.run(c), 0);
//    })

    int result = Math.max(grandchildSum + 1, childSum);
//    if(grandchildSum +1 > )
    node.setIndependentSetSize(result);
    return result;
  }

}
