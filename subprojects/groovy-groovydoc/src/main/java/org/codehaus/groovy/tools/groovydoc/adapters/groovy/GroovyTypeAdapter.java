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

import com.sun.javadoc.AnnotationTypeDoc;
import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.ParameterizedType;
import com.sun.javadoc.Type;
import com.sun.javadoc.TypeVariable;
import com.sun.javadoc.WildcardType;
import org.codehaus.groovy.groovydoc.GroovyType;
import org.codehaus.groovy.tools.groovydoc.SimpleGroovyClassDoc;

import java.util.Collections;

import static org.codehaus.groovy.tools.groovydoc.adapters.java.JavaDocUtils.toClassDoc;

public class GroovyTypeAdapter implements Type {
    private final GroovyType delegate;
    private ClassDoc classDoc;

    public GroovyTypeAdapter(GroovyType delegate) {
        this.delegate = delegate;
    }

    public GroovyType groovyType() {
        return delegate;
    }

    @Override
    public String typeName() {
        return delegate.typeName();
    }

    @Override
    public String qualifiedTypeName() {
        return delegate.qualifiedTypeName();
    }

    @Override
    public String simpleTypeName() {
        return delegate.simpleTypeName();
    }

    @Override
    public String dimension() {
        // TODO Groovy doesn't support this feature yet
        return null;
    }

    @Override
    public boolean isPrimitive() {
        return delegate.isPrimitive();
    }

    @Override
    public ClassDoc asClassDoc() {
        if (classDoc == null) {
            classDoc = toClassDoc(new SimpleGroovyClassDoc(Collections.<String>emptyList(), delegate.typeName()));
        }
        return classDoc;
    }

    @Override
    public ParameterizedType asParameterizedType() {
        // TODO Groovy doesn't support this feature yet
        return null;
    }

    @Override
    public TypeVariable asTypeVariable() {
        // TODO Groovy doesn't support this feature yet
        return null;
    }

    @Override
    public WildcardType asWildcardType() {
        // TODO Groovy doesn't support this feature yet
        return null;
    }

    @Override
    public AnnotationTypeDoc asAnnotationTypeDoc() {
        // TODO Groovy doesn't support this feature yet
        return null;
    }
}
