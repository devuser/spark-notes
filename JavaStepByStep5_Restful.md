基本配置
========

swagger
-------

```
127.0.0.1:38080/swagger-ui.html
```

常用维度
--------

-	候选币种 候选单位
-	币种
-	候选单位 [元： 1 万元 10000 亿元: ]

附加参数
--------

-	页码

-	导出的页数限制

-	导出文件清单

-	加密时应定要加密去存

-	用户状态的打开，锁定

-	login_at

-	用户的生命周期

-	用户报表关联表组

```
导出文件时发出请求，请求等待，
发送文件清单，保存文件，
发出导出文件请求，发送文件，
任务结束，
月底时将文件删除。
我们对于导出文件太大时可以压缩文件
```

```
group_id
========

- user_id
```

文档授权表
----------

-授权用户时，类型是unum

-授权报表组时，类型是enum

-	页面配置信息配置表。

-	外部数据配置(增加接口)

-	id -name -conenection -username -password -maxconnections -start_at

-	系统变量表

\*

```
class {
  bizdate
  map[docname]= {is-etltasklist-all-ok, etltasklist}
  timestamp
}
```

id event subevent message operator(system) create_at

```
//看MySQL的端口号：
 echo  $MYSQL_PORT_3306_TCP
```

```
dos中导出文件：
dir >>D:/foo.txt
```

泛型案例
========

```
@RequestMapping(value = "/api/v1/user/{userId}/{appKey}/page-settings", method = RequestMethod.GET,
        produces = {"application/json;charset=UTF-8"})
@ResponseBody
public DocResult<UserSimpleInfo> getPageSettings(@PathVariable("userId") String userId,
                             @PathVariable("appKey") String appKey) {
    UserSimpleInfo info = new UserSimpleInfo(userId, appKey);
    return new DocResult<UserSimpleInfo>(true, info);
}
```

索取报表清单：requesttableList 首先是在redis中存入任务的请求，用hash表

报表描述
========

JSON

查询维度
========

查询机构
--------

-	请求查询机构：'requestorganization'

```
@RequestMapping(value = "/apiv1/{md5}/{organization}requestorganization", method = RequestMethod.post, produces = {"application/json;charset=UTF-8"})
public DocResult<User> requestorganization(@PathVariable("md5") String md5,
                             @RequestParam("username") String username,
                             @RequestParam("password") String password)
```

当登录之后，在用户的权限氛围内用户请求机构的请求

请求存款表格：depositTable

```
@RequestMapping(value = "/apiv1/depositTable", method = RequestMethod.post, produces = {"application/json;charset=UTF-8"})
@ResponseBody
public DocResult<depositTable> depositTable(@PathVariable("md5") String md5,
                             @RequestParam("username") String username,
                             @RequestParam("password") String password)
                             @RequestParam("requestzerodata")
```

报表描述
--------

-	报表编号 - 报表名称 - 业务日期类型（日报、月报、年报） - 业务结束日期 - 业务开始日期 - 币种 - 候选单位 - 当前机构 - 候选维度选择项 单独请求机构树。

-候选维度 -是否分页 - 每页记录数 -文件格式 -页码总数 报表描述时是有优先级的。

报表查询区域
------------

业务结束日期与开始日期必须填写，有日报的开始日期与结束日期一致。

安全需求

请求密码规则
------------

-	密码长度范围 - 密码字符范围 - 报警字符串（：+""） - 密码规则可选 - 密码生效日期 - used代表当前密码规则 - 密码规则产生时间 - @todo

校验规则不一定同时生效， 密码 请求新密码时应该

日志

-	在线用户 - 新增用户

角色管理

日志出来的数据一定是有排序规则的。提供日志页面多列的单独排序，如果客户没有选择则默认排序规则，如点一下便会改变升降排序。

金额一定要有千分符，如100，000 数字部分一定要全部显示出来。日期+时间到分。导出excel表时，金额为万元时金额显示为小数点后两位，但是可以显示完全。列是否能够伸展。 下周一挑选存款或者结算做出一张表格。 。好

