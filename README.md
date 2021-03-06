## Sportide-后端设计报告

| 文件标识： |           |
| ---------- | --------- |
| 当前版本： | 1.0       |
| 作 者：    | 甘凯元    |
| 完成日期： | 2020-5-12 |

版 本 历 史

| **版本/状态** | **作者** | **审核人** | **起止日期** | **备注** |
| ------------- | -------- | ---------- | ------------ | -------- |
| 1.0           | 甘凯元   | yuxinmao   | 2019-5-12    | ALPHA    |

目 录

1 文档介绍 5

>   1.1 文档目的 5

>   1.2 文档范围 5

>   1.3 读者对象 5

2 设计要点 6

3 接口设计 6

>   3.1 接口getlimituser定义 6

>   3.2 接口addadmin定义 7

>   3.3 接口deluser定义 7

>   3.4 接口updateuser定义 7

>   3.5 接口login定义 7

>   3.6 接口getteambylimit定义 8

>   3.7 接口getscorebygame定义 8

>   3.8 接口getplayerbygame定义 8

>   3.9 接口getteamscorebygame定义 8

>   3.10 接口getgameindex定义 9

>   3.11 接口updategamescore定义 9

>   3.12 接口getgameinfo定义 9

>   3.13 接口future定义 9

>   3.14 接口login定义 10

>   3.15 接口python定义 10

>   3.16 接口recap定义 10

4 数据结构设计 12

>   4.1 AdminS 12

>   4.2 comment 13

>   4.3 future_games 13

>   4.4 game 13

>   4.5 player_score_stats 14

>   4.6 post 14

>   4.7 recap 14

>   4.8 team 15

>   4.9 team_score_stats 15

>   4.10 user 16

>   4.11 season2019 16

# 文档介绍

## 文档目的

用于web前端和手机端开发人员了解api接口。

## 文档范围

后端主要技术手段、api接口以及数据库表项。

## 读者对象

Web前端开发人员、手机端开发人员、产品经理。

# 设计要点

后端主要是用了SSM(spring+springMVC+Mybatis)作为整体框架，选用了mysql作为数据库，并使用nginx作为反向代理，并配置了redis。

# 接口设计

| **序号** | **前缀**     | **接口编号/名称**       | **来源/文档编号** | **说明**                         |
|----------|--------------|-------------------------|-------------------|----------------------------------|
|          | **/user**    | **/getLimitUser**       |                   | **获得所有用户的信息（除密码）** |
|          | **/user**    | **/addAdmin**           |                   | **添加管理员**                   |
|          | **/user**    | **/delUser**            |                   | **删除用户**                     |
|          | **/user**    | **/updateUser**         |                   | **更新用户信息**                 |
|          | **/user**    | **/login**              |                   | **用户手机端登录**               |
|          | **/team**    | **/getTeamByLimit**     |                   | **获得全部球队的信息**           |
|          | **/team**    | **/updateTeamInfo**     |                   | **更新球队信息**                 |
|          | **/game**    | **/getGameByLimit**     |                   | **获取所有比赛信息**             |
|          | **/game**    | **/getScoreByGame**     |                   | **获得比赛双方的得分数据**       |
|          | **/game**    | **/getPlayerByGame**    |                   | **获得一场比赛的球员统计数据**   |
|          | **/game**    | **/getTeamScoreByGame** |                   | **获得一场比赛的球队统计数据**   |
|          | **/game**    | **/getGameIndex**       |                   | **通过日期获得比赛**             |
|          | **/game**    | **/updateGameScore**    |                   | **修改比赛的比分**               |
|          | **/game**    | **/getGameInfo**        |                   | **获得比赛基本信息**             |
|          | **/future**  | **/getGamePreView**     |                   | **请求比赛前瞻**                 |
|          | **/future**  | **/getAllFutureGame**   |                   | **请求所有未进行的比赛**         |
|          | **/recap**   | **/getRecap**           |                   | **通过比赛获得战报**             |
|          | **/recap**   | **/getRecapByDate**     |                   | **获取当天比赛战报**             |
|          | **/login**   | **/adminLogin**         |                   | **登录**                         |
|          | **/login**   | **/logout**             |                   | **登出**                         |
|          | **/login**   | **/register**           |                   | **注册**                         |
|          | **/python**  | **/predictGames**       |                   | **预测比赛胜负**                 |
|          | **/python**  | **/crawlGames**         |                   | **爬取新的比赛数据**             |

## 接口getLimitUser定义

获取所有用户 GET /user/getLimitUser

