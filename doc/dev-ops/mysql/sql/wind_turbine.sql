/*
 Navicat Premium Data Transfer

 Source Server         : AWS
 Source Server Type    : MySQL
 Source Server Version : 80042 (8.0.42)
 Source Host           : 192.168.1.99:3306
 Source Schema         : wind_turbine

 Target Server Type    : MySQL
 Target Server Version : 80042 (8.0.42)
 File Encoding         : 65001

 Date: 11/07/2025 16:42:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for region
-- ----------------------------
DROP TABLE IF EXISTS `region`;
CREATE TABLE `region`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '区域主键ID',
  `region_name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '区域名称',
  `region_code` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '区域编码（唯一标识）',
  `latitude` decimal(10, 6) NULL DEFAULT NULL COMMENT '区域中心点纬度',
  `longitude` decimal(10, 6) NULL DEFAULT NULL COMMENT '区域中心点经度',
  `remark` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '备注信息',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `region_code`(`region_code` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '风电区域信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of region
-- ----------------------------
INSERT INTO `region` VALUES (1, '张家港保税区', 'ZJG', 120.458470, 31.970510, '张家港保税区', '2025-07-09 09:50:08');

-- ----------------------------
-- Table structure for region_env
-- ----------------------------
DROP TABLE IF EXISTS `region_env`;
CREATE TABLE `region_env`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `region_id` bigint NOT NULL COMMENT '区域ID',
  `record_time` datetime NOT NULL COMMENT '采集时间（如每10分钟）',
  `weather_desc` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '天气描述（晴、多云、雨等）',
  `temperature` double NULL DEFAULT NULL COMMENT '气温（℃）',
  `humidity` double NULL DEFAULT NULL COMMENT '湿度（%）',
  `pressure` double NULL DEFAULT NULL COMMENT '气压（hPa）',
  `wind_speed` double NULL DEFAULT NULL COMMENT '风速（m/s）',
  `wind_direction` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '风向（如：东南风）',
  `wave_height` double NULL DEFAULT NULL COMMENT '海浪高度（米）',
  `wave_period` double NULL DEFAULT NULL COMMENT '波浪周期（秒）',
  `water_speed` double NULL DEFAULT NULL COMMENT '水流速度（m/s）',
  `water_temp` double NULL DEFAULT NULL COMMENT '海水温度（℃）',
  `visibility` double NULL DEFAULT NULL COMMENT '能见度（公里）',
  `uv_index` double NULL DEFAULT NULL COMMENT '紫外线指数',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_region_time`(`region_id` ASC, `record_time` ASC) USING BTREE,
  CONSTRAINT `region_env_ibfk_1` FOREIGN KEY (`region_id`) REFERENCES `region` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '区域历史环境数据（天气、风速、水速等）' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of region_env
-- ----------------------------

-- ----------------------------
-- Table structure for turbine_alert
-- ----------------------------
DROP TABLE IF EXISTS `turbine_alert`;
CREATE TABLE `turbine_alert`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `turbine_id` bigint NOT NULL COMMENT '风机ID',
  `alert_time` datetime NOT NULL COMMENT '报警时间',
  `error_code` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '错误码或异常类型',
  `alert_level` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '报警级别（如：警告、严重）',
  `description` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '报警描述',
  `is_processed` tinyint(1) NULL DEFAULT 0 COMMENT '是否已处理',
  `process_time` datetime NULL DEFAULT NULL COMMENT '处理时间',
  `process_user` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '处理人员',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_alert_turbine_time`(`turbine_id` ASC, `alert_time` ASC) USING BTREE,
  CONSTRAINT `turbine_alert_ibfk_1` FOREIGN KEY (`turbine_id`) REFERENCES `wind_turbine` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '风机异常报警记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of turbine_alert
-- ----------------------------
INSERT INTO `turbine_alert` VALUES (1, 1, '2025-07-09 10:09:16', 'E0001', '1', '测试错误', 1, '2025-07-09 10:09:37', 'xc');

-- ----------------------------
-- Table structure for turbine_data
-- ----------------------------
DROP TABLE IF EXISTS `turbine_data`;
CREATE TABLE `turbine_data`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `turbine_id` bigint NOT NULL COMMENT '风机ID，关联风机基础信息',
  `record_time` datetime NOT NULL COMMENT '数据采集时间（每10分钟一条）',
  `error_code` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '错误状态码或描述（异常时填写）',
  `avg_wind_speed` double NULL DEFAULT NULL COMMENT '平均风速',
  `max_wind_speed` double NULL DEFAULT NULL COMMENT '最大风速',
  `min_wind_speed` double NULL DEFAULT NULL COMMENT '最小风速',
  `avg_rotation` double NULL DEFAULT NULL COMMENT '平均转速',
  `max_rotation` double NULL DEFAULT NULL COMMENT '最大转速',
  `min_rotation` double NULL DEFAULT NULL COMMENT '最小转速',
  `avg_power` double NULL DEFAULT NULL COMMENT '平均有功功率',
  `max_power` double NULL DEFAULT NULL COMMENT '最大有功功率',
  `min_power` double NULL DEFAULT NULL COMMENT '最小有功功率',
  `reactive_power_avg` double NULL DEFAULT NULL COMMENT '平均无功功率',
  `reactive_power_max` double NULL DEFAULT NULL COMMENT '最大无功功率',
  `reactive_power_min` double NULL DEFAULT NULL COMMENT '最小无功功率',
  `available_p_from_wind` double NULL DEFAULT NULL COMMENT '风能提供的可用功率',
  `available_p_tech` double NULL DEFAULT NULL COMMENT '技术原因造成的功率损失',
  `available_p_force_majeure` double NULL DEFAULT NULL COMMENT '不可抗力因素造成的功率损失',
  `available_p_external` double NULL DEFAULT NULL COMMENT '外部原因造成的功率损失',
  `operating_hours` double NULL DEFAULT NULL COMMENT '运行小时数（累计）',
  `production_kwh` double NULL DEFAULT NULL COMMENT '累计发电量（kWh）',
  `production_minutes` int NULL DEFAULT NULL COMMENT '累计发电分钟数',
  `nacelle_position` double NULL DEFAULT NULL COMMENT '机舱方向（含电缆扭转）',
  `blade_angle_a` double NULL DEFAULT NULL COMMENT 'A叶片角度',
  `inverter_avg` double NULL DEFAULT NULL COMMENT '逆变器功率平均值',
  `inverter_std_dev` double NULL DEFAULT NULL COMMENT '逆变器功率标准差',
  `nacelle_temp` double NULL DEFAULT NULL COMMENT '机舱温度',
  `ambient_temp` double NULL DEFAULT NULL COMMENT '外部环境温度',
  `control_cabinet_temp` double NULL DEFAULT NULL COMMENT '控制柜温度',
  `front_bearing_temp` double NULL DEFAULT NULL COMMENT '前轴承温度',
  `rear_bearing_temp` double NULL DEFAULT NULL COMMENT '后轴承温度',
  `blade_a_temp` double NULL DEFAULT NULL COMMENT '叶片A温度',
  `blade_b_temp` double NULL DEFAULT NULL COMMENT '叶片B温度',
  `blade_c_temp` double NULL DEFAULT NULL COMMENT '叶片C温度',
  `rotor_temp_1` double NULL DEFAULT NULL COMMENT '转子温度1',
  `rotor_temp_2` double NULL DEFAULT NULL COMMENT '转子温度2',
  `stator_temp_1` double NULL DEFAULT NULL COMMENT '定子温度1',
  `stator_temp_2` double NULL DEFAULT NULL COMMENT '定子温度2',
  `tower_temp` double NULL DEFAULT NULL COMMENT '塔筒温度',
  `yaw_inverter_temp` double NULL DEFAULT NULL COMMENT '偏航逆变柜温度',
  `rectifier_cabinet_temp` double NULL DEFAULT NULL COMMENT '整流柜温度',
  `transformer_temp` double NULL DEFAULT NULL COMMENT '变压器温度',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_tid_time`(`turbine_id` ASC, `record_time` ASC) USING BTREE,
  CONSTRAINT `turbine_data_ibfk_1` FOREIGN KEY (`turbine_id`) REFERENCES `wind_turbine` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '风机10分钟监控数据表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of turbine_data
-- ----------------------------
INSERT INTO `turbine_data` VALUES (1, 1, '2025-07-09 09:50:29', '0', 11, 150, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2025-07-09 10:08:56');
INSERT INTO `turbine_data` VALUES (3, 1, '2025-07-09 10:26:46', '0', 11, 123, 321, 123, 321, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2025-07-09 10:26:58');

-- ----------------------------
-- Table structure for wind_turbine
-- ----------------------------
DROP TABLE IF EXISTS `wind_turbine`;
CREATE TABLE `wind_turbine`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '风机主键ID',
  `region_id` bigint NOT NULL COMMENT '所属区域ID',
  `turbine_code` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '风机编号（唯一）',
  `turbine_name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '风机名称',
  `status` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '风机状态（运行、维护、故障等）',
  `latitude` decimal(10, 6) NULL DEFAULT NULL COMMENT '风机纬度',
  `longitude` decimal(10, 6) NULL DEFAULT NULL COMMENT '风机经度',
  `install_date` date NULL DEFAULT NULL COMMENT '安装日期',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `turbine_code`(`turbine_code` ASC) USING BTREE,
  INDEX `region_id`(`region_id` ASC) USING BTREE,
  CONSTRAINT `wind_turbine_ibfk_1` FOREIGN KEY (`region_id`) REFERENCES `region` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '风机基础信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wind_turbine
-- ----------------------------
INSERT INTO `wind_turbine` VALUES (1, 1, '0001', '风力发电机1', '0', 120.458470, 31.970510, '2025-07-09', '2025-07-09 10:08:49');

SET FOREIGN_KEY_CHECKS = 1;
