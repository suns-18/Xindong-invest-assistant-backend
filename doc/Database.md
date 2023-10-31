# 数据库表设计

## 1. product

理财产品信息

| 字段名         | 字段类型          | 字段描述                     |
|-------------|---------------|--------------------------|
| code        |               | 产品代码                     |
| name        | varchar(255)  | 产品名称                     |
| details     | **longtext?** | 产品细节：公司背景、市场走势、成交额、市场价等等 |
| price       | decimal(.2)   | 购入价                      |
| anti_risk   |               | 非风险率                     |
| flexibility |               | 灵活性：指定期还是非定期             |
| return_rate |               | 汇报率                      |
| state       |               | 收藏状态                     |

## 2.trade_record

模拟交易信息

| 字段名          | 字段类型        | 字段描述      |
|--------------|-------------|-----------|
| id           |             | 交易记录id    |
| product_code | **int?**    | 模拟交易的产品代码 |
| price        | decimal(.2) | 交易价格      |
| amount       | decimal(.2) | 交易数量      |
| deal_time    | datetime    | 交易时间      |

## 3. question_title

问卷题目

| 字段名   | 字段类型         | 字段描述 |
|-------|--------------|------|
| id    | int          | 问题id |
| title | varchar(255) | 问题描述 |

## 4. question_option

问题选项

| 字段名      | 字段类型         | 字段描述      |
|----------|--------------|-----------|
| id       | int          | 选项id      |
| question | int          | 对应问题id    |
| title    | varchar(255) | 选项描述      |
| value    | int          | 选项对应分值（？） |

## 5. answer

问卷作答

| 字段名      | 字段类型 | 字段描述   |
|----------|------|--------|
| id       | int  | 答案id   |
| question | int  | 对应问题id |
| option   | int  | 选项id   |

## 6. possession

持仓信息

| 字段名            | 字段类型 | 字段描述        |
|----------------|------|-------------|
| id             | int  | 流水号         |
| product_code   | int  | 模拟持仓内部的产品代码 |
| purchase_price | int  | 买入价格        |
| amount         | int  | 在仓数量        |
