---
title: "【Java】ビットマスクとEnumの変換方法"
emoji: "😷"
type: "tech" # tech: 技術記事 / idea: アイデア
topics: ["java"]
published: true
---

# ビットマスクとは

ビットマスクとは、2進数の整数の各桁(ビット)をフラグに割り当ててフラグの組み合わせを表現するものです。
型は整数なのでintになります。2進数表記するとフラグの組み合わせになるだけで特殊なデータではありません。

詳しくはこちらの記事がわかりやすくおすすめです。
https://qiita.com/drken/items/7c6ff2aa4d8fce1c9361

# Javaにおけるビットマスクの歴史

元々、Javaでは定数の組み合わせの表現にint定数のビット和(AND)=ビットマップが用いられていました。
しかし、定数を引数とすると任意のintが渡せてしまうなどの問題からJava 5でEnumが導入されたという歴史があります。(なのでJava 5以前の標準ライブラリでint定数が用いられていることがあります)

int定数がEnum定数となったことで、ビットマップはEnumSetとなりました。
プログラムが明確になる上、パフォーマンスも十分なのでビットマップを使うことは推奨されていません。(Effective Java 項目36 ビットフィールドの代わりにEnumSetを使う)
しかし、外部APIとのデータ受け渡しにおいてもビットマップが用いられていることがあるので、その際にEnumSetとビットマスク(int)の変換が必要になります。

# 方法1. Enumクラスに変換メソッドを定義

Enumクラス自体にstaticな変換メソッドを定義します。
Enum定数に値を定義することで、これを変更しない限りビットマスクの互換性を保つことができます。

https://github.com/risu729/zenn-content/blob/main/code/java-enum-bitmask-conversion/EnumExample.java

# 方法2. 変換用ユーティリティクラス

全てのEnumに変換メソッドを定義しなくて良いように、ユーティリティクラスを作成します。
ただし、この実装はEnum.ordinal()によってEnum定数の宣言順に依存するので並び替え/削除をするとそれ以前に生成したビットマスクと互換性がなくなります。

https://github.com/risu729/zenn-content/blob/main/code/java-enum-bitmask-conversion/EnumSetBitmaskConverter.java

# 方法3. ビットフラグ用インターフェース＆変換用ユーティリティクラス

宣言順の変更があっても互換性を保つことができるよう、方法2のユーティリティクラスに方法1のようにbitflagを定義してあるEnumクラスのみ渡せるようにします。

まず、インターフェースでoffsetを保存することをEnumに強制し、bitflagを取得できるようにします。
https://github.com/risu729/zenn-content/blob/main/code/java-enum-bitmask-conversion/BitflagGetable.java

このインターフェースを実装したEnumは以下のようになります。
https://github.com/risu729/zenn-content/blob/main/code/java-enum-bitmask-conversion/BitflagGetableImpl.java

そして、ユーティリティクラスではジェネリクスで引数となるEnumにこのインターフェースを実装していることを要求します。
https://github.com/risu729/zenn-content/blob/main/code/java-enum-bitmask-conversion/SafeEnumSetBitmaskConverter.java

# 終わりに

Enumが少なければ方法1で良さそうですが、共通化する際に宣言順を変更しても問題ないようにすると方法3のように面倒になってしまいました…
何かより良い方法があれば教えていただけると助かります。
