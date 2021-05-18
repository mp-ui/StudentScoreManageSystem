/**
 * @AUTHOR Prince
 * @TIME 2021/5/17 18:22
 */

package com.prince.frame.teacher;

import com.prince.entity.Student;
import com.prince.entity.Teacher;
import com.prince.frame.BaseFrame;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

public class TeacherFrame extends BaseFrame {
    private Teacher teacher;

    public TeacherFrame(Teacher teacher){
        this.teacher = teacher;
        setTitle(teacher.gettName() + "老师，欢迎您！");
        JPanel left = new JPanel();
        left.setPreferredSize(new Dimension(200, 0));
        rootPanel.add(left, BorderLayout.WEST);
        left.setLayout(new GridLayout(10, 1));
        JLabel jLabel1 = new JLabel("工号：" + teacher.gettNo());
        JLabel jLabel2 = new JLabel("姓名：" + teacher.gettName());
        JLabel jLabel3 = new JLabel("性别：" + (teacher.gettSex() == 0 ? "未知" : teacher.gettSex() == 1 ? "男" : "女"));
        JLabel jLabel4 = new JLabel("生日：" + new SimpleDateFormat("yyyy-MM-dd").format(teacher.gettBirthday()));
        left.add(jLabel1);
        left.add(jLabel2);
        left.add(jLabel3);
        left.add(jLabel4);
        left.setBackground(Color.CYAN);
        JPanel right = new JPanel(new GridLayout(10, 1));
        right.setBackground(Color.ORANGE);
        right.setPreferredSize(new Dimension(200, 0));
        rootPanel.add(right, BorderLayout.EAST);
        JButton jButton1 = new JButton("查询我教的课程");
        JButton jButton2 = new JButton("登记分数");
        right.add(jButton1);
        right.add(jButton2);
        jButton1.addActionListener((e) -> {

        });
        jButton2.addActionListener((e) -> {

        });
    }

}
