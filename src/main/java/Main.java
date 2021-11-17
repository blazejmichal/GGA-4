import com.google.common.collect.Maps;
import java.util.Map;
import model.NodeTwo;
import model.SizeTask;
import model.TreeBuilder;

public class Main {

  public static void main(String[] args) {
//    Node root = new Node(1);
//    root.setLeft(new Node(2));
//    root.setRight(new Node(3));
//    root.getLeft().setLeft(new Node(4));
//    root.getRight().setLeft(new Node(5));
//    root.getRight().setRight(new Node(6));
//    root.getRight().getLeft().setLeft(new Node(7));
//    root.getRight().getLeft().setRight(new Node(8));
//    Map<Node, Integer> map = Maps.newLinkedHashMap();
//    SizeTask sizeTask = new SizeTask();
//    System.out.println("The size of a maximum independent set is " +
//        sizeTask.calculateMaximumIndependentSetSize(root, map));
//    Map<Node, Result> tree = Maps.newLinkedHashMap();
//    Result result = new SizeTask().runSizeAndSet(root, tree);
//    System.out.println(result);

//    NodeTwo root2 = new NodeTwo(1);
//    root2.setLeft(new NodeTwo(2));
//    root2.setRight(new NodeTwo(3));
//    root2.getLeft().setLeft(new NodeTwo(4));
//    root2.getRight().setLeft(new NodeTwo(5));
//    root2.getRight().setRight(new NodeTwo(6));
//    root2.getRight().getLeft().setLeft(new NodeTwo(7));
//    root2.getRight().getLeft().setRight(new NodeTwo(8));
//    Map<NodeTwo, Integer> tree2 = Maps.newLinkedHashMap();
//    SizeTask sizeTask2 = new SizeTask();
//    System.out.println("The size of a maximum independent set is " +
//        sizeTask2.test(root2, tree2));
    TreeBuilder treeBuilder = new TreeBuilder(1000);
    SizeTask task1000000 = new SizeTask();
    Map<NodeTwo, Integer> tree10000000 = Maps.newLinkedHashMap();
    System.out.println("The size of a maximum independent set is " + task1000000.test(
        treeBuilder.getRoot(),
        tree10000000
    ));
    System.out.println("end");
  }

}
