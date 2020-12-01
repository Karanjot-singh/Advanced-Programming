package assignment4;

import java.util.*;

public class TreeExplicitMultithreading implements java.lang.Runnable {
    private volatile static int NodesFound = 0;
    private final TreeNode root;
    private final Integer height, numberOfThreads;
    private final HashMap<Integer, Integer> nodesToCheck;

    public TreeExplicitMultithreading(TreeNode root, int height, HashMap<Integer, Integer> nodesToCheck, int numberOfThreads) {
        this.root = root;
        this.height = height;
        this.nodesToCheck = nodesToCheck;
        this.numberOfThreads = numberOfThreads;
    }

    public synchronized static void incrementCount() {
        NodesFound++;
    }

    public void isNodeToCheck() {
        //compare with all nodes to check
        for (Map.Entry<Integer, Integer> entry : this.nodesToCheck.entrySet()) {
            if (entry.getKey().equals(root.getData())) {
                entry.setValue(this.height);
                incrementCount();
                return;
            }
        }
    }

    private void AllNodesFound() {
        if (this.NodesFound == nodesToCheck.size()) {
            Main.shutdownPool();
        }
    }

    @Override
    public void run() {

        if (this.root == null) {
            return;
        }

        if (this.height == 0) {
            int numberOfChildren = root.getChildren().size();
            List<Thread> threads = new ArrayList<Thread>(numberOfChildren);
            Iterator<TreeNode> itr = root.getChildren().iterator();
            if (this.numberOfThreads == 1) {
                new SequentialTree(this.root, 0, nodesToCheck);
            }
            if (this.numberOfThreads >= numberOfChildren) {
                while (itr.hasNext()) {
                    TreeNode childNode = itr.next();
                    TreeExplicitMultithreading subthread = new TreeExplicitMultithreading(childNode, height + 1, nodesToCheck, this.numberOfThreads);
                    Thread t = new Thread(subthread);
                    threads.add(t);
                    t.start();
                }
            } else {
                int remaining = numberOfChildren % numberOfThreads;
                int times = numberOfChildren / this.numberOfThreads;
                for (int j = 1; j <= times; j++) {
                    for (int i = 0; i < numberOfThreads; i++) {
                        TreeNode childNode = root.getChildren().get(i * j);
                        TreeExplicitMultithreading child = new TreeExplicitMultithreading(childNode, j, nodesToCheck, this.numberOfThreads);
                        Thread thread = new Thread(child);
                        thread.start();
                        threads.add(thread);
                    }
                }
                for (int j = 0; j < remaining; j++) {
                    TreeNode childNode = root.getChildren().get(times * numberOfThreads + j);
                    new TreeExplicitMultithreading(childNode, j, nodesToCheck, this.numberOfThreads);
                }
            }

        }
        this.isNodeToCheck();
        AllNodesFound();
        if (root.getChildren() != null && !root.getChildren().isEmpty()) {
            Iterator<TreeNode> itr = root.getChildren().iterator();
            while (itr.hasNext()) {
                TreeNode childNode = itr.next();
                new TreeExplicitMultithreading(childNode, height + 1, nodesToCheck, this.numberOfThreads);
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
