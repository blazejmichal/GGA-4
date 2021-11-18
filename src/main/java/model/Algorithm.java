package model;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    int setWithoutCurrentRootSize = 0;
    Set<Node> setWithoutCurrentRoot = Sets.newLinkedHashSet();
    if (root.getLeft() != null) {
      setWithoutCurrentRootSize = setWithoutCurrentRootSize + this.run(root.getLeft(), tree);
      setWithoutCurrentRoot.addAll(
          root.getLeft().getIndependentSet()
      );
    }
    if (root.getRight() != null) {
      setWithoutCurrentRootSize = setWithoutCurrentRootSize + this.run(root.getRight(), tree);
      setWithoutCurrentRoot.addAll(
          root.getRight().getIndependentSet()
      );
    }
    int setWithCurrentRootSize = 1;
    Set<Node> setWithCurrentRoot = Sets.newLinkedHashSet();
    setWithCurrentRoot.add(root);
    if (root.getLeft() != null) {
      if (root.getLeft().getLeft() != null) {
        setWithCurrentRootSize += this.run(root.getLeft().getLeft(), tree);
        setWithCurrentRoot.addAll(root.getLeft().getLeft().getIndependentSet());
      }
      if (root.getLeft().getRight() != null) {
        setWithCurrentRootSize += this.run(root.getLeft().getRight(), tree);
        setWithCurrentRoot.addAll(root.getLeft().getRight().getIndependentSet());
      }
    }
    if (root.getRight() != null) {
      if (root.getRight().getLeft() != null) {
        setWithCurrentRootSize += this.run(root.getRight().getLeft(), tree);
        setWithCurrentRoot.addAll(root.getRight().getLeft().getIndependentSet());
      }
      if (root.getRight().getRight() != null) {
        setWithCurrentRootSize += this.run(root.getRight().getRight(), tree);
        setWithCurrentRoot.addAll(root.getRight().getRight().getIndependentSet());
      }
    }
    setWithoutCurrentRoot.removeAll(Collections.singleton(null));
    if (setWithCurrentRootSize != setWithCurrentRoot.size()
        || setWithoutCurrentRootSize
        != setWithoutCurrentRoot.size()
    ) {
      System.out.println();
    }
    if (setWithCurrentRootSize > setWithoutCurrentRootSize) {
      root.addToIndependentSet(
          setWithCurrentRoot
      );
      root.getIndependentSet().add(root);
    } else {
      root.addToIndependentSet(
          setWithoutCurrentRoot
      );
    }
    tree.put(root, Integer.max(setWithoutCurrentRootSize,
        setWithCurrentRootSize));
    return tree.get(root);
  }

}
