---
title: ""
emoji: "👌"
type: "tech" # tech: 技術記事 / idea: アイデア
topics: []
published: false
---
TypeAdapterが必要なのがたまーにある

Path、hierarchy使う
OffsetDateTime, LocalDateTimeなど

Path
インターフェースなので(？)そのままでは変換できない
jsonで必ず/または\にしないとjvmの実行環境によって互換性が消える、区切り文字は指定しよう
LocalDate
Immutableだからか変換できない
自分で作ろう(DateTimeFormatterも指定できて良い)
Semver
int配列にしたりstringにしたり
自身で指定してもいいし、1.0.0みたいにシンプルなときのみint配列にしてもいい、あんまり良くないかも()

singletonにしてnullsafe使うが、メモリ確保してしまうから随時作りたい場合はファクトリメソッドで使うべきかもーてか絶対にそう