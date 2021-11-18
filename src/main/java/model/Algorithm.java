package model;

import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.Set;
import lombok.Data;

@Data
public class Algorithm {

  private Integer nodesAmount;
  private Node root;
  private Set<Node> maximalIndependentSet = Sets.newHashSet();
  private Long timeInMilliseconds = 0L;

  public Algorithm(
      Integer nodesAmount,
      Node root
  ) {
    this.nodesAmount = nodesAmount;
    this.root = root;
    this.run();
  }

  public void run(
  ) {
    long start = System.currentTimeMillis();
    this.processCurrentRoot(
        this.root
    );
    this.timeInMilliseconds = System.currentTimeMillis() - start;
    this.maximalIndependentSet = this.root.getIndependentSet();
  }

  /**
   * Szukany jest niezależny ciąg dla aktualnego korzenia z iteracji (z argumentu metody
   * rekurencyjnej)
   */
  public void processCurrentRoot(
      Node currentRoot
  ) {
    // Jeśli dany korzeń był już przeliczany to ta wartość zostanie przywołana
    if (
        currentRoot.getIndependentSet().size() != 0
    ) {
      return;
    }
    // Wyznaczany jest niezależny ciąŋ bez aktualnego korzenia dla iteracji
    Set<Node> setWithoutCurrentRoot = this.findSetWithoutRoot(
        currentRoot
    );
    // Wyznaczany jest niezależny ciąŋ z aktualnym korzeniem dla iteracji
    Set<Node> setWithCurrentRoot = this.findSetWithRoot(
        currentRoot
    );
    // Większy ciąg jest przypisywany do aktualnego korzenia z iteracji
    this.attachIndependentSetToRoot(
        currentRoot,
        setWithoutCurrentRoot,
        setWithCurrentRoot
    );
  }

  /**
   * Wyznaczany jest niezależny ciąŋ z aktualnym korzeniem dla iteracji
   */
  public Set<Node> findSetWithRoot(
      Node root
  ) {
    Set<Node> setWithCurrentRoot = Sets.newLinkedHashSet();
    setWithCurrentRoot.add(root);
    if (root.getLeft() != null) {
      if (root.getLeft().getLeft() != null) {
        this.processCurrentRoot(root.getLeft().getLeft());
        setWithCurrentRoot.addAll(root.getLeft().getLeft().getIndependentSet());
      }
      if (root.getLeft().getRight() != null) {
        this.processCurrentRoot(root.getLeft().getRight());
        setWithCurrentRoot.addAll(root.getLeft().getRight().getIndependentSet());
      }
    }
    if (root.getRight() != null) {
      if (root.getRight().getLeft() != null) {
        this.processCurrentRoot(root.getRight().getLeft());
        setWithCurrentRoot.addAll(root.getRight().getLeft().getIndependentSet());
      }
      if (root.getRight().getRight() != null) {
        this.processCurrentRoot(root.getRight().getRight());
        setWithCurrentRoot.addAll(root.getRight().getRight().getIndependentSet());
      }
    }
    return setWithCurrentRoot;
  }

  /**
   * Wyznaczany jest niezależny ciąŋ bez aktualnego korzenia dla iteracji
   */
  public Set<Node> findSetWithoutRoot(
      Node root
  ) {
    Set<Node> setWithoutCurrentRoot = Sets.newLinkedHashSet();
    if (
        root.getLeft() != null
    ) {
      this.processCurrentRoot(
          root.getLeft()
      );
      setWithoutCurrentRoot.addAll(
          root.getLeft().getIndependentSet()
      );
    }
    if (
        root.getRight() != null
    ) {
      this.processCurrentRoot(
          root.getRight()
      );
      setWithoutCurrentRoot.addAll(
          root.getRight().getIndependentSet()
      );
    }
    setWithoutCurrentRoot.removeAll(
        Collections.singleton(null)
    );
    return setWithoutCurrentRoot;
  }

  /**
   * Większy ciąg jest przypisywany do aktualnego korzenia z iteracji
   */
  public void attachIndependentSetToRoot(
      Node root,
      Set<Node> setWithoutCurrentRoot,
      Set<Node> setWithCurrentRoot
  ) {
    if (
        setWithoutCurrentRoot.size() < setWithCurrentRoot.size()
    ) {
      root.addToIndependentSet(
          setWithCurrentRoot
      );
      root.getIndependentSet().add(
          root
      );
    } else {
      root.addToIndependentSet(
          setWithoutCurrentRoot
      );
    }
  }

}
