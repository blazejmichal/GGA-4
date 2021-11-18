import com.google.common.collect.Maps;
import java.util.Map;
import model.Node;
import model.Algorithm;
import model.TreeBuilder;

public class Main {

  public static void main(String[] args) {
    TreeBuilder treeBuilder = new TreeBuilder(100000);
    Algorithm task1000000 = new Algorithm();
    Map<Node, Integer> tree10000000 = Maps.newLinkedHashMap();
    System.out.println("The size of a maximum independent set is " + task1000000.run(
        treeBuilder.getRoot(),
        tree10000000
    ));
    System.out.println("end");
  }

}
