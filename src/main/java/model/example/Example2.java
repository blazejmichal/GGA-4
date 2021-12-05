package model.example;

import model.Node;
import model.binary.NodeBinary;

public class Example2 {

  public NodeBinary buildBinary() {
    NodeBinary node1 = new NodeBinary(1);
    NodeBinary node2 = new NodeBinary(2);
    NodeBinary node3 = new NodeBinary(3);
    NodeBinary node4 = new NodeBinary(4);
    NodeBinary node5 = new NodeBinary(5);
    NodeBinary node6 = new NodeBinary(6);
    NodeBinary node7 = new NodeBinary(7);
    NodeBinary node8 = new NodeBinary(8);
    NodeBinary node9 = new NodeBinary(9);
    NodeBinary node10 = new NodeBinary(10);
    NodeBinary node11 = new NodeBinary(11);
    NodeBinary node12 = new NodeBinary(12);
    NodeBinary node13 = new NodeBinary(13);
    node1.setLeft(node2);
    node1.setRight(node3);
    node2.setLeft(node4);
    node4.setLeft(node8);
    node8.setLeft(node13);
    return node1;
  }

  public Node build() {
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);
    Node node5 = new Node(5);
    Node node6 = new Node(6);
    Node node7 = new Node(7);
    Node node8 = new Node(8);
    Node node9 = new Node(9);
    Node node10 = new Node(10);
    Node node11 = new Node(11);
    Node node12 = new Node(12);
    Node node13 = new Node(13);
    node1.addChild(node2);
    node1.addChild(node3);
    node2.addChild(node4);
    node4.addChild(node8);
    node8.addChild(node13);
    node3.addChild(node5);
    node3.addChild(node6);
    node3.addChild(node7);
    node7.addChild(node9);
    node7.addChild(node10);
    node7.addChild(node11);
    node7.addChild(node12);
    return node1;
  }

}
