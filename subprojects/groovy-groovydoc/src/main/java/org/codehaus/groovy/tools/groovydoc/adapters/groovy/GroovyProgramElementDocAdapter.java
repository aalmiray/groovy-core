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
package org.codehaus.groovy.tools.groovydoc.adapters.groovy;

import com.sun.javadoc.AnnotationDesc;
import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.PackageDoc;
import com.sun.javadoc.ProgramElementDoc;
import org.codehaus.groovy.groovydoc.GroovyProgramElementDoc;

import static org.codehaus.groovy.tools.groovydoc.adapters.java.JavaDocUtils.toClassDoc;
import static org.codehaus.groovy.tools.groovydoc.adapters.java.JavaDocUtils.toPackageDoc;

public class GroovyProgramElementDocAdapter extends GroovyDocAdapter implements ProgramElementDoc {
    public GroovyProgramElementDocAdapter(GroovyProgramElementDoc delegate) {
        super(delegate);
    }

    public GroovyProgramElementDoc groovyProgramElementDoc() {
        return (GroovyProgramElementDoc) groovyDoc();
    }

    @Override
    public ClassDoc containingClass() {
        return toClassDoc(groovyProgramElementDoc().containingClass());
    }

    @Override
    public PackageDoc containingPackage() {
        return toPackageDoc(groovyProgramElementDoc().containingPackage());
    }

    @Override
    public String qualifiedName() {
        return groovyProgramElementDoc().qualifiedName();
    }

    @Override
    public int modifierSpecifier() {
        return groovyProgramElementDoc().modifierSpecifier();
    }

    @Override
    public String modifiers() {
        return groovyProgramElementDoc().modifiers();
    }

    @Override
    public AnnotationDesc[] annotations() {
        return new AnnotationDesc[0]; // TODO
    }

    @Override
    public boolean isPublic() {
        return groovyProgramElementDoc().isPublic();
    }

    @Override
    public boolean isProtected() {
        return groovyProgramElementDoc().isProtected();
    }

    @Override
    public boolean isPrivate() {
        return groovyProgramElementDoc().isPrivate();
    }

    @Override
    public boolean isPackagePrivate() {
        return groovyProgramElementDoc().isPackagePrivate();
    }

    @Override
    public boolean isStatic() {
        return groovyProgramElementDoc().isStatic();
    }

    @Override
    public boolean isFinal() {
        return groovyProgramElementDoc().isFinal();
    }
}
