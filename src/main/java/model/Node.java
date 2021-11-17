package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Node {

  private int value;
  private Node left;
  private Node right;

  public Node(int value) {
    this.value = value;
  }

}
