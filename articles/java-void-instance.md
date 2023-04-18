---
title: "java でVoid クラスのインスタンスを作る"
emoji: "🐈"
type: "tech" # tech: 技術記事 / idea: アイデア
topics: []
published: false
---

// java --add-opens java.base/java.lang=ALL-UNNAMED Main.java

final class Main {

  public static void main(String[] args) throws Exception {
    System.out.println(test());
  }

  private static Void test() {
    try {
      var constructor = Void.class.getDeclaredConstructors()[0];
      constructor.setAccessible(true);
      return (Void) constructor.newInstance();
    } catch (InvocationTargetException | InstantiationException |
             IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }
