---
title: "DependabotのPRを自動でマージするGitHub Actions"
emoji: "🔖"
type: "tech" # tech: 技術記事 / idea: アイデア
topics: []
published: false
---
https://docs.github.com/ja/code-security/dependabot/working-with-dependabot/keeping-your-actions-up-to-date-with-dependabot
https://docs.github.com/en/code-security/dependabot/working-with-dependabot/automating-dependabot-with-github-actions
https://github.com/dependabot/fetch-metadata
PRとそのマージで2commitになるのがうざい
rebase / squash で解決、dependabotのprは常に1commitなのでどちらでもいいが、authorの観点からrebase
squashの方がauthor減る&PRへのリンク残る

fetch-metadataで条件付けできるが、気にしなくて良いのならなし
ついでに、dependabotは時間指定とか頻度とか便利なので指定した方がいい
dependabotのpr limit 0

permissions: contents:write & pr: read

autoかどうかどちらでも良い

html url 使わないとダメ、numberだとcheckout必要

@dependabotのコメントで操作した方が手動と統一されててよさげ、rebaseもできるし
