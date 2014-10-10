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

import com.sun.javadoc.FieldDoc;
import com.sun.javadoc.SerialFieldTag;
import com.sun.javadoc.Type;
import org.codehaus.groovy.groovydoc.GroovyFieldDoc;

import static org.codehaus.groovy.tools.groovydoc.adapters.java.JavaDocUtils.toType;

public class GroovyFieldDocAdapter extends GroovyMemberDocAdapter implements FieldDoc {
    public GroovyFieldDocAdapter(GroovyFieldDoc delegate) {
        super(delegate);
    }

    public GroovyFieldDoc groovyFieldDoc() {
        return (GroovyFieldDoc) groovyDoc();
    }

    @Override
    public Type type() {
        return toType(groovyFieldDoc().type());
    }

    @Override
    public boolean isTransient() {
        return groovyFieldDoc().isTransient();
    }

    @Override
    public boolean isVolatile() {
        return groovyFieldDoc().isVolatile();
    }

    @Override
    public SerialFieldTag[] serialFieldTags() {
        // TODO apparently Groovy doesn't support this feature
        return new SerialFieldTag[0];
    }

    @Override
    public Object constantValue() {
        return groovyFieldDoc().constantValue();
    }

    @Override
    public String constantValueExpression() {
        return groovyFieldDoc().constantValueExpression();
    }
}
