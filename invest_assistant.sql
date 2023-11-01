/*
 Navicat Premium Data Transfer

 Source Server         : fintechSystem
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : localhost:3306
 Source Schema         : invest_assistant

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 01/11/2023 16:20:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer`  (
  `id` int NOT NULL,
  `question` int NULL DEFAULT NULL,
  `option` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of answer
-- ----------------------------

-- ----------------------------
-- Table structure for possession
-- ----------------------------
DROP TABLE IF EXISTS `possession`;
CREATE TABLE `possession`  (
  `id` int NOT NULL,
  `product_code` int NULL DEFAULT NULL,
  `purchase_price` decimal(10, 2) NULL DEFAULT NULL,
  `amount` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of possession
-- ----------------------------

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `code` int NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `details` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `anti_risk` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `flexibility` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `return_rate` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, '美的集团股票', '美的集团背景、走势', 2000.00, '1', '1', '1', '1（收藏）');

-- ----------------------------
-- Table structure for question_option
-- ----------------------------
DROP TABLE IF EXISTS `question_option`;
CREATE TABLE `question_option`  (
  `id` int NOT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `question` int NULL DEFAULT NULL,
  `value` int NULL DEFAULT NULL,
  `question_type` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question_option
-- ----------------------------

-- ----------------------------
-- Table structure for question_title
-- ----------------------------
DROP TABLE IF EXISTS `question_title`;
CREATE TABLE `question_title`  (
  `id` int NOT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question_title
-- ----------------------------

-- ----------------------------
-- Table structure for trade_record
-- ----------------------------
DROP TABLE IF EXISTS `trade_record`;
CREATE TABLE `trade_record`  (
  `id` int NOT NULL,
  `product_code` int NULL DEFAULT NULL,
  `purchase_price` decimal(10, 2) NULL DEFAULT NULL,
  `amount` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `deal_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of trade_record
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
