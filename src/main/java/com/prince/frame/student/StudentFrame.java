/**
 * @AUTHOR Prince
 * @TIME 2021/5/17 18:22
 */

package com.prince.frame.student;

import com.prince.dao.LessonDao;
import com.prince.dao.ScoreDao;
import com.prince.entity.*;
import com.prince.factory.SpringFactory;
import com.prince.frame.BaseDialog;
import com.prince.frame.BaseFrame;
import com.prince.service.SCService;
import com.prince.util.ScoreUtils;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class StudentFrame extends BaseFrame {
    private Student student;
    private ApplicationContext applicationContext;

    public StudentFrame(Student student) {
        this.applicationContext = SpringFactory.getInstance();
        this.student = student;
        setTitle(student.getsName() + "同学，欢迎您！");
        JLabel jLabel1 = new JLabel("学号：" + student.getsNo());
        JLabel jLabel2 = new JLabel("姓名：" + student.getsName());
        JLabel jLabel3 = new JLabel("性别：" + (student.getsSex() == 0 ? "未知" : student.getsSex() == 1 ? "男" : "女"));
        JLabel jLabel4 = new JLabel("生日：" + new SimpleDateFormat("yyyy-MM-dd").format(student.getsBirthday()));
        left.add(jLabel1);
        left.add(jLabel2);
        left.add(jLabel3);
        left.add(jLabel4);
        JButton jButton1 = new JButton("选课");
        JButton jButton2 = new JButton("成绩查询");
        right.add(jButton1);
        right.add(jButton2);
        jButton1.addActionListener((e) -> {
            chooseLesson();
        });
        jButton2.addActionListener((e) -> {
            selectScore();
        });
    }

    //筛选选课课程
    private String searchWord = "";

    //选课的时候获取所有课程
    public List<Lesson> getLessons() {
        LessonDao lessonDao = applicationContext.getBean(LessonDao.class);
        return lessonDao.getAllLessonBySNoAndCName(student.getsNo(), searchWord);
    }


    public void chooseLesson() {
        BaseDialog baseDialog = new BaseDialog(this, "网上选课");
        searchWord = "";
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
        final List<Lesson>[] lessons = new List[]{null};
        lessons[0] = getLessons();
        int allChooseCredit = 0;
        int allUnChooseCredit = 0;
        {
            for (int i = 0; i < 8; i++) {
                jTable.addColumn(new TableColumn());
            }
            tableModel.addColumn("课程编号");
            tableModel.addColumn("课程名称");
            tableModel.addColumn("课程类型");
            tableModel.addColumn("学分");
            tableModel.addColumn("教师编号");
            tableModel.addColumn("教师姓名");
            tableModel.addColumn("教师职称");
            tableModel.addColumn("是否已选");
            for (Lesson lesson : lessons[0]) {
                Object[] obj = new Object[8];
                obj[0] = lesson.getcNo();
                obj[1] = lesson.getcName();
                obj[2] = lesson.getcType();
                obj[3] = lesson.getcCredit();
                obj[4] = lesson.gettNo();
                obj[5] = lesson.gettName();
                obj[6] = lesson.gettPosition();
                if (lesson.getScore() != null) {
                    obj[7] = "已选";
                    allChooseCredit += lesson.getcCredit();
                } else {
                    obj[7] = "未选";
                    allUnChooseCredit += lesson.getcCredit();
                }
                tableModel.addRow(obj);
            }
        }
        //展示选了多少分
        {
            JLabel jLabel = new JLabel();
            jLabel.setFont(new Font("楷体", Font.PLAIN, 35));
            jLabel.setForeground(Color.BLUE);
            jLabel.setVerticalAlignment(SwingConstants.CENTER);
            jLabel.setHorizontalAlignment(SwingConstants.CENTER);
            jLabel.setText(String.format("已选学分：%d，未选学分：%d", allChooseCredit, allUnChooseCredit));
            up.add(jLabel);
        }
        //搜索按钮
        {
            JPanel searchPanel = new JPanel();
            up.add(searchPanel);
            searchPanel.add(new JLabel("查找课程："));
            JTextField sea = new JTextField(20);
            searchPanel.add(sea);
            JButton seaBtn = new JButton("查找");
            seaBtn.addActionListener(e -> {
                tableModel.setRowCount(0); //清空所有列
                searchWord = sea.getText();
                lessons[0] = getLessons();
                for (Lesson lesson : lessons[0]) {
                    Object[] obj = new Object[8];
                    obj[0] = lesson.getcNo();
                    obj[1] = lesson.getcName();
                    obj[2] = lesson.getcType();
                    obj[3] = lesson.getcCredit();
                    obj[4] = lesson.gettNo();
                    obj[5] = lesson.gettName();
                    obj[6] = lesson.gettPosition();
                    if (lesson.getScore() != null) {
                        obj[7] = "已选";
                    } else {
                        obj[7] = "未选";
                    }
                    tableModel.addRow(obj);
                }
                baseDialog.repaint();
            });
            searchPanel.add(seaBtn);
        }
        //选课按钮
        {
            JPanel choosePanel = new JPanel();
            up.add(choosePanel);
            JButton jButton1 = new JButton("我要选这个课！");
            JButton jButton2 = new JButton("我不要选这个课！");
            choosePanel.add(jButton1);
            choosePanel.add(jButton2);
            //选课
            jButton1.addActionListener((e) -> {
                int where = jTable.getSelectedRow();
                if (where < 0) {
                    JOptionPane.showMessageDialog(this, "你还没有在列表里面选择课程！", "error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (where >= lessons[0].size()) {
                    JOptionPane.showMessageDialog(this, "未知错误！", "error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Lesson lesson = lessons[0].get(where);
                if (lesson.getScore() != null) {
                    JOptionPane.showMessageDialog(this, "你已经选了这个课啦！", "error", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                SC sc = new SC();
                sc.setcNo(lesson.getcNo());
                sc.setsNo(lesson.getsNo());
                sc.setScore(-1);
                SCService scService = applicationContext.getBean(SCService.class);
                int i = scService.insert(sc);
                if (i > 0) {
                    JOptionPane.showMessageDialog(this, "选课成功！", "error", JOptionPane.PLAIN_MESSAGE);
                    //修改数据
                    tableModel.setValueAt("已选", where, 7);
                } else {
                    JOptionPane.showMessageDialog(this, "选课失败！", "error", JOptionPane.ERROR_MESSAGE);
                }
                //更新lesson
                lessons[0] = getLessons();
            });
            //取消选课
            jButton2.addActionListener((e) -> {
                int where = jTable.getSelectedRow();
                if (where < 0) {
                    JOptionPane.showMessageDialog(this, "你还没有在列表里面选择课程！", "error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (where >= lessons[0].size()) {
                    JOptionPane.showMessageDialog(this, "未知错误！", "error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Lesson lesson = lessons[0].get(where);
                if (lesson.getScore() == null) {
                    JOptionPane.showMessageDialog(this, "你还没选这个课！", "error", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (lesson.getScore() >= 0) {
                    JOptionPane.showMessageDialog(this, "你选的这个课已经上完了，不能再退了！", "error", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                SCExample scExample = new SCExample();
                SCExample.Criteria criteria = scExample.createCriteria();
                criteria.andCNoEqualTo(lesson.getcNo()).andSNoEqualTo(lesson.getsNo());
                SCService scService = applicationContext.getBean(SCService.class);
                int i = scService.deleteByExample(scExample);
                if (i > 0) {
                    JOptionPane.showMessageDialog(this, "取消选课成功！", "error", JOptionPane.PLAIN_MESSAGE);
                    //修改数据
                    tableModel.setValueAt("未选", where, 7);
                } else {
                    JOptionPane.showMessageDialog(this, "取消选课失败！", "error", JOptionPane.ERROR_MESSAGE);
                }
                //更新lesson
                lessons[0] = getLessons();
            });
        }
        baseDialog.setVisible(true);
    }

    public void selectScore() {
        BaseDialog baseDialog = new BaseDialog(this, "成绩查询");
        JPanel jPanel = baseDialog.rootPanel;
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable jTable = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTable.setRowHeight(30);
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        jPanel.add(jScrollPane, BorderLayout.CENTER);
        JLabel jLabel = new JLabel();
        jLabel.setFont(new Font("楷体", Font.PLAIN, 35));
        jLabel.setForeground(Color.BLUE);
        jLabel.setVerticalAlignment(SwingConstants.CENTER);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jPanel.add(jLabel, BorderLayout.NORTH);
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
            ScoreDao scoreDao = applicationContext.getBean(ScoreDao.class);
            List<Score> scores = scoreDao.selectAllBySNo(student.getsNo());
            int allCredit = 0;
            double allJiDian = 0;
            for (Score score : scores) {
//                System.out.println(score);
                Object[] data = new Object[11];
                data[0] = score.getsNo();
                data[1] = score.getsName();
                data[2] = score.getcNo();
                data[3] = score.getcType();
                data[4] = score.getcName();
                data[5] = score.getcCredit();
                data[6] = score.getScore();
                data[7] = String.format("%.01f", ScoreUtils.getJiDian(score.getScore()));
                data[8] = score.gettNo();
                data[9] = score.gettName();
                data[10] = score.gettPosition();
                tableModel.addRow(data);
                allCredit += score.getcCredit();
                allJiDian += ScoreUtils.getJiDian(score.getScore()) * score.getcCredit();
            }
            jLabel.setText(String.format("已修学分：%d，总绩点为：%.02f", allCredit, allCredit == 0 ? 0 : (allJiDian / allCredit)));
        }
        baseDialog.setVisible(true);
    }

}
