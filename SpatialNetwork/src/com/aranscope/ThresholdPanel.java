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
public class ThresholdPanel extends JPanel implements Observer {
    private JLabel label;
    private JSlider slider;
    private final SpatialModel model;

    public ThresholdPanel(final SpatialModel model, int min, int max){
        super();

        this.model = model;

        label = new JLabel("Threshold");

        slider = new JSlider(min, max, (int)(model.getThreshold()*100));
        slider.setMajorTickSpacing((max-min)/10);
        slider.setMinorTickSpacing((max-min)/50);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setPaintTrack(true);

        slider.addChangeListener(changeEvent -> model.setThreshold(slider.getValue() / 100.0));

        model.addObserver(this);

        setLayout(new BorderLayout());
        add(label, BorderLayout.CENTER);
        add(slider, BorderLayout.SOUTH);
    }

    @Override
    public void update(Observable observable, Object o) {
        repaint();
        slider.setValue((int)(model.getThreshold() * 100));
    }
}
