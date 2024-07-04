+++
title = '关于为什么count(*)只需要扫描全表一半的行数'
date = 2024-07-05T00:15:58+08:00
draft = false
+++
今天组里的同学在查找慢sql的时候发现一个问题，sql如下：

    explain
    select
    count(*)
    from
    isv_item_poi_0

执行得到结果，扫描了222120行数据，这个时候我们加上 where id > 0, sql如下：

    explain
    select
    count(*)
    from
    isv_item_poi_0
    where 
    id > 0

执行得到结果，扫描了111060行数据，同统计全表有多少行，为什么加上where条件扫描的行数变少了呢。
id是主键自增索引，都是大于0的，由于是统计是全表有多少行，那自然的想法也是应该扫描所有的行数，怎么会因为加上id > 0行数就少了一半呢。
