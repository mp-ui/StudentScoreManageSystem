/**
 * @AUTHOR Prince
 * @TIME 2021/5/17 21:35
 */

package com.prince.frame;

import javax.swing.*;
import java.awt.*;

public class BaseDialog extends JDialog {
    public JPanel rootPanel;

    public BaseDialog(Frame owner,String title){
        super(owner, title,true);
        setSize(1024,768);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        rootPanel = new JPanel(new BorderLayout());
        setContentPane(rootPanel);
    }
}
