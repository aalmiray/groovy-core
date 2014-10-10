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

import com.sun.javadoc.MethodDoc;
import org.codehaus.groovy.groovydoc.GroovyClassDoc;
import org.codehaus.groovy.groovydoc.GroovyMethodDoc;
import org.codehaus.groovy.groovydoc.GroovyType;

import static org.codehaus.groovy.tools.groovydoc.adapters.groovy.GroovyDocUtils.toGroovyClassDoc;
import static org.codehaus.groovy.tools.groovydoc.adapters.groovy.GroovyDocUtils.toGroovyMethodDoc;
import static org.codehaus.groovy.tools.groovydoc.adapters.groovy.GroovyDocUtils.toGroovyType;
import static org.codehaus.groovy.tools.groovydoc.adapters.java.JavaDocUtils.toMethodDoc;

public class JavaMethodDocAdapter extends JavaExecutableMemberDocAdapter implements GroovyMethodDoc {
    private GroovyType returnType;

    public JavaMethodDocAdapter(MethodDoc delegate) {
        super(delegate);
    }

    public MethodDoc methodDoc() {
        return (MethodDoc) doc();
    }

    @Override
    public boolean isAbstract() {
        return methodDoc().isAbstract();
    }

    @Override
    public GroovyClassDoc overriddenClass() {
        return toGroovyClassDoc(methodDoc().overriddenClass());
    }

    @Override
    public GroovyMethodDoc overriddenMethod() {
        return toGroovyMethodDoc(methodDoc().overriddenMethod());
    }

    @Override
    public GroovyType overriddenType() {
        return toGroovyType(methodDoc().overriddenType());
    }

    @Override
    public boolean overrides(GroovyMethodDoc meth) {
        return methodDoc().overrides(toMethodDoc(meth));
    }

    @Override
    public GroovyType returnType() {
        return this.returnType != null ? returnType : toGroovyType(methodDoc().returnType());
    }

    @Override
    public void setReturnType(GroovyType type) {
        this.returnType = type;
    }
}
