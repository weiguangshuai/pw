-- ---------------------------
-- table structure for user
-- ---------------------------
CREATE TABLE `user` (
  `user_id`   BIGINT       NOT NULL AUTO_INCREMENT
  COMMENT '用户ID',
  `username`  VARCHAR(120) NOT NULL
  COMMENT '用户名',
  `password`  VARCHAR(32)  NOT NULL
  COMMENT '用户密码',
  `authority` INT          NOT NULL
  COMMENT '用户权限',
  `email`     VARCHAR(32)  NOT NULL
  COMMENT '用户邮箱',

  PRIMARY KEY (`user_id`),
  KEY `username_password_index`(`username`, `password`) USING BTREE
)
  ENGINE = INNODB
  AUTO_INCREMENT = 100
  DEFAULT CHARSET = utf8
  COMMENT '用户信息表';

-- ---------------------
-- table structure for confirm_info
-- ---------------------
DROP TABLE IF EXISTS `confirm_info`;
CREATE TABLE `confirm_info` (
  `confirm_id` INT         NOT NULL AUTO_INCREMENT,
  `name`       VARCHAR(20) NOT NULL,
  `email`      VARCHAR(20) NOT NULL,
  `phone`      VARCHAR(20) NOT NULL,
  `address`    VARCHAR(20) NOT NULL,
  `user_id`    INT         NOT NULL,
  PRIMARY KEY (`confirm_id`)
)
  ENGINE = INNODB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8;

-- ------------------
-- table structure for document
-- ------------------

DROP TABLE IF EXISTS `document`;
CREATE TABLE `document` (
  `doc_id`      INT          NOT NULL AUTO_INCREMENT,
  `content`     TEXT         NOT NULL,
  `title`       VARCHAR(100) NOT NULL,
  `software_id` INT          NOT NULL,
  PRIMARY KEY (`doc_id`)
)
  ENGINE = INNODB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8
  COMMENT '文档表';
-- ------------------
-- table structure for software
-- ------------------
DROP TABLE IF EXISTS `software`;
CREATE TABLE `software` (
  `software_id`   INT         NOT NULL AUTO_INCREMENT,
  `path`          VARCHAR(100),
  `software_name` VARCHAR(20) NOT NULL,
  `introduction`  VARCHAR(50),
  `user_id`       INT         NOT NULL,
  PRIMARY KEY (`software_id`)
)
  ENGINE = INNODB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8
  COMMENT '软件表';

