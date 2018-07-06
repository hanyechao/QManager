/*
Navicat MySQL Data Transfer

Source Server         : localMysql
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : springtest

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2018-07-06 12:12:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for group_testcase
-- ----------------------------
DROP TABLE IF EXISTS `group_testcase`;
CREATE TABLE `group_testcase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cratetime` timestamp NOT NULL,
  `modifytime` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `group_id` varchar(64) DEFAULT NULL,
  `testcaseId` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of group_testcase
-- ----------------------------
INSERT INTO `group_testcase` VALUES ('105', '2018-07-06 11:34:44', '2018-07-06 11:34:44', '1fc94696-c0aa-452b-9a43-f55e8501fc00', '04f1715b-932a-4c87-867b-283e0abc7270');
INSERT INTO `group_testcase` VALUES ('106', '2018-07-06 11:35:08', '2018-07-06 11:35:08', '1fc94696-c0aa-452b-9a43-f55e8501fc00', 'c0134e20-cda0-44bf-ac2f-233258eca443');
INSERT INTO `group_testcase` VALUES ('107', '2018-07-06 11:52:25', '2018-07-06 11:52:25', '4bfa71b9-8b6e-4c3a-96b1-a9711ac9ef8a', '75b5bc43-2eef-45e4-97aa-5e568bd68deb');
INSERT INTO `group_testcase` VALUES ('108', '2018-07-06 11:53:13', '2018-07-06 11:53:13', '1fc94696-c0aa-452b-9a43-f55e8501fc00', '75b5bc43-2eef-45e4-97aa-5e568bd68deb');
INSERT INTO `group_testcase` VALUES ('109', '2018-07-06 11:55:44', '2018-07-06 11:55:44', '4bfa71b9-8b6e-4c3a-96b1-a9711ac9ef8a', 'df27310f-d047-4892-8623-b05faba18a4e');

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
-- Table structure for mock_data_new
-- ----------------------------
DROP TABLE IF EXISTS `mock_data_new`;
CREATE TABLE `mock_data_new` (
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
-- Records of mock_data_new
-- ----------------------------

-- ----------------------------
-- Table structure for postman_info
-- ----------------------------
DROP TABLE IF EXISTS `postman_info`;
CREATE TABLE `postman_info` (
  `_postman_id` varchar(64) CHARACTER SET utf8mb4 NOT NULL,
  `name` varchar(255) NOT NULL,
  `schema` varchar(255) NOT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`_postman_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of postman_info
-- ----------------------------

-- ----------------------------
-- Table structure for postman_itemlist
-- ----------------------------
DROP TABLE IF EXISTS `postman_itemlist`;
CREATE TABLE `postman_itemlist` (
  `itemId` varchar(128) CHARACTER SET utf8mb4 NOT NULL,
  `_postman_id` varchar(128) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `request` text,
  `response` text,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`itemId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of postman_itemlist
-- ----------------------------

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectName` varchar(255) DEFAULT NULL,
  `projectDescribe` varchar(255) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT NULL,
  `modifytime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `project_id` varchar(64) NOT NULL,
  PRIMARY KEY (`id`,`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('19', '煤炭江湖', '', '2018-07-04 18:08:11', '2018-07-04 18:08:11', '93e221f8-100b-4cf6-a5d7-32cd9c0d3938');

-- ----------------------------
-- Table structure for task_group
-- ----------------------------
DROP TABLE IF EXISTS `task_group`;
CREATE TABLE `task_group` (
  `cratetime` timestamp NULL DEFAULT NULL,
  `modifytime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `group_id` varchar(64) NOT NULL,
  `group_name` varchar(255) DEFAULT NULL,
  `group_describe` varchar(255) DEFAULT NULL,
  `isRun` tinyint(4) unsigned zerofill NOT NULL DEFAULT '0000',
  `cron_expression` varchar(64) DEFAULT NULL,
  `count` int(11) DEFAULT '0',
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of task_group
-- ----------------------------
INSERT INTO `task_group` VALUES ('2018-07-06 11:34:35', '2018-07-06 11:53:35', '1fc94696-c0aa-452b-9a43-f55e8501fc00', '运行中的定时任务', '', '0000', '0/5 * * * * ?', '3');
INSERT INTO `task_group` VALUES ('2018-07-06 11:52:17', '2018-07-06 11:55:44', '4bfa71b9-8b6e-4c3a-96b1-a9711ac9ef8a', '定时任务测试', '', '0001', '0/5 * * * * ?', '2');
INSERT INTO `task_group` VALUES ('2018-07-06 11:30:07', '2018-07-06 11:30:14', 'fd10ef9c-2f8c-452f-baf6-7765362c15b7', '测试', '测试', '0000', '0/5 * * * * ?', '2');

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
  `projectId` varchar(64) NOT NULL,
  PRIMARY KEY (`testcaseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of testcase
-- ----------------------------
INSERT INTO `testcase` VALUES ('04f1715b-932a-4c87-867b-283e0abc7270', '测试用例', '', null, 'https://www.easy-mock.com/mock/5afbfcbf5f03f365b8a8d79f/example/query', '1', '', '93e221f8-100b-4cf6-a5d7-32cd9c0d3938');
INSERT INTO `testcase` VALUES ('75b5bc43-2eef-45e4-97aa-5e568bd68deb', '测试', '', null, 'https://www.easy-mock.com/mock/5afbfcbf5f03f365b8a8d79f/example/query', '1', '', 'other');
INSERT INTO `testcase` VALUES ('c0134e20-cda0-44bf-ac2f-233258eca443', '测试', '', null, 'https://www.easy-mock.com/mock/5afbfcbf5f03f365b8a8d79f/example/query', '1', '', '93e221f8-100b-4cf6-a5d7-32cd9c0d3938');
INSERT INTO `testcase` VALUES ('df27310f-d047-4892-8623-b05faba18a4e', '测试', '', null, 'https://www.easy-mock.com/mock/5afbfcbf5f03f365b8a8d79f/example/query', '1', '', 'other');

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
