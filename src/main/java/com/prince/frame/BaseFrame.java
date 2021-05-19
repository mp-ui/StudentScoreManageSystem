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
        JLabel jLabel1 = new JLabel("<html><body><p align=\"center\">作者<br/>软件193<br/>甘洪雨</p></body></html>");
        jLabel1.setFont(new Font("楷体", Font.BOLD, 40));
        jLabel1.setForeground(Color.RED);
        jLabel1.setVerticalAlignment(SwingConstants.CENTER);
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        rootPanel.add(jLabel1,BorderLayout.CENTER);
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
