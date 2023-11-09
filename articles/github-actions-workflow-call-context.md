---
title: ""
emoji: "🕌"
type: "tech" # tech: 技術記事 / idea: アイデア
topics: []
published: false
---

github context は元と共通になる

https://docs.github.com/en/actions/using-workflows/reusing-workflows

When a reusable workflow is triggered by a caller workflow, the github context is always associated with the caller workflow. The called workflow is automatically granted access to github.token and secrets.GITHUB_TOKEN. For more information about the github context, see "Contexts."
