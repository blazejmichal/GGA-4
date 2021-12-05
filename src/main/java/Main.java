import model.Algorithm;
import model.example.Example1;
import model.example.Example2;

public class Main {

  public static void main(
      String[] args
  ) {
    Algorithm example1 = new Algorithm(
        new Example1().build()
    );
    Algorithm example2 = new Algorithm(
        new Example2().build()
    );
//    TreeBuilderBinary tree10 = new TreeBuilderBinary(10);
//    TreeBuilderBinary tree1000 = new TreeBuilderBinary(1000);
//    TreeBuilderBinary tree100000 = new TreeBuilderBinary(100000);
//    TreeBuilderBinary tree10000000 = new TreeBuilderBinary(10000000);
//    AlgorithmBinary task10 = new AlgorithmBinary(
//        tree10.getSize(),
//        tree10.getRoot()
//    );
//    AlgorithmBinary task1000 = new AlgorithmBinary(
//        tree1000.getSize(),
//        tree1000.getRoot()
//    );
//    AlgorithmBinary task100000 = new AlgorithmBinary(
//        tree100000.getSize(),
//        tree100000.getRoot()
//    );
//    AlgorithmBinary task10000000 = new AlgorithmBinary(
//        tree10000000.getSize(),
//        tree10000000.getRoot()
//    );
  }

}
