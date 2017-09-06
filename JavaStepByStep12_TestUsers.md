测试用户集
==========

```
select s.username, g.groupname from (
    select u.username, gu.doc_groups_id from user u
    left join doc_groups_users gu
    on u.id=gu.user_id) s
  left join doc_groups g
  on s.doc_groups_id = g.id;
```

```
+-----------+-------------+
| username  | groupname   |
+-----------+-------------+
| admin     | Admin Group |
| admin     | 测试组      |
| testuser1 | 存款组      |
| testuser1 | 信贷组      |
| testuser2 | 信贷组      |
| testuser3 | 资金组      |
| testuser4 | 结算组      |
+-----------+-------------+
7 rows in set (0.01 sec)
```

如下五名用户可以查询CPFC全辖数据

1.	admin
2.	testuser1
3.	testuser2
4.	testuser3
5.	testuser4

如下四名用户仅可查询对应机构的数据

1.	testuser5 华北分公司
2.	testuser6 华北分公司
3.	testuser7 华北分公司下属河北分公司
4.	testuser8 华北分公司下属河北分公司

```
select u.username,g.orgname from user u left join doc_orgs g on u.doc_org_id=g.id order by u.username;
```

```
+-----------+-----------------+
| username  | orgname         |
+-----------+-----------------+
| admin     | CPFC            |
| testuser1 | CPFC            |
| testuser2 | CPFC            |
| testuser3 | CPFC            |
| testuser4 | CPFC            |
| testuser5 | 华北分公司      |
| testuser6 | 华北分公司      |
| testuser7 | 直属营业部      |
| testuser8 | 直属营业部      |
+-----------+-----------------+
9 rows in set (0.00 sec)
```
