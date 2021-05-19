/**
 * @AUTHOR Prince
 * @TIME 2021/5/17 18:22
 */

package com.prince.frame.teacher;

import com.prince.dao.ScoreDao;
import com.prince.entity.*;
import com.prince.factory.SpringFactory;
import com.prince.frame.BaseDialog;
import com.prince.frame.BaseFrame;
import com.prince.service.CourseService;
import com.prince.service.SCService;
import com.prince.util.ScoreUtils;
import org.springframework.context.ApplicationContext;

import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.text.SimpleDateFormat;

public class TeacherFrame extends BaseFrame {
    private Teacher teacher;
    private ApplicationContext applicationContext;

    public TeacherFrame(Teacher teacher){
        applicationContext = SpringFactory.getInstance();
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
            selectLessonsITeach();
        });
        jButton2.addActionListener((e) -> {
            selectLessonsITeach();
        });
    }

    //获取我教的课程
    List<Course> getCourses(String word/*筛选*/){
        CourseService courseService = applicationContext.getBean(CourseService.class);
        CourseExample courseExample = new CourseExample();
        courseExample.createCriteria().andTNoEqualTo(teacher.gettNo()).andCNameLike("%" + word + "%");
        List<Course> courses = courseService.selectByExample(courseExample);
        return courses;
    }

    //查询我教的课程
    public void selectLessonsITeach(){
        BaseDialog baseDialog = new BaseDialog(this,"我教的课程");
        JPanel up = new JPanel(new GridLayout(3, 1));
        baseDialog.rootPanel.add(up, BorderLayout.NORTH);
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable jTable = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable.setRowHeight(30);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        baseDialog.rootPanel.add(jScrollPane, BorderLayout.CENTER);
        //List<Course> courses = null;
        final List<Course>[] courses = new List[]{null};
        courses[0] = getCourses("");
        {
            for (int i = 0; i < 4; i++) {
                jTable.addColumn(new TableColumn());
            }
            tableModel.addColumn("课程编号");
            tableModel.addColumn("课程名称");
            tableModel.addColumn("课程类型");
            tableModel.addColumn("学分");

            for (Course course : courses[0]) {
                Object[] obj = new Object[8];
                obj[0] = course.getcNo();
                obj[1] = course.getcName();
                obj[2] = course.getcType();
                obj[3] = course.getcCredit();
                tableModel.addRow(obj);
            }
        }
        //展示一共教多少个课？
        {
            JLabel jLabel = new JLabel();
            jLabel.setFont(new Font("楷体", Font.PLAIN, 35));
            jLabel.setForeground(Color.BLUE);
            jLabel.setVerticalAlignment(SwingConstants.CENTER);
            jLabel.setHorizontalAlignment(SwingConstants.CENTER);
            jLabel.setText(String.format("您一共教%d门课！",courses[0].size()));
            up.add(jLabel);
        }
        //搜索课程
        {
            JPanel searchPanel = new JPanel();
            up.add(searchPanel);
            searchPanel.add(new JLabel("查找课程："));
            JTextField sea = new JTextField(20);
            searchPanel.add(sea);
            JButton seaBtn = new JButton("查找");
            searchPanel.add(seaBtn);
            seaBtn.addActionListener((e) -> {
                tableModel.setRowCount(0); //清空所有列
                courses[0] = getCourses(sea.getText());
                for (Course course : courses[0]) {
                    Object[] obj = new Object[4];
                    obj[0] = course.getcNo();
                    obj[1] = course.getcName();
                    obj[2] = course.getcType();
                    obj[3] = course.getcCredit();
                    tableModel.addRow(obj);
                }
            });
        }
        //登记分数
        {
            JPanel jPanel = new JPanel();
            JButton jButton = new JButton("我要给这门课登分！");
            jPanel.add(jButton);
            up.add(jPanel);
            jButton.addActionListener((e)->{
                int where = jTable.getSelectedRow();
                if (where < 0) {
                    JOptionPane.showMessageDialog(this, "你还没有在列表里面选择课程！", "error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (where >= courses[0].size()) {
                    JOptionPane.showMessageDialog(this, "未知错误！", "error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Course course = courses[0].get(where);
                registerScore(course);
            });

        }
        baseDialog.setVisible(true);
    }

    //获得分数
    List<Score> getScores(Course course){
        ScoreDao scoreDao = applicationContext.getBean(ScoreDao.class);
        return scoreDao.selectAllByCNo(course.getcNo());
    }

    //登记分数
    public void registerScore(Course course){
        BaseDialog baseDialog = new BaseDialog(this,"正在给课程 " + course.getcName() + " 登记分数");
        JPanel up = new JPanel(new GridLayout(3, 1));
        baseDialog.rootPanel.add(up, BorderLayout.NORTH);
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable jTable = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable.setRowHeight(30);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        baseDialog.rootPanel.add(jScrollPane, BorderLayout.CENTER);
        final List<Score>[] scores = new List[]{null};
        scores[0] = getScores(course);
        {
            for (int i = 0; i < 10; i++) {
                jTable.addColumn(new TableColumn());
            }
            tableModel.addColumn("学号");
            tableModel.addColumn("姓名");
            tableModel.addColumn("课程编号");
            tableModel.addColumn("课程名称");
            tableModel.addColumn("课程类型");
            tableModel.addColumn("学分");
            tableModel.addColumn("成绩");
            tableModel.addColumn("绩点");
            tableModel.addColumn("教师工号");
            tableModel.addColumn("教师姓名");
            tableModel.addColumn("教师职称");
            for (Score score : scores[0]) {
                Object[] data = new Object[11];
                data[0] = score.getsNo();
                data[1] = score.getsName();
                data[2] = score.getcNo();
                data[3] = score.getcType();
                data[4] = score.getcName();
                data[5] = score.getcCredit();
                if(score.getScore() == null || score.getScore() < 0){
                    data[6] = "未登记";
                    data[7] = "未登记";
                }else{
                    data[6] = score.getScore();
                    data[7] = String.format("%.01f", ScoreUtils.getJiDian(score.getScore()));
                }
                data[8] = score.gettNo();
                data[9] = score.gettName();
                data[10] = score.gettPosition();
                tableModel.addRow(data);
            }
        }
        //第一列，展示一共有多少个学生
        {
            JLabel jLabel = new JLabel();
            jLabel.setFont(new Font("楷体", Font.PLAIN, 35));
            jLabel.setForeground(Color.BLUE);
            jLabel.setVerticalAlignment(SwingConstants.CENTER);
            jLabel.setHorizontalAlignment(SwingConstants.CENTER);
            jLabel.setText(String.format("您一共有%d名学生选了这门课！",scores[0].size()));
            up.add(jLabel);
        }
        //第二列，成绩登分
        {
            JPanel jPanel = new JPanel();
            up.add(jPanel);
            jPanel.add(new JLabel("输入分数："));
            JTextField inputScore = new JTextField(8);
            jPanel.add(inputScore);
            JButton register = new JButton("登记分数");
            jPanel.add(register);
            register.addActionListener((e)->{
                if(!inputScore.getText().matches("\\d+")){
                    JOptionPane.showMessageDialog(this, "您只能输入数字！", "error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Integer input = Integer.valueOf(inputScore.getText());
                if(input < 0 || input > 100){
                    JOptionPane.showMessageDialog(this, "您只能输入0-100之间的数字！", "error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int where = jTable.getSelectedRow();
                if (where < 0) {
                    JOptionPane.showMessageDialog(this, "你还没有在列表里面选择学生！", "error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (where >= scores[0].size()) {
                    JOptionPane.showMessageDialog(this, "未知错误！", "error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Score score = scores[0].get(where);
                SC sc = new SC();
                sc.setcNo(score.getcNo());
                sc.setsNo(score.getsNo());
                sc.setScore(input);
                SCService scService = applicationContext.getBean(SCService.class);
                SCExample scExample = new SCExample();
                scExample.createCriteria().andSNoEqualTo(score.getsNo()).andCNoEqualTo(score.getcNo());
                int i = scService.updateByExample(sc, scExample);
                if(i > 0){
                    tableModel.setValueAt(input,where,6);
                    tableModel.setValueAt(String.format("%.01f", ScoreUtils.getJiDian(input)),where,7);
                }else{
                    JOptionPane.showMessageDialog(this, "登记失败！", "error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                scores[0] = getScores(course);  //刷新课程
                baseDialog.repaint();
            });
        }
        //第三列，其他操作
        {
            JPanel jPanel = new JPanel();
            up.add(jPanel);
            JButton jButton1 = new JButton("我要踢掉这个学生！");
            JButton jButton2 = new JButton("我要取消这个学生的分数！");
            jPanel.add(jButton1);
            jPanel.add(jButton2);

        }
        baseDialog.setVisible(true);
    }

}
