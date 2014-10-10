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
import com.sun.javadoc.AnnotationTypeDoc;
import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.PackageDoc;
import org.codehaus.groovy.groovydoc.GroovyPackageDoc;

import static org.codehaus.groovy.tools.groovydoc.adapters.java.JavaDocUtils.make;
import static org.codehaus.groovy.tools.groovydoc.adapters.java.JavaDocUtils.toClassDoc;

public class GroovyPackageDocAdapter extends GroovyDocAdapter implements PackageDoc {
    private ClassDoc[] classes;
    private ClassDoc[] ordinaryClasses;
    private ClassDoc[] exceptions;
    private ClassDoc[] errors;
    private ClassDoc[] enums;
    private ClassDoc[] interfaces;

    public GroovyPackageDocAdapter(GroovyPackageDoc delegate) {
        super(delegate);
    }

    public GroovyPackageDoc groovyPackageDoc() {
        return (GroovyPackageDoc) groovyDoc();
    }

    @Override
    public ClassDoc[] allClasses(boolean filter) {
        return make(groovyPackageDoc().allClasses(filter));
    }

    @Override
    public ClassDoc[] allClasses() {
        return cacheClasses();
    }

    @Override
    public ClassDoc[] ordinaryClasses() {
        return cacheOrdinaryClasses();
    }

    @Override
    public ClassDoc[] exceptions() {
        return cacheExceptions();
    }

    @Override
    public ClassDoc[] errors() {
        return cacheErrors();
    }

    @Override
    public ClassDoc[] enums() {
        return cacheEnums();
    }

    @Override
    public ClassDoc[] interfaces() {
        return cacheInterfaces();
    }

    @Override
    public AnnotationTypeDoc[] annotationTypes() {
        return new AnnotationTypeDoc[0];
    }

    @Override
    public AnnotationDesc[] annotations() {
        return new AnnotationDesc[0];
    }

    @Override
    public ClassDoc findClass(String className) {
        return toClassDoc(groovyPackageDoc().findClass(className));
    }

    private ClassDoc[] cacheClasses() {
        if (classes == null) {
            classes = make(groovyPackageDoc().allClasses());
        }
        return classes;
    }

    private ClassDoc[] cacheOrdinaryClasses() {
        if (ordinaryClasses == null) {
            ordinaryClasses = make(groovyPackageDoc().ordinaryClasses());
        }
        return ordinaryClasses;
    }

    private ClassDoc[] cacheExceptions() {
        if (exceptions == null) {
            exceptions = make(groovyPackageDoc().exceptions());
        }
        return exceptions;
    }

    private ClassDoc[] cacheErrors() {
        if (errors == null) {
            errors = make(groovyPackageDoc().errors());
        }
        return errors;
    }

    private ClassDoc[] cacheEnums() {
        if (enums == null) {
            enums = make(groovyPackageDoc().enums());
        }
        return enums;
    }

    private ClassDoc[] cacheInterfaces() {
        if (interfaces == null) {
            interfaces = make(groovyPackageDoc().interfaces());
        }
        return interfaces;
    }
}