| **序号** | **字段** | **长度** | **类型**           | **说明**            |
|----------|----------|----------|--------------------|---------------------|
|          | request  | Argv     | HttpServletRequest | Http请求Servlet接口 |
|          | 返回值   |          | Json               | 用户信息List        |

## 接口addAdmin定义

添加管理员:POST /user/addAdmin

| **序号** | **字段** | **长度** | **类型** | **说明**     |
|----------|----------|----------|----------|--------------|
|          | name     | argv     | str      | 管理员名称   |
|          | pwd      | Argv     | str      | 管理员密码   |
|          | 返回值   |          | int      | 是否注册成功 |

## 接口delUser定义

添加管理员: POST /user/delUser

| **序号** | **字段** | **长度** | **类型** | **说明** |
|----------|----------|----------|----------|----------|
|          | id       |          | int      | 用户ID   |
|          | 返回值   |          | Str      | 是否成功 |

## 接口updateUser定义

更新用户信息：POST /user/updateUser

| **序号** | **字段** | **长度** | **类型** | **说明**     |
|----------|----------|----------|----------|--------------|
|          | user     | argv     | User     | 一个用户     |
|          | 返回值   |          | json     | 是否修改成功 |

## 接口login定义

管理员登录: /user/login

| **序号** | **字段**             | **长度** | **类型** | **说明**                                    |
|----------|----------------------|----------|----------|---------------------------------------------|
|          | Map\<String,Object\> | argv     | json     | Key: user_name, password Value:用户名和密码 |
|          | 返回值               |          | Int      | 是否成功                                    |

## 接口getTeamLimit定义

获取球队 GET /team/getTeamLimit

| **序号** | **字段** | **长度** | **类型** | **说明**       |
|----------|----------|----------|----------|----------------|
|          | 返回值   |          | json     | 30支球队的信息 |

## 接口updateTeamInfo定义

获取球队 GET /team/getTeamInfo

| **序号** | **字段**  | **长度** | **类型** | **说明**     |
|----------|-----------|----------|----------|--------------|
|          | teamId    |          | Str      | 球队名       |
|          | Field     |          | str      | 修改的字段   |
|          | New_value |          | Str      | 赋予的新值   |
|          | 返回值    |          | int      | 是否更新成功 |

## 接口getGameByimt定义

获取比赛信息 GET /game/getGameLimit

| **序号** | **字段** | **长度** | **类型**    | **说明**             |
|----------|----------|----------|-------------|----------------------|
|          | 返回值   |          | List\<Map\> | 向管理端返回比赛信息 |

## 接口getScoreByGame定义

GET /game/getScoreByGame

| **序号** | **字段** | **长度** | **类型** | **说明**                 |
|----------|----------|----------|----------|--------------------------|
|          | gameId   |          | int      | 比赛Id                   |
|          | 返回值   |          | Json     | 获得一场比赛双方得分数据 |

## 接口getPlayerByGame定义

GET /game/getPlayerByGame

| **序号** | **字段** | **长度** | **类型** | **说明**     |
|----------|----------|----------|----------|--------------|
|          | gameId   |          | int      | 比赛Id       |
|          | 返回值   |          | Json     | 球员统计数据 |

## 接口getTeamScoreByGame定义

GET /game/getTeamScoreByGame

| **序号** | **字段** | **长度** | **类型** | **说明**               |
|----------|----------|----------|----------|------------------------|
|          | gameId   |          | int      | 比赛Id                 |
|          | 返回值   |          | Json     | 一场比赛的球队统计数据 |

## 接口getGameIndex定义

GET /game/getGameIndex

| **序号** | **字段** | **长度** | **类型** | **说明**                                     |
|----------|----------|----------|----------|----------------------------------------------|
|          | date     |          | Str      | 日期                                         |
|          | 返回值   |          | Json     | 返回List\<已结束比赛\>或者List\<未进行比赛\> |

## 接口updateGameScore定义

GET /game/getGameScore

| **序号** | **字段** | **长度** | **类型** | **说明**     |
|----------|----------|----------|----------|--------------|
|          | gameId   |          | Int      | 比赛Id       |
|          | Newscore |          | str      | 修改为新比分 |
|          | 返回值   |          | int      | 是否修改成功 |

## 接口getGameInfo定义

GET /game/getGameInfo

| **序号** | **字段** | **长度** | **类型** | **说明**                           |
|----------|----------|----------|----------|------------------------------------|
|          | gameId   |          | Int      | 比赛Id                             |
|          | 返回值   |          | Json     | 比赛基本信息（场馆、时间、人数等） |

## 接口future定义

