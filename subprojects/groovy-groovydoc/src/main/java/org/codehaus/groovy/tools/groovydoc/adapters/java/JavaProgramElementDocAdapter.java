/*
 * Copyright 2003-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.codehaus.groovy.tools.groovydoc.adapters.java;

import com.sun.javadoc.ProgramElementDoc;
import org.codehaus.groovy.groovydoc.GroovyAnnotationRef;
import org.codehaus.groovy.groovydoc.GroovyClassDoc;
import org.codehaus.groovy.groovydoc.GroovyPackageDoc;
import org.codehaus.groovy.groovydoc.GroovyProgramElementDoc;

import static org.codehaus.groovy.tools.groovydoc.adapters.groovy.GroovyDocUtils.toGroovyClassDoc;
import static org.codehaus.groovy.tools.groovydoc.adapters.groovy.GroovyDocUtils.toGroovyPackageDoc;

public class JavaProgramElementDocAdapter extends JavaDocAdapter implements GroovyProgramElementDoc {
    public JavaProgramElementDocAdapter(ProgramElementDoc delegate) {
        super(delegate);
    }

    public ProgramElementDoc programElementDoc() {
        return (ProgramElementDoc) doc();
    }

    @Override
    public GroovyAnnotationRef[] annotations() {
        return new GroovyAnnotationRef[0]; // TODO
    }

    @Override
    public GroovyClassDoc containingClass() {
        return toGroovyClassDoc(programElementDoc().containingClass());
    }

    @Override
    public GroovyPackageDoc containingPackage() {
        return toGroovyPackageDoc(programElementDoc().containingPackage());
    }

    @Override
    public boolean isFinal() {
        return programElementDoc().isFinal();
    }

    @Override
    public boolean isPackagePrivate() {
        return programElementDoc().isPackagePrivate();
    }

    @Override
    public boolean isPrivate() {
        return programElementDoc().isPrivate();
    }

    @Override
    public boolean isProtected() {
        return programElementDoc().isProtected();
    }

    @Override
    public boolean isPublic() {
        return programElementDoc().isPublic();
    }

    @Override
    public boolean isStatic() {
        return programElementDoc().isStatic();
    }

    @Override
    public String modifiers() {
        return programElementDoc().modifiers();
    }

    @Override
    public int modifierSpecifier() {
        return programElementDoc().modifierSpecifier();
    }

    @Override
    public String qualifiedName() {
        return programElementDoc().qualifiedName();
    }
}
