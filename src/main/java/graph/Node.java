package graph;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 点
 * @author LXF
 * @date 2022/2/25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Node {

    /**
     * 值
     */
    private Integer value;
    /**
     * 入点
     */
    private Node from;
    /**
     * 出点
     */
    private Node to;
}
