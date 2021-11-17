package model;

import java.util.Map;

public class SizeTask {

  public int calculateMaximumIndependentSetSize(
      Node root,
      Map<Node, Integer> tree
  ) {
    if (root == null) {
      return 0;
    }
    if (tree.get(root) != null) {
      return tree.get(root);
    }
    int excl = this.calculateMaximumIndependentSetSize(root.getLeft(), tree)
        + this.calculateMaximumIndependentSetSize(root.getRight(), tree);
    int incl = 1;
    if (root.getRight() != null) {
      incl += this.calculateMaximumIndependentSetSize(root.getLeft().getLeft(), tree)
          + this.calculateMaximumIndependentSetSize(root.getLeft().getRight(), tree);
    }
    if (root.getRight() != null) {
      incl += this.calculateMaximumIndependentSetSize(root.getRight().getLeft(), tree)
          + this.calculateMaximumIndependentSetSize(root.getRight().getRight(), tree);
    }
    tree.put(root, Integer.max(excl, incl));
    return tree.get(root);
  }

}
