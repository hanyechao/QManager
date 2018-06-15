/*
Navicat MySQL Data Transfer

Source Server         : localMysql
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : springtest

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2018-06-15 15:18:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mockdata
-- ----------------------------
DROP TABLE IF EXISTS `mockdata`;
CREATE TABLE `mockdata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `interfaseName` varchar(255) DEFAULT NULL,
  `project_id` int(11) NOT NULL,
  `method` varchar(255) DEFAULT NULL,
  `content` longtext,
  `comment` longtext,
  `status` varchar(255) DEFAULT NULL,
  `bodyFileName` varchar(255) DEFAULT NULL,
  `headers` varchar(255) DEFAULT NULL,
  `fileName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mockdata
-- ----------------------------
INSERT INTO `mockdata` VALUES ('1', '/user/details1', '2', 'GET', '{ \"request\": { \"method\": \"POST\", \"url\": \"/api/products\", \"bodyPatterns\": [ {\"equalToJson\" : \"{ \\\"name\\\": \\\"new product\\\", \\\"creator\\\": \\\"tester\\\", \\\"createTime\\\": \\\"2015-09-07\\\" }\", \"jsonCompareMode\": \"LENIENT\"} ] }, \"response\": { \"status\": 201, \"body\": \"Add successfully.\", \"headers\":{ \"x-token\":\"xxxxxxxxxxxxxxxxxxxxxxxxxxxx\" } } }', null, '201', 'null', '{\"Content-Type\": \"application/json\"}	', '');
INSERT INTO `mockdata` VALUES ('2', '/user/details2', '2', 'GET', '{ \"request\": { \"method\": \"POST\", \"url\": \"/api/products\", \"bodyPatterns\": [ {\"equalToJson\" : \"{ \\\"name\\\": \\\"new product\\\", \\\"creator\\\": \\\"tester\\\", \\\"createTime\\\": \\\"2015-09-07\\\" }\", \"jsonCompareMode\": \"LENIENT\"} ] }, \"response\": { \"status\": 201, \"body\": \"Add successfully.\", \"headers\":{ \"x-token\":\"xxxxxxxxxxxxxxxxxxxxxxxxxxxx\" } } }', null, '200', 'null', '{\"Content-Type\": \"application/json\"}	', null);
INSERT INTO `mockdata` VALUES ('3', '/user/details3', '0', 'GET', '{ \"request\": { \"method\": \"POST\", \"url\": \"/api/products\", \"bodyPatterns\": [ {\"equalToJson\" : \"{ \\\"name\\\": \\\"new product\\\", \\\"creator\\\": \\\"tester\\\", \\\"createTime\\\": \\\"2015-09-07\\\" }\", \"jsonCompareMode\": \"LENIENT\"} ] }, \"response\": { \"status\": 201, \"body\": \"Add successfully.\", \"headers\":{ \"x-token\":\"xxxxxxxxxxxxxxxxxxxxxxxxxxxx\" } } }', null, '201', 'null', '{\"Content-Type\": \"application/json\"}	', null);
INSERT INTO `mockdata` VALUES ('4', '/user/details4', '0', 'GET', '{ \"request\": { \"method\": \"POST\", \"url\": \"/api/products\", \"bodyPatterns\": [ {\"equalToJson\" : \"{ \\\"name\\\": \\\"new product\\\", \\\"creator\\\": \\\"tester\\\", \\\"createTime\\\": \\\"2015-09-07\\\" }\", \"jsonCompareMode\": \"LENIENT\"} ] }, \"response\": { \"status\": 201, \"body\": \"Add successfully.\", \"headers\":{ \"x-token\":\"xxxxxxxxxxxxxxxxxxxxxxxxxxxx\" } } }', null, '500', 'null', '{\"Content-Type\": \"application/json\"}	', null);
INSERT INTO `mockdata` VALUES ('5', '/user/details5', '0', 'GET', '{ \"request\": { \"method\": \"POST\", \"url\": \"/api/products\", \"bodyPatterns\": [ {\"equalToJson\" : \"{ \\\"name\\\": \\\"new product\\\", \\\"creator\\\": \\\"tester\\\", \\\"createTime\\\": \\\"2015-09-07\\\" }\", \"jsonCompareMode\": \"LENIENT\"} ] }, \"response\": { \"status\": 201, \"body\": \"Add successfully.\", \"headers\":{ \"x-token\":\"xxxxxxxxxxxxxxxxxxxxxxxxxxxx\" } } }', null, '501', 'null', '{\"Content-Type\": \"application/json\"}	', null);
INSERT INTO `mockdata` VALUES ('6', '/user/details6', '1', 'GET', '{ \"request\": { \"method\": \"POST\", \"url\": \"/api/products\", \"bodyPatterns\": [ {\"equalToJson\" : \"{ \\\"name\\\": \\\"new product\\\", \\\"creator\\\": \\\"tester\\\", \\\"createTime\\\": \\\"2015-09-07\\\" }\", \"jsonCompareMode\": \"LENIENT\"} ] }, \"response\": { \"status\": 201, \"body\": \"Add successfully.\", \"headers\":{ \"x-token\":\"xxxxxxxxxxxxxxxxxxxxxxxxxxxx\" } } }', null, '505', 'null', '{\"Content-Type\": \"application/json\"}	', null);
INSERT INTO `mockdata` VALUES ('7', '/user/details7', '1', 'GET', '{ \"request\": { \"method\": \"POST\", \"url\": \"/api/products\", \"bodyPatterns\": [ {\"equalToJson\" : \"{ \\\"name\\\": \\\"new product\\\", \\\"creator\\\": \\\"tester\\\", \\\"createTime\\\": \\\"2015-09-07\\\" }\", \"jsonCompareMode\": \"LENIENT\"} ] }, \"response\": { \"status\": 201, \"body\": \"Add successfully.\", \"headers\":{ \"x-token\":\"xxxxxxxxxxxxxxxxxxxxxxxxxxxx\" } } }', null, '301', 'null', '{\"Content-Type\": \"application/json\"}	', null);
INSERT INTO `mockdata` VALUES ('8', '/user/details8', '1', 'GET', '{ \"request\": { \"method\": \"POST\", \"url\": \"/api/products\", \"bodyPatterns\": [ {\"equalToJson\" : \"{ \\\"name\\\": \\\"new product\\\", \\\"creator\\\": \\\"tester\\\", \\\"createTime\\\": \\\"2015-09-07\\\" }\", \"jsonCompareMode\": \"LENIENT\"} ] }, \"response\": { \"status\": 201, \"body\": \"Add successfully.\", \"headers\":{ \"x-token\":\"xxxxxxxxxxxxxxxxxxxxxxxxxxxx\" } } }', null, '200', 'null', '{\"Content-Type\": \"application/json\"}	', null);
INSERT INTO `mockdata` VALUES ('9', '/user/details9', '1', 'GET', '{ \"request\": { \"method\": \"POST\", \"url\": \"/api/products\", \"bodyPatterns\": [ {\"equalToJson\" : \"{ \\\"name\\\": \\\"new product\\\", \\\"creator\\\": \\\"tester\\\", \\\"createTime\\\": \\\"2015-09-07\\\" }\", \"jsonCompareMode\": \"LENIENT\"} ] }, \"response\": { \"status\": 201, \"body\": \"Add successfully.\", \"headers\":{ \"x-token\":\"xxxxxxxxxxxxxxxxxxxxxxxxxxxx\" } } }', null, '200', 'null', '{\"Content-Type\": \"application/json\"}	', null);
INSERT INTO `mockdata` VALUES ('10', '/user/details10', '1', 'GET', '{ \"request\": { \"method\": \"POST\", \"url\": \"/api/products\", \"bodyPatterns\": [ {\"equalToJson\" : \"{ \\\"name\\\": \\\"new product\\\", \\\"creator\\\": \\\"tester\\\", \\\"createTime\\\": \\\"2015-09-07\\\" }\", \"jsonCompareMode\": \"LENIENT\"} ] }, \"response\": { \"status\": 201, \"body\": \"Add successfully.\", \"headers\":{ \"x-token\":\"xxxxxxxxxxxxxxxxxxxxxxxxxxxx\" } } }', null, '200', 'null', '{\"Content-Type\": \"application/json\"}	', null);
INSERT INTO `mockdata` VALUES ('11', '/api/products', '6', 'POST', '{request={\"method\":\"POST\",\"bodyPatterns\":[{\"equalToJson\":\"{ \\\"name\\\": \\\"new product\\\", \\\"creator\\\": \\\"tester\\\", \\\"createTime\\\": \\\"2015-09-07\\\" }\",\"jsonCompareMode\":\"LENIENT\"}],\"url\":\"/api/products\"}, response={\"headers\":{\"x-token\":\"xxxxxxxxxxxxxxxxxxxxxxxxxxxx\"},\"body\":\"Add successfully.\",\"status\":201}}', null, '201', null, '{\"x-token\":\"xxxxxxxxxxxxxxxxxxxxxxxxxxxx\"}', null);
INSERT INTO `mockdata` VALUES ('12', '/api/products', '6', 'POST', '{ \"request\": { \"method\": \"POST\", \"url\": \"/api/products\", \"bodyPatterns\": [ {\"equalToJson\" : \"{ \\\"name\\\": \\\"new product\\\", \\\"creator\\\": \\\"tester\\\", \\\"createTime\\\": \\\"2015-09-07\\\" }\", \"jsonCompareMode\": \"LENIENT\"} ] }, \"response\": { \"status\": 201, \"body\": \"Add successfully.\", \"headers\":{ \"x-token\":\"xxxxxxxxxxxxxxxxxxxxxxxxxxxx\" } } }       ', null, '201', null, '{\"x-token\":\"xxxxxxxxxxxxxxxxxxxxxxxxxxxx\"}', null);
INSERT INTO `mockdata` VALUES ('13', '/api/products', '28', 'POST', '{ \"request\": { \"method\": \"POST\", \"url\": \"/api/products\", \"bodyPatterns\": [ {\"equalToJson\" : \"{ \\\"name\\\": \\\"new product\\\", \\\"creator\\\": \\\"tester\\\", \\\"createTime\\\": \\\"2015-09-07\\\" }\", \"jsonCompareMode\": \"LENIENT\"} ] }, \"response\": { \"status\": 201, \"body\": \"Add successfully.\", \"headers\":{ \"x-token\":\"xxxxxxxxxxxxxxxxxxxxxxxxxxxx\" } } }', null, '201', null, '{\"x-token\":\"xxxxxxxxxxxxxxxxxxxxxxxxxxxx\"}', null);
INSERT INTO `mockdata` VALUES ('14', '/api/products', '1', 'POST', '{ \"request\": { \"method\": \"POST\", \"url\": \"/api/products\", \"bodyPatterns\": [ {\"equalToJson\" : \"{ \\\"name\\\": \\\"new product\\\", \\\"creator\\\": \\\"tester\\\", \\\"createTime\\\": \\\"2015-09-07\\\" }\", \"jsonCompareMode\": \"LENIENT\"} ] }, \"response\": { \"status\": 201, \"body\": \"Add successfully.\", \"headers\":{ \"x-token\":\"1111111\" } } }', null, '201', null, '{\"x-token\":\"1111111\"}', null);
INSERT INTO `mockdata` VALUES ('16', '/api/products', '2', 'POST', '{ \"request\": { \"method\": \"POST\", \"url\": \"/api/products\", \"bodyPatterns\": [ {\"equalToJson\" : \"{ \\\"name\\\": \\\"new product\\\", \\\"creator\\\": \\\"tester\\\", \\\"createTime\\\": \\\"2015-09-07\\\" }\", \"jsonCompareMode\": \"LENIENT\"} ] }, \"response\": { \"status\": 201, \"body\": \"Add successfully.\", \"headers\":{ \"x-token\":\"xxxxxxxxxxxxxxxxxxxxxxxxxxxx\" } } }', null, '201', null, '{\"x-token\":\"xxxxxxxxxxxxxxxxxxxxxxxxxxxx\"}', 'f2fbd5b7-5f7e-40fe-807f-ea83d2e8a69c_2.json');
INSERT INTO `mockdata` VALUES ('17', '/api/mytest', '1', 'GET', '{\n    \"request\": {\n        \"method\": \"GET\",\n        \"url\": \"/api/mytest\"\n    },\n    \"response\": {\n        \"status\": 200,\n        \"body\": \"More content\\n\"\n    }\n}', null, '200', null, null, '9b3d7502-5e49-4077-aa36-88079d6024a3_1.json');
INSERT INTO `mockdata` VALUES ('18', '/api/helloworld', '1', 'POST', '{\n    \"request\": {\n        \"method\": \"POST\",\n        \"url\": \"/api/helloworld\"\n    },\n    \"response\": {\n        \"status\": 200,\n        \"body\": \"helloworld!!!!\"\n    }\n}', null, '200', null, null, 'cd496617-5aec-49f0-bd2b-1bdd903b4a5f_1.json');
INSERT INTO `mockdata` VALUES ('19', '/api/add', '1', 'POST', '{  \n\"request\":{  \n\"url\":\"/api/add\",  \n\"method\":\"POST\"  \n  \n},  \n\"response\":{  \n\"status\":200,  \n\"body\":\"post body\"  \n  \n}  \n}  ', null, '200', null, null, '1ebd27fc-d51d-4798-b63c-db4b4655c014_1.json');
INSERT INTO `mockdata` VALUES ('20', '/api/hello', '1', 'POST', '{ \"request\":{ \"url\":\"/api/hello\", \"method\":\"POST\" }, \"response\":{ \"status\":200, \"body\":\"hello body\" } }', null, '200', null, null, 'dbbd2a0e-ab7f-439b-80d9-50793c239302_1.json');

-- ----------------------------
-- Table structure for mockd_data
-- ----------------------------
DROP TABLE IF EXISTS `mockd_data`;
CREATE TABLE `mockd_data` (
  `id` int(11) NOT NULL,
  `project_id` int(11) DEFAULT NULL,
  `request` longtext,
  `response` longtext,
  `url` varchar(255) DEFAULT NULL,
  `method` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `body` varchar(255) DEFAULT NULL,
  `headers` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mockd_data
-- ----------------------------

-- ----------------------------
-- Table structure for postman_info
-- ----------------------------
DROP TABLE IF EXISTS `postman_info`;
CREATE TABLE `postman_info` (
  `_postman_id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `schema` varchar(255) NOT NULL,
  PRIMARY KEY (`_postman_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of postman_info
-- ----------------------------

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectName` varchar(255) DEFAULT NULL,
  `projectDescribe` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('1', '煤炭江湖', '煤炭江湖描述');
INSERT INTO `project` VALUES ('2', '鳗鱼出行', '鳗鱼出行描述');

-- ----------------------------
-- Table structure for task_testcase
-- ----------------------------
DROP TABLE IF EXISTS `task_testcase`;
CREATE TABLE `task_testcase` (
  `taskId` varchar(64) NOT NULL,
  `testcaseId` varchar(64) NOT NULL,
  `cronExpresstion` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of task_testcase
-- ----------------------------

-- ----------------------------
-- Table structure for testcase
-- ----------------------------
DROP TABLE IF EXISTS `testcase`;
CREATE TABLE `testcase` (
  `testcaseId` varchar(64) NOT NULL,
  `testcaseName` varchar(255) NOT NULL,
  `requestContent` varchar(255) NOT NULL,
  `response` varchar(255) DEFAULT NULL,
  `url` varchar(255) NOT NULL,
  `requestType` int(10) NOT NULL,
  `verification` varchar(255) NOT NULL,
  PRIMARY KEY (`testcaseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of testcase
-- ----------------------------
INSERT INTO `testcase` VALUES ('11111', '测试用例', '', '', 'https://www.baidu.com/', '1', '111');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  `register_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '89921218@qq.com', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆', '1', '2017-06-23 14:24:23');
INSERT INTO `user` VALUES ('2', '2@qq.com', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-2', '1', '2017-06-23 14:24:23');
INSERT INTO `user` VALUES ('3', '3@qq.com', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-3', '1', '2017-06-23 14:24:23');
INSERT INTO `user` VALUES ('4', '4@qq.com', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-4', '1', '2017-06-23 14:24:23');
INSERT INTO `user` VALUES ('5', '5@qq.com', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-5', '1', '2017-06-23 14:24:23');
INSERT INTO `user` VALUES ('6', '6@qq.com', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-6', '1', '2017-06-23 14:24:23');
INSERT INTO `user` VALUES ('7', '7@qq.com', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-7', '1', '2017-06-23 14:24:23');
INSERT INTO `user` VALUES ('8', '8@qq.com', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-8', '1', '2017-06-23 14:24:23');
INSERT INTO `user` VALUES ('9', '9@qq.com', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-9', '1', '2017-06-23 14:24:23');
INSERT INTO `user` VALUES ('10', '10@qq.com', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-10', '1', '2017-06-23 14:24:23');
