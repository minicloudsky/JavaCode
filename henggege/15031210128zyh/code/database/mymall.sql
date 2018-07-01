/*
Navicat MySQL Data Transfer

Source Server         : amy
Source Server Version : 50637
Source Host           : localhost:3306
Source Database       : mymall

Target Server Type    : MYSQL
Target Server Version : 50637
File Encoding         : 65001

Date: 2018-01-05 17:56:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `evaluate`
-- ----------------------------
DROP TABLE IF EXISTS `evaluate`;
CREATE TABLE `evaluate` (
  `evaluate_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `evaluate_content` varchar(255) NOT NULL,
  `evalute_picture1` varchar(255) DEFAULT NULL,
  `evaluate_pro` int(11) DEFAULT NULL,
  PRIMARY KEY (`evaluate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of evaluate
-- ----------------------------
INSERT INTO `evaluate` VALUES ('1', '1', '看起来还不错哦，第一次买来伊份。我们湖北都是良品铺子，还不知道味道如何，尝一下再说。', null, '1');
INSERT INTO `evaluate` VALUES ('2', '2', '嘿嘿嘿，又来评价啦，但是这不是买给我寄几吃的，给我滴小伙伴买滴，应该还行吧，因为她并没有向我吐槽说这个炒鸡难吃，也没有想要打我的冲动，以我的判断，应该挺好吃的，买来伊份，一是因为室友吃过，而是因为三只松鼠没做活动(哭死)，正好看见它家做活动就买啦，就酱。辣条嘛，肯定差不了多少滴。', null, '1');
INSERT INTO `evaluate` VALUES ('3', '3', '买了几种牌子的坚果来试，三只松鼠的最好吃，沃隆的也好，只是放了防腐剂，来依份和恰恰都不好吃，来依份的南瓜籽扁扁干干有几个变色，恰恰的杏仁不脆，放两包防腐剂吃起来还不新鲜', null, '1');
INSERT INTO `evaluate` VALUES ('4', '4', '是良品铺子的忠实粉丝了，东西很好吃，而且日期都很新鲜，东西都是小包装分开的干净卫生，鸭肫有点辣，但是味道很好，儿子特喜欢吃，猪肉铺也是一样的很好，以后会经常光顾良品铺子的', null, '5');
INSERT INTO `evaluate` VALUES ('5', '1', '收到了满满的一大箱零食，我很喜欢吃良品铺子这一类的零食，这次看到这个大礼包还蛮感兴趣的，就买了一箱，味道果然没有让我失望，有好几种都是我特喜欢的，棒棒哒，我和我的小伙伴回经常回购的，相信并支持良品铺子！打开箱子满满地一箱，太合算了，日期也蛮新鲜的，我拿了一包兰花豆，很好吃，脆脆的，很香，吃了停不下来，良品铺子也是个老牌子了，吃了放心，价钱也比较实惠，喜欢的就不要忧虑了，不会让你失望的，我吃完后还会光顾这个店铺的，关键是东西好，而且货物发得超快，包装仔细，值得信赖!很愉快地一次购物！', null, '5');
INSERT INTO `evaluate` VALUES ('6', '2', '每个口味买了一盒 每一个里面二十支 这三个口味 我个人觉得最好吃的是威化 威化的芝士味道比较适中并且比较均匀吃起来不会太腻 蛋卷是味道最浓的 因为他整个蛋卷里面满满的全是芝士 短胖短胖的那个吃起来有点咸 如果你是第一次买这个吃 我建议不要连着吃这三个 那样你就品尝不出最原始的味道', null, '6');
INSERT INTO `evaluate` VALUES ('7', '6', '和寝室的妹子分了好多～以前就吃过芝士饼干，没吃过另外两种，这次买来都试试。味道都一样的是浓郁的芝士味！爱芝士爱炸了！！送的巧扣力味的也吼吼次呀！最喜欢的是夹心卷和威化饼干！打call！！！等我这段时间腻完会回购的！', null, '6');
INSERT INTO `evaluate` VALUES ('8', '8', '零食很好吃，在实体店买过 第二次就决定在网上买 很便宜 而且味道和实体店的一样 多家对比发现这家蛮便宜的 送了 下次还会光顾的 就是没想到460g的是三条装成一板 不过味道还是好吃 好评！', null, '6');
INSERT INTO `evaluate` VALUES ('9', '3', '宝贝不错哦，很好吃，给老公买的，当零食或早餐。就是双十一没有用到购物券，比较遗憾，卖家同意退回去，想想算了，怪麻烦的。', null, '7');
INSERT INTO `evaluate` VALUES ('10', '2', '日期新鲜，双11第一份包裹，快递快。好吃推荐', null, '7');
INSERT INTO `evaluate` VALUES ('11', '7', '友臣的肉松饼，一直有买，品质不错，买一箱可以吃好久，自己吃或者送送人也实惠，日期很新鲜，挺好的。', null, '7');
INSERT INTO `evaluate` VALUES ('12', '5', '抱歉，吃完了才来评论，手撕肉非常好吃，绿色包装的最辣，红色的一般，黄色的不辣，比较喜欢最辣的口味，还会再来买的', null, '8');
INSERT INTO `evaluate` VALUES ('13', '3', '自第一次室友给我甩了两小袋我就喜欢上了这个味，要来了链接直接就拍了，三种味道都特别的香，刚拿回来就给她们发了福利，吃完了肯定还要买的，这个世界上没有一包麻辣小吃解决不了的问题，如果有，那就是两包。', null, '8');
INSERT INTO `evaluate` VALUES ('14', '4', '总共买了六种糖果，准备结婚装礼盒送同事朋友的，昨晚和妈妈俩人把糖都装好，一份心意，希望他们都喜欢，糖果日期新鲜，自己试吃都很好吃。因为比较多，店家发成两个快递，非常满意，双十二价格也实惠，谢谢店家，生意兴隆！', null, '9');
INSERT INTO `evaluate` VALUES ('15', '12', '小面包很好吃，上一次也买了两盒一盒送人了一盒自己吃，大家都很喜欢吃也找我各种要链接，我也是有一次别人给我吃我觉得很好吃我才过来买的，一盒分量也很足，很不错。上一次买到家秒光，两天就被吃光了，我们家的小狗狗也喜欢吃哦。这一次又加购了两盒。', null, '10');
INSERT INTO `evaluate` VALUES ('16', '7', '买了很多，囤货，一直喜欢旺仔牛奶。经典原味和苹果味都好喝。', null, '11');
INSERT INTO `evaluate` VALUES ('17', '8', '小时候的味道，长大后依旧觉得很好喝，现在还有多口味选择，都很不错，和家人每天一瓶，营养快乐每一天！', null, '11');

-- ----------------------------
-- Table structure for `products`
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `pro_id` int(11) NOT NULL AUTO_INCREMENT,
  `pro_name` varchar(255) NOT NULL,
  `pro_content` text,
  `pro_picture1` varchar(255) DEFAULT NULL,
  `pro_picture2` varchar(255) DEFAULT NULL,
  `pro_picture3` varchar(255) DEFAULT NULL,
  `pro_sale` int(11) NOT NULL DEFAULT '0',
  `pro_shop` int(255) NOT NULL,
  `pro_kind` char(255) NOT NULL,
  `pro_price` int(11) NOT NULL,
  PRIMARY KEY (`pro_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of products
-- ----------------------------
INSERT INTO `products` VALUES ('1', '来伊份天天坚果组合每日坚果25gx7袋装混合干果仁小包装零食', '温馨提示:混合坚果营养丰富、健康美味，孕妇食用桂圆干请谨遵医嘱；幼儿及儿童请在家长监护下食用！\r\n\r\n', 'image/a1.png', 'image/a2.png', 'image/a3.png', '0', '1', '零食', '33');
INSERT INTO `products` VALUES ('5', '良品铺子甜辣味鸭脖卤味特产麻辣肉类零食小吃真空休闲熟食小包装', null, 'image/b1.png', 'image/b2.png', 'image/b3.png', '0', '1', '零食', '20');
INSERT INTO `products` VALUES ('6', '印尼进口零食 richeese丽芝士纳宝帝奶酪威化饼干nabati夹心芝士', null, 'image/c1.png', 'image/c2.png', 'image/c3.png', '0', '2', '零食', '29');
INSERT INTO `products` VALUES ('7', '友臣旗舰店 友臣肉松饼 整箱1.25kg 传统糕点闽台特产零食早餐', null, 'image/d1.png', 'image/d2.png', 'image/d3.png', '0', '0', '零食', '42');
INSERT INTO `products` VALUES ('8', '湖南特产手撕素肉50包豆干制品素牛排卷蛋白香辣麻辣味零食素牛肉', null, 'image/e1.png', 'image/e2.png', 'image/e3.png', '0', '0', '零食', '19');
INSERT INTO `products` VALUES ('9', '麦德好旗舰店 燕麦巧克力1000g营养麦片巧克力婚庆喜糖果散装零食', null, 'image/f1.png', 'image/f2.png', 'image/f3.png', '0', '0', '零食', '20');
INSERT INTO `products` VALUES ('10', '豪士乳酸菌小口袋680g*2箱小白面包心里软蒸蛋糕早餐网红糕点零食', null, 'image/g1.png', 'image/g2.png', 'image/g3.png', '0', '0', '零食', '33');
INSERT INTO `products` VALUES ('11', '旺旺旺仔牛奶245ml*8+4原味、苹果味儿童牛奶早餐饮品铁罐', null, 'image/h1.png', 'image/h2.png', 'image/h3.png', '0', '0', '饮料', '30');
INSERT INTO `products` VALUES ('12', '天润奶啤300ml*12整箱易拉罐装饮料新疆特产非啤酒', null, 'image/i1.png', 'image/i2.png', 'image/i3.png', '0', '0', '饮料', '50');
INSERT INTO `products` VALUES ('13', '1000g速溶阿萨姆奶茶粉 茶香三合一原味奶茶红茶冲饮料奶茶店原料', null, 'image/j1.png', 'image/j2.png', 'image/j3.png', '0', '0', '饮料', '10');
INSERT INTO `products` VALUES ('14', '【欧阳娜娜设计款】森马情侣卫衣女2018春季新款女装', null, 'image/k1.png', 'image/k2.png', 'image/k3.png', '0', '0', '女装', '70');
INSERT INTO `products` VALUES ('15', '香港潮牌卫衣2017新款女装韩版宽松连帽小清新学院保暧加绒厚外套', null, 'image/l1.png', 'image/l2.png', 'image/l3.png', '0', '0', '女装', '49');
INSERT INTO `products` VALUES ('16', '学生寝室宿舍办公室必备懒人神器创意家居日用百货卧室居家日用品', null, 'image/m1.png', 'image/m2.png', 'image/m3.png', '0', '0', '生活用品', '99');
INSERT INTO `products` VALUES ('17', '创意圣诞节礼物送女生老师家居生活用品小百货卫生间厨房用具日用', null, 'image/n1.png', 'image/n2.png', 'image/n3.png', '0', '0', '生活用品', '20');
INSERT INTO `products` VALUES ('18', '健身器材套装男家用体育用品多功能胸肌训练锻炼臂力棒拉力臂力器', null, 'image/o1.png', 'image/o2.png', 'image/o3.png', '0', '0', '体育', '40');
INSERT INTO `products` VALUES ('19', '猫人男装中长款羽绒服男冬季新款青年黑色修身连帽韩版休闲外套', null, 'image/p1.png', 'image/p2.png', 'image/p3.png', '0', '0', '男装', '99');
INSERT INTO `products` VALUES ('20', '鞋子秋季英伦男士休闲皮鞋韩版潮流真皮增高复古冬季男鞋板鞋潮鞋', null, 'image/q1.png', 'image/q2.png', 'image/q3.png', '0', '0', '鞋包', '50');
INSERT INTO `products` VALUES ('21', '莉迪卡娜 花朵 施华洛世奇元素高档水晶胸针女胸花别针配饰丝巾扣', null, 'image/r1.png', 'image/r2.png', 'image/r3.png', '0', '0', '配饰', '10');

-- ----------------------------
-- Table structure for `shop`
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `shop_id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_name` varchar(255) NOT NULL,
  `shop_owner_id` int(11) NOT NULL,
  `shop_date` date NOT NULL,
  PRIMARY KEY (`shop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES ('1', 'as', '1', '2017-12-18');
INSERT INTO `shop` VALUES ('2', 'ew', '2', '2017-12-18');

-- ----------------------------
-- Table structure for `shopcar`
-- ----------------------------
DROP TABLE IF EXISTS `shopcar`;
CREATE TABLE `shopcar` (
  `shopcar_id` int(11) NOT NULL AUTO_INCREMENT,
  `shopcar_userid` int(11) NOT NULL,
  `shopcar_proid` int(11) NOT NULL,
  PRIMARY KEY (`shopcar_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopcar
-- ----------------------------
INSERT INTO `shopcar` VALUES ('12', '1', '5');
INSERT INTO `shopcar` VALUES ('14', '1', '1');
INSERT INTO `shopcar` VALUES ('15', '1', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` char(255) NOT NULL,
  `user_pwd` varchar(255) NOT NULL,
  `user_isboss` int(1) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', '1', '1');
INSERT INTO `user` VALUES ('2', '2', '3', '1');
