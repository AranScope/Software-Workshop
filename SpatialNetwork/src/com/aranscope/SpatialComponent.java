package com.aranscope;

import javax.swing.*;
import java.awt.*;

/**
 * Created by aranscope on 24/11/15.
 */
public class SpatialComponent extends JPanel {
    public SpatialComponent(SpatialNetwork network){
        super();

        SpatialModel model = new SpatialModel(network);
        SpatialView view = new SpatialView(model);
        ThresholdPanel panel = new ThresholdPanel(model, 0, 100);
        NumberPanel panel2 = new NumberPanel(model, 0, 500);
        ButtonPanel panel3 = new ButtonPanel(model);

        model.addObserver(view);
        model.addObserver(panel);
        model.addObserver(panel2);

        setLayout(new BorderLayout());
        add(view, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
        add(panel2, BorderLayout.NORTH);
        add(panel3, BorderLayout.EAST);

    }
}
