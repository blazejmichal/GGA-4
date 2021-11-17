package model;

import com.google.common.collect.Lists;
import java.util.List;
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
    if (root.getLeft() != null) {
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

  public int test(
      NodeTwo root,
      Map<NodeTwo, Integer> tree
  ) {
    if (root == null) {
      return 0;
    }
    if (tree.get(root) != null) {
//      root.getIndependentSet().add(root);
      return tree.get(root);
    }
    List<NodeTwo> exclNodes = Lists.newLinkedList();
    exclNodes.add(root.getLeft());
    exclNodes.add(root.getRight());
    int excl = this.test(root.getLeft(), tree)
        + this.test(root.getRight(), tree);
    int incl = 1;
    List<NodeTwo> inclNodes = Lists.newLinkedList();
    if (root.getLeft() != null) {
      incl += this.test(root.getLeft().getLeft(), tree)
          + this.test(root.getLeft().getRight(), tree);
      inclNodes.add(root.getLeft().getLeft());
      inclNodes.add(root.getLeft().getRight());
    }
    if (root.getRight() != null) {
      incl += this.test(root.getRight().getLeft(), tree)
          + this.test(root.getRight().getRight(), tree);
      inclNodes.add(root.getRight().getLeft());
      inclNodes.add(root.getRight().getRight());
    }
    if (incl > excl) {
      root.addToIndependentSet(
          inclNodes
      );
//      if (incl == 1) {
        root.getIndependentSet().add(root);
//      }
    } else {
      root.addToIndependentSet(
          exclNodes
      );
    }
    tree.put(root, Integer.max(excl, incl));
    return tree.get(root);
  }

  public Result runSizeAndSet(
      Node root,
      Map<Node, Result> tree
  ) {
    if (root == null) {
      return new Result();
    }
    if (tree.get(root) != null) {
      return tree.get(root);
    }
    Result leftNodeResult = this.runSizeAndSet(
        root.getLeft(),
        tree
    );
    Result rightNodeResult = this.runSizeAndSet(
        root.getLeft(),
        tree
    );
    int excl = leftNodeResult.getSize() + rightNodeResult.getSize();
    int incl = 1;
    List<Result> inclResults = Lists.newLinkedList();
    if (root.getRight() != null) {
      Result leftLeftNodeResult = this.runSizeAndSet(
          root.getLeft().getLeft(),
          tree
      );
      Result leftRightNodeResult = this.runSizeAndSet(
          root.getLeft().getRight(),
          tree
      );
      inclResults.add(leftLeftNodeResult);
      inclResults.add(leftRightNodeResult);
      incl += leftLeftNodeResult.getSize() + leftRightNodeResult.getSize();
    }
    if (root.getRight() != null) {
      Result rightLeftNodeResult = this.runSizeAndSet(
          root.getRight().getLeft(),
          tree
      );
      Result rightRightNodeResult = this.runSizeAndSet(
          root.getRight().getRight(),
          tree
      );
      inclResults.add(rightLeftNodeResult);
      inclResults.add(rightRightNodeResult);
      incl += rightLeftNodeResult.getSize() + rightRightNodeResult.getSize();
    }
    Result result = new Result();
    if (excl > incl) {
      result.concat(leftNodeResult);
      result.concat(rightNodeResult);
      tree.put(
          root,
          result
      );
    } else {
      for (Result subResult : inclResults) {
        result.concat(subResult);
      }
    }
    tree.put(root, result);
    return tree.get(root);
  }

}
