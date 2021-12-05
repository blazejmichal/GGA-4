package model.example;

import model.Node;
import model.binary.NodeBinary;

public class Example1 {

  public NodeBinary buildBinary() {
    NodeBinary node1Example = new NodeBinary(1);
    NodeBinary node2Example = new NodeBinary(2);
    NodeBinary node3Example = new NodeBinary(3);
    NodeBinary node4Example = new NodeBinary(4);
    NodeBinary node5Example = new NodeBinary(5);
    NodeBinary node6Example = new NodeBinary(6);
    NodeBinary node7Example = new NodeBinary(7);
    node1Example.setLeft(node2Example);
    node1Example.setRight(node3Example);
    node2Example.setLeft(node4Example);
    node2Example.setRight(node5Example);
    node3Example.setLeft(node6Example);
    node3Example.setRight(node7Example);
    return node1Example;
  }

  public Node build() {
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);
    Node node5 = new Node(5);
    Node node6 = new Node(6);
    Node node7 = new Node(7);
    node1.getChildren().add(node2);
    node1.getChildren().add(node3);
    node2.getChildren().add(node4);
    node2.getChildren().add(node5);
    node3.getChildren().add(node6);
    node3.getChildren().add(node7);
    return node1;
  }

}
