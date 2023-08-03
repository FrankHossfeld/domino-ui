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
package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLDivElement;

/**
 * DivElement class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class DivElement extends BaseElement<HTMLDivElement, DivElement> {
  /**
   * of.
   *
   * @param e a {@link elemental2.dom.HTMLDivElement} object
   * @return a {@link org.dominokit.domino.ui.elements.DivElement} object
   */
  public static DivElement of(HTMLDivElement e) {
    return new DivElement(e);
  }

  /**
   * Constructor for DivElement.
   *
   * @param element a {@link elemental2.dom.HTMLDivElement} object
   */
  public DivElement(HTMLDivElement element) {
    super(element);
  }
}