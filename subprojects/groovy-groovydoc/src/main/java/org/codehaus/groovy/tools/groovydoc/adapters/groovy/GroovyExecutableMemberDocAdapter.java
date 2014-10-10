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
import com.sun.javadoc.ExecutableMemberDoc;
import com.sun.javadoc.ParamTag;
import com.sun.javadoc.Parameter;
import com.sun.javadoc.ThrowsTag;
import com.sun.javadoc.Type;
import com.sun.javadoc.TypeVariable;
import org.codehaus.groovy.groovydoc.GroovyExecutableMemberDoc;

import static org.codehaus.groovy.tools.groovydoc.adapters.java.JavaDocUtils.make;

public class GroovyExecutableMemberDocAdapter extends GroovyMemberDocAdapter implements ExecutableMemberDoc {
    private ClassDoc[] thrownExceptions;
    private Parameter[] parameters;
    private TypeVariable[] typeParameters;

    public GroovyExecutableMemberDocAdapter(GroovyExecutableMemberDoc delegate) {
        super(delegate);
    }

    public GroovyExecutableMemberDoc groovyExecutableMemberDoc() {
        return (GroovyExecutableMemberDoc) groovyDoc();
    }

    @Override
    public ClassDoc[] thrownExceptions() {
        return cacheThrownExceptions();
    }

    @Override
    public Type[] thrownExceptionTypes() {
        return cacheThrownExceptions();
    }

    @Override
    public boolean isNative() {
        return groovyExecutableMemberDoc().isNative();
    }

    @Override
    public boolean isSynchronized() {
        return groovyExecutableMemberDoc().isSynchronized();
    }

    @Override
    public boolean isVarArgs() {
        return groovyExecutableMemberDoc().isVarArgs();
    }

    @Override
    public Parameter[] parameters() {
        return cacheParameters();
    }

    @Override
    public ThrowsTag[] throwsTags() {
        return new ThrowsTag[0]; // TODO
    }

    @Override
    public ParamTag[] paramTags() {
        return new ParamTag[0]; // TODO
    }

    @Override
    public ParamTag[] typeParamTags() {
        return new ParamTag[0]; // TODO
    }

    @Override
    public String signature() {
        return groovyExecutableMemberDoc().signature();
    }

    @Override
    public String flatSignature() {
        return groovyExecutableMemberDoc().flatSignature();
    }

    @Override
    public TypeVariable[] typeParameters() {
        return new TypeVariable[0]; // TODO
    }

    public ClassDoc[] cacheThrownExceptions() {
        if (thrownExceptions == null) {
            thrownExceptions = make(groovyExecutableMemberDoc().thrownExceptions());
        }
        return thrownExceptions;
    }

    private Parameter[] cacheParameters() {
        if (parameters == null) {
            parameters = make(groovyExecutableMemberDoc().parameters());
        }
        return parameters;
    }
}
