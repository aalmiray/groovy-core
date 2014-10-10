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

import com.sun.javadoc.PackageDoc;
import org.codehaus.groovy.groovydoc.GroovyClassDoc;
import org.codehaus.groovy.groovydoc.GroovyPackageDoc;

import static org.codehaus.groovy.tools.groovydoc.adapters.groovy.GroovyDocUtils.make;
import static org.codehaus.groovy.tools.groovydoc.adapters.groovy.GroovyDocUtils.toGroovyClassDoc;

public class JavaPackageDocAdapter extends JavaDocAdapter implements GroovyPackageDoc {
    private GroovyClassDoc[] classes;
    private GroovyClassDoc[] ordinaryClasses;
    private GroovyClassDoc[] exceptions;
    private GroovyClassDoc[] errors;
    private GroovyClassDoc[] enums;
    private GroovyClassDoc[] interfaces;

    public JavaPackageDocAdapter(PackageDoc delegate) {
        super(delegate);
    }

    public PackageDoc packageDoc() {
        return (PackageDoc) doc();
    }

    @Override
    public GroovyClassDoc[] allClasses() {
        return cacheClasses();
    }

    @Override
    public GroovyClassDoc[] allClasses(boolean filter) {
        return make(packageDoc().allClasses());
    }

    @Override
    public GroovyClassDoc[] enums() {
        return cacheEnums();
    }

    @Override
    public GroovyClassDoc[] errors() {
        return cacheErrors();
    }

    @Override
    public GroovyClassDoc[] exceptions() {
        return cacheExceptions();
    }

    @Override
    public GroovyClassDoc findClass(String className) {
        return toGroovyClassDoc(packageDoc().findClass(className));
    }

    @Override
    public GroovyClassDoc[] interfaces() {
        return cacheInterfaces();
    }

    @Override
    public GroovyClassDoc[] ordinaryClasses() {
        return cacheOrdinaryClasses();
    }

    @Override
    public String summary() {
        return null; // TODO
    }

    @Override
    public String description() {
        return null; // TODO
    }

    @Override
    public String nameWithDots() {
        return null; // TODO
    }

    @Override
    public String getRelativeRootPath() {
        return null; // TODO
    }

    private GroovyClassDoc[] cacheClasses() {
        if (classes == null) {
            classes = make(packageDoc().allClasses());
        }
        return classes;
    }

    private GroovyClassDoc[] cacheOrdinaryClasses() {
        if (ordinaryClasses == null) {
            ordinaryClasses = make(packageDoc().ordinaryClasses());
        }
        return ordinaryClasses;
    }

    private GroovyClassDoc[] cacheExceptions() {
        if (exceptions == null) {
            exceptions = make(packageDoc().exceptions());
        }
        return exceptions;
    }

    private GroovyClassDoc[] cacheErrors() {
        if (errors == null) {
            errors = make(packageDoc().errors());
        }
        return errors;
    }

    private GroovyClassDoc[] cacheEnums() {
        if (enums == null) {
            enums = make(packageDoc().enums());
        }
        return enums;
    }

    private GroovyClassDoc[] cacheInterfaces() {
        if (interfaces == null) {
            interfaces = make(packageDoc().interfaces());
        }
        return interfaces;
    }
}
