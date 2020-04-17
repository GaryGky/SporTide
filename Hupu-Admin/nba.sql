/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : nba

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 17/04/2020 19:17:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admins
-- ----------------------------
DROP TABLE IF EXISTS `admins`;
CREATE TABLE `admins`  (
  `admin_id` int(8) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `admin_pwd` blob NOT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admins
-- ----------------------------
INSERT INTO `admins` VALUES (1, 'ad1', 0x89B9E80987FB64E6EC11C8299C7D821B);
INSERT INTO `admins` VALUES (2, 'ad2', 0x741BAD4129296EC862E3757925615481);
INSERT INTO `admins` VALUES (3, 'ad3', 0x828C5AD322251AD862192EAE84FB7C32);
INSERT INTO `admins` VALUES (4, 'ad4', 0x079BB5D934CD9435CE536EA30D062216);
INSERT INTO `admins` VALUES (5, 'ad5', 0x8DA6AD3E9FA24348DD75B9C6F797A599);
INSERT INTO `admins` VALUES (6, 'ad6', 0xA0DA9E10260D34E786251E5967C97C77);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` int(16) NOT NULL,
  `comment_info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `comment_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `comment_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `post_id` int(8) NOT NULL,
  `to_uid` int(8) NOT NULL,
  `from_uid` int(8) NULL DEFAULT NULL,
  PRIMARY KEY (`comment_id`) USING BTREE,
  INDEX `ref-post`(`post_id`) USING BTREE,
  INDEX `from-uid`(`from_uid`) USING BTREE,
  INDEX `to-uid`(`to_uid`) USING BTREE,
  CONSTRAINT `from-uid` FOREIGN KEY (`from_uid`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `ref-post` FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `to-uid` FOREIGN KEY (`to_uid`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, 'info2', 'status', 'time1', 1, 3, 1);
INSERT INTO `comment` VALUES (2, 'info3', 'status', 'time1', 1, 1, 2);
INSERT INTO `comment` VALUES (3, 'info1', 'status', 'time1', 2, 2, 3);

-- ----------------------------
-- Table structure for game_base_info
-- ----------------------------
DROP TABLE IF EXISTS `game_base_info`;
CREATE TABLE `game_base_info`  (
  `game_id` int(11) NOT NULL,
  `开赛` varchar(31) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `耗时` varchar(31) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `球馆` varchar(31) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `上座` varchar(31) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`game_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for game_recap
-- ----------------------------
DROP TABLE IF EXISTS `game_recap`;
CREATE TABLE `game_recap`  (
  `game_id` int(11) NOT NULL,
  `标题` varchar(31) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `内容` varchar(511) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `更新时间` varchar(31) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `精彩瞬间` varchar(31) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`game_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for game_score_info
-- ----------------------------
DROP TABLE IF EXISTS `game_score_info`;
CREATE TABLE `game_score_info`  (
  `game_id` int(11) NOT NULL,
  `队名` varchar(31) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `基本信息` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `一` int(11) NULL DEFAULT NULL,
  `二` int(11) NULL DEFAULT NULL,
  `三` int(11) NULL DEFAULT NULL,
  `四` int(11) NULL DEFAULT NULL,
  `总分` int(11) NULL DEFAULT NULL,
  `球队链接` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`game_id`) USING BTREE,
  UNIQUE INDEX `game_score_info_game_id_uindex`(`game_id`) USING BTREE,
  UNIQUE INDEX `game_score_info_队名_uindex`(`队名`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`  (
  `post_id` int(8) NOT NULL,
  `post_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `post_info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `post_time` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `post_collectnum` int(8) NULL DEFAULT 0,
  `post_commentnum` int(8) NULL DEFAULT 0,
  `post_readNum` int(8) NULL DEFAULT 0,
  `user_id` int(8) NULL DEFAULT NULL COMMENT '发表该消息的用户id',
  PRIMARY KEY (`post_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES (1, 'type1', 'info1', 'time1', 0, 0, 0, 1);
INSERT INTO `post` VALUES (2, 'type2', 'info2', 'time2', 0, 0, 0, 2);
INSERT INTO `post` VALUES (3, 'type3', 'info3', 'time3', 0, 0, 0, 3);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(8) NOT NULL,
  `user_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_password` blob NOT NULL,
  `user_nikename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '注册时间',
  `user_status` int(1) NOT NULL DEFAULT 0 COMMENT '默认0',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `user_user_id_uindex`(`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'email1', 0x138FED11BCCC85F921FE8BC09153FB0B, 'name1', 'time1', 0);
INSERT INTO `user` VALUES (2, 'email2', 0xF886D7E3DEE14220F94357378657AEF6, 'name2', 'time2', 0);
INSERT INTO `user` VALUES (3, 'email3', 0xAC0F59980EA8B0B05C4904E46E5F288D, 'name3', 'time3', 0);

SET FOREIGN_KEY_CHECKS = 1;
