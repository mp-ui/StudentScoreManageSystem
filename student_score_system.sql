/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : student_score_system

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 22/05/2021 23:53:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `a_no` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `a_password` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`a_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('10086', '123456');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `c_no` int(11) NOT NULL AUTO_INCREMENT,
  `t_no` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `c_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `c_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `c_credit` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`c_no`) USING BTREE,
  INDEX `t_no`(`t_no`) USING BTREE,
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`t_no`) REFERENCES `teacher` (`t_no`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, '1008611', '程序设计基础', '专业必修课程', 3);
INSERT INTO `course` VALUES (2, '1008611', '离散数学', '专业必修课程', 3);
INSERT INTO `course` VALUES (3, '1008612', '数据结构', '专业必修课程', 2);
INSERT INTO `course` VALUES (6, '1008612', '编译原理', '专业选修课程', 2);

-- ----------------------------
-- Table structure for sc
-- ----------------------------
DROP TABLE IF EXISTS `sc`;
CREATE TABLE `sc`  (
  `c_no` int(11) NOT NULL,
  `s_no` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `score` int(11) NOT NULL DEFAULT -1,
  INDEX `c_no`(`c_no`) USING BTREE,
  INDEX `s_no`(`s_no`) USING BTREE,
  CONSTRAINT `sc_ibfk_1` FOREIGN KEY (`c_no`) REFERENCES `course` (`c_no`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `sc_ibfk_2` FOREIGN KEY (`s_no`) REFERENCES `student` (`s_no`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sc
-- ----------------------------
INSERT INTO `sc` VALUES (3, '1906300101', 100);
INSERT INTO `sc` VALUES (2, '1906300102', 88);
INSERT INTO `sc` VALUES (1, '1906300102', 66);
INSERT INTO `sc` VALUES (3, '1906300102', 79);
INSERT INTO `sc` VALUES (1, '1906300101', 98);
INSERT INTO `sc` VALUES (2, '1906300101', 99);
INSERT INTO `sc` VALUES (6, '1906300101', 60);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `s_no` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `s_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `s_birthday` date NOT NULL,
  `s_sex` int(11) NOT NULL DEFAULT 0,
  `s_password` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`s_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1906300101', '大哥', '2001-04-06', 1, '123456');
INSERT INTO `student` VALUES ('1906300102', '大海', '2000-10-04', 1, '123456');
INSERT INTO `student` VALUES ('1906300103', '小伦', '2000-12-18', 1, '123456');
INSERT INTO `student` VALUES ('1906300104', '坤坤酱', '2000-06-14', 1, '123456');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `t_no` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `t_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `t_position` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '讲师',
  `t_birthday` date NOT NULL,
  `t_sex` int(11) NOT NULL DEFAULT 0,
  `t_password` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`t_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1008611', '小汤', '副院长', '1956-12-13', 1, '123456');
INSERT INTO `teacher` VALUES ('1008612', '小张', '副院长', '1956-12-13', 2, '123456');

SET FOREIGN_KEY_CHECKS = 1;
