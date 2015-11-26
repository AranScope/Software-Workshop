package com.aranscope;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by aranscope on 24/11/15.
 */
public class NumberPanel extends JPanel implements Observer {
    private JLabel label;
    private JSlider slider;
    private final SpatialModel model;

    public NumberPanel(final SpatialModel model, int min, int max){
        super();

        this.model = model;

        label = new JLabel("Number Of Nodes");

        slider = new JSlider(min, max, model.getNumOfNodes());
        slider.setMajorTickSpacing((max-min)/10);
        slider.setMinorTickSpacing((max-min)/50);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setPaintTrack(true);

        slider.addChangeListener(changeEvent -> model.setNumOfNodes(slider.getValue()));

        model.addObserver(this);

        setLayout(new BorderLayout());
        add(label, BorderLayout.CENTER);
        add(slider, BorderLayout.SOUTH);
    }

    @Override
    public void update(Observable observable, Object o) {
        repaint();
        slider.setValue(model.getNumOfNodes());
    }
}
