/*
 * Copyright 2014-2019 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.netflix.spectator.log4j;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.spi.StandardLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LevelTagTest {

  @Test
  public void levels() {
    for (StandardLevel std : StandardLevel.values()) {
      Level level = Level.getLevel(std.name());
      Assertions.assertEquals(std, LevelTag.get(level).standardLevel());
    }
  }

  @Test
  public void values() {
    for (LevelTag tag : LevelTag.values()) {
      String v = tag.ordinal() + "_" + tag.name();
      Assertions.assertEquals(v, tag.value());
    }
  }

}