客户可见功能接口
================

-	`bizdate` 核心系统的业务日期（日切） @RequestMapping(value = "/api/v1/bizdate", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})

-	每隔五分钟向核心系统查询业务日期，写入Redis bizdate -->

-	客户端查询业务日期

```
@RequestMapping(value = "/api/v1/{md5}/bizdate", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
```

-	核心系统保存的业务日期序列 （时间零点）20170101--到今天
-	日期格式 `yyyy-mm-dd hh:ii:ss`
-	日期范围天数
-	日期范围月数
-	日期范围年份
-	请求报表权限 查询`报表描述` 可查询时间范围(日报，范围) 可以查询的机构树（用户） 候选币种 候选单位

报表权限 ：authority

```
@RequestMapping(value = "/api/v1/authority", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
```

-	币种
-	候选单位 [元： 1 万元 10000 亿元: ]
-	是否分页 分页多少行\* 报表分页：paging

```
@RequestMapping(value = "/api/v1/{line}paging", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
```

-	登录接口：login

```
@RequestMapping(value = "/api/v1/{md5}/login", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
```

-	注销接口：log-off

```
@RequestMapping(value = "/api/v1/{md5}/log-off", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
```

返回：true or fails 只有当登录之后才可以使用该接口。

-	修改密码：amendpassworld

```
@RequestMapping(value = "/api/v1/{md5}/amendpassword", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
```

只有当登录之后才可以使用该接口

-	请求权限：requestauthority

```
@RequestMapping(value = "/api/v1/{md5}/requestauthority", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
```

当用户登录之后，点击登录按钮之后会自动的发送权限请求，从redis中核对了用户之后，根据机构给出他相应的查询权限，并显示相应的机构名称。 返回：相应的权限，和相关的机构名称，

-	请求查询的日期：requestdate

```
@RequestMapping(value = "/api/v1/{md5}/{date}/requestdate", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
```

当用户选择了相应的查询日期之后，发送给后端，后端调用redis中的核心系统的业务日期，并且与用户的请求的日期相比对，如果日期超出核心系统时间零点或者日期超出查询范围则返回error，并提示用户输入正确时间。

-	索取报表清单： `requesttableList`

```
@RequestMapping(value = "/api/v1/{userid}requesttable", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
@ResponseBody
public DocResult<List<table>>reqlist () {
    List<requesttable> reqList = requesttableMapper.<request>selectAll();
    return new DocResult<List<DocDocnames>>(true, reqList);
```

-	接受客户请求后，首先查询Redis - 查询数据库，获取客户可以访问的报表清单 - 将当前用户可以访问的报表清单缓存在Redis。 - 返回报表清单

下次请求时，直接查询Redis。
---------------------------

仅限于保存报表编号。
--------------------

当用户登录时便将所有的表导入到redis中，当用户需要时按照请求的不同给用户不同的表格。

请求存款表格：depositTable

```
@RequestMapping(value = "/api/v1v1/depositTable", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
@ResponseBody
public DocResult<depositTable> depositTable(@PathVariable("md5") String md5,
                             @RequestParam("username") String username,
                             @RequestParam("password") String password)
                             @RequestParam("requestzerodata")
```

更新缓存： 贷款 资金 结算

接口名称
--------

接口分组： 接口名称： 接口输入 接口输出 样例： 调用方法（特别注意前后关系）：

序列图

登录 注销 修改密码 鉴权

请求权限 ----》

绘制查询区域（）

提交请求，索取报表 更新缓存（key value） --- 最近浏览

后台自动缓存（凌晨自动刷新报表，数据写入缓存）
----------------------------------------------

定时任务
========

每隔五分钟核对日切 数据整合任务（基本 存款 贷款 资金 结算）

服务器协同机制
==============

任务协同
========

state (HOLD TODO DONE FAILED) task:taskname:bizdate:state -- state task:taskname:bizdate:systime -- state

task依赖关系（JSON Java)

定时任务的模板
--------------

查询日切 判断依赖任务是否完成 执行 报告状态 写入日志

