新核心业务系统
==============

数据库链接
----------

测试库
------

-	User: `v7test`
-	Password `v7test`
-	IP: `172.16.4.18`

开发库
------

-	User: `v7dev`
-	Password `v7dev`
-	IP: `172.16.4.18`

对公客户
--------

```
select * from kcfb_cfdgzj;--对公客户证件表
select * from kcfb_cfdgdz;--对公客户地址表
select * from kcfb_cfdglx;--对公客户联系信息表
select * from kcfb_cfdgjc;--对公客户基础信息表
select * from kcfb_cfdgdl;--对公客户电子联系信息表
select * from kcfb_cfdgfz;--对公客户信息辅助表
select * from kcfb_cfdgfb;--对公客户新增要素信息辅助表
select * from kcfb_cfdgcc;--对公客户批准上级查询表

select * from kdpb_wabhzj
select * from ktlp_gycshu r where r.guiydlzt = '2' and r.guiydaih like 'DC%' order by r.guiydaih asc;
```

同业客户
--------

```
select * from kcfb_cftyzj;--同业客户证件表
select * from kcfb_cftydz;--同业客户地址表
select * from kcfb_cftylx;--同业客户联系信息表
select * from kcfb_cftyjc;--同业客户基础信息表
select * from kcfb_cftydl;--同业客户电子联系信息表
select * from kcfb_cftyfz;--同业客户信息辅助表
select * from kcfb_cftyfb;--同业客户新增要素信息辅助表


select * from kapp_jioyxx where jiaoyima='k029';

select * from kbrp_jycshu where jiaoyima='4019';

```
