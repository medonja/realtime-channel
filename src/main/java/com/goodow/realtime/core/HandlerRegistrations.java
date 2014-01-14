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
package com.goodow.realtime.core;

import com.goodow.realtime.json.Json;
import com.goodow.realtime.json.JsonArray;

/**
 * A {@link HandlerRegistration} that will call {@link HandlerRegistration#unregisterHandler()} on
 * all added handlers if {@link HandlerRegistration#unregisterHandler()} is called on this object.
 */
public class HandlerRegistrations implements HandlerRegistration {
  private JsonArray registrations;

  public void add(HandlerRegistration registration) {
    if (registrations == null) {
      registrations = Json.createArray();
    }
    registrations.push(registration);
  }

  @Override
  public void unregisterHandler() {
    if (registrations != null) {
      for (int i = 0, len = registrations.length(); i < len; i++) {
        registrations.<HandlerRegistration> get(i).unregisterHandler();
      }
      // make sure we remove the handlers to avoid potential leaks
      // if someone fails to null out their reference to us
      registrations.clear();
      registrations = null;
    }
  }
}
