package com.aranscope;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by aranscope on 24/11/15.
 */
public class SpatialNetwork {
    private LinkedList<Node> nodes;
    private double threshold;

    public SpatialNetwork(int numOfNodes, double threshold){
        this.threshold = threshold;
        generateNetwork(numOfNodes);
    }

    public boolean isConnected(Node node1, Node node2){
        return node1.hasNeighbour(node2);
    }

    public LinkedList<Node> getNodes(){
        return nodes;
    }

    public int getNumOfNodes(){
        return nodes.size();
    }

    public double getThreshold(){
        return threshold;
    }

    public void setThreshold(double threshold){
        this.threshold = threshold;
        generateNeighbours();
    }

    public void setNumOfNodes(int numOfNodes){
        generateNetwork(numOfNodes);
    }

    private void generateNetwork(int numOfNodes){
        Random ra = new Random();

        if(nodes == null) {
            nodes = new LinkedList<>();
            for (int i = 0; i < numOfNodes; i++) {
                nodes.add(new Node(ra.nextDouble(), ra.nextDouble()));
            }
        }
        else if(numOfNodes > nodes.size()){
            for(int i = 0; i < numOfNodes - nodes.size(); i++){
                nodes.add(new Node(ra.nextDouble(), ra.nextDouble()));
            }
        }
        else if (numOfNodes < nodes.size()){
            for(int i = 0; i < nodes.size() - numOfNodes; i++){
                nodes.remove();
            }
        }

        generateNeighbours();
    }

    private void generateNeighbours(){
        for(Node node: nodes){
            node.removeAllNeighbours();
        }

        for(Node node1: nodes){
            for(Node node2: nodes){
                if(node1 != node2) {
                    if (node1.getDistanceTo(node2) < threshold) node1.addNeighbour(node2);
                }
            }
        }
    }
}
