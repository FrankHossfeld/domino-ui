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
package org.dominokit.domino.ui.icons.lib;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.icons.MdiIconsByTagFactory;

/**
 * This is a generated class, please don't modify
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class Arrange_Factory implements MdiIconsByTagFactory {
  private static final List<Supplier<MdiIcon>> icons = new ArrayList();

  private static final Arrange tagIcons = new Arrange() {};

  static {
    icons.add(() -> tagIcons.arrange_bring_forward_arrange());
    icons.add(() -> tagIcons.arrange_bring_to_front_arrange());
    icons.add(() -> tagIcons.arrange_send_backward_arrange());
    icons.add(() -> tagIcons.arrange_send_to_back_arrange());
    icons.add(() -> tagIcons.flip_horizontal_arrange());
    icons.add(() -> tagIcons.flip_to_back_arrange());
    icons.add(() -> tagIcons.flip_to_front_arrange());
    icons.add(() -> tagIcons.flip_vertical_arrange());
    icons.add(() -> tagIcons.vector_arrange_above_arrange());
    icons.add(() -> tagIcons.vector_arrange_below_arrange());
  }

  /** {@inheritDoc} */
  @Override
  public List<Supplier<MdiIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