获得比赛前瞻: GET /future/getAllFuture

| **序号** | **字段** | **长度** | **类型** | **说明**             |
|----------|----------|----------|----------|----------------------|
| 1        | 返回值   |          | Json     | 请求所有未进行的比赛 |

获取一场比赛的前瞻: GET /future/getGamePreview

| **序号** | **字段** | **长度** | **类型** | **说明**                                 |
|----------|----------|----------|----------|------------------------------------------|
| 1        | gameId   |          | int      | 比赛Id                                   |
| 2        | 返回值   |          | Json     | 返回一场比赛的前瞻内容（胜率，历史数据） |

## 接口Python定义

AI预测: POST /python/predictGames

| **序号** | **字段** | **长度** | **类型** | **说明**     |
|----------|----------|----------|----------|--------------|
| 1        | 返回值   |          | Str      | 预测是否成功 |

爬取当天数据POST /python /crawlGames"

| **序号** | **字段** | **长度** | **类型** | **说明**     |
|----------|----------|----------|----------|--------------|
| 1        | dates    |          | str      | 请求日期     |
| 2        | 返回值   |          | json     | 是否爬取成功 |

## 接口getRecap定义

请求战报: GET /recap/getRecap

| **序号** | **字段** | **长度** | **类型** | **说明** |
|----------|----------|----------|----------|----------|
| 1        | gameId   |          | int      | 比赛Id   |

按日期请求战报 GET /recap/getRecapByDate

| **序号** | **字段** | **长度** | **类型** | **说明**             |
|----------|----------|----------|----------|----------------------|
| 1        | date     |          | str      | 请求日期             |
| 2        | 返回值   |          | json     | 返回请求日期当天战报 |

## 接口Login定义

登出管理端: /login/logout

| **序号** | **字段** | **长度** | **类型** | **说明** |
|----------|----------|----------|----------|----------|
| 1        | 返回值   |          | str      | 登出系统 |

管理员登录，POST /login/adminLogin

| **序号** | **字段** | **长度** | **类型** | **说明**     |
|----------|----------|----------|----------|--------------|
| 1        | name     |          | Str      | 管理员用户名 |
| 2        | password |          | str      | 管理员密码   |
| 3        | 返回值   |          |          | 是否登录成功 |

# 数据结构设计

| **序号** | **类型**   | **数据编号/名称**  | **来源/文档编号** | **说明**                |
|----------|------------|--------------------|-------------------|-------------------------|
|          | 数据库表   | admins             |                   | 管理员                  |
|          | 数据库表   | Comment            |                   | 评论                    |
|          | 数据库表   | Future_games       |                   | 机场                    |
|          | 数据库表   | Game               |                   | 比赛基本数据            |
|          | 数据库表   | Player_score_stats |                   | 球员统计数据            |
|          | 数据库表   | Post               |                   | 管理员发布的新闻        |
|          | 数据库表   | Recap              |                   | 比赛战报                |
|          | 数据库表   | Team               |                   | 球队信息                |
|          | 数据库表   | Team_score_stats   |                   | 球队数据统计            |
|          | 数据库表   | User               |                   | 用户表                  |
|          | 数据库视图 | Season2019         |                   | 统计2019-2020赛季的game |

## Admins

| **序号** | **字段**   | **类型**     | **说明**               |
|----------|------------|--------------|------------------------|
|          | admin_id   | int(8)       | 管理员Id               |
|          | admin_name | varchar(255) | 管理员名称             |
|          | admin_pwd  | blob         | 管理员密码（对称加密） |

## comment

| **序号** | **字段**       | **类型**     | **说明**         |
|----------|----------------|--------------|------------------|
|          | comment_id     | int(16)      | 评论Id           |
|          | comment_info   | varchar(255) | 评论信息         |
|          | comment_status | varchar(255) | 评论状态         |
|          | comment_time   | varchar(255) | 评论时间         |
|          | post_id        | int(8)       | 评论的新闻或比赛 |
|          | to_uid         | int(8)       | 新闻发起者       |
|          | from_uid       | int(8)       | 评论的用户       |

## Future_games

| **序号** | **字段**      | **类型**     | **说明** |
|----------|---------------|--------------|----------|
|          | gameId        | varchar(255) | 比赛Id   |
|          | home          | varchar(255) | 主场球队 |
|          | away          | varchar(255) | 客场球队 |
|          | gameTime      | varchar(255) | 比赛时间 |
|          | home_win_rate | varchar(255) | 主队胜率 |
|          | away_win_rate | varchar(255) | 客队胜率 |

## Game

