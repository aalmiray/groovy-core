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

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.Type;
import org.codehaus.groovy.groovydoc.GroovyMethodDoc;

import static org.codehaus.groovy.tools.groovydoc.adapters.groovy.GroovyDocUtils.toGroovyMethodDoc;
import static org.codehaus.groovy.tools.groovydoc.adapters.java.JavaDocUtils.toClassDoc;
import static org.codehaus.groovy.tools.groovydoc.adapters.java.JavaDocUtils.toMethodDoc;
import static org.codehaus.groovy.tools.groovydoc.adapters.java.JavaDocUtils.toType;

public class GroovyMethodDocAdapter extends GroovyExecutableMemberDocAdapter implements MethodDoc {
    public GroovyMethodDocAdapter(GroovyMethodDoc delegate) {
        super(delegate);
    }

    public GroovyMethodDoc groovyMethodDoc() {
        return (GroovyMethodDoc) groovyDoc();
    }

    @Override
    public boolean isAbstract() {
        return groovyMethodDoc().isAbstract();
    }

    @Override
    public Type returnType() {
        return toType(groovyMethodDoc().returnType());
    }

    @Override
    public ClassDoc overriddenClass() {
        return toClassDoc(groovyMethodDoc().overriddenClass());
    }

    @Override
    public Type overriddenType() {
        return toType(groovyMethodDoc().overriddenType());
    }

    @Override
    public MethodDoc overriddenMethod() {
        return toMethodDoc(groovyMethodDoc().overriddenMethod());
    }

    @Override
    public boolean overrides(MethodDoc method) {
        return groovyMethodDoc().overrides(toGroovyMethodDoc(method));
    }
}
