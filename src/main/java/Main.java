import com.google.common.collect.Maps;
import java.util.Map;
import model.Node;
import model.SetTask;
import model.SizeTask;

public class Main {

  public static void main(String[] args) {
    Node root = new Node(1);
    root.setLeft(new Node(2));
    root.setRight(new Node(3));
    root.getLeft().setLeft(new Node(4));
    root.getRight().setLeft(new Node(5));
    root.getRight().setRight(new Node(6));
    root.getRight().getLeft().setLeft(new Node(7));
    root.getRight().getLeft().setRight(new Node(8));
    Map<Node, Integer> map = Maps.newLinkedHashMap();
    SizeTask sizeTask = new SizeTask();
    System.out.println("The size of a maximum independent set is " +
        sizeTask.calculateMaximumIndependentSetSize(root, map));

    new SetTask().run();
  }

}
