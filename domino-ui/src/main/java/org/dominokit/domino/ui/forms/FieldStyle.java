/*
 * Copyright © 2019 Dominokit
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
package org.dominokit.domino.ui.forms;

/** An enum to list the types of fields styles */
public interface FieldStyle {

  /** Fields are styles with rounded borders */
  FieldStyle ROUNDED = () -> "rounded";

  /** Fields are styles with bottom border line and greyed boxed area. this is the default style */
  FieldStyle LINED = () -> "lined";

  /** @return String name of the style css class */
  String getStyle();

  /**
   * Applies the style on an element
   *
   * @param valueBox {@link ValueBox}
   */
  default void apply(ValueBox valueBox) {
    FieldStyle fieldStyle = valueBox.getFieldStyle();
    valueBox.removeCss(fieldStyle.getStyle());
    valueBox.css(getStyle());
  }
}
