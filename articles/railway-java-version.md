---
title: "RailwayでJavaのバージョンを変更する方法"
emoji: "🚝"
type: "tech" # tech: 技術記事 / idea: アイデア
topics: ["railway", "java"]
published: false
---

# TL;DR

サービスの `Variables` に `NIXPACKS_JDK_VERSION` を追加することで、Javaのバージョンを指定できます。


![variables](/images/railway-java-version/railway-variables.png)

# Railway とは

Heroku などの代替となる無料で使える PaaS サービスです。
様々な言語でデプロイすることができ、もちろんJavaにも対応しています。

# Java