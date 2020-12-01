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
        System.out.println("Time taken: " + (endTime - startTime) / 1000000.000 + " ms");
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
        double speedup, speedup2, pe, pe2;
        long seqStartTime = System.nanoTime();
        SequentialTree seq = new SequentialTree(tree.getRoot(), 0, nodesToCheckExplicit);
//        seq.printResult();
        long seqEndTime = System.nanoTime();
        double timediff, timediff2;
        double timediffs = (endTime - startTime) / 1000000.000;
        System.out.println("Sequential Time taken: " + timediffs + " ms");

        System.out.print("Enter number of threads to be used: ");
        int numThreads = s.nextInt();

        int flag =0;
        while (flag ==0) {
            System.out.println("\nInput the technique to check the program:\n0) Exit\n1) Explicit Multithreading\n2) ForkJoinPool");
            int technique = s.nextInt();
            switch (technique) {
                case 0:
                    flag=1;
                case 1:
//				explicit multithreading
                    System.out.println("Explicit");
                    startTime = System.nanoTime();
                    TreeExplicitMultithreading root = new TreeExplicitMultithreading(tree.getRoot(), 0, nodesToCheckExplicit, numThreads);
                    root.printResult();
                    endTime = System.nanoTime();
                    timediff = (endTime - startTime) / 1000000.000;
                    System.out.println("Time taken by Explicit threads: " + timediff + " ms");
                    speedup2 = timediffs / timediff;
                    pe2 = speedup2 / numThreads;
                    System.out.println("Speedup v/s T1: " + speedup2 + " ms" + "| Parallel Efficiency: " + pe2 + " ms");

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
                    timediff = (endTime - startTime) / 1000000.000;
                    System.out.println("Time taken by ForkJoinPool: " + timediff + " ms");

                    // Single thread

                    startTime = System.nanoTime();
                    pool = new ForkJoinPool(1);
                    TreeForkJoinPool task2 = new TreeForkJoinPool(tree.getRoot(), 0, nodesToCheck);
                    try {
                        pool.invoke(task2);
                    } catch (CancellationException e) {
                    }
                    endTime = System.nanoTime();
                    timediff2 = (endTime - startTime) / 1000000.000;
                    speedup = timediff2 / timediff;
                    speedup2 = timediffs / timediff;
                    pe = speedup / numThreads;
                    pe2 = speedup2 / numThreads;
                    System.out.println("Speedup v/s T1: " + speedup + " ms" + "| Parallel Efficiency: " + pe + " ms");
                    System.out.println("Speedup v/s recursive: " + speedup2 + " ms" + "| Parallel Efficiency: " + pe2 + " ms");

                    break;
                default:
                    System.out.println("Wrong input");
            }
        }
    }
}
