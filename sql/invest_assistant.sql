/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80031
 Source Host           : localhost:3306
 Source Schema         : invest_assistant

 Target Server Type    : MySQL
 Target Server Version : 80031
 File Encoding         : 65001

 Date: 09/11/2023 18:50:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer`  (
  `id` int(0) NOT NULL,
  `question` int(0) NULL DEFAULT NULL,
  `option` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of answer
-- ----------------------------
INSERT INTO `answer` VALUES (1, 3, 7);
INSERT INTO `answer` VALUES (2, 14, 59);
INSERT INTO `answer` VALUES (3, 4, 12);

-- ----------------------------
-- Table structure for possession
-- ----------------------------
DROP TABLE IF EXISTS `possession`;
CREATE TABLE `possession`  (
  `id` int(0) NOT NULL,
  `product_id` int(0) NULL DEFAULT NULL,
  `purchase_price` decimal(10, 2) NULL DEFAULT NULL,
  `amount` int(0) NULL DEFAULT NULL,
  `sold` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` int(0) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `details` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `anti_risk` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `flexibility` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `return_rate` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (605599, '菜百股份', '北京菜市口百货股份有限公司主营业务为黄金珠宝商品的原料采购、款式设计、连锁销售和品牌运营。公司主要产品包括黄金饰品、贵金属文化产品、贵金属投资产品，以及钻翠珠宝饰品。菜百股份是“全国文明单位”和“全国模范劳动关系和谐企业”，曾荣获“中国质量奖提名奖”、“企业信用评价AAA级信用单位”、“中国黄金第一家”、“中国黄金行业社会责任杰出贡献奖”、“中国改革开放40周年珠宝行业社会贡献奖”、“北京市人民政府质量奖提名奖”等诸多荣誉或称号。公司是上金所业务委员会的委员单位，是中国珠宝玉石首饰行业协会副会长单位和中国黄金协会副会长单位，是中国金币特许零售商和北京2022年冬奥会和冬残奥会组织委员会特许零售商。公司管理层作为全国珠宝玉石标准化技术委员会（TC298）委员和全国首饰标准化技术委员会（TC256）委员，参与制定、修订黄金珠宝国家标准和行业标准。2019年，公司成为“中国珠宝玉石首饰品牌集群”首批标杆品牌集群副主席成员单位，并通过“国家级商贸服务业标准化试点”验收。', 13.51, '0.9949', '0.0019', '0.034', '1');
