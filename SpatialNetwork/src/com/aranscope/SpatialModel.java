package com.aranscope;

import java.util.LinkedList;
import java.util.Observable;
import java.util.Random;

/**
 * Created by aranscope on 24/11/15.
 */
public class SpatialModel extends Observable {
    private SpatialNetwork network;

    public SpatialModel(SpatialNetwork network){
        this.network = network;
    }

    public boolean isConnected(Node node1, Node node2){
        return node1.hasNeighbour(node2);
    }

    public LinkedList<Node> getNodes(){
        return network.getNodes();
    }

    public int getNumOfNodes(){
        return network.getNumOfNodes();
    }

    public double getThreshold(){
        return network.getThreshold();
    }

    public void setThreshold(double threshold){
        network.setThreshold(threshold);
        setChanged();
        notifyObservers();
    }

    public void setNumOfNodes(int numOfNodes){
        network.setNumOfNodes(numOfNodes);
        setChanged();
        notifyObservers();
    }
}
