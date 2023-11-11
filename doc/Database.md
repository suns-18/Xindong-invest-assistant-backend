# 数据库表设计

## 1. product

理财产品信息

| 字段名         | 字段类型         | 字段描述                     |
|-------------|--------------|--------------------------|
| id          | int          | 产品id                     |
| name        | varchar(255) | 产品名称                     |
| details     | longtext     | 产品细节：公司背景、市场走势、成交额、市场价等等 |
| price       | decimal(.2)  | 购入价                      |
| anti_risk   |              | 非风险率                     |
| flexibility |              | 灵活性：指定期还是非定期             |
| return_rate |              | 汇报率                      |
| state       |              | 收藏状态                     |

## 2.trade_record

模拟交易 信息

| 字段名        | 字段类型        | 字段描述       |
|------------|-------------|------------|
| id         | int         | 交易记录id     |
| product_id | int         | 模拟交易的产品代码  |
| price      | decimal(.2) | 交易价格       |
| amount     | int         | 交易数量       |
| deal_time  | datetime    | 交易时间       |
| sold       | int         | 是否卖出（0假1真） |

## 3. question_title

问卷题目

| 字段名   | 字段类型         | 字段描述 |
|-------|--------------|------|
| id    | int          | 问题id |
| title | varchar(255) | 问题描述 |

## 4. question_option

问题选项

| 字段名           | 字段类型         | 字段描述                                                |
|---------------|--------------|-----------------------------------------------------|
| id            | int          | 选项id                                                |
| question      | int          | 对应问题id                                              |
| title         | varchar(255) | 选项描述                                                |
| value         | int          | 选项对应分值                                              |
| question_type | int          | 对应指标 anti_risk:0 return_rate:1 flexibility:2 其他问题:3 |

## 5. answer
风险问卷前端返回是比值：
antiRisk/5.00——3.您投资中对风险波动的厌恶有何种程度？ 低1 中低2 中3 中高4 高5
returnRate/4.00——4.投资目标是
尽可能保证本金安全，收益无所谓1
追求一定收益2
追求较多的收益产生3
实现资产的大幅增长4
stability/6.00——14.工作是什么？  党政机关及事业单位6   一般企业单位5  蓝领4  在校学生3  自由职业 2 无固定职业1
问卷作答

| 字段名      | 字段类型 | 字段描述   |
|----------|------|--------|
| id       | int  | 答案id   |
| question | int  | 对应问题id |
| option   | int  | 选项id   |

## 6. product_param
产品页面跳转网址参数

| 字段名        | 字段类型        | 字段描述 |
|------------|-------------|------|
| id         | int         | id   |
| product_id | int         | 产品id |
| param      | varchar(255) | 网址参数 |

