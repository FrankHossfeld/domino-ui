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
package org.dominokit.ui.tools.processor;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Test {

  private static String varName;

  public static void main(String[] args) {
    String colors =
        "--dui-clr-dominant-l-5: #f2f2f2;\n"
            + "    --dui-clr-dominant-l-4: #f2f2f2;\n"
            + "    --dui-clr-dominant-l-3: #f2f2f2;\n"
            + "    --dui-clr-dominant-l-2: #f2f2f2;\n"
            + "    --dui-clr-dominant-l-1: #f2f2f2;\n"
            + "    --dui-clr-dominant: #FFFFFF;\n"
            + "    --dui-clr-dominant-d-1: #f2f2f2;\n"
            + "    --dui-clr-dominant-d-2: #d9d9d9;\n"
            + "    --dui-clr-dominant-d-3: #adadad;\n"
            + "    --dui-clr-dominant-d-4: #797979;\n"
            + "\n"
            + "    --dui-clr-accent-l-5: #ECEFF1;\n"
            + "    --dui-clr-accent-l-4: #CFD8DC;\n"
            + "    --dui-clr-accent-l-3: #B0BEC5;\n"
            + "    --dui-clr-accent-l-2: #90A4AE;\n"
            + "    --dui-clr-accent-l-1: #78909C;\n"
            + "    --dui-clr-accent: #607D8B;\n"
            + "    --dui-clr-accent-d-1: #546E7A;\n"
            + "    --dui-clr-accent-d-2: #455A64;\n"
            + "    --dui-clr-accent-d-3: #37474F;\n"
            + "    --dui-clr-accent-d-4: #263238;\n"
            + "\n"
            + "    --dui-clr-primary-l-5: #E8EAF6;\n"
            + "    --dui-clr-primary-l-4: #C5CAE9;\n"
            + "    --dui-clr-primary-l-3: #9FA8DA;\n"
            + "    --dui-clr-primary-l-2: #7986CB;\n"
            + "    --dui-clr-primary-l-1: #5C6BC0;\n"
            + "    --dui-clr-primary: #3F51B5;\n"
            + "    --dui-clr-primary-d-1: #3949AB;\n"
            + "    --dui-clr-primary-d-2: #303F9F;\n"
            + "    --dui-clr-primary-d-3: #283593;\n"
            + "    --dui-clr-primary-d-4: #1A237E;\n"
            + "\n"
            + "    --dui-clr-secondary-l-5: #ECEFF1;\n"
            + "    --dui-clr-secondary-l-4: #CFD8DC;\n"
            + "    --dui-clr-secondary-l-3: #B0BEC5;\n"
            + "    --dui-clr-secondary-l-2: #90A4AE;\n"
            + "    --dui-clr-secondary-l-1: #78909C;\n"
            + "    --dui-clr-secondary: #607D8B;\n"
            + "    --dui-clr-secondary-d-1: #546E7A;\n"
            + "    --dui-clr-secondary-d-2: #455A64;\n"
            + "    --dui-clr-secondary-d-3: #37474F;\n"
            + "    --dui-clr-secondary-d-4: #263238;\n"
            + "\n"
            + "    --dui-clr-success-l-5: #E8F5E9;\n"
            + "    --dui-clr-success-l-4: #C8E6C9;\n"
            + "    --dui-clr-success-l-3: #A5D6A7;\n"
            + "    --dui-clr-success-l-2: #81C784;\n"
            + "    --dui-clr-success-l-1: #66BB6A;\n"
            + "    --dui-clr-success: #4CAF50;\n"
            + "    --dui-clr-success-d-1: #43A047;\n"
            + "    --dui-clr-success-d-2: #388E3C;\n"
            + "    --dui-clr-success-d-3: #2E7D32;\n"
            + "    --dui-clr-success-d-4: #1B5E20;\n"
            + "\n"
            + "    --dui-clr-warning-l-5: #FFF3E0;\n"
            + "    --dui-clr-warning-l-4: #FFE0B2;\n"
            + "    --dui-clr-warning-l-3: #FFCC80;\n"
            + "    --dui-clr-warning-l-2: #FFB74D;\n"
            + "    --dui-clr-warning-l-1: #FFA726;\n"
            + "    --dui-clr-warning: #FF9800;\n"
            + "    --dui-clr-warning-d-1: #FB8C00;\n"
            + "    --dui-clr-warning-d-2: #F57C00;\n"
            + "    --dui-clr-warning-d-3: #EF6C00;\n"
            + "    --dui-clr-warning-d-4: #E65100;\n"
            + "\n"
            + "    --dui-clr-info-l-5: #E3F2FD;\n"
            + "    --dui-clr-info-l-4: #BBDEFB;\n"
            + "    --dui-clr-info-l-3: #90CAF9;\n"
            + "    --dui-clr-info-l-2: #64B5F6;\n"
            + "    --dui-clr-info-l-1: #42A5F5;\n"
            + "    --dui-clr-info: #2196F3;\n"
            + "    --dui-clr-info-d-1: #1E88E5;\n"
            + "    --dui-clr-info-d-2: #1976D2;\n"
            + "    --dui-clr-info-d-3: #1565C0;\n"
            + "    --dui-clr-info-d-4: #0D47A1;\n"
            + "\n"
            + "    --dui-clr-error-l-5: #FFEBEE;\n"
            + "    --dui-clr-error-l-4: #FFCDD2;\n"
            + "    --dui-clr-error-l-3: #EF9A9A;\n"
            + "    --dui-clr-error-l-2: #E57373;\n"
            + "    --dui-clr-error-l-1: #EF5350;\n"
            + "    --dui-clr-error: #F44336;\n"
            + "    --dui-clr-error-d-1: #E53935;\n"
            + "    --dui-clr-error-d-2: #D32F2F;\n"
            + "    --dui-clr-error-d-3: #C62828;\n"
            + "    --dui-clr-error-d-4: #B71C1C;\n"
            + "\n"
            + "    --dui-clr-red-l-5: #FFEBEE;\n"
            + "    --dui-clr-red-l-4: #FFCDD2;\n"
            + "    --dui-clr-red-l-3: #EF9A9A;\n"
            + "    --dui-clr-red-l-2: #E57373;\n"
            + "    --dui-clr-red-l-1: #EF5350;\n"
            + "    --dui-clr-red: #F44336;\n"
            + "    --dui-clr-red-d-1: #E53935;\n"
            + "    --dui-clr-red-d-2: #D32F2F;\n"
            + "    --dui-clr-red-d-3: #C62828;\n"
            + "    --dui-clr-red-d-4: #B71C1C;\n"
            + "\n"
            + "    --dui-clr-pink-l-5: #FCE4EC;\n"
            + "    --dui-clr-pink-l-4: #F8BBD0;\n"
            + "    --dui-clr-pink-l-3: #F48FB1;\n"
            + "    --dui-clr-pink-l-2: #F06292;\n"
            + "    --dui-clr-pink-l-1: #EC407A;\n"
            + "    --dui-clr-pink: #E91E63;\n"
            + "    --dui-clr-pink-d-1: #D81B60;\n"
            + "    --dui-clr-pink-d-2: #C2185B;\n"
            + "    --dui-clr-pink-d-3: #AD1457;\n"
            + "    --dui-clr-pink-d-4: #880E4F;\n"
            + "\n"
            + "    --dui-clr-purple-l-5: #F3E5F5;\n"
            + "    --dui-clr-purple-l-4: #E1BEE7;\n"
            + "    --dui-clr-purple-l-3: #CE93D8;\n"
            + "    --dui-clr-purple-l-2: #BA68C8;\n"
            + "    --dui-clr-purple-l-1: #AB47BC;\n"
            + "    --dui-clr-purple: #9C27B0;\n"
            + "    --dui-clr-purple-d-1: #8E24AA;\n"
            + "    --dui-clr-purple-d-2: #7B1FA2;\n"
            + "    --dui-clr-purple-d-3: #6A1B9A;\n"
            + "    --dui-clr-purple-d-4: #4A148C;\n"
            + "\n"
            + "    --dui-clr-deep-purple-l-5: #EDE7F6;\n"
            + "    --dui-clr-deep-purple-l-4: #D1C4E9;\n"
            + "    --dui-clr-deep-purple-l-3: #B39DDB;\n"
            + "    --dui-clr-deep-purple-l-2: #9575CD;\n"
            + "    --dui-clr-deep-purple-l-1: #7E57C2;\n"
            + "    --dui-clr-deep-purple: #673AB7;\n"
            + "    --dui-clr-deep-purple-d-1: #5E35B1;\n"
            + "    --dui-clr-deep-purple-d-2: #512DA8;\n"
            + "    --dui-clr-deep-purple-d-3: #4527A0;\n"
            + "    --dui-clr-deep-purple-d-4: #311B92;\n"
            + "\n"
            + "    --dui-clr-indigo-l-5: #E8EAF6;\n"
            + "    --dui-clr-indigo-l-4: #C5CAE9;\n"
            + "    --dui-clr-indigo-l-3: #9FA8DA;\n"
            + "    --dui-clr-indigo-l-2: #7986CB;\n"
            + "    --dui-clr-indigo-l-1: #5C6BC0;\n"
            + "    --dui-clr-indigo: #3F51B5;\n"
            + "    --dui-clr-indigo-d-1: #3949AB;\n"
            + "    --dui-clr-indigo-d-2: #303F9F;\n"
            + "    --dui-clr-indigo-d-3: #283593;\n"
            + "    --dui-clr-indigo-d-4: #1A237E;\n"
            + "\n"
            + "    --dui-clr-blue-l-5: #E3F2FD;\n"
            + "    --dui-clr-blue-l-4: #BBDEFB;\n"
            + "    --dui-clr-blue-l-3: #90CAF9;\n"
            + "    --dui-clr-blue-l-2: #64B5F6;\n"
            + "    --dui-clr-blue-l-1: #42A5F5;\n"
            + "    --dui-clr-blue: #2196F3;\n"
            + "    --dui-clr-blue-d-1: #1E88E5;\n"
            + "    --dui-clr-blue-d-2: #1976D2;\n"
            + "    --dui-clr-blue-d-3: #1565C0;\n"
            + "    --dui-clr-blue-d-4: #0D47A1;\n"
            + "\n"
            + "    --dui-clr-light-blue-l-5: #E1F5FE;\n"
            + "    --dui-clr-light-blue-l-4: #B3E5FC;\n"
            + "    --dui-clr-light-blue-l-3: #81D4FA;\n"
            + "    --dui-clr-light-blue-l-2: #4FC3F7;\n"
            + "    --dui-clr-light-blue-l-1: #29B6F6;\n"
            + "    --dui-clr-light-blue: #03A9F4;\n"
            + "    --dui-clr-light-blue-d-1: #039BE5;\n"
            + "    --dui-clr-light-blue-d-2: #0288D1;\n"
            + "    --dui-clr-light-blue-d-3: #0277BD;\n"
            + "    --dui-clr-light-blue-d-4: #01579B;\n"
            + "\n"
            + "    --dui-clr-cyan-l-5: #E0F7FA;\n"
            + "    --dui-clr-cyan-l-4: #B2EBF2;\n"
            + "    --dui-clr-cyan-l-3: #80DEEA;\n"
            + "    --dui-clr-cyan-l-2: #4DD0E1;\n"
            + "    --dui-clr-cyan-l-1: #26C6DA;\n"
            + "    --dui-clr-cyan: #00BCD4;\n"
            + "    --dui-clr-cyan-d-1: #00ACC1;\n"
            + "    --dui-clr-cyan-d-2: #0097A7;\n"
            + "    --dui-clr-cyan-d-3: #00838F;\n"
            + "    --dui-clr-cyan-d-4: #006064;\n"
            + "\n"
            + "    --dui-clr-teal-l-5: #E0F2F1;\n"
            + "    --dui-clr-teal-l-4: #B2DFDB;\n"
            + "    --dui-clr-teal-l-3: #80CBC4;\n"
            + "    --dui-clr-teal-l-2: #4DB6AC;\n"
            + "    --dui-clr-teal-l-1: #26A69A;\n"
            + "    --dui-clr-teal: #009688;\n"
            + "    --dui-clr-teal-d-1: #00897B;\n"
            + "    --dui-clr-teal-d-2: #00796B;\n"
            + "    --dui-clr-teal-d-3: #00695C;\n"
            + "    --dui-clr-teal-d-4: #004D40;\n"
            + "\n"
            + "    --dui-clr-green-l-5: #E8F5E9;\n"
            + "    --dui-clr-green-l-4: #C8E6C9;\n"
            + "    --dui-clr-green-l-3: #A5D6A7;\n"
            + "    --dui-clr-green-l-2: #81C784;\n"
            + "    --dui-clr-green-l-1: #66BB6A;\n"
            + "    --dui-clr-green: #4CAF50;\n"
            + "    --dui-clr-green-d-1: #43A047;\n"
            + "    --dui-clr-green-d-2: #388E3C;\n"
            + "    --dui-clr-green-d-3: #2E7D32;\n"
            + "    --dui-clr-green-d-4: #1B5E20;\n"
            + "\n"
            + "    --dui-clr-light-green-l-5: #F1FFE5;\n"
            + "    --dui-clr-light-green-l-4: #DCEDC8;\n"
            + "    --dui-clr-light-green-l-3: #C5E1A5;\n"
            + "    --dui-clr-light-green-l-2: #AED581;\n"
            + "    --dui-clr-light-green-l-1: #9CCC65;\n"
            + "    --dui-clr-light-green: #8BC34A;\n"
            + "    --dui-clr-light-green-d-1: #7CB342;\n"
            + "    --dui-clr-light-green-d-2: #689F38;\n"
            + "    --dui-clr-light-green-d-3: #558B2F;\n"
            + "    --dui-clr-light-green-d-4: #33691E;\n"
            + "\n"
            + "    --dui-clr-lime-l-5: #F9FBE7;\n"
            + "    --dui-clr-lime-l-4: #F0F4C3;\n"
            + "    --dui-clr-lime-l-3: #E6EE9C;\n"
            + "    --dui-clr-lime-l-2: #DCE775;\n"
            + "    --dui-clr-lime-l-1: #D4E157;\n"
            + "    --dui-clr-lime: #CDDC39;\n"
            + "    --dui-clr-lime-d-1: #C0CA33;\n"
            + "    --dui-clr-lime-d-2: #AFB42B;\n"
            + "    --dui-clr-lime-d-3: #9E9D24;\n"
            + "    --dui-clr-lime-d-4: #827717;\n"
            + "\n"
            + "    --dui-clr-yellow-l-5: #FFFDE7;\n"
            + "    --dui-clr-yellow-l-4: #FFF9C4;\n"
            + "    --dui-clr-yellow-l-3: #FFF59D;\n"
            + "    --dui-clr-yellow-l-2: #FFF176;\n"
            + "    --dui-clr-yellow-l-1: #FFEE58;\n"
            + "    --dui-clr-yellow: #FFEB3B;\n"
            + "    --dui-clr-yellow-d-1: #FDD835;\n"
            + "    --dui-clr-yellow-d-2: #FBC02D;\n"
            + "    --dui-clr-yellow-d-3: #F9A825;\n"
            + "    --dui-clr-yellow-d-4: #F57F17;\n"
            + "\n"
            + "    --dui-clr-amber-l-5: #FFF8E1;\n"
            + "    --dui-clr-amber-l-4: #FFECB3;\n"
            + "    --dui-clr-amber-l-3: #FFE082;\n"
            + "    --dui-clr-amber-l-2: #FFD54F;\n"
            + "    --dui-clr-amber-l-1: #FFCA28;\n"
            + "    --dui-clr-amber: #FFC107;\n"
            + "    --dui-clr-amber-d-1: #FFB300;\n"
            + "    --dui-clr-amber-d-2: #FFA000;\n"
            + "    --dui-clr-amber-d-3: #FF8F00;\n"
            + "    --dui-clr-amber-d-4: #FF6F00;\n"
            + "\n"
            + "    --dui-clr-orange-l-5: #FFF3E0;\n"
            + "    --dui-clr-orange-l-4: #FFE0B2;\n"
            + "    --dui-clr-orange-l-3: #FFCC80;\n"
            + "    --dui-clr-orange-l-2: #FFB74D;\n"
            + "    --dui-clr-orange-l-1: #FFA726;\n"
            + "    --dui-clr-orange: #FF9800;\n"
            + "    --dui-clr-orange-d-1: #FB8C00;\n"
            + "    --dui-clr-orange-d-2: #F57C00;\n"
            + "    --dui-clr-orange-d-3: #EF6C00;\n"
            + "    --dui-clr-orange-d-4: #E65100;\n"
            + "\n"
            + "    --dui-clr-brown-l-5: #EFEBE9;\n"
            + "    --dui-clr-brown-l-4: #D7CCC8;\n"
            + "    --dui-clr-brown-l-3: #BCAAA4;\n"
            + "    --dui-clr-brown-l-2: #A1887F;\n"
            + "    --dui-clr-brown-l-1: #8D6E63;\n"
            + "    --dui-clr-brown: #795548;\n"
            + "    --dui-clr-brown-d-1: #6D4C41;\n"
            + "    --dui-clr-brown-d-2: #5D4037;\n"
            + "    --dui-clr-brown-d-3: #4E342E;\n"
            + "    --dui-clr-brown-d-4: #3E2723;\n"
            + "\n"
            + "    --dui-clr-grey-l-5: #FAFAFA;\n"
            + "    --dui-clr-grey-l-4: #FAFAFA;\n"
            + "    --dui-clr-grey-l-3: #EEEEEE;\n"
            + "    --dui-clr-grey-l-2: #E0E0E0;\n"
            + "    --dui-clr-grey-l-1: #BDBDBD;\n"
            + "    --dui-clr-grey: #9E9E9E;\n"
            + "    --dui-clr-grey-d-1: #757575;\n"
            + "    --dui-clr-grey-d-2: #616161;\n"
            + "    --dui-clr-grey-d-3: #424242;\n"
            + "    --dui-clr-grey-d-4: #212121;\n"
            + "\n"
            + "    --dui-clr-blue-grey-l-5: #ECEFF1;\n"
            + "    --dui-clr-blue-grey-l-4: #CFD8DC;\n"
            + "    --dui-clr-blue-grey-l-3: #B0BEC5;\n"
            + "    --dui-clr-blue-grey-l-2: #90A4AE;\n"
            + "    --dui-clr-blue-grey-l-1: #78909C;\n"
            + "    --dui-clr-blue-grey: #607D8B;\n"
            + "    --dui-clr-blue-grey-d-1: #546E7A;\n"
            + "    --dui-clr-blue-grey-d-2: #455A64;\n"
            + "    --dui-clr-blue-grey-d-3: #37474F;\n"
            + "    --dui-clr-blue-grey-d-4: #263238;\n"
            + "\n"
            + "    --dui-clr-white-l-5: #EEEEEE;\n"
            + "    --dui-clr-white-l-4: #EEEEEE;\n"
            + "    --dui-clr-white-l-3: #EEEEEE;\n"
            + "    --dui-clr-white-l-2: #EEEEEE;\n"
            + "    --dui-clr-white-l-1: #EEEEEE;\n"
            + "    --dui-clr-white: #FFFFFF;\n"
            + "    --dui-clr-white-d-1: #EEEEEE;\n"
            + "    --dui-clr-white-d-2: #EEEEEE;\n"
            + "    --dui-clr-white-d-3: #EEEEEE;\n"
            + "    --dui-clr-white-d-4: #EEEEEE;\n"
            + "\n"
            + "    --dui-clr-black-l-5: #737373;\n"
            + "    --dui-clr-black-l-4: #595959;\n"
            + "    --dui-clr-black-l-3: #404040;\n"
            + "    --dui-clr-black-l-2: #262626;\n"
            + "    --dui-clr-black-l-1: #0d0d0d;\n"
            + "    --dui-clr-black: #000000;\n"
            + "    --dui-clr-black-d-1: #595959;\n"
            + "    --dui-clr-black-d-2: #404040;\n"
            + "    --dui-clr-black-d-3: #262626;\n"
            + "    --dui-clr-black-d-4: #0d0d0d;";
    System.out.println(
        Arrays.stream(colors.split("\n"))
            .filter(line -> !line.isEmpty())
            .map(
                line -> {
                  varName = line.substring(0, line.indexOf(":")).trim();
                  String fgClass;
                  if (varName.contains("-d-")) {
                    String temp = varName.replace("--dui-clr", "--dui");
                    fgClass = temp.substring(0, temp.indexOf("-d-")) + "-fg-clr";
                  } else if (varName.contains("-l-")) {
                    String temp = varName.replace("--dui-clr", "--dui");
                    fgClass = temp.substring(0, temp.indexOf("-l-")) + "-fg-clr";
                  } else {
                    fgClass = varName.replace("--dui-clr", "--dui") + "-fg-clr";
                  }

                  String className = varName.replace("--dui-clr-", ".dui-context-");
                  return className
                      + " {\n"
                      + "\t--dui-context-color: var("
                      + varName
                      + ");\n"
                      + "\t--dui-context-fg-color: var("
                      + fgClass
                      + ");\n"
                      + "}";
                })
            .collect(Collectors.joining("\n")));
  }
}