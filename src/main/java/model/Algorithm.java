package model;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;

public class Algorithm {

  public int run(
      Node root,
      Map<Node, Integer> tree
  ) {
    // Obsługa gdy dany korzeń od którego liczymy jest nullem
    if (root == null) {
      return 0;
    }
    // Jeśli dany korzeń był już przeliczany to ta wartość zostanie przywołana
    if (tree.get(root) != null) {
      return tree.get(root);
    }
    List<Node> maximalIndependentSetWithoutCurrentRoot = Lists.newLinkedList();
    maximalIndependentSetWithoutCurrentRoot.add(
        root.getLeft()
    );
    maximalIndependentSetWithoutCurrentRoot.add(
        root.getRight()
    );
    int maximalIndependentSetWithoutCurrentRootSize =
        this.run(root.getLeft(), tree) + this.run(root.getRight(), tree);
    int maximalIndependentSetWithCurrentRootSize = 1;
    List<Node> maximalIndependentSetWithCurrentRoot = Lists.newLinkedList();
    if (root.getLeft() != null) {
      maximalIndependentSetWithCurrentRootSize += this.run(root.getLeft().getLeft(), tree)
          + this.run(root.getLeft().getRight(), tree);
      maximalIndependentSetWithCurrentRoot.add(root.getLeft().getLeft());
      maximalIndependentSetWithCurrentRoot.add(root.getLeft().getRight());
    }
    if (root.getRight() != null) {
      maximalIndependentSetWithCurrentRootSize += this.run(root.getRight().getLeft(), tree)
          + this.run(root.getRight().getRight(), tree);
      maximalIndependentSetWithCurrentRoot.add(root.getRight().getLeft());
      maximalIndependentSetWithCurrentRoot.add(root.getRight().getRight());
    }
    if (maximalIndependentSetWithCurrentRootSize > maximalIndependentSetWithoutCurrentRootSize) {
      root.addToIndependentSet(
          maximalIndependentSetWithCurrentRoot
      );
      root.getIndependentSet().add(root);
    } else {
      root.addToIndependentSet(
          maximalIndependentSetWithoutCurrentRoot
      );
    }
    tree.put(root, Integer.max(maximalIndependentSetWithoutCurrentRootSize,
        maximalIndependentSetWithCurrentRootSize));
    return tree.get(root);
  }

}
