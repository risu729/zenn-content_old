---
title: ""
emoji: "📑"
type: "tech" # tech: 技術記事 / idea: アイデア
topics: []
published: false
---

https://support.google.com/mail/answer/22370

https://qiita.com/rokuosan/items/e3415ea30ad5e48d3b0f

https://support.google.com/a/answer/2716802

https://support.google.com/accounts/answer/185833

https://www.cloudflare.com/ja-jp/learning/email-security/dmarc-dkim-spf/

https://mxtoolbox.com/spf.aspx

CNAME で転送することでその先の SPF を使える
https://stripe.com/docs/payments/account/email-domain#verifying_domain

DMARC Management > レコードを表示 (メール セキュリティ レコード)

https://www.cloudflare.com/ja-jp/learning/dns/dns-records/dns-dmarc-record/

https://www.cloudflare.com/ja-jp/learning/dns/dns-records/dns-spf-record/

https://www.cloudflare.com/ja-jp/learning/dns/dns-records/dns-dkim-record/

https://support.google.com/mail/answer/22370

https://developers.cloudflare.com/dmarc-management/

https://developers.cloudflare.com/email-routing/

https://community.cloudflare.com/t/reply-from-a-custom-address-email/455857/6

https://mupon.net/gmail-alias-on-off/

https://developers.cloudflare.com/email-routing/email-workers/send-email-workers/

あくまでGoogleのサーバーからメールを送信するので、SPFでGoogleから送られていることは証明されるが、DMARCで弾かれる
というか、Googleが安全のために送信するメールアドレスに確認を送っているだけで技術的には偽装できる
ということで、GoogleのSMTPから送るとDMARC fail は不可避らしい

Cloudflare は転送しているので送信もできる…が、認証済みにしか送れないので意味ない

送信はSESから
