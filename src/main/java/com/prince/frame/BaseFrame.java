/**
 * @AUTHOR Prince
 * @TIME 2021/5/17 18:37
 */

package com.prince.frame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BaseFrame extends JFrame {
    public JPanel rootPanel;
    public JPanel right;
    public JPanel left;
    public BaseFrame(){
        setLocationRelativeTo(null);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        rootPanel = new JPanel();
        rootPanel.setLayout(new BorderLayout());
        setContentPane(rootPanel);
        JPanel top = new JPanel();
        top.setSize(0,100);
        top.setLayout(new BorderLayout());
        rootPanel.add(top,BorderLayout.NORTH);
        JLabel jLabel = new JLabel("欢迎使用学生成绩管理系统！");
        jLabel.setFont(new Font("楷体",Font.BOLD,50));
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel.setVerticalAlignment(SwingConstants.CENTER);
        rootPanel.add(jLabel,BorderLayout.NORTH);
        rootPanel.setBorder(new EmptyBorder(8,8,8,8));
        //right
        {
            right = new JPanel(new GridLayout(10, 1));
            right.setBackground(Color.ORANGE);
            right.setPreferredSize(new Dimension(200, 0));
            rootPanel.add(right, BorderLayout.EAST);
        }
        //left
        {
            left = new JPanel();
            left.setPreferredSize(new Dimension(200, 0));
            rootPanel.add(left, BorderLayout.WEST);
            left.setLayout(new GridLayout(10, 1));
            left.setBackground(Color.CYAN);
        }
    }
}
