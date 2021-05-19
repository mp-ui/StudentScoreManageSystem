/**
 * @AUTHOR Prince
 * @TIME 2021/5/17 18:22
 */

package com.prince.frame.admin;

import com.prince.entity.*;
import com.prince.factory.SpringFactory;
import com.prince.frame.BaseDialog;
import com.prince.frame.BaseFrame;
import com.prince.service.CourseService;
import com.prince.service.StudentService;
import com.prince.service.TeacherService;
import com.prince.service.impl.StudentServiceImpl;
import com.prince.service.impl.TeacherServiceImpl;
import com.prince.util.CheckUtils;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AdminFrame extends BaseFrame {
    private Admin admin;
    private ApplicationContext applicationContext;

    public AdminFrame(Admin admin){
        this.admin = admin;
        setTitle("管理员登录");
        this.applicationContext = SpringFactory.getInstance();
        left.add(new JLabel("管理员：" + admin.getaNo()));
        JButton jButton1 = new JButton("学生管理");
        JButton jButton2 = new JButton("教师管理");
        right.add(jButton1);
        right.add(jButton2);
        jButton1.addActionListener(e->manageStudent());
        jButton2.addActionListener(e->manageTeacher());
    }

    List<Student> getStudents(){
        StudentService studentService = applicationContext.getBean(StudentService.class);
        return studentService.selectByExample(new StudentExample());
    }

    //管理学生
    public void manageStudent(){
        BaseDialog baseDialog = new BaseDialog(this,"学生管理");
        JPanel up = new JPanel(new GridLayout(2, 1));
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
        final java.util.List<Student>[] students = new List[]{null};
        students[0] = getStudents();
        {
            for (int i = 0; i < 4; i++) {
                jTable.addColumn(new TableColumn());
            }
            tableModel.addColumn("学号");
            tableModel.addColumn("姓名");
            tableModel.addColumn("性别");
            tableModel.addColumn("生日");
            for (Student student : students[0]) {
                Object[] obj = new Object[4];
                obj[0] = student.getsNo();
                obj[1] = student.getsName();
                obj[2] = student.getsSex() == 0 ? "未知" : student.getsSex() == 1 ? "男" : "女";
                obj[3] = new SimpleDateFormat("yyyy-MM-dd").format(student.getsBirthday());
                tableModel.addRow(obj);
            }
        }
        //展示一共有多少个学生？
        {
            JLabel jLabel = new JLabel();
            jLabel.setFont(new Font("楷体", Font.PLAIN, 35));
            jLabel.setForeground(Color.BLUE);
            jLabel.setVerticalAlignment(SwingConstants.CENTER);
            jLabel.setHorizontalAlignment(SwingConstants.CENTER);
            jLabel.setText(String.format("一共有%d个学生！",students[0].size()));
            up.add(jLabel);
        }
        //按钮
        {
            JPanel jPanel = new JPanel();
            JButton jButton1 = new JButton("添加学生");
            JButton jButton2 = new JButton("删除学生");
            jPanel.add(jButton1);
            jPanel.add(jButton2);
            up.add(jPanel);
            //添加学生
            jButton1.addActionListener((e)->{
                addStudent();
                students[0] = getStudents();
                tableModel.setRowCount(0);
                for (Student student : students[0]) {
                    Object[] obj = new Object[4];
                    obj[0] = student.getsNo();
                    obj[1] = student.getsName();
                    obj[2] = student.getsSex() == 0 ? "未知" : student.getsSex() == 1 ? "男" : "女";
                    obj[3] = new SimpleDateFormat("yyyy-MM-dd").format(student.getsBirthday());
                    tableModel.addRow(obj);
                }
                baseDialog.repaint();
            });
            //删除学生
            jButton2.addActionListener((e)->{
                int where = jTable.getSelectedRow();
                if (where < 0) {
                    JOptionPane.showMessageDialog(this, "你还没有在列表里面选择学生！", "error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (where >= students[0].size()) {
                    JOptionPane.showMessageDialog(this, "未知错误！", "error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Student student = students[0].get(where);
                int i = JOptionPane.showConfirmDialog(this,"确认删除学生？\n如果删除，该学生所对应的所有课程成绩都会清空且无法恢复！","really",JOptionPane.YES_OPTION);
                if(i == JOptionPane.YES_OPTION){
                    if(deleteStudent(student)){
                        //删除成功
                        JOptionPane.showMessageDialog(this, "删除成功！", "successfully", JOptionPane.PLAIN_MESSAGE);
                        tableModel.removeRow(where);
                    }else{
                        JOptionPane.showMessageDialog(this, "删除失败！", "error", JOptionPane.ERROR_MESSAGE);
                    }
                    //刷新
                    students[0] = getStudents();
                }
            });
        }
        baseDialog.setVisible(true);
    }

    //添加学生对话框
    public void addStudent(){
        JDialog jDialog = new JDialog(this,"添加学生",true);
        JPanel jPanel = new JPanel();
        jDialog.setContentPane(jPanel);
        jPanel.setLayout(new GridLayout(8,1));
        jDialog.setSize(400,300);
        jDialog.setLocationRelativeTo(null);
        //第一行：
        {
            JLabel jLabel = new JLabel();
            jLabel.setFont(new Font("楷体", Font.PLAIN, 35));
            jLabel.setForeground(Color.BLUE);
            jLabel.setVerticalAlignment(SwingConstants.CENTER);
            jLabel.setHorizontalAlignment(SwingConstants.CENTER);
            jLabel.setText("添加学生");
            jPanel.add(jLabel);
        }
        JTextField no = new JTextField(20);
        JTextField name = new JTextField(20);
        JComboBox<String> sex = new JComboBox<>(new String[]{"请选择","男","女"});
        JTextField birthday = new JTextField(20);
        JPasswordField password = new JPasswordField(20);
        JPasswordField com_password = new JPasswordField(20);
        //第二行：输入学号
        {
            JPanel jPanel1 = new JPanel();
            jPanel1.add(new JLabel("学生学号："));
            jPanel1.add(no);
            jPanel.add(jPanel1);
        }
        //第三行：输入姓名
        {
            JPanel jPanel1 = new JPanel();
            jPanel1.add(new JLabel("学生姓名："));
            jPanel1.add(name);
            jPanel.add(jPanel1);
        }
        //第四行：选择性别
        {
            JPanel jPanel1 = new JPanel();
            jPanel1.add(new JLabel("学生性别："));
            jPanel1.add(sex);
            jPanel.add(jPanel1);
        }
        //第五行：出生日期
        {
            JPanel jPanel1 = new JPanel();
            jPanel1.add(new JLabel("出生日期："));
            jPanel1.add(birthday);
            jPanel.add(jPanel1);
        }
        //第六行：密码
        {
            JPanel jPanel1 = new JPanel();
            jPanel1.add(new JLabel("密码："));
            jPanel1.add(password);
            jPanel.add(jPanel1);
        }
        //第七行：确认密码
        {
            JPanel jPanel1 = new JPanel();
            jPanel1.add(new JLabel("确认密码："));
            jPanel1.add(com_password);
            jPanel.add(jPanel1);
        }
        //第八行：确认按钮
        {
            JPanel jPanel1 = new JPanel();
            JButton jButton1 = new JButton("确认添加学生");
            JButton jButton2 = new JButton("取消添加学生");
            jPanel1.add(jButton1);
            jPanel1.add(jButton2);
            jPanel.add(jPanel1);
            jButton1.addActionListener((e)->{
                if(addStudent(no.getText(),name.getText(),sex.getSelectedIndex(),birthday.getText(),new String(password.getPassword()),new String(com_password.getPassword()))){
                    jDialog.dispose();
                }
            });
            jButton2.addActionListener((e)->{
                jDialog.dispose();
            });

        }
        jDialog.setVisible(true);
    }

    //添加学生具体实现
    public boolean addStudent(String no,String name,int sex,String birthday,String password,String com_password){
        if(!CheckUtils.checkUsername(no)){
            JOptionPane.showMessageDialog(this, "账号格式错误，必须为5-10位数字", "error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(name.length() == 0 || name.length() > 20){
            JOptionPane.showMessageDialog(this, "名字长度必须为1-20", "error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(sex == 0){
            JOptionPane.showMessageDialog(this, "请选择性别", "error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birth = null;
        try {
            birth = simpleDateFormat.parse(birthday);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "日期输入错误，请保证日期存在且格式为yyyy-MM-dd", "error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(!CheckUtils.checkPassword(password)){
            JOptionPane.showMessageDialog(this, "密码格式错误，必须由6-16位的字母、数字、下划线组成", "error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(!password.equals(com_password)){
            JOptionPane.showMessageDialog(this, "两次输入的密码不一样！", "error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        StudentService studentService = applicationContext.getBean(StudentService.class);
        Student student1 = studentService.selectByPrimaryKey(no);
        if(student1 != null){
            JOptionPane.showMessageDialog(this, "该学号已经存在！", "error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        Student student = new Student();
        student.setsNo(no);
        student.setsName(name);
        student.setsSex(sex);
        student.setsPassword(password);
        student.setsBirthday(birth);
        int i = studentService.insert(student);
        if(i > 0){
            JOptionPane.showMessageDialog(this, "添加成功！", "successfully", JOptionPane.PLAIN_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "添加失败！", "error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    //删除学生
    public boolean deleteStudent(Student student){
        StudentServiceImpl studentService = applicationContext.getBean(StudentServiceImpl.class);
        return studentService.deleteStudent(student) > 0;
    }

    List<Teacher> getTeachers(){
        TeacherService teacherService = applicationContext.getBean(TeacherService.class);
        return teacherService.selectByExample(new TeacherExample());
    }

    public void manageTeacher(){
        BaseDialog baseDialog = new BaseDialog(this,"教师管理");
        JPanel up = new JPanel(new GridLayout(2, 1));
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
        final java.util.List<Teacher>[] teachers = new List[]{null};
        teachers[0] = getTeachers();
        {
            for (int i = 0; i < 5; i++) {
                jTable.addColumn(new TableColumn());
            }
            tableModel.addColumn("学号");
            tableModel.addColumn("姓名");
            tableModel.addColumn("性别");
            tableModel.addColumn("生日");
            tableModel.addColumn("职称");
            for (Teacher teacher : teachers[0]) {
                Object[] obj = new Object[5];
                obj[0] = teacher.gettNo();
                obj[1] = teacher.gettName();
                obj[2] = teacher.gettSex() == 0 ? "未知" : teacher.gettSex() == 1 ? "男" : "女";
                obj[3] = new SimpleDateFormat("yyyy-MM-dd").format(teacher.gettBirthday());
                obj[4] = teacher.gettPosition();
                tableModel.addRow(obj);
            }
        }
        //展示一共有多少个老师？
        {
            JLabel jLabel = new JLabel();
            jLabel.setFont(new Font("楷体", Font.PLAIN, 35));
            jLabel.setForeground(Color.BLUE);
            jLabel.setVerticalAlignment(SwingConstants.CENTER);
            jLabel.setHorizontalAlignment(SwingConstants.CENTER);
            jLabel.setText(String.format("一共有%d个老师！",teachers[0].size()));
            up.add(jLabel);
        }
        //按钮
        {
            JPanel jPanel = new JPanel();
            JButton jButton1 = new JButton("添加老师");
            JButton jButton2 = new JButton("删除老师");
            jPanel.add(jButton1);
            jPanel.add(jButton2);
            up.add(jPanel);
            //添加老师
            jButton1.addActionListener((e)->{
                addTeacher();
                teachers[0] = getTeachers();
                tableModel.setRowCount(0);
                for (Teacher teacher : teachers[0]) {
                    Object[] obj = new Object[5];
                    obj[0] = teacher.gettNo();
                    obj[1] = teacher.gettName();
                    obj[2] = teacher.gettSex() == 0 ? "未知" : teacher.gettSex() == 1 ? "男" : "女";
                    obj[3] = new SimpleDateFormat("yyyy-MM-dd").format(teacher.gettBirthday());
                    obj[4] = teacher.gettPosition();
                    tableModel.addRow(obj);
                }
                baseDialog.repaint();
            });
            //删除老师
            jButton2.addActionListener((e)->{
                int where = jTable.getSelectedRow();
                if (where < 0) {
                    JOptionPane.showMessageDialog(this, "你还没有在列表里面选择老师！", "error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (where >= teachers[0].size()) {
                    JOptionPane.showMessageDialog(this, "未知错误！", "error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Teacher teacher = teachers[0].get(where);
                int i = JOptionPane.showConfirmDialog(this,"确认删除老师？\n如果删除，该老师所对应的所有课程都会被清空，而且选了该课程的学生的成绩也会清空！","really",JOptionPane.YES_OPTION);
                if(i == JOptionPane.YES_OPTION){
                    if(deleteTeacher(teacher)){
                        //删除成功
                        JOptionPane.showMessageDialog(this, "删除成功！", "successfully", JOptionPane.PLAIN_MESSAGE);
                        tableModel.removeRow(where);
                    }else{
                        JOptionPane.showMessageDialog(this, "删除失败！", "error", JOptionPane.ERROR_MESSAGE);
                    }
                    //刷新
                    teachers[0] = getTeachers();
                }
            });
        }
        baseDialog.setVisible(true);
    }


    //添加老师对话框
    public void addTeacher(){
        JDialog jDialog = new JDialog(this,"添加老师",true);
        JPanel jPanel = new JPanel();
        jDialog.setContentPane(jPanel);
        jPanel.setLayout(new GridLayout(9,1));
        jDialog.setSize(400,400);
        jDialog.setLocationRelativeTo(null);
        //第一行：
        {
            JLabel jLabel = new JLabel();
            jLabel.setFont(new Font("楷体", Font.PLAIN, 35));
            jLabel.setForeground(Color.BLUE);
            jLabel.setVerticalAlignment(SwingConstants.CENTER);
            jLabel.setHorizontalAlignment(SwingConstants.CENTER);
            jLabel.setText("添加老师");
            jPanel.add(jLabel);
        }
        JTextField no = new JTextField(20);
        JTextField name = new JTextField(20);
        JComboBox<String> sex = new JComboBox<>(new String[]{"请选择","男","女"});
        JTextField birthday = new JTextField(20);
        JTextField position = new JTextField(20);
        JPasswordField password = new JPasswordField(20);
        JPasswordField com_password = new JPasswordField(20);
        //第二行：输入学号
        {
            JPanel jPanel1 = new JPanel();
            jPanel1.add(new JLabel("老师工号："));
            jPanel1.add(no);
            jPanel.add(jPanel1);
        }
        //第三行：输入姓名
        {
            JPanel jPanel1 = new JPanel();
            jPanel1.add(new JLabel("老师姓名："));
            jPanel1.add(name);
            jPanel.add(jPanel1);
        }
        //第四行：选择性别
        {
            JPanel jPanel1 = new JPanel();
            jPanel1.add(new JLabel("老师性别："));
            jPanel1.add(sex);
            jPanel.add(jPanel1);
        }
        //第五行：出生日期
        {
            JPanel jPanel1 = new JPanel();
            jPanel1.add(new JLabel("出生日期："));
            jPanel1.add(birthday);
            jPanel.add(jPanel1);
        }
        //第六行：职称
        {
            JPanel jPanel1 = new JPanel();
            jPanel1.add(new JLabel("职称："));
            jPanel1.add(position);
            jPanel.add(jPanel1);
        }
        //第七行：密码
        {
            JPanel jPanel1 = new JPanel();
            jPanel1.add(new JLabel("密码："));
            jPanel1.add(password);
            jPanel.add(jPanel1);
        }
        //第八行：确认密码
        {
            JPanel jPanel1 = new JPanel();
            jPanel1.add(new JLabel("确认密码："));
            jPanel1.add(com_password);
            jPanel.add(jPanel1);
        }
        //第九行：确认按钮
        {
            JPanel jPanel1 = new JPanel();
            JButton jButton1 = new JButton("确认添加老师");
            JButton jButton2 = new JButton("取消添加老师");
            jPanel1.add(jButton1);
            jPanel1.add(jButton2);
            jPanel.add(jPanel1);
            jButton1.addActionListener((e)->{
                if(addTeacher(no.getText(),name.getText(),sex.getSelectedIndex(),birthday.getText(),position.getText(),new String(password.getPassword()),new String(com_password.getPassword()))){
                    jDialog.dispose();
                }
            });
            jButton2.addActionListener((e)->{
                jDialog.dispose();
            });

        }
        jDialog.setVisible(true);
    }


    //添加老师具体实现
    public boolean addTeacher(String no,String name,int sex,String birthday,String position,String password,String com_password){
        if(!CheckUtils.checkUsername(no)){
            JOptionPane.showMessageDialog(this, "账号格式错误，必须为5-10位数字", "error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(name.length() == 0 || name.length() > 20){
            JOptionPane.showMessageDialog(this, "名字长度必须为1-20", "error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(sex == 0){
            JOptionPane.showMessageDialog(this, "请选择性别", "error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(position.length() == 0 || position.length() > 10){
            JOptionPane.showMessageDialog(this, "职称长度必须为1-10", "error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birth = null;
        try {
            birth = simpleDateFormat.parse(birthday);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "日期输入错误，请保证日期存在且格式为yyyy-MM-dd", "error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(!CheckUtils.checkPassword(password)){
            JOptionPane.showMessageDialog(this, "密码格式错误，必须由6-16位的字母、数字、下划线组成", "error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(!password.equals(com_password)){
            JOptionPane.showMessageDialog(this, "两次输入的密码不一样！", "error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        TeacherService teacherService = applicationContext.getBean(TeacherService.class);
        if(teacherService.selectByPrimaryKey(no) != null){
            JOptionPane.showMessageDialog(this, "该工号已经存在！", "error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        Teacher teacher = new Teacher();
        teacher.settNo(no);
        teacher.settName(name);
        teacher.settSex(sex);
        teacher.settPosition(position);
        teacher.settPassword(password);
        teacher.settBirthday(birth);
        int i = teacherService.insert(teacher);
        if(i > 0){
            JOptionPane.showMessageDialog(this, "添加成功！", "successfully", JOptionPane.PLAIN_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "添加失败！", "error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    //删除老师
    public boolean deleteTeacher(Teacher teacher){
        TeacherServiceImpl teacherService = applicationContext.getBean(TeacherServiceImpl.class);
        return teacherService.deleteTeacher(teacher) > 0;
    }

}
