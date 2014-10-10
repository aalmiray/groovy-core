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

import com.sun.javadoc.MemberDoc;
import org.codehaus.groovy.groovydoc.GroovyAnnotationRef;
import org.codehaus.groovy.groovydoc.GroovyClassDoc;
import org.codehaus.groovy.groovydoc.GroovyMemberDoc;
import org.codehaus.groovy.groovydoc.GroovyPackageDoc;

import static org.codehaus.groovy.tools.groovydoc.adapters.groovy.GroovyDocUtils.toGroovyClassDoc;
import static org.codehaus.groovy.tools.groovydoc.adapters.groovy.GroovyDocUtils.toGroovyPackageDoc;

public class JavaMemberDocAdapter extends JavaDocAdapter implements GroovyMemberDoc {
    public JavaMemberDocAdapter(MemberDoc delegate) {
        super(delegate);
    }

    public MemberDoc memberDoc() {
        return (MemberDoc) doc();
    }

    @Override
    public boolean isSynthetic() {
        return memberDoc().isSynthetic();
    }

    @Override
    public GroovyAnnotationRef[] annotations() {
        return new GroovyAnnotationRef[0]; // TODO
    }

    @Override
    public GroovyClassDoc containingClass() {
        return toGroovyClassDoc(memberDoc().containingClass());
    }

    @Override
    public GroovyPackageDoc containingPackage() {
        return toGroovyPackageDoc(memberDoc().containingPackage());
    }

    @Override
    public boolean isFinal() {
        return memberDoc().isFinal();
    }

    @Override
    public boolean isPackagePrivate() {
        return memberDoc().isPackagePrivate();
    }

    @Override
    public boolean isPrivate() {
        return memberDoc().isPrivate();
    }

    @Override
    public boolean isProtected() {
        return memberDoc().isProtected();
    }

    @Override
    public boolean isPublic() {
        return memberDoc().isPublic();
    }

    @Override
    public boolean isStatic() {
        return memberDoc().isStatic();
    }

    @Override
    public String modifiers() {
        return memberDoc().modifiers();
    }

    @Override
    public int modifierSpecifier() {
        return memberDoc().modifierSpecifier();
    }

    @Override
    public String qualifiedName() {
        return memberDoc().qualifiedName();
    }
}
