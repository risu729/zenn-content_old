---
title: "Minecraft Bedrock(統合版) Server を OCI Arm インスタンスで建てる(無料)"
emoji: "💎"
type: "tech" # tech: 技術記事 / idea: アイデア
topics: ["minecraft", "oci", "arm"]
published: false
---

# はじめに

この記事は、2022/09/10に公開されたものです。一部内容は古い可能性があります。最新の情報を確認してください。

# OCI とは

OCI ([Oracle Cloud Infrastructure](https://www.oracle.com/jp/cloud/)) とは、Oracle の提供しているクラウドサービスです。
4OCPU(≒8コア), メモリ24GBというつよつよなArmインスタンスを期間制限なく無料で使用できます。(初月はこれと別で33,000JPYのクレジットが付与されます)

::::details 詳細スペック

アカウントにつき、以下のスペックまで常時無料で使用できます。

||スペック|備考|
|---|---|---|
|CPU|4OCPU(≒8コア)|Ampere社の[Armアーキテクチャ](https://sittoku.net/arm_architecture.html), 最低1OCPU|
|Memory|24GB|最低(OCPU数)|
|ストレージ(ブート・ボリューム)|200GB|デフォルト&最低50GB|
|[ネットワーク帯域幅](https://baremetal.jp/blog/2022/07/13/1220/)|4Gbps|(OCPU数)Gbps|
|OS|Canonical Ubuntu 22.04|Oracle Linux 9 も選択できます|

:::message
このスペックはArmインスタンス(VM.Standard.A1.Flex)のものです。
また、スペックを分割することでインスタンスを複数作成できます。
詳しくは[Oracleのドキュメント](https://baremetal.jp/blog/2022/07/13/1220/)を参照してください。
:::

::::

# アカウント作成

この記事では省略します。(また書いたらリンクを貼っておきます)
:::message alert
無料プラン(Free Tier)ではリージョンを追加したり変更できません。
特定のリージョンではArmインスタンスが制限されていますという旨のメッセージが表示されるので、そこに記載されていないリージョンを選択してください。(2022/08時点では東京とソウルのみ記載)
私は大阪を選択しましたが、2022/08~09にかけてインスタンス作成で制限がかかったことはありません。
:::

# インスタンス作成

# VNC設定

# 環境構築

```bash
wget https://raw.githubusercontent.com/risu729/zenn-content/main/code/minecraft-bedrock-server-oci/setup.sh
chmod +x setup.sh
./setup.sh
rm setup.sh
```

cd bds
LD_LIBRARY_PATH=. screen -S bds ./bedrock_server

# 起動

# クライアントからの接続方法

# サーバーの設定方法 & ワールドのインポート

# おまけ RDP接続

https://qiita.com/non_cal/items/008ef7e1a8bc03415817
https://qiita.com/hnishi/items/3190f2901f88e2594a5f
https://www.openssl.org/source/
https://ohayoyogi.hatenablog.com/entry/2021/12/13/231826
https://nadja.jp/posts/minecraft_on_oci/
https://zenn.dev/fuyutsuki/articles/mcbe-adventcalendar-1221_fbe27c857a043c
