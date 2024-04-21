create table user (
                      id int(8) NOT NULL AUTO_INCREMENT COMMENT '学号',
                      username varchar(25) COMMENT '姓名',
                      mima varchar(25) COMMENT '密码',
                      sex int(2) COMMENT '性别',
                      email varchar(20)  COMMENT '邮箱',
                      hobby varchar(50)   COMMENT '爱好',
                      hobby2 varchar(50)   COMMENT '爱好2',
                      hobby3 varchar(50)   COMMENT '爱好3',
                      PRIMARY KEY(`id`)
)


create table collection(
                           id int(8) NOT NULL AUTO_INCREMENT ,
                           uid int(8) NOT NULL,
                           pid int(8) NOT NULL,
                           pName varchar(50) NOT NULL,
                           PRIMARY KEY(`id`)
)


create table product(
                        id int(8) PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '产品编号',
                        catId int(8)  NOT NULL ,
                        tim varchar(25),
                        sim1 varchar(25),
                        sim2 varchar(25),
                        sim3 varchar(25),
                        sim4 varchar(25),
                        sim5 varchar(25),
                        alt varchar(25),
                        price int(5),
                        trFee int(3),
                        claim varchar(255),
                        remainTime  varchar(255),
                        latterNum int(6),
                        totalNum int(6),
                        tag varchar(80),
                        origin varchar(100),
                        remain int(6),
                        observeTimes int(7)
)


create table seller(
                       id int(8) NOT NULL AUTO_INCREMENT ,
                       sname varchar(25) COMMENT '姓名',
                       phone varchar(25) ,
                       des varchar(25),
                       credit int(5),
                       cmp int(5),
                       PRIMARY KEY(`id`)
)
create table CartRec(
                        id int(8) NOT NULL AUTO_INCREMENT ,
                        cid int(8) NOT NULL ,
                        pid int(8) NOT NULL ,
                        num int(8) NOT NULL ,
                        uid int(8) NOT NULL ,
                        pName varchar(30) NOT NULL,
                        pri float NOT NULL,
                        discount float NOT NULL,
                        date  DATETIME  NOT NULL,
                        PRIMARY KEY(`id`)
)

create table `orderItem`(
                        id int(8) NOT NULL AUTO_INCREMENT ,
                        uid int(8) NOT NULL,
                        pid int(8) NOT NULL,
                        per int(6) NOT NULL,
                        statusOfOrder int(8) NOT NULL ,
                        num int(8) NOT NULL ,
                        discount float NOT NULL,
                        total int(8) NOT NULL,
                        codeOfOrder varchar(5)  NOT NULL,
                        telNumber varchar(20) NOT NULL,
                        branchNumber varchar(20) NOT NULL,
                        receiver varchar(20) NOT NULL,
                        address varchar(50) NOT NULL,
                        PRIMARY KEY(`id`)
)


CREATE TABLE `cart` (
                                      `id` int(8) NOT NULL AUTO_INCREMENT,
                                      `oid` int(8) NOT NULL,
                                      `pid` int(8) NOT NULL,
                                      PRIMARY KEY (`id`) USING BTREE
)

CREATE TABLE `catgory`  (
                                      `id` int(8) NOT NULL AUTO_INCREMENT,
                                      `catName` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                                      PRIMARY KEY (`id`) USING BTREE
)


CREATE TABLE `customer`  (
                                      `cid` int(8) NOT NULL,
                                      PRIMARY KEY (`cid`) USING BTREE
)

CREATE TABLE `order`  (
                                      `id` int(8) NOT NULL AUTO_INCREMENT,
                                      `uid` int(8) NOT NULL,
                                      `num` int(8) NOT NULL,
                                      `total` float NOT NULL,
                                      `youhui` float NOT NULL,
                                      PRIMARY KEY (`id`) USING BTREE
)



CREATE TABLE `ProductIncart`  (
                                      `pName` int(0) NOT NULL AUTO_INCREMENT,
                                      `pri` int(0) NOT NULL,
                                      `discount` float NOT NULL,
                                      `num` int(0) NOT NULL,
                                      PRIMARY KEY (`pName`) USING BTREE
)


INSERT INTO `ProductIncart` (`pName`, `pri`, `discount`, `num`) VALUES
(1, 100, 0.1, 2),
(2, 150, 0.05, 1),
(3, 200, 0.2, 3),
(4, 250, 0.15, 1),
(5, 300, 0.08, 2),
(6, 350, 0.12, 4),
(7, 400, 0.07, 1),
(8, 450, 0.18, 3),
(9, 500, 0.1, 2),
(10, 550, 0.05, 5);

INSERT INTO `cart` (`oid`, `pid`) VALUES
                                      (1, 101),
                                      (1, 102),
                                      (2, 103),
                                      (2, 104),
                                      (3, 105),
                                      (3, 101),
                                      (4, 102),
                                      (4, 106),
                                      (5, 107),
                                      (5, 108);

INSERT INTO `category`  VALUES
                                       ('Electronics'),
                                       ('Books'),
                                       ('Clothing'),
                                       ('Home & Garden'),
                                       ('Sports & Outdoors'),
                                       ('Tools & Hardware'),
                                       ('Jewelry'),
                                       ('Beauty & Personal Care'),
                                       ('Grocery'),
                                       ('Toys & Games');

INSERT INTO `customer`  VALUES
                                   (1001),
                                   (1002),
                                   (1003),
                                   (1004),
                                   (1005),
                                   (1006),
                                   (1007),
                                   (1008),
                                   (1009),
                                   (1010);


