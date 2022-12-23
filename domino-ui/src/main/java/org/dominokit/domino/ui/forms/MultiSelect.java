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

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.dominokit.domino.ui.menu.AbstractMenuItem;

public class MultiSelect<V> extends AbstractSelect<V, List<V>, Option<V>, MultiSelect<V>> {

  public <V> MultiSelect<V> create() {
    return new MultiSelect<>();
  }

  public <V> MultiSelect<V> create(String label) {
    return new MultiSelect<>(label);
  }

  public MultiSelect() {
    optionsMenu.setMultiSelect(true);
  }

  public MultiSelect(String label) {
    this();
    setLabel(label);
  }

  public MultiSelect<V> withValue(V... value) {
    return withValue(isChangeListenersPaused(), value);
  }

  public MultiSelect<V> withValue(boolean silent, V... value) {
    return withValue(Arrays.asList(value), silent);
  }

  protected void doSetValue(List<V> value) {
    withPauseChangeListenersToggle(
        true,
        (field, handler) -> {
          value.forEach(v -> findOptionByValue(v).ifPresent(AbstractMenuItem::select));
        });
  }

  @Override
  public List<V> getValue() {
    if (!optionsMenu.getSelection().isEmpty()) {
      return optionsMenu.getSelection().stream()
          .map(AbstractMenuItem::getValue)
          .collect(Collectors.toList());
    }
    return null;
  }
}
