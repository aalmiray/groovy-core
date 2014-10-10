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

import com.sun.javadoc.Doc;
import com.sun.javadoc.SourcePosition;
import com.sun.javadoc.Tag;
import org.codehaus.groovy.groovydoc.GroovyTag;

public class GroovyTagAdapter implements Tag {
    private final GroovyTag delegate;
    private final Doc holder;

    public GroovyTagAdapter(GroovyTag delegate, Doc holder) {
        this.delegate = delegate;
        this.holder = holder;
    }

    public GroovyTag groovyTag() {
        return delegate;
    }

    @Override
    public String name() {
        return delegate.name();
    }

    @Override
    public Doc holder() {
        return holder;
    }

    @Override
    public String kind() {
        String name = name();

        if (name.equals("@exception")) {
            return "@throws";
        } else if (name.equals("@link")) {
            return "@see";
        } else if (name.equals("@linkplain")) {
            return "@see";
        } else if (name.equals("@serialData")) {
            return "@serial";
        }

        return name;
    }

    @Override
    public String text() {
        return delegate.text();
    }

    @Override
    public Tag[] inlineTags() {
        return new Tag[0]; // TODO
    }

    @Override
    public Tag[] firstSentenceTags() {
        return new Tag[0]; // TODO
    }

    @Override
    public SourcePosition position() {
        return null; // TODO
    }
}