INSERT INTO `order` (`uid`, `num`, `total`, `youhui`) VALUES
                                                          (1001, 2, 150.00, 10.00),
                                                          (1002, 3, 225.00, 15.00),
                                                          (1003, 1, 100.00, 5.00),
                                                          (1004, 4, 400.00, 30.00),
                                                          (1005, 2, 120.00, 8.00),
                                                          (1006, 1, 50.00, 2.50),
                                                          (1007, 3, 210.00, 14.00),
                                                          (1008, 2, 160.00, 11.00),
                                                          (1009, 1, 75.00, 3.75),
                                                          (1010, 2, 180.00, 12.00);



INSERT INTO user (username, mima, sex, email, hobby, hobby2, hobby3) VALUES
                                                                         ('张三', 'pass1234', 1, 'zhangsan@example.com', '阅读', '跑步', '旅游'),
                                                                         ('李四', 'lisi5678', 2, 'lisi@example.net', '游泳', '音乐', '摄影'),
                                                                         ('王五', 'wangwu90', 1, 'wangwu@example.org', '编程', '电影', '篮球'),
                                                                         ('赵六', 'zhaoliu123', 2, 'zhaoliu@example.com', '健身', '美食', NULL),
                                                                         ('孙七', 'sunqi456', 1, 'sunqi@example.net', '旅游', '桌游', '爬山'),
                                                                         ('周八', 'zhouba789', 2, 'zhouba@example.org', '绘画', '书法', '羽毛球'),
                                                                         ('吴九', 'wujiu098', 1, 'wujiu@example.com', '阅读', '电影', '游泳'),
                                                                         ('郑十', 'zhengshi12', 2, 'zhengshi@example.net', '摄影', '跑步', '桌游'),
                                                                         ('陈十一', 'chenyishi34', 1, 'chenyishi@example.org', '美食', '旅游', '编程'),
                                                                         ('黄十二', 'huangshi23', 2, 'huangshi@example.com', '篮球', '健身', '游泳');

INSERT INTO collection (uid, pid, pName) VALUES
                                             (1, 1, '产品A'), -- 张三收藏了产品A
                                             (1, 2, '产品B'), -- 张三也收藏了产品B
                                             (2, 3, '产品C'), -- 李四收藏了产品C
                                             (2, 4, '产品D'), -- 李四也收藏了产品D
                                             (3, 5, '产品E'), -- 王五收藏了产品E
                                             (4, 2, '产品B'), -- 赵六收藏了产品B
                                             (5, 6, '产品F'), -- 孙七收藏了产品F
                                             (6, 1, '产品A'), -- 周八收藏了产品A
                                             (7, 7, '产品G'), -- 吴九收藏了产品G
                                             (8, 8, '产品H'), -- 郑十收藏了产品H
                                             (9, 9, '产品I'), -- 陈十一收藏了产品I
                                             (10, 10, '产品J'); -- 黄十二收藏了产品J


INSERT INTO product (catId, tim, sim1, sim2, sim3, sim4, sim5, alt, price, trFee, claim, remainTime, latterNum, totalNum, tag, origin, remain, observeTimes) VALUES
                                                                                                                                                                 (1, '2023-01-01', 'sim1_1.jpg', 'sim2_1.jpg', 'sim3_1.jpg', 'sim4_1.jpg', 'sim5_1.jpg', '产品A描述', 199, 10, '全新正品', '30天', 5, 100, '热门', '中国', 95, 50),

                                                                                                                                                                 (2, '2023-02-01', 'sim1_2.jpg', 'sim2_2.jpg', 'sim3_2.jpg', NULL, NULL, '产品B描述', 399, 20, '官方直供', '60天', 15, 200, '促销', '进口', 180, 120);


INSERT INTO seller (sname, phone, des, credit, cmp) VALUES
                                                        ('张三', '13800138000', '诚信经营', 95, 10),
                                                        ('李四', '13912345678', '优质服务', 90, 8),
                                                        ('王五', '15923456789', '新品上市', 92, 9),
                                                        ('赵六', '18678901234', '质量保证', 88, 7),
                                                        ('孙七', '13745678901', '快速发货', 93, 11);


INSERT INTO CartRec (cid, pid, num, uid, pName, pri, discount, date) VALUES
                                                                         (1, 1, 2, 1, '产品A', 199.00, 0.95, '2023-04-01 10:00:00'),
                                                                         (2, 2, 1, 2, '产品B', 399.00, 0.90, '2023-04-02 15:30:00'),
                                                                         (3, 3, 3, 3, '产品C', 249.00, 0.85, '2023-04-03 08:45:00'),
                                                                         (4, 4, 1, 4, '产品D', 149.00, 1.00, '2023-04-04 12:15:00'),
                                                                         (5, 5, 2, 5, '产品E', 349.00, 0.92, '2023-04-05 20:30:00');


INSERT INTO orderItem (uid, pid, per, statusOfOrder, num, discount, total, codeOfOrder, telNumber, branchNumber, receiver, address) VALUES
                                                                                                                                        (1, 1, 1, 1, 2, 0.95, 398.00, '12345', '13800138000', '001', '张三', '北京市海淀区某路1号'),
                                                                                                                                        (2, 2, 1, 2, 1, 0.90, 359.10, '67890', '13912345678', '002', '李四', '上海市黄浦区某路2号'),
                                                                                                                                        (3, 3, 1, 3, 3, 0.85, 747.00, '23456', '15923456789', '003', '王五', '广州市天河区某路3号'),
                                                                                                                                        (4, 4, 1, 1, 1, 1.00, 149.00, '78901', '18678901234', '004', '赵六', '深圳市南山区某路4号'),
                                                                                                                                        (5, 5, 1, 2, 2, 0.92, 642.24, '34567', '13745678901', '005', '孙七', '成都市武侯区某路5号');