报表权限
========

-	通用 -

登录请求
--------

-	unload

-	URL：/api/v1/user/{userId}/{appkey} - 请求方式： 'GET' - 请求时间戳timestamp - 请求appId - channelId - 签名 - 返回一个secret（'随机string'+timestamp）

-	登录请求：

-	URL：/api/v1/user/{userId}/{appkey} - 请求方式： 'GET' - 请求时间 - 用户id - user password - secret - 返回：通过校验用户的Id和密码，返回true或者false、user的若干项属性。

-	请求角色权限

-	URL：/api/v1/user/{userId}/{appkey}/roleaccess - 请求方式 ： 'GET' - userId - 返回一个角色权限列表。

-	请求报表权限

-	URL：api/v1/user/{userId}/{appkey}/docaccess - 请求方式： 'GET' - 返回用户所拥有报表清单

-	请求组织机构树

-	URL：api/v1/user/{userId}/{appkey}/orglist - 请求方式： 'GET' - 返回组织机构树清单。

-	请求报表描述

-	URL：api/v1/user/{userId}/{appkey}/docname/{docname}/reportdesc - 请求方式：'GET' - 返回一个报表描述如包含如下内容：

```
- 报表编号
- 报表名称
- 业务日期类型（日报、月报、年报）
- 业务结束日期
- 业务开始日期
- 币种
- 候选单位
- 当前机构
- 候选维度选择项
```

-	请求报表

-	URL：api/v1/user/{userId}/{appkey}/report - 请求方式： 'POST' - 报表描述(包含查询条件) - 返回：

-success（true或者false） - data:

```
- 返回报表描述
- 报表的url
- 报表页数
```

-	请求报表页面

-	URL：/api/v1/user/{userId}/{appkey}/report - 请求方式： 'GET' - 报表url - 返回：报表页面。

-	请求导出报表文件清单

-	URL：api/v1/user/{userId}/{appkey}/report/exportfiles - 请求方式：'POST' - 请求参数：报表描述 - 返回是否导出成功及其导出的报表excel文件清单

-	请求导出报表的文件

-	URL：api/v1/user/{userId}/{appkey}/report/exportfiles/{exportFileId} - 请求方式： 'POST' - 返回一个报表excel文件(给出默认的下载文件名：报表中文名称_填报日期.xls)。

提交新密码
----------

-	URL：api/v1/user/{userId}/{appkey}/users/{userId} - 请求方式： 'PUT' - 原密码 - 新密码 - 确认新密码 - 前置条件：请求密码规则，根据密码规则绘制页面和构建校验条件

请求密码规则
------------

-	请求方式： 'GET' - URL：api/v1/user/{userId}/{appkey}/passwordrules/{current} - 返回密码规则描述如：密码长度，密码字符串规定，最开始应该是默认规则，或者八位数字。

提交密码规则
------------

-	URL：api/v1/user/{userId}/{appkey}/passwordrules
-	请求方式： 'POST'
-	userId
-	密码长度
-	密码字符串
-	密码有效期限
-	请求期限
-	返回true或者false表示设置成功或者失败

提交新增用户
------------

-	URL：api/v1/user/{userId}/{appkey}/users
-	请求方式： 'POST'
-	请求参数：用户描述
-	返回成功或者失败、新增用户描述（屏蔽敏感信息）。

删除用户
--------

-	URL：api/v1/user/{userId}/{appkey}/users/{userId}
-	请求方式： 'DELETE'
-	请求删除的用户Id - 返回成功或者失败

请求日切
--------

-	URL：api/v1/user/{userId}/{appkey}/bizdates/current
-	请求方式：'GET'
-	返回，每隔五分钟求取核心系统的时间，对比核心系统的时间是否更新，如更新则返回true，如没有更新则返回false

请求业务日期清单
----------------

-	URL：api/v1/user/{userId}/{appkey}/bizdates - 请求方式：'GET' - 返回最近一年的业务日期

请求更新数据层
--------------

