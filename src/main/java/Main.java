import model.Algorithm;
import model.TreeBuilder;

public class Main {

  public static void main(
      String[] args
  ) {
    TreeBuilder tree10 = new TreeBuilder(10);
    TreeBuilder tree1000 = new TreeBuilder(1000);
    TreeBuilder tree100000 = new TreeBuilder(100000);
    TreeBuilder tree10000000 = new TreeBuilder(10000000);
    Algorithm task10 = new Algorithm(
        tree10.getSize(),
        tree10.getRoot()
    );
    Algorithm task1000 = new Algorithm(
        tree1000.getSize(),
        tree1000.getRoot()
    );
    Algorithm task100000 = new Algorithm(
        tree100000.getSize(),
        tree100000.getRoot()
    );
    Algorithm task10000000 = new Algorithm(
        tree10000000.getSize(),
        tree10000000.getRoot()
    );
  }

}
