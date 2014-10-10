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

import com.sun.javadoc.ExecutableMemberDoc;
import org.codehaus.groovy.groovydoc.GroovyClassDoc;
import org.codehaus.groovy.groovydoc.GroovyExecutableMemberDoc;
import org.codehaus.groovy.groovydoc.GroovyParameter;
import org.codehaus.groovy.groovydoc.GroovyType;

import static org.codehaus.groovy.tools.groovydoc.adapters.groovy.GroovyDocUtils.make;

public class JavaExecutableMemberDocAdapter extends JavaMemberDocAdapter implements GroovyExecutableMemberDoc {
    private GroovyClassDoc[] thrownExceptions;
    private GroovyParameter[] parameters;

    public JavaExecutableMemberDocAdapter(ExecutableMemberDoc delegate) {
        super(delegate);
    }

    public ExecutableMemberDoc executableMemberDoc() {
        return (ExecutableMemberDoc) doc();
    }

    @Override
    public String flatSignature() {
        return executableMemberDoc().flatSignature();
    }

    @Override
    public boolean isNative() {
        return executableMemberDoc().isNative();
    }

    @Override
    public boolean isSynchronized() {
        return executableMemberDoc().isSynchronized();
    }

    @Override
    public boolean isVarArgs() {
        return executableMemberDoc().isVarArgs();
    }

    @Override
    public GroovyParameter[] parameters() {
        return cacheParameters();
    }

    @Override
    public String signature() {
        return executableMemberDoc().signature();
    }

    @Override
    public GroovyClassDoc[] thrownExceptions() {
        return cacheThrownExceptions();
    }

    @Override
    public GroovyType[] thrownExceptionTypes() {
        return cacheThrownExceptions();
    }

    private GroovyClassDoc[] cacheThrownExceptions() {
        if (thrownExceptions == null) {
            thrownExceptions = make(executableMemberDoc().thrownExceptions());
        }
        return thrownExceptions;
    }

    private GroovyParameter[] cacheParameters() {
        if (parameters == null) {
            parameters = make(executableMemberDoc().parameters());
        }
        return parameters;
    }
}
