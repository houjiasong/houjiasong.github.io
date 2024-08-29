+++
title = 'How to Create Website'
date = 2024-07-04T00:38:22+08:00
draft = false
+++

这里先研究下为什么windows创建会失败，创建语句如下：

    hugo new how-to-create-website.md

出错信息如下

    Error: error building site: process: readAndProcessContent: "C:\Users\houjiasong\Desktop\houjiasong.github.io\content\posts\papermod\papermod-installation.md:22:108": failed to extract shortcode: template for shortcode "inTextImg" not found

<!-- 这里是可以看到test-how-to-create-website.md是可以创建成功的 -->

根据报错信息我们可以看到具体位置，首先注释掉使用inTextImg语句的部分，注释掉并没有起到作用，在启动hugo的时候还是爆了和上面一样的问题，索性就先删掉再启动hugo

    Error: error building site: process: readAndProcessContent: "C:\Users\houjiasong\Desktop\houjiasong.github.io\content\posts\papermod\papermod-installation.md:37:3": failed to extract shortcode: template for shortcode "collapse" not found

同样的问题出现了，注释掉代码但是依然会再这里报错，信息如下：

    Error: error building site: process: readAndProcessContent: "C:\Users\houjiasong\Desktop\houjiasong.github.io\content\posts\papermod\papermod-installation.md:109:9": got closing shortcode, but none is open


问题和上面类似都是failed to extract shortcode,把上面报错的都删除之后启动还是失败，先分析一下failed to extract shortcode

theme里面没东西
这个问题是git submodule 的问题
就是说 clone 不会包括submodule里面的内容

下一个问题

    <!-- ERROR error calling resources.GetRemote: Get "https://publish.twitter.com/oembed?dnt=false&url=https%3A%2F%2Ftwitter.com%2Fadityatelange%2Fstatus%2F1724414854348357922": dial tcp 162.125.7.1:443: connectex: A connection attempt failed because the connected party did not properly respond after a period of time, or established connection failed because connected host has failed to respond.
    Total in 21848 ms -->

这个问题始终没有解决，搞不懂为什么在mac上就可以执行hugo server在win10上就出现这样的bug，先看下之前的discord吧
resources.GetRemote因为是获取twitter上面的json资源所以我怀疑是代理的问题，这里就先把example的默认文章先删掉，等之后弄懂clash的原理了再设置，不得不说啊，还是不说了。