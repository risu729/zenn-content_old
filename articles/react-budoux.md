---
title: ""
emoji: "🤖"
type: "tech" # tech: 技術記事 / idea: アイデア
topics: []
published: false
---

"use client"

import { Text, TextProps } from "@chakra-ui/react";
import { loadDefaultJapaneseParser } from "budoux";
import { ReactNode } from "react";

const parser = loadDefaultJapaneseParser();

const BudouxText = ({
 children,
 ...props
}: TextProps & { children: ReactNode }) => {
 return (
  <Text wordBreak="keep-all" overflowWrap="anywhere" {...props}>
   {parser.parse(children as string).join("<wbr />")}
  </Text>
 );
};

export default BudouxText;
