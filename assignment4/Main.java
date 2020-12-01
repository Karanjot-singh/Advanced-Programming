package assignment4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ForkJoinPool;

/*
Flyweight and strategy pattern
calculate and
print the speedup over the sequential execution along with the parallel efficiency.
 */

public class Main {
    private static ForkJoinPool pool;

    public static void shutdownPool() {
        pool.shutdownNow();

    }

    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of nodes in the tree: ");
        Tree tree = new Tree(s.nextInt());
        long startTime = System.nanoTime();
        tree.generateTree();
        long endTime = System.nanoTime();
        //divide by 1000000 to get milliseconds.
        System.out.println("Time taken: " + (endTime - startTime)/1000000.000 +" ms");
        System.out.println("Height: " + tree.getHeight());
        System.out.print("Input number of nodes to check: ");
        int numOfNodes = s.nextInt();
        HashMap<Integer, Integer> nodesToCheck = new HashMap<>(numOfNodes);
        HashMap<Integer, Integer> nodesToCheckExplicit = new HashMap<>(numOfNodes);
        for (int i = 0; i < numOfNodes; i++) {
            //hashmap of node number and height
            int index = s.nextInt();
            nodesToCheck.put(index, -1);
            nodesToCheckExplicit.put(index, -1);
        }
        //Sequential Tree search
        long seqStartTime = System.nanoTime();
        SequentialTree seq = new SequentialTree(tree.getRoot(), 0, nodesToCheckExplicit);
        seq.printResult();
        long seqEndTime = System.nanoTime();
        System.out.println("Time taken: " + (seqEndTime - seqStartTime)/1000000.000 +" ms");

        System.out.println("Input the technique to check the program:\n1) Explicit Multithreading\n2) ForkJoinPool");
        int technique = s.nextInt();
        System.out.print("Enter number of threads to be used: ");
        int numThreads = s.nextInt();
        switch (technique) {
            case 1:
//				explicit multithreading
                System.out.println("Explicit");
                TreeExplicitMultithreading root = new TreeExplicitMultithreading(tree.getRoot(), 0, nodesToCheckExplicit);
                List<Thread> threadList = new ArrayList<>();

                if (numOfNodes > numThreads) {
                    for (int i =0 ; i< numThreads; i++){
                        TreeExplicitMultithreading child = new TreeExplicitMultithreading(tree.getRoot(), 1, nodesToCheckExplicit);
                        Thread thread = new Thread(child);
                        thread.start();
                        threadList.add(thread);
                    }
                    int numberOfChildren = tree.getRoot().getChildren().size();
                    for (int i = 0; i < numberOfChildren; i++) {
                        for(int j =0; j<numOfNodes/numThreads+1;j++)
                        {

                        }
                        int remaining = numOfNodes%numberOfChildren;
                        for(int j=0; j<remaining; j++){

                        }
//                        for (int i = 0; i < numberOfChildren; i++) {
//                            TreeNode childNode = root.getChildren().get(i);
//                            subtask = new TreeForkJoinPool(childNode, height + 1, nodesToCheck);
//                            if (i != numberOfChildren - 1) {
//                                subtasks.add(subtask);
//                                subtask.fork();
//                            }
//                        }
                    }

                } else {
                    for (int i =0 ; i< numThreads; i++){
                        TreeExplicitMultithreading child = new TreeExplicitMultithreading(tree.getRoot(), 1, nodesToCheckExplicit);
                        Thread thread = new Thread(child);
                        thread.start();
                        threadList.add(thread);
                    }
                }
                root.printResult();
                break;
            case 2:
                System.out.println("ForkJoinPool");
                startTime = System.nanoTime();
                pool = new ForkJoinPool(numThreads);
                //root task created
                TreeForkJoinPool task = new TreeForkJoinPool(tree.getRoot(), 0, nodesToCheck);
                //speculative parallelism thread shutdown
                try {
                    pool.invoke(task);
                } catch (CancellationException e) {
                    //All threads have found the values abort
                }
                task.printResult();
                endTime = System.nanoTime();
                System.out.println("Time taken by ForkJoinPool: " + (endTime - startTime)/1000000.000 +" ms");
                break;
            default:
                System.out.println("Wrong input");
        }
    }
}
