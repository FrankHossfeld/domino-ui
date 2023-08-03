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
package org.dominokit.domino.ui.i18n;

/**
 * PaginationLabels interface.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public interface PaginationLabels extends Labels {
  /**
   * getPaginationCountLabel.
   *
   * @param pagesCount a int
   * @return a {@link java.lang.String} object
   */
  default String getPaginationCountLabel(int pagesCount) {
    return " of " + pagesCount + " Pages";
  }

  /**
   * getPreviousLabel.
   *
   * @return a {@link java.lang.String} object
   */
  default String getPreviousLabel() {
    return "Previous";
  }

  /**
   * getNextLabel.
   *
   * @return a {@link java.lang.String} object
   */
  default String getNextLabel() {
    return "Next";
  }
}