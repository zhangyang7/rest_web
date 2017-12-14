/***
	权限模块
**/
-- ----------------------------
-- 菜单资源表
-- Table structure for auth_resource_info
-- ----------------------------
CREATE TABLE `auth_resource_info` (
  `ID`  bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `NAME` varchar(50) NOT NULL COMMENT '资源名称',
  `PID` bigint(11) NOT NULL COMMENT '上级资源ID，顶级为-1',
  `RES_TYPE` varchar(10) NOT NULL COMMENT '资源类型，分类、菜单、按钮',
  `ORDERS` bigint(8) NULL COMMENT '排序',
  `SCRIPTURLS` varchar(300) NOT NULL COMMENT '资源URL，多个以分号隔开追加上去',
  `DESCRIPTION` varchar(200) NULL COMMENT '备注',
  `CREATE_TIME` datetime NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  INDEX `auth_resource_info` (`id`) USING BTREE
);

-- ----------------------------
-- 角色信息表
-- Table structure for auth_role_info
-- ----------------------------
CREATE TABLE `auth_role_info` (
  `ID` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `ROLE_CODE` varchar(15) NOT NULL COMMENT '角色编码',
  `ROLE_NAME` varchar(50) NOT NULL COMMENT '角色名称  ',
  `PID` bigint(1) NOT NULL COMMENT '上级角色ID，主要用于逐级权限分配时的角色范围控制，顶级为-1',
  `DESCRIPTION` varchar(200) COMMENT '描述',
  `STATUS` int(1) NOT NULL COMMENT '状态',
  `TYPE` int(1) NOT NULL COMMENT '角色类型',
  `CREATE_TIME` datetime NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  INDEX `auth_role_info` (`id`) USING BTREE
);

-- ----------------------------
-- 角色与菜单资源关联表
-- Table structure for auth_role_resources_rel
-- ----------------------------
CREATE TABLE `auth_role_resources_rel` (
  `ID` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `ROLE_ID` bigint(11) NOT NULL COMMENT '角色ID',
  `RES_ID` bigint(11) NOT NULL COMMENT '资源ID',
  `CREATE_TIME` datetime NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  INDEX `auth_role_resources_rel` (`id`) USING BTREE,
  INDEX `auth_R_RES_REL_ROLEID` (`ROLE_ID`) USING BTREE,
  INDEX `auth_R_RES_REL_RESID` (`RES_ID`) USING BTREE
);


-- ----------------------------
-- 用户与角色关联表
-- Table structure for auth_user_role_rel
-- ----------------------------
CREATE TABLE `auth_user_role_rel` (
  `ID` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `USER_ID` bigint(11) NOT NULL COMMENT '用户ID ',
  `ROLE_ID` bigint(11) NOT NULL COMMENT '角色ID',
  `CREATE_TIME` datetime NULL COMMENT '创建时间',
  `RESTRAINT` varchar(200) NULL COMMENT '约束',
  PRIMARY KEY (`id`),
  INDEX `auth_user_role_rel` (`id`) USING BTREE,
  INDEX `auth_U_ROLE_REL_ROLEID` (`ROLE_ID`) USING BTREE,
  INDEX `auth_U_ROLE_REL_USERID` (`USER_ID`) USING BTREE
);

-- ----------------------------
-- 组织信息表
-- Table structure for auth_org_info
-- ----------------------------
CREATE TABLE `auth_org_info` (
`ID`  bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID' ,
`ORGID`  varchar(90) NULL DEFAULT NULL COMMENT '组织编码' ,
`DISPLAYNAME`  varchar(900) NULL DEFAULT NULL COMMENT '组织全称' ,
`INITIALS`  varchar(450) NULL DEFAULT NULL COMMENT '组织简称' ,
`DESCRIPTION`  varchar(900) NULL DEFAULT NULL COMMENT '描述' ,
`STATUS`  varchar(3) NULL DEFAULT NULL COMMENT '状态' ,
`PARENTORGID`  varchar(90) NULL DEFAULT NULL COMMENT '上级组织编码' ,
`ORGTYPE`  varchar(30) NULL DEFAULT NULL COMMENT '组织类型' ,
`ORGLEVEL`  varchar(3) NULL DEFAULT NULL COMMENT '组织级别' ,
`DISPLAYORDER`  varchar(30) NULL DEFAULT NULL COMMENT '排序号' ,
`VICEMANAGER`  varchar(300) NULL DEFAULT NULL COMMENT '组织管理员' ,
`CREATETIME`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
`LASTUPDATETIME`  datetime NULL DEFAULT NULL COMMENT '最近更新时间' ,
PRIMARY KEY (`ID`),
INDEX `UUMS_ORG_INFO_OID` (`ORGID`) USING BTREE ,
INDEX `UUMS_ORG_INFO_POID` (`PARENTORGID`) USING BTREE
);


-- ----------------------------
-- 用户信息表
-- Table structure for auth_user_info
-- ----------------------------
CREATE TABLE `auth_user_info` (
`id`  bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
`password`  varchar(128) NOT NULL COMMENT '用户密码',
`last_login`  datetime(6) NULL DEFAULT NULL COMMENT '最后登录时间',
`is_superuser`  int(1) NOT NULL COMMENT '是否是管理员用户',
`user_name`  varchar(30) NOT NULL COMMENT '用户账号',
`first_name`  varchar(30) NULL COMMENT '姓',
`last_name`  varchar(30) NULL COMMENT '名',
`mobile`  varchar(15) NULL COMMENT '手机',
`email`  varchar(50) NOT NULL COMMENT '邮箱',
`group_name`  varchar(30) NULL COMMENT '所属的组或部门',
`is_staff`  int(1) NOT NULL,
`is_active`  int(1) NOT NULL COMMENT '状态，1正常，0注销',
`date_joined`  datetime NOT NULL COMMENT '创建时间',
`credit`  bigint(20) NULL DEFAULT NULL COMMENT '授信额度' ,
PRIMARY KEY (`id`),
UNIQUE INDEX `user_name` (`user_name`) USING BTREE 
);

