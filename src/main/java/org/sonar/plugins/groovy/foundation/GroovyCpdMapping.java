/*
 * Sonar Groovy Plugin
 * Copyright (C) 2010 SonarSource
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */

package org.sonar.plugins.groovy.foundation;

import net.sourceforge.pmd.cpd.Tokenizer;
import org.sonar.api.batch.AbstractCpdMapping;
import org.sonar.api.resources.Language;
import org.sonar.api.resources.Resource;
import org.sonar.plugins.groovy.jacoco.GroovyFile;

import java.io.File;
import java.util.List;

public class GroovyCpdMapping extends AbstractCpdMapping {

  private final Groovy language;

  public GroovyCpdMapping(Groovy language) {
    this.language = language;
  }

  public Resource createResource(java.io.File file, List<File> sourceDirs) {
    return GroovyFile.fromIOFile(file, sourceDirs, false);
  }

  public Tokenizer getTokenizer() {
    return new GroovyCpdTokenizer();
  }

  public Language getLanguage() {
    return language;
  }

}
