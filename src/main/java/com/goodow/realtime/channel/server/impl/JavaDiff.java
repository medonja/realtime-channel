/*
 * Copyright 2014 Goodow.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.goodow.realtime.channel.server.impl;

import com.goodow.realtime.core.Diff;
import com.goodow.realtime.json.JsonArray;

import java.util.Comparator;
import java.util.LinkedList;

import org.bitbucket.cowwoc.diffmatchpatch.DiffMatchPatch;

public class JavaDiff implements Diff {
  private final DiffMatchPatch dmp = new DiffMatchPatch();

  @Override
  public void diff(String before, String after, ListTarget<String> target) {
    LinkedList<DiffMatchPatch.Diff> diffs = dmp.diffMain(before, after);
    dmp.diffCleanupSemantic(diffs);
    int cursor = 0;
    for (DiffMatchPatch.Diff diff : diffs) {
      String text = diff.text;
      int len = text.length();
      switch (diff.operation) {
        case EQUAL:
          cursor += len;
          break;
        case INSERT:
          target.insert(cursor, text);
          cursor += len;
          break;
        case DELETE:
          target.remove(cursor, len);
          break;
        default:
          throw new RuntimeException("Shouldn't reach here!");
      }
    }
  }

  @Override
  public void diff(JsonArray before, JsonArray after, ListTarget<JsonArray> target,
                   Comparator<Object> comparator) {

  }
}