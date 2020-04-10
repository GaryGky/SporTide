# 体育赛事咨询平台

### 项目目标：

本项目计划**面向某类竞赛项目**（**NBA**），基于目前可公开访问的赛事数据资讯源头，开发一款体育赛事资讯平台。本项目应实现数据采集，赛事列表查看，赛事数据详情查看，发表评论，比赛结果预测等功能。

### Content

### Game:

MySQL中按照队名对表进行排序

1. Team：队伍(30支队伍的数据)
2. Game：Team的比赛编号
3. Date：比赛日期
4. Home：主场球队
5. Opponent：客场球队
6. Win or Loss：输赢

### Team and Opponent:

1. Team Points：队伍得分
2. Field Goals：总的投篮得分
3. Field Goals Attempted：出手次数
4. Field Goals Percentage：命中率
5. 3 Point Shots：三分球得分
6. 3 Point Shots Attempted：三分球出手
7. 3 Point Shots Percentage：三分命中率
8. Free Throws：罚球得分
9. Free Throws Attempted：罚球次数
10. Free Throws Percentage：罚球命中率
11. Offensive Rebounds：进攻篮板
12. Total Rebounds：总篮板
13. Assists：助攻
14. Steals：抢断
15. Blocks：盖帽
16. Turnovers：失误
17. Total Fouls：犯规次数

### 主要功能和需求如下

- 数据准备

  请根据现有的可靠数据源头，爬取该类赛事的相关数据。为丰富平台内容，数据内容应包含赛事的基本信息，如时间、参与双方详情、比赛结果、相关比赛数据以及相关精彩瞬间图片等。同时应提供录入新赛事信息的功能（手动或自动）。

- 管理端需求

  需要实现管理员登录、赛事数据库管理、赛事内容管理、录入新赛事信息、用户管理以及留言管理。

- 用户端需求

  需要实现用户浏览赛事列表（已结束赛事与未来赛事）、赛事战报信息与相关图片查看、未来赛事预告提醒、针对某场赛事评论留言与回复评论以及查看系统提供的赛事结果预测。

- AI预测

  系统根据自己的预测算法结合过往比赛数据，对未来的比赛进行胜率（或比分）预测，为用户提供参考。



### 数据库设计

- #### score表

  - Team 和 opponent指定对战双方 String
  - Home：标识主客场 String
  - TeamPoints： 主场球队得分 int
  - OpponentPoint：客场球队得分 int

  说明：

  1. 对分数添加了check约束，每支球队单场得分的范围(0,300)
  2. 

- #### user表

  - 用户名 username 
  - 用户ID 唯一标识
  - 性别 sex
  - 所在地 addr
  - 关注的球队 Follow
  - 发表的评论 comments
  - 回帖 reply

- #### comments  评论表

  



### 软工进度

- #### 第一周 4.10

  贺行健：周报、需求规格和概要设计
  张佳一：数据实时获取
  毛豫新：管理端前端
  甘凯元：管理端后端
  
  - #### 4/10 21:12更新：代码部署说明
  
    - For ALL
  
      `IDEA2018.3+ `
  
      `MAVEN3.6+ `
  
      `TomCAT9+`
  
    - For 前端
  
      前端的界面主要是在web/WEB-INF/jsp文件夹下新建jsp文件
  
      前端请求后端需要用到Servlet的request和response
  
      `com.hupu.controller`文件夹下用来连接前后端数据，数据交换形式为json
  
    - For 后端
  
      DAO层进行SQL操作
  
      POJO层是对数据库元素的封装
  
      SERVICE层是业务层，未来的业务逻辑可能要在这层实现
  
    emmm我个人作业的文档对spring层次描写的比较清楚，可以看看~
  
    连接：<https://github.com/GaryGky/SE-Peroject1>

