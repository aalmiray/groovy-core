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

import com.sun.javadoc.Parameter;
import org.codehaus.groovy.groovydoc.GroovyAnnotationRef;
import org.codehaus.groovy.groovydoc.GroovyParameter;
import org.codehaus.groovy.groovydoc.GroovyType;

import static org.codehaus.groovy.tools.groovydoc.adapters.groovy.GroovyDocUtils.toGroovyType;

public class JavaParameterAdapter implements GroovyParameter {
    private final Parameter delegate;

    public JavaParameterAdapter(Parameter delegate) {
        this.delegate = delegate;
    }

    public Parameter parameter() {
        return delegate;
    }

    @Override
    public GroovyAnnotationRef[] annotations() {
        return new GroovyAnnotationRef[0]; // TODO
    }

    @Override
    public String name() {
        return delegate.name();
    }

    @Override
    public GroovyType type() {
        return toGroovyType(delegate.type());
    }

    @Override
    public String typeName() {
        return delegate.typeName();
    }

    @Override
    public String defaultValue() {
        return null; // TODO verify if null is OK given that Java does not support this feature
    }
}
