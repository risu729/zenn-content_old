---
title: "命名規則リスト"
emoji: "🎃"
type: "tech" # tech: 技術記事 / idea: アイデア
topics: []
published: false
---
# はじめに

プログラミングでの命名規則などを見ているとキャメルケースやらスネークケースやら様々な規則が出てきます。
例えばJavaならクラス名にはパスカルケース、メソッド名にはキャメルケース、定数名にはアッパースネークケース…などです。
あるプログラムでこれらの変換が必要になったので整理するために〇〇ケースの種類についてまとめてみました。

# 一覧表

::: note info
各ケース名は詳細な説明にリンクしています
:::

大文字 = Uppercase, Capitals
小文字 = Lowercase

### プログラミング

| 例 | ケース名 | Javaでの主な用途 |
|:-:|:-:|:-:|
| JavaIsTheBest | [Pascal case](#pascalcase) <br> Upper camel case <br> Bumpy case <br> Studly case | クラス名 |
| javaIsTheBest | [Camel case](#camelcase) <br> Lower camel case <br> Dromedary case | メソッド名 <br> 変数名 |
| JAVA_IS_THE_BEST | [Screaming snake case](#screaming_snake_case) <br> Upper snake case <br> Hazard case <br> Constant case <br> Macro case | 定数名 |
| java_is_the_best | [Snake case](#snake_case) <br> Lower snake case <br> Pothole case |  |
| Java_Is_The_Best | [Pascal snake case](#pascal_snake_case) |   |
| java_Is_The_Best | [Camel snake case](#camel_snake_case) |   |
| JAVA-IS-THE-BEST | [Train case](#train-case-1) <br> Upper kebab case <br> Screaming kebab case <br> Upper dash case <br> Upper hyphen case <br> COBOL case |   |
| Java-Is-The-Best | [Train case](#train-case-2) <br> HTTP header case |   |
| java-is-the-best | [Kebab case](#kebab-case) <br> Lower kebab case <br> Spinal case <br> Brochette case <br> Chain case <br> Dash case <br> Hyphen case <br> Param (Parameter) case <br> Lisp case |   |
| java.is.the.best | [Dot case](#dot.case) |   |
| JAVAISTHEBEST | [Upper flat case](#upperflatcase) |   |
| javaisthebest | [Flat case](#flatcase) |   |

### 英文

| 例 | ケース名 | 主な用途 |
|:-:|:-:|:-:|
| Java is the Best | Title case <br> Capital case <br> Headline case | タイトル |
| Java Is The Best | Start case | タイトル |
| JAVA IS THE BEST | All caps (capitals) <br> All uppercase | 強調 |
| ${\rm J{\scriptsize AVA}}$ ${\rm \scriptsize IS}$ ${\rm \scriptsize THE}$ ${\rm \scriptsize BEST}$ | Small caps | タイトル |
| Java is the best | Sentence case | 本文 |
| java is the best | All lowercase | 詩 |
| JaVA iS thE bESt <br> jAVA IS tHe besT | Studly caps |   |

## 大文字/小文字と区切り文字でのまとめ

下の表のように、大文字/小文字の規則と、区切り文字の組み合わせで表すことができます。(英文での特殊なものを除く)

::: note info

- 基本的に数字や記号はそれらの連続を一単語として扱います。(e.g. name_001)
- URLなど全て大文字の単語はその先頭の文字の大文字/小文字に単語全体を合わせます。(e.g. URItoURL, uriToURL, uri-to-url)
:::

| 区切り文字 | UPPERCASE | PascalCase | camelCase | lowercase |
|:-:|:-:|:-:|:-:|:-:|
| **なし** | UPPERFLATCASE | PascalCase | camelCase | flatcase |
| **_ Underscore** | SCREAMING_SNAKE_CASE | Pascal_Snake_Case | camel_Snake_Case | snake_case |
| **- Hyphen** | TRAIN-CASE | Train-Case |   | kebab-case |
| **. Dot** |   |   |   | dot.case |
| **Space** | ALL CAPS | Start Case |   | all lowercase |

- **含まれていないケース**
  - Title Case
  - ${\rm S{\scriptsize MALL}}$ ${\rm \scriptsize CAPS}$
  - Sentence case
  - StuDLy cApS

# 詳細

間違いや補足などありましたら教えていただけると幸いです。

## PascalCase

全ての単語(先頭も含む)の先頭の文字を大文字とする。
URLなどの全て大文字の単語はそのまま用いる。(e.g. MalformedURLException)

| ケース名 | 由来 |
|:-:|:-:|
| Pascal case | Pascal(言語)で用いられる |
| Upper camel case | 大文字がラクダ(camel)のこぶに見えることから <br> Upperは[camelCase](#camelcase)と区別するため |
| Bumpy case | bumpy = でこぼこな |
| Studly case | studly = スパイク(Stud)のような |

## camelCase

先頭以外の全ての単語の先頭の文字を大文字とする。
PascalCaseと同様に、URLなどの全て大文字の単語はそのまま用いるが、先頭の単語の場合は全て小文字とする。(e.g. uriToURL)

単に"Camel case"といった場合、これを示すことが多い。

| ケース名 | 由来 |
|:-:|:-:|
| Camel case | 大文字がラクダ(camel)のこぶに見えることから |
| Lower camel case | [UpperCamelCase](#pascalcase)(PascalCase)と明確に区別するため |
| Dromedary case | dromedary = ヒトコブラクダ🐪 <br> 2単語の場合大文字が1つになることから |

## SCREAMING_SNAKE_CASE

全て大文字で、単語の区切り文字に"_"(アンダースコア)を用いる。

| ケース名 | 由来 |
|:-:|:-:|
| Screaming snake case | アンダースコアで繋げられている様子がヘビ(snake)のように見えることから <br> screaming = 叫んでいる |
| Upper snake case | Upperは[snake_case](#snake_case)と区別するため |
| Hazard case | hazard = 危険 |
| Constant case | 主に定数(constant)に用いられる |
| Macro case | Cプリプロセッサのマクロ(macro)に用いられる |

## snake_case

全て小文字で、単語の区切り文字に"_"(アンダースコア)を用いる。
本来大文字を用いる単語(固有名詞(Japan)、略称(URL)など)も全て小文字にする。

単に"Snake case"といった場合、これを示すことが多い。

| ケース名 | 由来 |
|:-:|:-:|
| Snake case | アンダースコアで繋げられている様子がヘビ(snake)のように見えることから |
| Lower snake case | [UPPER_SNAKE_CASE](#screaming_snake_case)と明確に区別するため |
| Pothole case | pothole = ポットホール(アスファルト舗装の道路にできる穴)

## Pascal_Snake_Case

[PascalCase](#pascalcase)と[snake_case](#snake_case)を合わせたもの。

## camel_Snake_Case

[camelCase](#camelcase)と[snake_case](#snake_case)を合わせたもの。

## TRAIN-CASE (1)

全て大文字で、単語の区切り文字に"-"(ハイフン)を用いる。

単に"Train case"といった場合、これを示すことが多い。
ただし、同名の[Train-Case](#train-case-2)もあるので注意が必要。

| ケース名 | 由来 |
|:-:|:-:|
| Train case | 列車(train)の連結のように見えることから |
| Upper kebab case | ハイフンがケバブ(kebab) の串のように見えることから <br> Upperは[kebab-case](#kebab-case)と区別するため |
| Screaming kebab case | screaming = 叫んでいる |
| Upper dash case | dash = ダッシュ = ハイフン <br> Upperは[dash-case](#kebab-case)(kebab-case)と区別するため |
| Upper hyphen case | hyphen = ハイフン <br> Upperは[hyphen-case](#kebab-case)(kebab-case)と区別するため |
| COBOL case | COBOL(言語)で用いられる |

## Train-Case (2)

全ての単語(先頭も含む)の先頭の文字を大文字とし、単語の区切り文字に"-"(ハイフン)を用いる。
URLなどの全て大文字の単語はそのまま用いる。(e.g. HTTP-Header-Case)
同名の[TRAIN-CASE](#train-case-1)もあるので注意が必要。

| ケース名 | 由来 |
|:-:|:-:|
| Train case | 列車(train)の連結のように見えることから |
| HTTP header case | HTTP(通信プロトコル)のヘッダー(header)で用いられる |

## kebab-case

全て小文字で、単語の区切り文字に"-"(ハイフン)を用いる。
本来大文字を用いる単語(固有名詞(Japan)、略称(URL)など)も全て小文字にする。

単に"Kebab case"といった場合、これを示すことが多い

| ケース名 | 由来 |
|:-:|:-:|
| Kebab case | ハイフンがケバブ(kebab)の串に見えることから |
| Lower kebab case | [UPPER-KEBAB-CASE](#train-case-1)(TRAIN-CASE)と明確に区別するため |
| Spinal case | spinal = 脊柱の |
| Brochette case | brochette = 焼き串 |
| Chain case | chain = 鎖 |
| Dash case | dash = ダッシュ = ハイフン |
| Hyphen case | hyphen = ハイフン  |
| Param case | param = parameter = パラメーター |
| Lisp case | Lisp(言語)で用いられる |

## dot.case

全て全て小文字で、単語の区切り文字に"."(ドット)を用いる。
本来大文字を用いる単語(固有名詞(Japan)、略称(URL)など)も全て小文字にする。

| ケース名 | 由来 |
|:-:|:-:|
| Dot case | dot = ドット |

## UPPERFLATCASE

全て大文字にする。区切りはない。

| ケース名 | 由来 |
|:-:|:-:|
| Upper flat case | flat = 平らな <br> Upperは[flatcase](#flatcase)と区別するため |

## flatcase

全て小文字にする。区切りはない。
本来大文字を用いる単語(固有名詞(Japan)、略称(URL)など)も全て小文字にする。

| ケース名 | 由来 |
|:-:|:-:|
| Flat case | flat = 平らな |

## Title Case

# 感想

使われ始めた当時は名前があったわけではないようで、様々な名前で呼ばれていました。
そして仕様書などでユーモアのある名前を定義して使うようになったようです。
それにしても叫ぶケバブってなんだ…

# 参考

https://en.wikipedia.org/wiki/Letter_case

https://en.m.wikipedia.org/wiki/Naming_convention_(programming)

https://en.wikipedia.org/wiki/Camel_case

https://en.wikipedia.org/wiki/Snake_case

https://qiita.com/terra_yucco/items/ec437c6005932fd73fb9

https://qiita.com/deerboy/items/f035b9044edf9a51aff7

https://future-architect.github.io/coding-standards/documents/forJava/Javaコーディング規約.html