INSERT INTO `product` VALUES (605598, '上海港湾', '上海港湾基础建设(集团)股份有限公司主营业务是全球客户提供集勘察、设计、施工、监测于一体的岩土工程综合服务。公司主要产品及服务包括地基处理、桩基工程。公司荣获“军队科技进步一等奖”、教育部“科学技术进步奖一等奖”、“中国专利优秀奖”等奖项。', 26.96, '0.9967', '0.0121', '0.0024', '0');
INSERT INTO `product` VALUES (605589, '圣泉集团', '济南圣泉集团股份有限公司的主营业务是合成树脂及复合材料、生物质化工材料及新能源相关产品的研发、生产、销售。公司的主要产品为酚醛树脂、呋喃树脂、冷芯盒树脂、环氧树脂、过滤器、涂料、固化剂、木糖、纤维素、木质素。近年来公司荣获“第三届（2019年）中国电子材料行业五十强企业”和“第三届（2019年）中国电子行业电子化工材料专业十强企业”等一系列重要荣誉。公司先后荣获“国家制造业单项冠军示范企业”“山东省制造业单项冠军企业”“民营企业研发投入500家和发明专利500家”“山东省高端品牌培育企业”“山东省就业创业工作先进集体”等一系列重要荣誉和肯定。', 22.50, '0.961', '0.0381', '0.0089', '0');
INSERT INTO `product` VALUES (605588, '冠石科技', '南京冠石科技股份有限公司主营业务为半导体显示器件及特种胶粘材料的研发、生产和销售，其中半导体显示器件包括偏光片、功能性器件、信号连接器、液晶面板、生产辅耗材及OCA光学胶等，主要应用于液晶电视、智能手机、平板电脑、笔记本电脑、智能穿戴等带有显示屏幕的消费电子产品；特种胶粘材料包括胶带、搭扣、泡棉、保护膜、标签等各类产品，主要应用于工业、轨道交通及汽车行业。', 60.00, '0.9386', '0.4254', '0.0018', '0');
INSERT INTO `product` VALUES (605580, '恒盛能源', '恒盛能源股份有限公司主营业务为燃煤热电及生物质热电联产业务。主要产品有蒸汽和电力。', 11.87, '0.9933', '0.023', '0.0363', '0');
INSERT INTO `product` VALUES (605577, '龙版传媒', '黑龙江出版传媒股份有限公司的主营业务是图书、期刊及电子出版物的出版、发行及印刷服务等业务。公司的主要产品是教材教辅、一般图书、期刊、报纸、纸张、印刷耗材、印刷品。公司旗下有112家新华书店门店实现连锁经营，其中有10家书店获得“最美新华书店”国家级荣誉。', 16.03, '0.9001', '0.1102', '0.0069', '0');
INSERT INTO `product` VALUES (601318, '中国平安', '中国平安保险(集团)股份有限公司为经营区域覆盖全国，以保险业务为核心，以统一的品牌向客户提供包括保险、银行、证券、信托等多元化金融服务的全国领先的综合性金融服务集团。通过多渠道分销网络，以统一的品牌，借助旗下平安寿险、平安产险、平安养老险、平安健康险、平安银行、平安信托、平安证券、平安资产管理及平安融资租赁等公司经营保险、银行、资产管理三大核心金融业务，借助陆金所控股、金融壹账通、平安好医生、平安医保科技、汽车之家等公司经营科技业务，向客户提供多种金融产品和服务。公司科技专利申请数较年初增加7,008项，累计达38,420项，位居国际金融机构前列。2021年公司名列《财富》世界500强第16位，较去年上升5位，全球金融企业排名第2位；《福布斯》全球上市公司2000强排名从第7位上升至第6位；BrandZTM全球品牌价值100强排名第49位，首次位列全球银行保险机构第1位，六度蝉联全球保险品牌第1位。', 43.28, '0.9698', '0.014', '0.0563', '0');
INSERT INTO `product` VALUES (600839, '四川长虹', '四川长虹电器股份有限公司的主营业务是电视机、冰箱、空调、压缩机、视听产品、电池、手机等产品的生产销售、IT产品的销售以及房地产开发等生产经营活动。主要产品是电视、空调冰箱、ICT产品、中间产品、机顶盒、电池、系统工程、运输、厨卫产品、房地产、特种业务。公司已经实现了从单纯的家电制造商向标准制定商、内容提供商的转变,形成了集数字电视、空调、冰箱、IT、通讯、数码、网络、电源、商用系统电子、小家电等产业研发、生产、销售为一体的多元化、综合型跨国企业集团。报告期内，公司家用电器业务保持了市场地位的基本稳定, 彩电、冰箱零售量规模保持国内行业第一阵列，但面临较大竞争压力；冰箱压缩机业务在全球和国内市场的销量份额均稳居第一；IT综合服务、特种电源等业务在细分行业市场领域继续保持领先地位。', 6.63, '0.9924', '0.2106', '0.006', '0');
INSERT INTO `product` VALUES (601012, '隆基绿能', '隆基绿能科技股份有限公司主要从事单晶硅棒,硅片,电池和组件的研发,生产和销售，为光伏集中式地面电站和分布式屋顶开发提供产品和系统解决方案。公司的主要产品为太阳能组件及电池、硅片及硅棒、电站建设及服务、电力。公司是全球最大的集研发、生产、销售、服务于一体的单晶光伏产品制造企业，始终坚持以提升客户价值为核心，通过技术创新驱动提升公司的市场竞争力，多项核心技术与产品处于行业领先地位。', 24.24, '0.965', '0.0309', '0.0165', '0');
INSERT INTO `product` VALUES (601901, '方正证券', '方正证券股份有限公司主要业务为财富管理、投资银行、资产管理、投资与交易、研究服务。主要产品和服务为财富管理、投资银行、证券资产管理、公募基金管理、私募股权基金投资管理、期货资产管理、定向资产管理、集合资产管理、专项资产管理、资产证券化、权益类证券投资、固定收益类证券投资、FOF投资、另类投资、股权投资业务、研究服务。方正证券作为中国首批综合类证券公司,多年来坚持以客户为核心,构建稳健均衡的业务结构,不断提升自身的品牌影响力和综合竞争力。', 9.31, '0.9758', '0.0609', '0.0013', '0');
INSERT INTO `product` VALUES (600895, '张江高科', '上海张江高科技园区开发股份有限公司的主营业务是受让地块内的土地转让、房产开发与销售、房产租赁、数据通信服务，创业投资。主要产品是房地产销售、房产租赁。依托浦东张江高科技园区，已形成了生物医药、房产物业、通讯信息和海外投资四个投资集群。主要经营受让地块内的土地转让、房产开发与销售、房产租赁、商品贸易、数据通信服务。', 24.23, '0.9886', '0.1085', '0.0066', '0');
INSERT INTO `product` VALUES (600418, '江淮汽车', '安徽江淮汽车集团股份有限公司是一家集商用车、乘用车及动力总成研发、制造、销售和服务于一体的综合型汽车厂商。其主要产品有各类汽车及底盘、风商务车(MPV),瑞鹰越野车(SRV),C级宾悦、B级和悦及和悦RS、A级同悦及同悦RS、A0级悦悦轿车。', 19.65, '0.9786', '0.0825', '0.0014', '0');
INSERT INTO `product` VALUES (603220, '中贝通信', '中贝通信集团股份有限公司的主营业务是为客户提供5G新基建、智慧城市与5G行业应用服务，同时包含光电子器件的生产和销售。公司的主要产品与服务是为客户提供包括5G移动通信网络、光传输千兆光网等新型数字基础设施在内的网络建设服务，其中智慧城市项目包含方案设计、系统平台开发与安装调测等全业务环节服务。', 42.66, '0.9794', '0.2327', '0.0033', '0');
INSERT INTO `product` VALUES (603985, '恒润股份', '江阴市恒润重工股份有限公司是主要从事辗制环形锻件、锻制法兰及其他自由锻件等产品的研发、生产和销售，产品主要应用于风电行业、石化行业、金属压力容器行业、机械行业、船舶、核电等多种行业。 公司是辗制环形锻件和锻制法兰行业重要供应商，在国内同行业中具备较强装备工艺优势及研发优势。公司获得了维斯塔斯、通用电气、西门子歌美飒、阿尔斯通、艾默生、三星重工、韩国重山等国际知名厂商的合格供应商资质或进入其供应商目录。在辗制环形锻件市场，公司已成为海上风电塔筒法兰的重要供应商，在全球同行业同类产品中处于领先地位，同时公司也是目前全球较少能制造7.0MW及以上海上风电塔筒法兰的企业之一。目前公司已取得国家质量监督检验检疫总局特种设备制造资格许可证（压力管道元件），还取得了莱茵技术（TUV）ISO9001：2008质量体系认证证书、莱茵技术（TUV）欧盟承压设备（PED97/23/EC和AD2000）指令中法兰制造许可证（PED和AD证书）、日本JIS证书、法国BV风电法兰工厂认证。', 44.78, '0.9429', '0.1466', '0.0009', '0');
INSERT INTO `product` VALUES (603496, '恒为科技', '恒为科技(上海)股份有限公司的主营业务是智能系统解决方案的研发、销售与服务。公司的主要产品有网络可视化基础架构、嵌入式与融合计算平台。公司现持有中国电子信息行业联合会于2016年3月18日颁发的《信息系统集成及服务三级资质证书》。', 34.14, '0.9001', '0.2711', '0.0015', '0');
INSERT INTO `product` VALUES (603019, '中科曙光', '曙光信息产业股份有限公司以IT核心设备研发、生产制造为基础，对外提供高端计算机、存储、安全数据中心等ICT基础设施产品，大力发展云计算、大数据、人工智能、边缘计算等先进计算业务，为用户提供全方位的信息系统服务解决方案。主要产品为高端计算机、存储产品、软件开发、系统集成、技术服务。2020年，公司智慧城市、智慧电力和网格化社会治理三个项目列入工信部大数据产业发展试点示范项目；XData大数据智能引擎获得工信部测试机构认证，在针对大数据系统制定的TPCx-HS基准测试中，获得了超过世界记录的实测成绩；在安徽省经信厅举办的中国云计算生态峰会上，曙光云计算凭借“安全可信城市云”荣获2020中国云计算领军企业奖。', 40.90, '0.9879', '0.0425', '0.0073', '0');
INSERT INTO `product` VALUES (600519, '贵州茅台', '贵州茅台酒股份有限公司主要业务是茅台酒及系列酒的生产与销售。主导产品“贵州茅台酒”是世界三大蒸馏名酒之一，也是集国家地理标志产品、有机食品和国家非物质文化遗产于一身的白酒品牌。', 1794.11, '0.9976', '0.001', '0.0144', '0');

