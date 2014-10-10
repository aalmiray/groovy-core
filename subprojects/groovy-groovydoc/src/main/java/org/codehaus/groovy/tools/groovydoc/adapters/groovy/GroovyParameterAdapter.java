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
import com.sun.javadoc.Parameter;
import com.sun.javadoc.Type;
import org.codehaus.groovy.groovydoc.GroovyParameter;

import static org.codehaus.groovy.tools.groovydoc.adapters.java.JavaDocUtils.toType;

public class GroovyParameterAdapter implements Parameter{
    private final GroovyParameter delegate;

    public GroovyParameterAdapter(GroovyParameter delegate) {
        this.delegate = delegate;
    }

    public GroovyParameter groovyParameter() {
        return delegate;
    }

    @Override
    public Type type() {
        return toType(delegate.type());
    }

    @Override
    public String name() {
        return delegate.name();
    }

    @Override
    public String typeName() {
        return delegate.typeName();
    }

    @Override
    public AnnotationDesc[] annotations() {
        return new AnnotationDesc[0]; // TODO
    }
}
