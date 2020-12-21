DROP TABLE IF EXISTS `wx_user`;
CREATE TABLE `wx_user` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`open_id` varchar(255) DEFAULT NULL COMMENT '微信openid，微信内唯一标识码',
`union_id` varchar(255) DEFAULT NULL COMMENT '腾讯体系用户唯一表示，包括公众号，小程序',
`base_user_id` int(11) DEFAULT NULL COMMENT '基础用户id',
`create_time` datetime DEFAULT NULL COMMENT '创建用户',
`modify_time` datetime DEFAULT NULL COMMENT '编辑时间',
`create_user_id` int(11) DEFAULT NULL comment '创建者id',
`modify_user_id` int(11) DEFAULT NULL COMMENT '编辑者id',
`status` int(2) DEFAULT NULL COMMENT '状态，1：正常,0禁用，-1删除',
`remark` text DEFAULT NULL COMMENT '备注',
PRIMARY KEY (`id`)
) comment '微信用户' ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4;