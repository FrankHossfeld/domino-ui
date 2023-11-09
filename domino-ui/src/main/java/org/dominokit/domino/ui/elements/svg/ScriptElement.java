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
package org.dominokit.domino.ui.elements.svg;

import elemental2.svg.SVGScriptElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * This class provides a wrapper for the {@link SVGScriptElement}, which represents an SVG script
 * element. The {@code ScriptElement} class allows you to work with script elements within the
 * Domino UI framework, making it easier to create and manipulate script elements in SVG graphics.
 *
 * @see BaseElement
 * @see SVGScriptElement
 */
public class ScriptElement extends BaseElement<SVGScriptElement, ScriptElement> {

  /**
   * Factory method for creating a new {@code ScriptElement} instance from an existing {@code
   * SVGScriptElement}. This method provides a standardized way of wrapping {@code SVGScriptElement}
   * objects within the Domino UI framework, promoting a consistent object creation pattern.
   *
   * @param e the {@code SVGScriptElement} to wrap
   * @return a new instance of {@code ScriptElement}
   */
  public static ScriptElement of(SVGScriptElement e) {
    return new ScriptElement(e);
  }

  /**
   * Constructs a new {@code ScriptElement} by encapsulating the provided {@code SVGScriptElement}.
   * The constructor is protected to encourage the use of the static factory method {@code of()} for
   * creating new instances, ensuring uniformity across the framework.
   *
   * @param element the {@code SVGScriptElement} to be wrapped
   */
  public ScriptElement(SVGScriptElement element) {
    super(element);
  }
}
