---
title: "Minecraft Win10 (BE/統合版) で信号強度/チャンク境界表示、暗視のシェーダーを導入する"
emoji: "🐉"
type: "idea" # tech: 技術記事 / idea: アイデア
topics: ["Minecraft", "minecraftbedrock"]
published: true
---

:::message alert
この記事に記載されている内容を実行して発生したいかなる損害についても責任を負いません。
自己責任で試していただくようお願いします。
:::

# はじめに

Minecraft Bedrock Edition (統合版/以下BEと表記) はRTXのレイトレーシングに対応するため描画エンジンをglsl/hlslから"Render Dragon"という独自のものに切り替えました。
これに伴い旧来のシェーダーは一切使えなくなり、信号強度、チャンク境界の表示、暗視も含む、従来のシェーダーは使えなくなってしまいました。
MojangはRender Dragonでもシェーダーの開発をサポートすると表明していますが、2022/11現在全く音沙汰がありません…

しかし、中国の方が描画エンジンのファイルを編集してシェーダーを開発するツール([MaterialBinTool](https://github.com/ddf8196/MaterialBinTool))を制作してくださり、それを使ったシェーダーが公開されています。
Win10版で入れる方法に辿り着くのが大変だったので残しておきます。

![シェーダーを適用した状態のスクリーンショット](/images/minecraft-win10-shader/screenshot.png)

# ファイルの準備

必要なソフト、ファイルをダウンロードします。

## IOBit Unlocker

中国(香港?)のIObit Information Technology社が無料で配布しているファイルのロックを解除するソフトです。

BE Win10 Edition はUWPアプリ(Microsoft Storeからインストールするソフト)なので、Windowsによって保護されていてファイルを編集するのは難しいです。
ファイル/フォルダの所有者や権限を変更したりrobocopyコマンドを使っても閲覧/削除はできても編集はできませんし、デュアルブートしたLinuxから編集しようとしてもフォルダが見えません。

このソフトで無理矢理ロックを解除して編集できますが、安全性に疑念があるようです。使用は自己責任でお願いします。

:::message
以下のサイトにて安全性について書かれています。
https://eizone.info/iobit-software/
:::

使用する場合、以下の公式サイトからダウンロードして、インストーラーの指示に従ってインストールしてください。
https://jp.iobit.com/pc-optimization-software/iobit-unlocker-free.html

## Useless Shader

とてもUsefullなシェーダーです。
信号強度、チャンク境界を表示できます。また、暗視がついているバージョンもあります。

中国の方が開発してくださったもので、GitHubで公開されています。
https://github.com/OEOTYAN/useless-shaders

[Releases](https://github.com/OEOTYAN/useless-shaders/releases)の"v.rd"から始まる最新のバージョン(2022/11/06時点では[v.rd.0.2](https://github.com/OEOTYAN/useless-shaders/releases/tag/v.rd.0.2))の"Assets"から、**RenderChunk.material.zip**(暗視なし)、または、**RenderChunk_NightVision.material.zip**(暗視あり)をダウンロードして解凍してください。

# 描画エンジンの編集

## 元ファイルのバックアップ

まず、描画エンジンの元ファイルをバックアップします。(しなくても構いませんが元に戻したい際、Minecraftを再インストールする必要があります)
`C:\Program Files\WindowsApps\Microsoft.MinecraftUWP_[version]\data\renderer\materials\RenderChunk.material.bin` をドラッグしてIOBit Unlockerに追加します。

:::message
`Micorsoft.MinecraftUWP` から始まるフォルダが複数ある場合、最新バージョンのフォルダを選択してください。
:::

解除の右のプルダウンから**解除&コピー**します。
![IOBit Unlockerでバックアップする](/images/minecraft-win10-shader/iobit-backup.png)
「コピーしたオブジェクトの転送先フォルダを選択してください。」と表示されるので、適当な場所に保存してください。

## 元ファイルの削除

次に、元ファイルを削除します。
同様にファイルをIOBit Unlockerに追加し、解除の右のプルダウンから**解除&削除**します。
![IOBit Unlockerで削除する](/images/minecraft-win10-shader/iobit-delete.png)

一度IOBit Unlockerを**終了**して再度起動してください。

## シェーダーの適用

最後に、Useless Shaderのファイルを元のファイルを置き換えるようにコピーします。
ダウンロードして解凍したシェーダーから、`\RenderChunk.material\Windows\RenderChunk.material.bin` をIOBit Unlockerに追加します。
(暗視ありの場合は `\RenderChunk_NightVision.material\Windows\RenderChunk.material.bin`)

解除の右のプルダウンから**解除&コピー**します。
![IOBit Unlockerでコピーする](/images/minecraft-win10-shader/iobit-copy-1.png)
「コピーしたオブジェクトの転送先フォルダを選択してください。」と表示されるので、`C:\Program Files\WindowsApps\Microsoft.MinecraftUWP_[version]\data\renderer\materials` を選択してください。

:::message
先に削除していない場合、コピーに失敗します。削除してからやり直してください。
:::

# Minecraftの起動

以上でシェーダーの導入は完了です。
BEを通常通りの方法で起動してください。機能が反映されているはずです。
描画エンジンを直接編集しているので、シングル、マルチともに機能します。マルチサーバーなどで使用してBAN等されても責任は負いません。

:::message alert
この方法で導入したシェーダーはオンオフを切り替えることができません。
元に戻す際は最初にバックアップしたファイルを同様の方法で戻すか、Minecraftを再インストールしてください。
再インストールするとデータが消えるので、アンインストールの前に必要なファイルはバックアップすることをお勧めします。
:::

# 他のシェーダー

同様にRender Dragon向けに開発されたシェーダーもこの方法で入れることができます。(複数のシェーダーは同時に使用できません)
シェーダーによっては編集する `.material.bin` ファイルが複数あることもあるので、全て削除してから移動するよう注意してください。(IOBit Unlockerは複数ファイルを同時に選択して操作できます)

## [Musk Rose RD](https://github.com/Rinloid/musk_rose_rd)

日本のRinさんが開発されたシェーダーです。Render Dragon導入前からこの方の他のシェーダーを使用していましたがとても綺麗です。

同様に[Releases](https://github.com/Rinloid/musk_rose_rd/releases)からダウンロードできます。
**Musk_Rose_RD_Base.mcpack**も適用する必要があるので注意してください。
https://github.com/Rinloid/musk_rose_rd

# 参考

Elsa55さんの動画を参考に、というか全く同じことをしています。ありがとうございました。
英語ですが文章で分かりにくい部分があれば見てみてください。
https://www.youtube.com/watch?v=qe7m0YRGHs8&t=279s

また、上記の動画は先程紹介したシェーダーの説明で見つけました。それまで何してもダメだったのでありがたい限りです…
(Android/iOS向けの解説動画のリンクもあります)
https://github.com/Rinloid/musk_rose_rd

# 最後に

何か分からない部分やエラーなどがあればできる限り対応しますのでコメントしてください。(私自身詳しくないのでできない場合もあります)
