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
import com.sun.javadoc.SeeTag;
import com.sun.javadoc.SourcePosition;
import com.sun.javadoc.Tag;
import org.codehaus.groovy.groovydoc.GroovyDoc;

public class GroovyDocAdapter implements Doc {
    private final GroovyDoc delegate;

    public GroovyDocAdapter(GroovyDoc delegate) {
        this.delegate = delegate;
    }

    public GroovyDoc groovyDoc() {
        return delegate;
    }

    @Override
    public String commentText() {
        return delegate.commentText();
    }

    @Override
    public Tag[] tags() {
        return new Tag[0]; // TODO
    }

    @Override
    public Tag[] tags(String tagname) {
        return new Tag[0]; // TODO
    }

    @Override
    public SeeTag[] seeTags() {
        return new SeeTag[0]; // TODO
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
    public String getRawCommentText() {
        return delegate.getRawCommentText();
    }

    @Override
    public boolean isAnnotationType() {
        return delegate.isAnnotationType();
    }

    @Override
    public boolean isAnnotationTypeElement() {
        return delegate.isAnnotationTypeElement();
    }

    @Override
    public boolean isClass() {
        return delegate.isClass();
    }

    @Override
    public boolean isConstructor() {
        return delegate.isConstructor();
    }

    public boolean isDeprecated() {
        return delegate.isDeprecated();
    }

    @Override
    public boolean isEnum() {
        return delegate.isEnum();
    }

    @Override
    public boolean isEnumConstant() {
        return delegate.isEnumConstant();
    }

    @Override
    public boolean isError() {
        return delegate.isError();
    }

    @Override
    public boolean isException() {
        return delegate.isException();
    }

    @Override
    public boolean isField() {
        return delegate.isField();
    }

    @Override
    public boolean isIncluded() {
        return delegate.isIncluded();
    }

    @Override
    public SourcePosition position() {
        return null;
    }

    @Override
    public boolean isInterface() {
        return delegate.isInterface();
    }

    @Override
    public boolean isMethod() {
        return delegate.isMethod();
    }

    @Override
    public boolean isOrdinaryClass() {
        return delegate.isOrdinaryClass();
    }

    @Override
    public String name() {
        return delegate.name();
    }

    @Override
    public void setRawCommentText(String arg0) {
        delegate.setRawCommentText(arg0);
    }

    public String firstSentenceCommentText() {
        return delegate.firstSentenceCommentText();
    }

    @Override
    public int compareTo(Object o) {
        return delegate.compareTo(o);
    }
}
