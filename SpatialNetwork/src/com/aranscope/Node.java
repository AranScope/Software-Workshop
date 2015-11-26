package com.aranscope;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.LinkedList;

/**
 * Created by aranscope on 24/11/15.
 */
public class Node extends Point2D.Double{
    private LinkedList<Node> neighbours;

    public Node(double x, double y){
        super(x, y);
        neighbours = new LinkedList<>();
    }

    public boolean hasNeighbour(Node node){
        return neighbours.contains(node);
    }

    public void addNeighbour(Node node){
        neighbours.add(node);
    }

    public void removeNeighbour(Node node){
        neighbours.remove(node);
    }

    public void removeAllNeighbours(){
        neighbours = new LinkedList<>();
    }

    public double getDistanceTo(Node node){
        return Math.sqrt(Math.pow(this.x - node.x, 2) + Math.pow(this.y - node.y, 2));
    }

    public Ellipse2D.Double getDrawable(int radius, int panelWidth, int panelHeight){
        return new Ellipse2D.Double((panelWidth * this.x) - radius, (panelHeight*this.y)  - radius, 2*radius, 2*radius);
    }

    public Line2D.Double getLineToNeighbour(Node neighbour, int panelWidth, int panelHeight){
        return new Line2D.Double(panelWidth * this.x, panelHeight * this.y, panelWidth * neighbour.getX(), panelHeight * neighbour.getY());
    }
}
