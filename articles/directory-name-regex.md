---
title: "ディレクトリ名の正規表現"
emoji: "🎉"
type: "tech" # tech: 技術記事 / idea: アイデア
topics: []
published: false
---
ディレクトリ正規表現
. (only for directory)
case_insensitive, unix case
<>:"/\|?*
integer 0(\x00), 1-31(\x01-1f), 127(\x7f)
CON、PRN、AUX、NUL、COM1、COM2、COM3、COM4、COM5、COM6、COM7、COM8、COM9、LPT1、LPT2、LPT3、LPT4、LPT5、LPT6、LPT7、LPT8、LPT9
ends with . or " "
not empty
max 255 chars
starts with " "

folder
^(?!^(CON|PRN|AUX|NUL|COM[1-9]|LPT[1-9])$)([^\.<>:"/\\\|\?\*\x00-\x20\x7f][^\.<>:"/\\\|\?\*\x00-\x1f\x7f]{0,253}[^\.<>:"/\\\|\?\*\x00-\x20\x7f]|[^\.<>:"/\\\|\?\*\x00-\x20\x7f])$

file
^(?!^(CON|PRN|AUX|NUL|COM[1-9]|LPT[1-9])(\..*$|$))([^<>:"/\\\|\?\*\x00-\x20\x7f][^<>:"/\\\|\?\*\x00-\x1f\x7f]{0,253}[^\.<>:"/\\\|\?\*\x00-\x1f\x7f ]|[^\.<>:"/\\\|\?\*\x00-\x20\x7f])$

https://regex101.com/
https://uxmilk.jp/50674
https://www-creators.com/archives/4304
https://learn.microsoft.com/ja-jp/troubleshoot/windows-client/shell-experience/file-folder-name-whitespace-characters