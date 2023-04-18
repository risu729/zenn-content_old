---
title: ""
emoji: "🎃"
type: "tech" # tech: 技術記事 / idea: アイデア
topics: []
published: false
---

/*
 * Copyright (c) 2023 Risu
 *
 *  This source code is licensed under the MIT license found in the
 *  LICENSE file in the root directory of this source tree.
 *
 */

package io.github.risu729.erutcurts.util.gson;

import com.google.gson.FieldNamingStrategy;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class SnakeCaseFieldNamingStrategy implements FieldNamingStrategy {

  private static final String SNAKE_DELIMITER = "_";

  private static final Pattern CAMEL_SEPARATOR = Pattern.compile(
      "(?<=[A-Z])(?=[A-Z][a-z])|(?<=[^A-Z])(?=[A-Z])|(?<=[0-9])(?=[^A-Z0-9])|(?=[0-9])"
          + "(?<=[^0-9])|(?<=[^A-Za-z0-9])(?=[a-z])|(?=[^A-Za-z0-9])(?<=[A-Za-z])");

  private static final SnakeCaseFieldNamingStrategy INSTANCE = new SnakeCaseFieldNamingStrategy();

  private SnakeCaseFieldNamingStrategy() {}

  @Contract(pure = true)
  public static @NotNull SnakeCaseFieldNamingStrategy getInstance() {
    return INSTANCE;
  }

  @Override
  public @NotNull String translateName(@NotNull Field f) {
    return CAMEL_SEPARATOR.splitAsStream(f.getName())
        .map(s -> s.toLowerCase(Locale.ENGLISH))
        .collect(Collectors.joining(SNAKE_DELIMITER));
  }
}
