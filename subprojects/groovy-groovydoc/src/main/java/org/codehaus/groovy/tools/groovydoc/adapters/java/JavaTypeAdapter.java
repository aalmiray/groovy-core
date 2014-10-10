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

import com.sun.javadoc.Type;
import org.codehaus.groovy.groovydoc.GroovyType;

public class JavaTypeAdapter implements GroovyType{
    private final Type type;

    public JavaTypeAdapter(Type type) {
        this.type = type;
    }

    public Type type() {
        return type;
    }

    @Override
    public boolean isPrimitive() {
        return type.isPrimitive();
    }

    @Override
    public String qualifiedTypeName() {
        return type.qualifiedTypeName();
    }

    @Override
    public String simpleTypeName() {
        return type.simpleTypeName();
    }

    @Override
    public String typeName() {
        return type.typeName();
    }
}
