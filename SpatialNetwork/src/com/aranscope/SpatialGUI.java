package com.aranscope;

import javax.swing.*;

/**
 * Created by aranscope on 24/11/15.
 */
public class SpatialGUI {
    public static void main(String[] args){
        JFrame frame = new JFrame("Spatial Network");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SpatialNetwork network = new SpatialNetwork(100, 0.1);
//        SpatialModel model = new SpatialModel(network);
//        model.setThreshold(0.1);
//        SpatialView view = new SpatialView(model);

        SpatialComponent comp = new SpatialComponent(network);

        frame.add(comp);
        frame.setVisible(true);
    }
}