| **序号** | **字段**   | **类型**    | **说明** |
|----------|------------|-------------|----------|
|          | gameId     | int(11)     | 比赛Id   |
|          | gameTime   | varchar(32) | 比赛时间 |
|          | consumTime | varchar(32) | 比赛耗时 |
|          | arena      | varchar(32) | 比赛球馆 |
|          | peopleNum  | varchar(32) | 上座人数 |

## Player_score_stats

| **序号** | **字段**     | **类型**    | **说明**                  |
|----------|--------------|-------------|---------------------------|
|          | id           | int(11)     | 球员统计Id                |
|          | teamId       | varchar(32) | 球队名                    |
|          | teamStatsId  | int(11)     | 球队数据                  |
|          | playerName   | varchar(32) | 球员名字                  |
|          | isFirst      | int(11)     | 是否未首发                |
|          | position     | varchar(32) | 球员位置                  |
|          | playMinute   | int(11)     | 上场时间                  |
|          | shot         | varchar(32) | 命中次数-出手次数         |
|          | threeShot    | varchar(32) | 三分命中次数-三分出手次数 |
|          | penaltyShot  | varchar(32) | 罚球命中-罚球             |
|          | frontCourt   | int(11)     | 前场篮板次数              |
|          | backCourt    | int(11)     | 后场篮板次数              |
|          | rebound      | int(11)     | 篮板次数                  |
|          | assist       | int(11)     | 助攻次数                  |
|          | foul         | int(11)     | 犯规次数                  |
|          | steal        | int(11)     | 抢断次数                  |
|          | fault        | int(11)     | 技术犯规次数              |
|          | block        | int(11)     | 盖帽次数                  |
|          | score        | int(11)     | 得分                      |
|          | Contribution | int(11)     | 正负值                    |

## Post

| **序号** | **字段**        | **类型**     | **说明** |
|----------|-----------------|--------------|----------|
|          | post_id         | int(8)       | 新闻Id   |
|          | post_type       | varchar(20)  | 新闻类型 |
|          | post_info       | varchar(255) | 新闻内容 |
|          | post_time       | varchar(15)  | 发起时间 |
|          | post_collectnum | int(8)       | 收藏数量 |
|          | post_commentnum | int(8)       | 评论量   |
|          | post_readNum    | int(8)       | 阅读量   |

## P2pelement

| **序号** | **字段** | **类型**     | **说明**      |
|----------|----------|--------------|---------------|
|          | gameId   | int(11)      | 比赛Id        |
|          | header   | varchar(64)  | 战报头部内容  |
|          | content  | text         | 战报内容      |
|          | updTime  | varchar(32)  | 战报时间      |
|          | capture  | varchar(256) | 战报图片的url |

## Team

| **序号** | **字段**    | **类型**    | **说明**     |
|----------|-------------|-------------|--------------|
|          | teamId      | varchar(32) | 球队名称     |
|          | teamName    | varchar(32) | 球队中文名   |
|          | buildTime   | varchar(32) | 建立时间     |
|          | area        | varchar(32) | 所属赛区     |
|          | homeCourt   | varchar(32) | 主场球馆     |
|          | chiefCoach  | varchar(32) | 主教练       |
|          | logoUrl     | varchar(64) | Logo的URL    |
|          | website     | varchar(64) | 球队官网连接 |
|          | description | text        | 球队描述     |

## Team_score_stats

| **序号** | **字段** | **类型**   | **说明**   |
|----------|----------|------------|------------|
|          | id       | int(11)    | 球队统计ID |
|          | teamId   | varchar(8) | 球队ID     |
|          | gameId   | int(11)    | 比赛ID     |
|          | isHome   | int(11)    | 是否主场   |
|          | score1   | int(11)    | 第一节得分 |
|          | score2   | int(11)    | 第二节得分 |
|          | score3   | int(11)    | 第三节得分 |
|          | score4   | int(11)    | 第四节得分 |
|          | score    | int(11)    | 总得分     |

## friendship_block

| **序号** | **字段**      | **类型**     | **说明**             |
|----------|---------------|--------------|----------------------|
|          | user_id       | int(8)       | 用户ID               |
|          | user_name     | varchar(31)  | 用户名               |
|          | user_email    | varchar(255) | 用户邮箱             |
|          | user_password | blob         | 用户密码（对称加密） |
|          | user_nikename | varchar(255) | 用户昵称             |
|          | user_time     | varchar(255) | 用户创建时间         |
|          | user_status   | int(1)       | 用户状态             |
|          | user_head     | int(8)       | 用户头像             |
