package assignment4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

// Only tasks are created, The thread manager maps the task to threads on a greedy approach
/*
synchronise()
Design pattern & efficiency
*/
public class SequentialTree {
    private static int NodesFound = 0;
    private final TreeNode root;
    private final Integer height;
    private final HashMap<Integer, Integer> nodesToCheck;

    public SequentialTree(TreeNode root, int height, HashMap<Integer, Integer> nodesToCheck) {
        this.root = root;
        this.height = height;
        this.nodesToCheck = nodesToCheck;
        this.compute();
    }

    public static void incrementCount() {
        NodesFound++;
    }

    public void isNodeToCheck() {
        for (Map.Entry<Integer, Integer> entry : this.nodesToCheck.entrySet()) {
            if (entry.getKey().equals(root.getData())) {
                entry.setValue(this.height);
                incrementCount();
                return;
            }
        }
    }

    private void sequentialTraversal() {

    }

    protected void compute() {
        if (this.root == null) {
            System.out.println("df");
            return;
        }
        this.isNodeToCheck();
        int numberOfChildren = root.getChildren().size();
        for (int i = 0; i < numberOfChildren; i++) {
            TreeNode childNode = root.getChildren().get(i);
            System.out.println("w");
            new TreeForkJoinPool(childNode, height + 1, nodesToCheck);
        }
    }

    public void printResult() {
        for (Map.Entry<Integer, Integer> entry : this.nodesToCheck.entrySet()) {
            if (entry.getValue().equals(-1)) {
                System.out.println("No occurrences of " + entry.getKey() + ".");
            } else {
                System.out.println("Found " + entry.getKey() + " at depth " + entry.getValue() + ".");
            }
        }
    }
}