/*
 Navicat Premium Data Transfer

 Source Server         : 
 Source Server Type    : MySQL
 Source Server Version : 80031
 Source Host           : localhost:3306
 Source Schema         : book

 Target Server Type    : MySQL
 Target Server Version : 80031
 File Encoding         : 65001

 Date: 13/12/2022 09:49:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `press` varchar(40) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `author` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `price` int DEFAULT NULL,
  `num` int DEFAULT NULL,
  `type` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `max` int DEFAULT '0' COMMENT '最大数量\n',
  `info` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

-- ----------------------------
-- Records of book
-- ----------------------------
BEGIN;
INSERT INTO `book` (`id`, `name`, `press`, `author`, `price`, `num`, `type`, `max`, `info`) VALUES (14, '上海上海', '北疆大学', '李四', 15, 100, '传记', 100, 'B楼3层东北区6号书架');
INSERT INTO `book` (`id`, `name`, `press`, `author`, `price`, `num`, `type`, `max`, `info`) VALUES (16, '北京北京', '北京大学出版社', '张三', 16, 100, '小说', 100, '北京大学出版社');
INSERT INTO `book` (`id`, `name`, `press`, `author`, `price`, `num`, `type`, `max`, `info`) VALUES (17, '张三自传', '俄文', '张三', 0, 0, '', 0, '');
INSERT INTO `book` (`id`, `name`, `press`, `author`, `price`, `num`, `type`, `max`, `info`) VALUES (19, '张三自传12', '俄文', '张三', 0, 0, '', 0, '');
INSERT INTO `book` (`id`, `name`, `press`, `author`, `price`, `num`, `type`, `max`, `info`) VALUES (20, '张三自传123', '俄文', '张三', 0, 0, '', 0, '');
INSERT INTO `book` (`id`, `name`, `press`, `author`, `price`, `num`, `type`, `max`, `info`) VALUES (21, '张三自传1234', '俄文', '张三', 0, 0, '', 0, '');
INSERT INTO `book` (`id`, `name`, `press`, `author`, `price`, `num`, `type`, `max`, `info`) VALUES (22, '张三自传12345', '俄文', '张三', 0, 0, '', 0, '');
INSERT INTO `book` (`id`, `name`, `press`, `author`, `price`, `num`, `type`, `max`, `info`) VALUES (23, '张三自传123456', '俄文', '张三', 0, 0, '', 0, '');
INSERT INTO `book` (`id`, `name`, `press`, `author`, `price`, `num`, `type`, `max`, `info`) VALUES (27, '张三', '', '', 0, 123, '', 124, '');
COMMIT;

-- ----------------------------
-- Table structure for lend
-- ----------------------------
DROP TABLE IF EXISTS `lend`;
CREATE TABLE `lend` (
  `uname` varchar(20) COLLATE utf8mb3_bin DEFAULT NULL,
  `bname` varchar(40) COLLATE utf8mb3_bin DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

-- ----------------------------
-- Records of lend
-- ----------------------------
BEGIN;
INSERT INTO `lend` (`uname`, `bname`, `id`) VALUES ('zhangsan', '', 1);
INSERT INTO `lend` (`uname`, `bname`, `id`) VALUES ('zhangsan', '张三自传', 2);
INSERT INTO `lend` (`uname`, `bname`, `id`) VALUES ('李四', '张三', 4);
INSERT INTO `lend` (`uname`, `bname`, `id`) VALUES ('试试', '张三', 5);
INSERT INTO `lend` (`uname`, `bname`, `id`) VALUES ('第三方', '张三', 6);
INSERT INTO `lend` (`uname`, `bname`, `id`) VALUES ('第三方奥德赛', '张三', 7);
INSERT INTO `lend` (`uname`, `bname`, `id`) VALUES ('第三方奥德赛岸上的', '张三', 8);
INSERT INTO `lend` (`uname`, `bname`, `id`) VALUES ('第三方奥德赛岸上的阿萨德', '张三', 9);
INSERT INTO `lend` (`uname`, `bname`, `id`) VALUES ('阿迪', '张三', 10);
INSERT INTO `lend` (`uname`, `bname`, `id`) VALUES ('asdasd', '张三', 11);
INSERT INTO `lend` (`uname`, `bname`, `id`) VALUES ('rewerwer', '张三', 12);
INSERT INTO `lend` (`uname`, `bname`, `id`) VALUES ('张三', '张三', 13);
INSERT INTO `lend` (`uname`, `bname`, `id`) VALUES ('啊啊打断', '张三', 14);
INSERT INTO `lend` (`uname`, `bname`, `id`) VALUES ('啊啊打断啊实', '张三', 15);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `username` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `status` int DEFAULT '0',
  `student` int DEFAULT '0' COMMENT '如果是学生则是1，不是学生则是0\n',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`id`, `name`, `username`, `password`, `status`, `student`) VALUES (1, 'Admin', 'admin', '123', 0, 0);
INSERT INTO `user` (`id`, `name`, `username`, `password`, `status`, `student`) VALUES (7, '123', '123', '123', 0, 0);
INSERT INTO `user` (`id`, `name`, `username`, `password`, `status`, `student`) VALUES (8, '123', '1234', '123', 0, 0);
INSERT INTO `user` (`id`, `name`, `username`, `password`, `status`, `student`) VALUES (9, '123', '12345', '123', 0, 0);
INSERT INTO `user` (`id`, `name`, `username`, `password`, `status`, `student`) VALUES (10, '12341254grwerf更热热风c ', '123456', '123', 0, 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
