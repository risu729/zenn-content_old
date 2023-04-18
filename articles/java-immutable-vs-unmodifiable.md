---
title: ""
emoji: "🐕"
type: "tech" # tech: 技術記事 / idea: アイデア
topics: []
published: false
---
Java の標準APIのDocsを読んでいると、Immutable(Stringとか) と Unmodifiable(List.ofで返されるListとか) が区別されて用いられています。また、GuavaのImmutableListなどもあります。
これらの違いがわからず調べたのでまとめてみます。

Immutableの定義は絶対に変化しないことですが、具体的には以下の要件があります。
フィールドを書き換えられないこと。フィールドを追加できないこと。フィールドが全てimmutableであること。

mutableは変更できる

Unmodifiableは直接は変更できないけれど、他からはできる

Guavaのも厳密にはImmutableじゃないから、単に名前が違うだけと捉えればいい

標準APIでのImmutableとUnmodifiableは使い分けられてるはず