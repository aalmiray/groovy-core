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
import com.sun.javadoc.PackageDoc;
import com.sun.javadoc.RootDoc;
import com.sun.javadoc.SourcePosition;
import org.codehaus.groovy.groovydoc.GroovyRootDoc;

import static org.codehaus.groovy.tools.groovydoc.adapters.java.JavaDocUtils.make;
import static org.codehaus.groovy.tools.groovydoc.adapters.java.JavaDocUtils.toClassDoc;
import static org.codehaus.groovy.tools.groovydoc.adapters.java.JavaDocUtils.toPackageDoc;

public class GroovyRootDocAdapter extends GroovyDocAdapter implements RootDoc {
    private PackageDoc[] specifiedPackages;
    private ClassDoc[] classes;
    private ClassDoc[] specifiedClasses;

    public GroovyRootDocAdapter(GroovyRootDoc delegate) {
        super(delegate);
    }

    public GroovyRootDoc groovyRootDoc() {
        return (GroovyRootDoc) groovyDoc();
    }

    @Override
    public String[][] options() {
        return groovyRootDoc().options();
    }

    @Override
    public PackageDoc[] specifiedPackages() {
        return cacheSpecifiedPackages();
    }

    @Override
    public ClassDoc[] specifiedClasses() {
        return cacheSpecifiedClasses();
    }

    @Override
    public ClassDoc[] classes() {
        return cacheClasses();
    }

    @Override
    public PackageDoc packageNamed(String name) {
        return toPackageDoc(groovyRootDoc().packageNamed(name));
    }

    @Override
    public ClassDoc classNamed(String qualifiedName) {
        return toClassDoc(groovyRootDoc().classNamed(null, qualifiedName));
    }

    @Override
    public void printError(String msg) {
        groovyRootDoc().printError(msg);
    }

    @Override
    public void printError(SourcePosition pos, String msg) {
        groovyRootDoc().printError(msg);
    }

    @Override
    public void printWarning(String msg) {
        groovyRootDoc().printWarning(msg);
    }

    @Override
    public void printWarning(SourcePosition pos, String msg) {
        groovyRootDoc().printWarning(msg);
    }

    @Override
    public void printNotice(String msg) {
        groovyRootDoc().printNotice(msg);
    }

    @Override
    public void printNotice(SourcePosition pos, String msg) {
        groovyRootDoc().printNotice(msg);
    }

    private ClassDoc[] cacheClasses() {
        if (classes == null) {
            classes = make(groovyRootDoc().classes());
        }
        return classes;
    }

    private ClassDoc[] cacheSpecifiedClasses() {
        if (specifiedClasses == null) {
            specifiedClasses = make(groovyRootDoc().specifiedClasses());
        }
        return specifiedClasses;
    }

    private PackageDoc[] cacheSpecifiedPackages() {
        if (specifiedPackages == null) {
            specifiedPackages = make(groovyRootDoc().specifiedPackages());
        }
        return specifiedPackages;
    }
}
