package model;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Node {

  private int value;
  private List<Node> children = Lists.newArrayList();
  private Set<Node> independentSet = Sets.newLinkedHashSet();
  private Integer independentSetSize = 0;

  public Node(
      int value
  ) {
    this.value = value;
  }

  public Boolean addChild(
      Node child
  ) {
    if (this.children == null) {
      this.children = Lists.newLinkedList();
    }
    this.getChildren().add(child);
    return Boolean.TRUE;
  }

}
