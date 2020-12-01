package assignment4;

import java.util.*;
import java.util.concurrent.*;

// Only tasks are created, The thread manager maps the task to threads on a greedy approach
//Iterator design pattern


public class TreeForkJoinPool extends RecursiveAction {
    private volatile static int NodesFound = 0;
    private static int threshold = 20;
    private final TreeNode root;
    private final Integer height;
    private final HashMap<Integer, Integer> nodesToCheck;

    public TreeForkJoinPool(TreeNode root, int height, HashMap<Integer, Integer> nodesToCheck) {
        this.root = root;
        this.height = height;
        this.nodesToCheck = nodesToCheck;
    }

    public synchronized static void incrementCount() {
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

    private void AllNodesFound() {
//        System.out.println("wkg");
        if (this.NodesFound == nodesToCheck.size()) {
            Main.shutdownPool();
        }
    }

    private void sequentialTraversal() {
        if (this.root == null) {
            return;
        }
        this.isNodeToCheck();
        if (root.getChildren() != null && !root.getChildren().isEmpty()) {
            //Iterator design Pattern
            Iterator<TreeNode> itr = root.getChildren().iterator();
            while(itr.hasNext()) {
                TreeNode childNode = itr.next();
                new TreeForkJoinPool(childNode, height + 1, nodesToCheck);
            }
//            for (int i = 0; i < numberOfChildren; i++) {
//                TreeNode childNode = root.getChildren().get(i);
//                new TreeForkJoinPool(childNode, height + 1, nodesToCheck);
//            }
        }
    }

    @Override
    protected void compute() {
        if (this.root == null) {
            return;
        }
        if (this.height > threshold) {
            sequentialTraversal();
        }
        AllNodesFound();
        this.isNodeToCheck();
        if (root.getChildren() != null && !root.getChildren().isEmpty()) {
                int numberOfChildren = root.getChildren().size();
                List<TreeForkJoinPool> subtasks = new ArrayList<TreeForkJoinPool>(numberOfChildren);
                TreeForkJoinPool subtask = null;
                for (int i = 0; i < numberOfChildren; i++) {
                    TreeNode childNode = root.getChildren().get(i);
                    subtask = new TreeForkJoinPool(childNode, height + 1, nodesToCheck);
                    if (i != numberOfChildren - 1) {
                        subtasks.add(subtask);
                        subtask.fork();
                    }
            }
            //last task for the current thread
            subtask.compute();
            for (ForkJoinTask otherTasks : subtasks) {
                otherTasks.helpQuiesce();
            }

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