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

import elemental2.svg.SVGPatternElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * This class provides a wrapper for the {@link SVGPatternElement}, which represents an SVG pattern
 * element. The {@code PatternElement} class allows you to work with pattern elements within the
 * Domino UI framework, making it easier to create and manipulate pattern elements in SVG graphics.
 *
 * @see BaseElement
 * @see SVGPatternElement
 */
public class PatternElement extends BaseElement<SVGPatternElement, PatternElement> {

  /**
   * Factory method for creating a new {@code PatternElement} instance from an existing {@code
   * SVGPatternElement}. This method provides a standardized way of wrapping {@code
   * SVGPatternElement} objects within the Domino UI framework, promoting a consistent object
   * creation pattern.
   *
   * @param e the {@code SVGPatternElement} to wrap
   * @return a new instance of {@code PatternElement}
   */
  public static PatternElement of(SVGPatternElement e) {
    return new PatternElement(e);
  }

  /**
   * Constructs a new {@code PatternElement} by encapsulating the provided {@code
   * SVGPatternElement}. The constructor is protected to encourage the use of the static factory
   * method {@code of()} for creating new instances, ensuring uniformity across the framework.
   *
   * @param element the {@code SVGPatternElement} to be wrapped
   */
  public PatternElement(SVGPatternElement element) {
    super(element);
  }
}
