package model;

import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.Set;

public class Algorithm {

  public void run(
      Node root
  ) {
    // Jeśli dany korzeń był już przeliczany to ta wartość zostanie przywołana
    if (root.getIndependentSet().size() != 0) {
      return;
    }
    Set<Node> setWithoutCurrentRoot = this.findSetWithoutRoot(root);
    Set<Node> setWithCurrentRoot = this.findSetWithRoot(root);
    this.attachIndependentSetToRoot(
        root,
        setWithoutCurrentRoot,
        setWithCurrentRoot
    );
  }

  public Set<Node> findSetWithRoot(
      Node root
  ) {
    Set<Node> setWithCurrentRoot = Sets.newLinkedHashSet();
    setWithCurrentRoot.add(root);
    if (root.getLeft() != null) {
      if (root.getLeft().getLeft() != null) {
        this.run(root.getLeft().getLeft());
        setWithCurrentRoot.addAll(root.getLeft().getLeft().getIndependentSet());
      }
      if (root.getLeft().getRight() != null) {
        this.run(root.getLeft().getRight());
        setWithCurrentRoot.addAll(root.getLeft().getRight().getIndependentSet());
      }
    }
    if (root.getRight() != null) {
      if (root.getRight().getLeft() != null) {
        this.run(root.getRight().getLeft());
        setWithCurrentRoot.addAll(root.getRight().getLeft().getIndependentSet());
      }
      if (root.getRight().getRight() != null) {
        this.run(root.getRight().getRight());
        setWithCurrentRoot.addAll(root.getRight().getRight().getIndependentSet());
      }
    }
    return setWithCurrentRoot;
  }

  public Set<Node> findSetWithoutRoot(
      Node root
  ) {
    Set<Node> setWithoutCurrentRoot = Sets.newLinkedHashSet();
    if (root.getLeft() != null) {
      this.run(root.getLeft());
      setWithoutCurrentRoot.addAll(
          root.getLeft().getIndependentSet()
      );
    }
    if (root.getRight() != null) {
      this.run(root.getRight());
      setWithoutCurrentRoot.addAll(
          root.getRight().getIndependentSet()
      );
    }
    setWithoutCurrentRoot.removeAll(Collections.singleton(null));
    return setWithoutCurrentRoot;
  }

  public void attachIndependentSetToRoot(
      Node root,
      Set<Node> setWithoutCurrentRoot,
      Set<Node> setWithCurrentRoot
  ) {
    if (setWithoutCurrentRoot.size() < setWithCurrentRoot.size()) {
      root.addToIndependentSet(
          setWithCurrentRoot
      );
      root.getIndependentSet().add(root);
    } else {
      root.addToIndependentSet(
          setWithoutCurrentRoot
      );
    }
  }

}