-- ----------------------------
-- Table structure for product_param
-- ----------------------------
DROP TABLE IF EXISTS `product_param`;
CREATE TABLE `product_param`  (
  `id` int(0) NOT NULL,
  `product_id` int(0) NULL DEFAULT NULL,
  `param` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_param
-- ----------------------------
INSERT INTO `product_param` VALUES (1, 605599, '/S/SH605599');
INSERT INTO `product_param` VALUES (2, 605598, '/S/SH605598');
INSERT INTO `product_param` VALUES (3, 605589, '/S/SH605589');
INSERT INTO `product_param` VALUES (4, 605588, '/S/SH605588');
INSERT INTO `product_param` VALUES (5, 605580, '/S/SH605580');
INSERT INTO `product_param` VALUES (6, 605577, '/S/SH605577');
INSERT INTO `product_param` VALUES (7, 601318, '/S/SH601318');
INSERT INTO `product_param` VALUES (8, 600839, '/S/SH600839');
INSERT INTO `product_param` VALUES (9, 601012, '/S/SH601012');
INSERT INTO `product_param` VALUES (10, 601901, '/S/SH601901');
INSERT INTO `product_param` VALUES (11, 600895, '/S/SH600895');
INSERT INTO `product_param` VALUES (12, 600418, '/S/SH600418');
INSERT INTO `product_param` VALUES (13, 603220, '/S/SH603220');
INSERT INTO `product_param` VALUES (14, 603985, '/S/SH603985');
INSERT INTO `product_param` VALUES (15, 603496, '/S/SH603496');
INSERT INTO `product_param` VALUES (16, 603019, '/S/SH603019');
INSERT INTO `product_param` VALUES (17, 600519, '/S/SH600519');

-- ----------------------------
-- Table structure for question_option
-- ----------------------------
DROP TABLE IF EXISTS `question_option`;
CREATE TABLE `question_option`  (
  `id` int(0) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `question` int(0) NULL DEFAULT NULL,
  `value` int(0) NULL DEFAULT NULL,
  `question_type` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question_option
-- ----------------------------
INSERT INTO `question_option` VALUES (1, '照顾自己', 1, 0, 3);
INSERT INTO `question_option` VALUES (2, '照顾另一半', 1, 0, 3);
INSERT INTO `question_option` VALUES (3, '抚养孩子', 1, 0, 3);
INSERT INTO `question_option` VALUES (4, '赡养老人', 1, 0, 3);
INSERT INTO `question_option` VALUES (5, '是', 2, 0, 3);
INSERT INTO `question_option` VALUES (6, '否', 2, 0, 3);
INSERT INTO `question_option` VALUES (7, '低', 3, 1, 0);
INSERT INTO `question_option` VALUES (8, '中低', 3, 2, 0);
INSERT INTO `question_option` VALUES (9, '中', 3, 3, 0);
INSERT INTO `question_option` VALUES (10, '中高', 3, 4, 0);
INSERT INTO `question_option` VALUES (11, '高', 3, 5, 0);
INSERT INTO `question_option` VALUES (12, '尽可能保证本金安全，收益无所谓', 4, 1, 1);
INSERT INTO `question_option` VALUES (13, '追求一定收益', 4, 2, 1);
INSERT INTO `question_option` VALUES (14, '追求较多的收益产生', 4, 3, 1);
INSERT INTO `question_option` VALUES (15, '实现资产的大幅增长', 4, 4, 1);
INSERT INTO `question_option` VALUES (16, '1年以内', 5, 0, 3);
INSERT INTO `question_option` VALUES (17, '1-3年', 5, 0, 3);
INSERT INTO `question_option` VALUES (18, '3-5年', 5, 0, 3);
INSERT INTO `question_option` VALUES (19, '5年以上', 5, 0, 3);
INSERT INTO `question_option` VALUES (20, '存款及国债', 6, 0, 3);
INSERT INTO `question_option` VALUES (21, '固定收益类', 6, 0, 3);
INSERT INTO `question_option` VALUES (22, '权益类', 6, 0, 3);
INSERT INTO `question_option` VALUES (23, '商品及衍生品类或其他高风险产品', 6, 0, 3);
INSERT INTO `question_option` VALUES (24, '有限', 7, 0, 3);
INSERT INTO `question_option` VALUES (25, '一般', 7, 0, 3);
INSERT INTO `question_option` VALUES (26, '丰富', 7, 0, 3);
INSERT INTO `question_option` VALUES (27, '1年以下', 8, 0, 3);
INSERT INTO `question_option` VALUES (28, '1-3年', 8, 0, 3);
INSERT INTO `question_option` VALUES (29, '3-5年', 8, 0, 3);
INSERT INTO `question_option` VALUES (30, '5年以上', 8, 0, 3);
INSERT INTO `question_option` VALUES (31, '除了银行储蓄外，基本没有其他投资经验', 9, 0, 3);
INSERT INTO `question_option` VALUES (32, '购买过债券、保险等理财产品', 9, 0, 3);
INSERT INTO `question_option` VALUES (33, '参与过股票、基金等产品的交易', 9, 0, 3);
INSERT INTO `question_option` VALUES (34, '参与过权证、期货、期权等产品的交易', 9, 0, 3);
INSERT INTO `question_option` VALUES (35, '还信用卡等消费贷', 10, 0, 3);
INSERT INTO `question_option` VALUES (36, ' 还车贷', 10, 0, 3);
INSERT INTO `question_option` VALUES (37, '还房贷', 10, 0, 3);
INSERT INTO `question_option` VALUES (38, '日常花销', 10, 0, 3);
INSERT INTO `question_option` VALUES (39, '1万以下', 11, 0, 3);
INSERT INTO `question_option` VALUES (40, '1-5万', 11, 0, 3);
INSERT INTO `question_option` VALUES (41, '5-10万', 11, 0, 3);
INSERT INTO `question_option` VALUES (42, '10-30万', 11, 0, 3);
INSERT INTO `question_option` VALUES (43, ' 30-100万', 11, 0, 3);
INSERT INTO `question_option` VALUES (44, '100万以上', 11, 0, 3);
INSERT INTO `question_option` VALUES (45, '工资奖金、劳务报酬', 13, 0, 3);
INSERT INTO `question_option` VALUES (46, '生产经营所得 ', 13, 0, 3);
INSERT INTO `question_option` VALUES (47, '利息、股息、转让等金融性资产收入', 13, 0, 3);
INSERT INTO `question_option` VALUES (48, '出租、出售房地产等非金融性资产收入', 13, 0, 3);
INSERT INTO `question_option` VALUES (49, '其他', 13, 0, 3);
INSERT INTO `question_option` VALUES (50, '5-10', 12, 0, 3);
INSERT INTO `question_option` VALUES (51, '10-30', 12, 0, 3);
INSERT INTO `question_option` VALUES (52, '30-50', 12, 0, 3);
INSERT INTO `question_option` VALUES (53, '50-100', 12, 0, 3);
INSERT INTO `question_option` VALUES (54, '100万以上', 12, 0, 3);
INSERT INTO `question_option` VALUES (55, '党政机关及事业单位', 14, 6, 2);
INSERT INTO `question_option` VALUES (56, '一般企业单位', 14, 5, 2);
INSERT INTO `question_option` VALUES (57, '蓝领', 14, 4, 2);
INSERT INTO `question_option` VALUES (58, '在校学生', 14, 2, 2);
INSERT INTO `question_option` VALUES (59, '无固定职业', 14, 1, 2);
INSERT INTO `question_option` VALUES (60, '自由职业 ', 14, 3, 2);

-- ----------------------------
-- Table structure for question_title
-- ----------------------------
DROP TABLE IF EXISTS `question_title`;
CREATE TABLE `question_title`  (
  `id` int(0) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question_title
-- ----------------------------
INSERT INTO `question_title` VALUES (1, '你要照顾的人？');
INSERT INTO `question_title` VALUES (2, '是否有境外税收居民身份？');
INSERT INTO `question_title` VALUES (3, '您投资中对风险波动的厌恶有何种程度？');
INSERT INTO `question_title` VALUES (4, '投资目标是 ');
INSERT INTO `question_title` VALUES (5, '您可接收的最长投资期限为？');
INSERT INTO `question_title` VALUES (6, '您想投资什么产品？（多选）');
INSERT INTO `question_title` VALUES (7, '您的投资知识可描述为');
INSERT INTO `question_title` VALUES (8, '有多少年投资经验');
INSERT INTO `question_title` VALUES (9, '投资经验有哪些（多选）');
INSERT INTO `question_title` VALUES (10, '每月钱花哪了（多选）');
INSERT INTO `question_title` VALUES (11, '家庭收入有多少钱用于投资？');
INSERT INTO `question_title` VALUES (12, '家庭可支配年收入为？');
INSERT INTO `question_title` VALUES (13, '收入主要来自？');
INSERT INTO `question_title` VALUES (14, '工作是什么？');

-- ----------------------------
-- Table structure for trade_record
-- ----------------------------
DROP TABLE IF EXISTS `trade_record`;
CREATE TABLE `trade_record`  (
  `id` int(0) NOT NULL,
  `product_id` int(0) NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `amount` int(0) NULL DEFAULT NULL,
  `deal_time` datetime(0) NULL DEFAULT NULL,
  `sold` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of trade_record
-- ----------------------------
INSERT INTO `trade_record` VALUES (1, 1, 1.00, 1, '2023-11-07 18:44:09', 1);

SET FOREIGN_KEY_CHECKS = 1;
