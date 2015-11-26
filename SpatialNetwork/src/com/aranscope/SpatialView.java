package com.aranscope;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by aranscope on 24/11/15.
 */
public class SpatialView extends JPanel implements Observer {
    private SpatialModel model;

    public SpatialView(SpatialModel model){
        super();

        this.model = model;
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.clearRect(0, 0, getWidth(), getHeight());

        int width = getWidth();
        int height = getHeight();


        for(Node node: model.getNodes()){
            g2.fill(node.getDrawable(4, width, height));
        }

        for(Node node1: model.getNodes()){
            for(Node node2: model.getNodes()){
                if(node1 != node2){
                    if(node1.hasNeighbour(node2)){
                        g2.draw(node1.getLineToNeighbour(node2, width, height));
                    }
                }
            }
        }
    }

    @Override
    public void update(Observable observable, Object o) {
        repaint();
    }
}
