package com.aranscope;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by aranscope on 24/11/15.
 */
public class ButtonPanel extends JPanel{

    private final SpatialModel model;
    private JButton reset;
    private JButton close;

    public ButtonPanel(final SpatialModel model){
        super();

        this.model = model;
        reset = new JButton("Reset");
        close = new JButton("Close");
        add(reset);
        add(close);

        reset.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                model.reset();
            }
        });

        close.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0);
            }
        });
    }
}
