---
title: "【GitHub Actions】 node_modules をキャッシュしてはいけない"
emoji: "😺"
type: "tech" # tech: 技術記事 / idea: アイデア
topics: []
published: false
---

[Title](https://github.com/actions/cache/blob/main/examples.md#node---npm)

[](https://github.com/actions/setup-node/blob/main/docs/advanced-usage.md#caching-packages-data)

Nodeのバージョンアップで壊れる可能性があるのでキャッシュするなとのこと

setup-node のオプションを使いましょう

corepackの場合、未だサポートされていない

[Title](https://github.com/actions/setup-node/issues/531)

pnpm このコメントにあるようにイメージに最初から入っているnodeを使ってcorepack enableすればキャッシュできる

[Title](https://github.com/actions/setup-node/issues/531#issuecomment-1217094233)

[Title](https://github.com/actions/runner-images/blob/main/images/linux/Ubuntu2204-Readme.md)