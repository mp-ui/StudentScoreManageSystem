/**
 * @AUTHOR Prince
 * @TIME 2021/5/17 12:14
 */

package com.prince.frame;


import com.prince.entity.*;
import com.prince.factory.SpringFactory;
import com.prince.frame.admin.AdminFrame;
import com.prince.frame.student.StudentFrame;
import com.prince.frame.teacher.TeacherFrame;
import com.prince.service.AdminService;
import com.prince.service.StudentService;
import com.prince.service.TeacherService;
import com.prince.util.CheckUtils;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class MainFrame extends JFrame {


    public MainFrame() {
        setTitle("学生成绩管理系统");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        JPanel jPanel = new JPanel();
        setContentPane(jPanel);
        jPanel.setLayout(new BorderLayout());
        {
            ButtonGroup buttonGroup = new ButtonGroup();
            JRadioButton jRadioButton1 = new JRadioButton("学生", true);
            JRadioButton jRadioButton2 = new JRadioButton("教师");
            JRadioButton jRadioButton3 = new JRadioButton("管理员");
            buttonGroup.add(jRadioButton1);
            buttonGroup.add(jRadioButton2);
            buttonGroup.add(jRadioButton3);
            JPanel jPanel1 = new JPanel();
            jPanel.add(jPanel1, BorderLayout.NORTH);
            //放单选框
            {
                jPanel1.setSize(0, 100);
                jPanel1.setLayout(new FlowLayout());
                jPanel1.add(jRadioButton1);
                jPanel1.add(jRadioButton2);
                jPanel1.add(jRadioButton3);
            }
            JPanel jPanel2 = new JPanel();
            jPanel.add(jPanel2, BorderLayout.CENTER);
            JTextField id = new JTextField(15);
            JPasswordField pwd = new JPasswordField(15);
            //登录文本框
            {
                jPanel2.setLayout(null);
                JLabel jLabel1 = new JLabel("账号：");
                JLabel jLabel2 = new JLabel("密码：");
                jPanel2.add(jLabel1);
                jPanel2.add(id);
                jPanel2.add(jLabel2);
                jPanel2.add(pwd);
                jLabel1.setBounds(60, 20, 60, 20);
                jLabel2.setBounds(60, 60, 60, 20);
                id.setBounds(100, 20, 200, 25);
                pwd.setBounds(100, 60, 200, 25);
                JButton jButton = new JButton("登录");
                jPanel2.add(jButton);
                jButton.setBounds(150, 100, 80, 30);
                jButton.addActionListener(e -> {
                    //判断类型
                    int type = 0;
                    if (jRadioButton1.isSelected()) {
                        type = 1;
                    } else if (jRadioButton2.isSelected()) {
                        type = 2;
                    } else if (jRadioButton3.isSelected()) {
                        type = 3;
                    }
                    login(type, id.getText(), new String(pwd.getPassword()));
                });
            }
        }

        setVisible(true);
    }

    public void login(int type, String username, String password) {
        //检查类型
        if (type <= 0 || type >= 4) {
            JOptionPane.showMessageDialog(this, "类型选择错误", "error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!CheckUtils.checkUsername(username)) {
            JOptionPane.showMessageDialog(this, "账号格式错误，必须为5-10位数字", "error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!CheckUtils.checkPassword(password)) {
            JOptionPane.showMessageDialog(this, "密码格式错误，必须由6-16位的字母、数字、下划线组成", "error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //Spring
        ApplicationContext applicationContext = SpringFactory.getInstance();
        AdminService adminService = applicationContext.getBean(AdminService.class);
        TeacherService teacherService = applicationContext.getBean(TeacherService.class);
        StudentService studentService = applicationContext.getBean(StudentService.class);
        if (type == 1) {
            //学生
            StudentExample studentExample = new StudentExample();
            StudentExample.Criteria criteria = studentExample.createCriteria();
            criteria.andSNoEqualTo(username).andSPasswordEqualTo(password);
            List<Student> students = studentService.selectByExample(studentExample);
            if (students == null || students.size() == 0) {
                JOptionPane.showMessageDialog(this, "账号密码错误", "error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            new StudentFrame(students.get(0)).setVisible(true);
        } else if (type == 2) {
            //教师
            TeacherExample teacherExample = new TeacherExample();
            TeacherExample.Criteria criteria = teacherExample.createCriteria();
            criteria.andTNoEqualTo(username).andTPasswordEqualTo(password);
            List<Teacher> teachers = teacherService.selectByExample(teacherExample);
            if (teachers == null || teachers.size() == 0) {
                JOptionPane.showMessageDialog(this, "账号密码错误", "error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            new TeacherFrame(teachers.get(0)).setVisible(true);
        } else if (type == 3) {
            //管理员
            AdminExample adminExample = new AdminExample();
            AdminExample.Criteria criteria = adminExample.createCriteria();
            criteria.andANoEqualTo(username).andAPasswordEqualTo(password);
            List<Admin> admins = adminService.selectByExample(adminExample);
            if (admins == null || admins.size() == 0) {
                JOptionPane.showMessageDialog(this, "账号密码错误", "error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            new AdminFrame(admins.get(0)).setVisible(true);
        }
        setVisible(false);
    }
}
