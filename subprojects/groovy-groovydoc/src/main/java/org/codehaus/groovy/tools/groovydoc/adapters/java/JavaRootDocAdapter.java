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

import com.sun.javadoc.RootDoc;
import org.codehaus.groovy.groovydoc.GroovyClassDoc;
import org.codehaus.groovy.groovydoc.GroovyPackageDoc;
import org.codehaus.groovy.groovydoc.GroovyRootDoc;

import java.util.List;
import java.util.Map;

import static org.codehaus.groovy.tools.groovydoc.adapters.groovy.GroovyDocUtils.make;
import static org.codehaus.groovy.tools.groovydoc.adapters.groovy.GroovyDocUtils.toGroovyClassDoc;
import static org.codehaus.groovy.tools.groovydoc.adapters.groovy.GroovyDocUtils.toGroovyPackageDoc;

public class JavaRootDocAdapter extends JavaDocAdapter implements GroovyRootDoc {
    private GroovyPackageDoc[] specifiedPackages;
    private GroovyClassDoc[] classes;
    private GroovyClassDoc[] specifiedClasses;

    public JavaRootDocAdapter(RootDoc delegate) {
        super(delegate);
    }

    public RootDoc rootDoc() {
        return (RootDoc) doc();
    }

    @Override
    public GroovyClassDoc classNamed(GroovyClassDoc groovyClassDoc, String name) {
        return toGroovyClassDoc(rootDoc().classNamed(name));
    }

    @Override
    public GroovyClassDoc[] classes() {
        return cacheClasses();
    }

    @Override
    public String[][] options() {
        return rootDoc().options();
    }

    @Override
    public GroovyPackageDoc packageNamed(String name) {
        return toGroovyPackageDoc(rootDoc().packageNamed(name));
    }

    @Override
    public GroovyClassDoc[] specifiedClasses() {
        return cacheSpecifiedClasses();
    }

    @Override
    public GroovyPackageDoc[] specifiedPackages() {
        return cacheSpecifiedPackages();
    }

    @Override
    public Map<String, GroovyClassDoc> getVisibleClasses(List importedClassesAndPackages) {
        return null; // TODO
    }

    @Override
    public void printError(String msg) {
        rootDoc().printError(msg);
    }

    @Override
    public void printNotice(String msg) {
        rootDoc().printNotice(msg);
    }

    @Override
    public void printWarning(String msg) {
        rootDoc().printWarning(msg);
    }

    private GroovyClassDoc[] cacheClasses() {
        if (classes == null) {
            classes = make(rootDoc().classes());
        }
        return classes;
    }

    private GroovyClassDoc[] cacheSpecifiedClasses() {
        if (specifiedClasses == null) {
            specifiedClasses = make(rootDoc().specifiedClasses());
        }
        return specifiedClasses;
    }

    private GroovyPackageDoc[] cacheSpecifiedPackages() {
        if (specifiedPackages == null) {
            specifiedPackages = make(rootDoc().specifiedPackages());
        }
        return specifiedPackages;
    }
}