-	URL：api/v1/user/{system}/{appkey}/etltaskexecution/{bizDate}
-	请求方式：'GET'
-	发布etltask启动指令
-	返回如果前面的请求日切的时间为true则发起这个请求，返回相应新报表。

请求数据层更新状态
------------------

-	URL：api/v1/user/{system}/{appkey}/etltaskstates/{bizDate}
-	请求方式：'GET'
-	返回成功或者失败，data：[etltask]

某个业务日期数据层全部更新完毕的判断标准：

```
- etltaskstates状态全为success：true。


```

请求数据层更新状态
------------------

-	URL：api/v1/user/{system}/{appkey}/etltaskstatebybizdate/{bizDate}
-	请求方式：'GET'
-	返回成功或者失败，data：bizDate

-	ETLTask定义

-	taskId - bizDate - state - bizType

-	请求报表是否准备就绪

-	URL：api/v1/user/{system}/{appkey}/docname/{docnameId}/statebybizdate/{bizDate}

-	请求方式：'GET'

-	返回成功或者失败，data：docnameId,bizDate

BizType的定义
-------------

-	基础

-	存款

-	贷款

-	资金

-	结算

请求浏览历史
------------

-	URL：api/v1/user/{userId}/{appkey}/docname - 请求方式： 'GET' - 返回相应的报表清单，或者返回null，只要提交一次查询报表请求便新增一个浏览历史。

提交新增用户权限
----------------

-	URL：api/v1/user/{admin}/{appkey}/useraccess/{userId} - 请求方式： 'POST' - 请求用户Id - 请求新增权限的用户Id - 请求新增用户的权限 - 返回true或者false

请求新增用户报表权限
--------------------

-	URL：api/v1/user/{admin}/{appkey}/docaccess/{userId} - 请求方式： 'POST' - 请求用户Id - 请求增加权限的而用户Id - 请求的报表权限 - 返回：将权限放入相应的用户，并且返回true或者false

请求日志列表
------------

-	URL：api/v1/user/{userId}/{appkey}/logs
-	请求方式：'POST'
-	事件时间范围
-	返回一个日志的列表(处理分页)

请求(按日)日志列表
------------------

-	URL：api/v1/user/{userId}/{appkey}/logsbydate/{date}
-	请求方式：'GET'
-	返回一个日志的列表(处理分页)

请求导出日志列表
----------------

-	URL：api/v1/user/{userId}/{appkey}/logsbydate/{date}/exportfiles - 返回一个日志列表.xls文件

服务状态
--------

-	请求方式：'GET' - 请求用户Id - 需要查看的事件 - 返回需要查看事件的状态，分为四种：TODO，hold，DONE，error，如果error会返回什么原因出错。

系统当前运行状态
----------------

-	URL：api/v1/user/{userId}/{appkey}/usersstate - 请求方式： 'GET' - 返回：用户账户当前状态列表

数据权限
--------

-	URL：api/v1/user/{userId}/{appkey}/dataaccess/{dataaccessId} - 请求方式：'GET' - 返回：一个数据权限清单列表

-	新增数据权限 - URL：api/v1/user/{userId}/{appkey}/dataaccess/{dataaccessId} - 请求方式：'POST' - 返回：success：true 或者 fail：false

快速授权
--------

-	URL：api/v1/user/{userId}/{appkey}/users/{userId}/roleaccess/{roleid} - 请求方式： 'POST' - 返回：快速授权成功或者失败

报表描述修改
------------

-	URL：api/v1/user/{userId}/{appkey}/docname/{docname}/reportdesc - 请求方式：'PUT' - 修改项编号 - 修改内容 - 返回：修改成功（true）或者失败（false）

请求系统页面参数
----------------

-	URL：api/v1/user/{userId}/{appkey}/pagesetings - 请求方式： 'GET' - 返回：页面设置参数

修改页面配置参数
----------------

-	URL：api/v1/user/{userId}/{appkey}/pagesetings/{pagesetingsId} - 请求方式： 'PUT'
-	修改配置参数编号 - 修改参数配置的内容 - 返回：修改成功（true）或者失败（false）
