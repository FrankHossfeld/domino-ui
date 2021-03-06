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
package org.dominokit.domino.ui.Typography;

import static org.jboss.elemento.Elements.strong;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/** A wrapper component for <strong>strong</strong> HTML tag */
public class Strong extends BaseDominoElement<HTMLElement, Strong> {

  private final HTMLElement element = strong().element();

  public Strong(String text) {
    element.textContent = text;
    init(this);
  }

  /**
   * Creates new instance with text
   *
   * @param text the value
   * @return new instance
   */
  public static Strong of(String text) {
    return new Strong(text);
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return element;
  }
}
