package model;

import com.google.common.collect.Sets;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result {

  private int size = 0;
  private Set<Node> maximalIndependentSet = Sets.newLinkedHashSet();

  public void concat(
      Result result
  ) {
    this.size = this.size + result.getSize();
    this.maximalIndependentSet.addAll(
        result.getMaximalIndependentSet()
    );
  }

}
