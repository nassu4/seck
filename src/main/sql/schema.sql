-- 数据库初始化脚本

-- 创建数据库
CREATE DATABASE seckill;

-- 使用数据库
USE seckill;

-- 创建秒杀库存表
CREATE TABLE stock (
    item_id BIGINT NOT NULL AUTO_INCREMENT COMMENT '商品id',
    item_name VARCHAR(120) NOT NULL COMMENT '商品名',
    item_stock INT NOT NULL COMMENT '商品库存',
    start_time TIMESTAMP NOT NULL COMMENT '秒杀开始时间',
    end_time TIMESTAMP NOT NULL COMMENT  '秒杀结束时间',
    creation_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '库存表创建时间',
    PRIMARY KEY (item_id),
    KEY (item_name),
    KEY (start_time),
    KEY (creation_time)
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=UTF8 COMMENT '秒杀库存表';

-- 初始化数据
INSERT INTO
    stock(item_name, item_stock, start_time, end_time)
VALUES
    ('iphone11', 100, '2020-11-11 00:00:00', '2020-11-12 00:00:00'),
    ('iphone11 pro', 50, '2020-11-11 00:00:00', '2020-11-12 00:00:00'),
    ('iphone11 pro max', 20, '2020-11-11 00:00:00', '2020-11-12 00:00:00'),
    ('airpods pro', 10, '2020-11-11 00:00:00', '2020-11-12 00:00:00');

-- 秒杀成功明细表
CREATE TABLE success_killed_order (
    item_id BIGINT NOT NULL COMMENT '商品id',
    user_phone_number BIGINT NOT NULL COMMENT '用户手机号',
    state TINYINT NOT NULL DEFAULT -1 COMMENT '状态：-1表示无效，0表示成功，1表示已付款，2表示已发货',
    creation_time TIMESTAMP NOT NULL COMMENT '成功明细表创建时间',
    PRIMARY KEY (item_id, user_phone_number),
    KEY (creation_time)
) ENGINE=INNODB DEFAULT CHARSET=UTF8 COMMENT '秒杀成功明细表';
