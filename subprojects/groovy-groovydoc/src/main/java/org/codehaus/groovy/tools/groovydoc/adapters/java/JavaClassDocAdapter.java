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

import com.sun.javadoc.ClassDoc;
import org.codehaus.groovy.groovydoc.GroovyClassDoc;
import org.codehaus.groovy.groovydoc.GroovyConstructorDoc;
import org.codehaus.groovy.groovydoc.GroovyFieldDoc;
import org.codehaus.groovy.groovydoc.GroovyMethodDoc;
import org.codehaus.groovy.groovydoc.GroovyPackageDoc;
import org.codehaus.groovy.groovydoc.GroovyType;

import static org.codehaus.groovy.tools.groovydoc.adapters.groovy.GroovyDocUtils.make;
import static org.codehaus.groovy.tools.groovydoc.adapters.groovy.GroovyDocUtils.toGroovyClassDoc;
import static org.codehaus.groovy.tools.groovydoc.adapters.groovy.GroovyDocUtils.toGroovyType;

public class JavaClassDocAdapter extends JavaProgramElementDocAdapter implements GroovyClassDoc {
    private GroovyMethodDoc[] methods;
    private GroovyMethodDoc[] serializableMethods;
    private GroovyFieldDoc[] fields;
    private GroovyFieldDoc[] enumConstants;
    private GroovyFieldDoc[] serializableFields;
    private GroovyConstructorDoc[] constructors;
    private GroovyClassDoc[] interfaces;
    private GroovyClassDoc[] innerClasses;
    private GroovyClassDoc[] importedClasses;
    private GroovyPackageDoc[] importedPackages;

    public JavaClassDocAdapter(ClassDoc delegate) {
        super(delegate);
    }

    public ClassDoc classDoc() {
        return (ClassDoc) doc();
    }

    @Override
    public GroovyConstructorDoc[] constructors() {
        return cacheConstructors();
    }

    @Override
    public GroovyConstructorDoc[] constructors(boolean filter) {
        return make(classDoc().constructors(filter));
    }

    @Override
    public boolean definesSerializableFields() {
        return classDoc().definesSerializableFields();
    }

    @Override
    public GroovyFieldDoc[] enumConstants() {
        return cacheEnumConstants();
    }

    @Override
    public GroovyFieldDoc[] fields() {
        return cacheFields();
    }

    @Override
    public GroovyFieldDoc[] properties() {
        return new GroovyFieldDoc[0]; // TODO
    }

    @Override
    public GroovyFieldDoc[] fields(boolean filter) {
        return make(classDoc().fields(filter));
    }

    @Override
    public GroovyClassDoc findClass(String className) {
        return toGroovyClassDoc(classDoc().findClass(className));
    }

    @Override
    public GroovyClassDoc[] importedClasses() {
        return cacheImportedClasses();
    }

    @Override
    public GroovyPackageDoc[] importedPackages() {
        return cacheImportedPackages();
    }

    @Override
    public GroovyClassDoc[] innerClasses() {
        return cacheInnerClasses();
    }

    @Override
    public GroovyClassDoc[] innerClasses(boolean filter) {
        return make(classDoc().innerClasses(filter));
    }

    @Override
    public GroovyClassDoc[] interfaces() {
        return cacheImportedClasses();
    }

    @Override
    public GroovyType[] interfaceTypes() {
        return cacheInterfaces();
    }

    @Override
    public boolean isAbstract() {
        return classDoc().isAbstract();
    }

    @Override
    public boolean isExternalizable() {
        return classDoc().isExternalizable();
    }

    @Override
    public boolean isSerializable() {
        return classDoc().isSerializable();
    }

    @Override
    public GroovyMethodDoc[] methods() {
        return cacheMethods();
    }

    @Override
    public GroovyMethodDoc[] methods(boolean filter) {
        return make(classDoc().methods(filter));
    }

    @Override
    public GroovyFieldDoc[] serializableFields() {
        return cacheSerializableFields();
    }

    @Override
    public GroovyMethodDoc[] serializationMethods() {
        return cacheSerializableMethods();
    }

    @Override
    public boolean subclassOf(GroovyClassDoc gcd) {
        return classDoc().subclassOf(JavaDocUtils.toClassDoc(gcd));
    }

    @Override
    public GroovyClassDoc superclass() {
        return toGroovyClassDoc(classDoc().superclass());
    }

    @Override
    public GroovyType superclassType() {
        return toGroovyType(classDoc().superclassType());
    }

    @Override
    public String getFullPathName() {
        return null; // TODO
    }

    @Override
    public String getRelativeRootPath() {
        return null; // TODO
    }

    @Override
    public boolean isPrimitive() {
        return classDoc().isPrimitive();
    }

    @Override
    public String qualifiedTypeName() {
        return classDoc().qualifiedName();
    }

    @Override
    public String simpleTypeName() {
        return classDoc().simpleTypeName();
    }

    @Override
    public String typeName() {
        return classDoc().typeName();
    }

    private GroovyConstructorDoc[] cacheConstructors() {
        if (constructors == null) {
            constructors = make(classDoc().constructors());
        }
        return constructors;
    }

    private GroovyMethodDoc[] cacheMethods() {
        if (methods == null) {
            methods = make(classDoc().methods());
        }
        return methods;
    }

    private GroovyMethodDoc[] cacheSerializableMethods() {
        if (serializableMethods == null) {
            serializableMethods = make(classDoc().serializationMethods());
        }
        return serializableMethods;
    }

    private GroovyFieldDoc[] cacheFields() {
        if (fields == null) {
            fields = make(classDoc().fields());
        }
        return fields;
    }

    private GroovyFieldDoc[] cacheEnumConstants() {
        if (enumConstants == null) {
            enumConstants = make(classDoc().enumConstants());
        }
        return enumConstants;
    }

    private GroovyFieldDoc[] cacheSerializableFields() {
        if (serializableFields == null) {
            serializableFields = make(classDoc().serializableFields());
        }
        return serializableFields;
    }

    private GroovyClassDoc[] cacheInterfaces() {
        if (interfaces == null) {
            interfaces = make(classDoc().interfaces());
        }
        return interfaces;
    }

    private GroovyClassDoc[] cacheInnerClasses() {
        if (innerClasses == null) {
            innerClasses = make(classDoc().innerClasses());
        }
        return innerClasses;
    }

    private GroovyClassDoc[] cacheImportedClasses() {
        if (importedClasses == null) {
            importedClasses = make(classDoc().importedClasses());
        }
        return importedClasses;
    }

    private GroovyPackageDoc[] cacheImportedPackages() {
        if (importedPackages == null) {
            importedPackages = make(classDoc().importedPackages());
        }
        return importedPackages;
    }
}
