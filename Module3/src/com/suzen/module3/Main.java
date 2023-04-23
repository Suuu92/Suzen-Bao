package com.suzen.module3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static ArrayList<Node> graph;
    public static void main(String[] args) throws FileNotFoundException {
        setupTree();
        // Enter the root node here, assuming it starts from 0
        BFS(0);
    }

    private static void BFS(int root) {
        // Create a queue for the all the nodes
        LinkedList<Node> queue = new LinkedList<>();

        // Get the startNode from the input (root)
        Node startNode = graph.get(root);

        // Set the root node as visited so it won't be added again in the queue
        startNode.setVisited(true);
        queue.add(startNode);

        while (!queue.isEmpty()) {
            // Remove the first node from the queue
            Node currentNode = queue.poll();
            System.out.println("Visited Node: " + currentNode.getKey());

            // Visit and add the leaf nodes of the current node
            List<Integer> leafNodes = currentNode.getNodes();
            for (int leafNode : leafNodes) {
                Node neighborNode = getNodeByKey(leafNode);

                // If leaf node is not visited, set as visited and add to the queue
                if (!neighborNode.isVisited()) {
                    queue.add(neighborNode);
                    neighborNode.setVisited(true);
                }
            }
        }
    }

    private static Node getNodeByKey(int key) {
        // Return the given key's nodes
        for (Node node : graph) {
            if (node.getKey() == key) {
                return node;
            }
        }
        return null;
    }

    private static void setupTree() throws FileNotFoundException {
        graph = new ArrayList<>();
        Scanner scan = new Scanner(new File("tree.txt"));
        while(scan.hasNext()){
            String line = scan.nextLine();
            parseLine(line);
        }
    }

    private static void parseLine(String line) {
        String[] keys = line.split(" ");
        int key = Integer.parseInt(keys[0]);
        ArrayList<Integer> points = new ArrayList<>();
        for(int i = 1; i < keys.length;i++){
            points.add(Integer.parseInt(keys[i]));
        }
        graph.add(new Node(key, points));
    }
}
