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

import com.sun.javadoc.AnnotationTypeDoc;
import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.ConstructorDoc;
import com.sun.javadoc.FieldDoc;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.PackageDoc;
import com.sun.javadoc.ParamTag;
import com.sun.javadoc.ParameterizedType;
import com.sun.javadoc.Type;
import com.sun.javadoc.TypeVariable;
import com.sun.javadoc.WildcardType;
import org.codehaus.groovy.groovydoc.GroovyClassDoc;

import static org.codehaus.groovy.tools.groovydoc.adapters.java.JavaDocUtils.make;
import static org.codehaus.groovy.tools.groovydoc.adapters.java.JavaDocUtils.toClassDoc;
import static org.codehaus.groovy.tools.groovydoc.adapters.java.JavaDocUtils.toType;

public class GroovyClassDocAdapter extends GroovyProgramElementDocAdapter implements ClassDoc {
    private MethodDoc[] methods;
    private MethodDoc[] serializableMethods;
    private FieldDoc[] fields;
    private FieldDoc[] serializableFields;
    private ConstructorDoc[] constructors;
    private ClassDoc[] interfaces;
    private ClassDoc[] innerClasses;
    private ClassDoc[] importedClasses;
    private PackageDoc[] importedPackages;

    public GroovyClassDocAdapter(GroovyClassDoc delegate) {
        super(delegate);
    }

    public GroovyClassDoc groovyClassDoc() {
        return (GroovyClassDoc) groovyDoc();
    }

    @Override
    public String typeName() {
        return groovyClassDoc().typeName();
    }

    @Override
    public String qualifiedTypeName() {
        return groovyClassDoc().qualifiedTypeName();
    }

    @Override
    public String simpleTypeName() {
        return groovyClassDoc().simpleTypeName();
    }

    @Override
    public String dimension() {
        // TODO Groovy doesn't support this feature yet
        return null;
    }

    @Override
    public boolean isPrimitive() {
        return groovyClassDoc().isPrimitive();
    }

    @Override
    public ClassDoc asClassDoc() {
        return this;
    }

    @Override
    public ParameterizedType asParameterizedType() {
        // TODO Groovy doesn't support this feature yet
        return null;
    }

    @Override
    public TypeVariable asTypeVariable() {
        // TODO Groovy doesn't support this feature yet
        return null;
    }

    @Override
    public WildcardType asWildcardType() {
        // TODO Groovy doesn't support this feature yet
        return null;
    }

    @Override
    public AnnotationTypeDoc asAnnotationTypeDoc() {
        // TODO Groovy doesn't support this feature yet
        return null;
    }

    @Override
    public boolean isAbstract() {
        return groovyClassDoc().isAbstract();
    }

    @Override
    public boolean isSerializable() {
        return groovyClassDoc().isSerializable();
    }

    @Override
    public boolean isExternalizable() {
        return groovyClassDoc().isExternalizable();
    }

    @Override
    public MethodDoc[] serializationMethods() {
        return cacheSerializableMethods();
    }

    @Override
    public FieldDoc[] serializableFields() {
        return cacheSerializableFields();
    }

    @Override
    public boolean definesSerializableFields() {
        return groovyClassDoc().definesSerializableFields();
    }

    @Override
    public ClassDoc superclass() {
        return toClassDoc(groovyClassDoc().superclass());
    }

    @Override
    public Type superclassType() {
        return toType(groovyClassDoc().superclassType());
    }

    @Override
    public boolean subclassOf(ClassDoc cd) {
        return groovyClassDoc().subclassOf(GroovyDocUtils.toGroovyClassDoc(cd));
    }

    @Override
    public ClassDoc[] interfaces() {
        return cacheInterfaces();
    }

    @Override
    public Type[] interfaceTypes() {
        return cacheInterfaces();
    }

    @Override
    public TypeVariable[] typeParameters() {
        // TODO
        return new TypeVariable[0];
    }

    @Override
    public ParamTag[] typeParamTags() {
        // TODO
        return new ParamTag[0];
    }

    @Override
    public FieldDoc[] fields() {
        return cacheFields();
    }

    @Override
    public FieldDoc[] fields(boolean filter) {
        return make(groovyClassDoc().fields(filter));
    }

    @Override
    public FieldDoc[] enumConstants() {
        // TODO
        return new FieldDoc[0];
    }

    @Override
    public MethodDoc[] methods() {
        return cacheMethods();
    }

    @Override
    public MethodDoc[] methods(boolean filter) {
        return make(groovyClassDoc().methods(filter));
    }

    @Override
    public ConstructorDoc[] constructors() {
        return cacheConstructors();
    }

    @Override
    public ConstructorDoc[] constructors(boolean filter) {
        // TODO Groovy doesn't support this feature
        return cacheConstructors();
    }

    @Override
    public ClassDoc[] innerClasses() {
        return cacheInnerClasses();
    }

    @Override
    public ClassDoc[] innerClasses(boolean filter) {
        return make(groovyClassDoc().innerClasses(filter));
    }

    @Override
    public ClassDoc findClass(String className) {
        return toClassDoc(groovyClassDoc().findClass(className));
    }

    @Override
    public ClassDoc[] importedClasses() {
        return cacheImportedClasses();
    }

    @Override
    public PackageDoc[] importedPackages() {
        return cacheImportedPackages();
    }

    private ConstructorDoc[] cacheConstructors() {
        if (constructors == null) {
            constructors = make(groovyClassDoc().constructors());
        }
        return constructors;
    }

    private MethodDoc[] cacheMethods() {
        if (methods == null) {
            methods = make(groovyClassDoc().methods());
        }
        return methods;
    }

    private MethodDoc[] cacheSerializableMethods() {
        if (serializableMethods == null) {
            serializableMethods = make(groovyClassDoc().serializationMethods());
        }
        return serializableMethods;
    }

    private FieldDoc[] cacheFields() {
        if (fields == null) {
            fields = make(groovyClassDoc().fields());
        }
        return fields;
    }

    private FieldDoc[] cacheSerializableFields() {
        if (serializableFields == null) {
            serializableFields = make(groovyClassDoc().serializableFields());
        }
        return serializableFields;
    }

    private ClassDoc[] cacheInterfaces() {
        if (interfaces == null) {
            interfaces = make(groovyClassDoc().interfaces());
        }
        return interfaces;
    }

    private ClassDoc[] cacheInnerClasses() {
        if (innerClasses == null) {
            innerClasses = make(groovyClassDoc().innerClasses());
        }
        return innerClasses;
    }

    private ClassDoc[] cacheImportedClasses() {
        if (importedClasses == null) {
            importedClasses = make(groovyClassDoc().importedClasses());
        }
        return importedClasses;
    }

    private PackageDoc[] cacheImportedPackages() {
        if (importedPackages == null) {
            importedPackages = make(groovyClassDoc().importedPackages());
        }
        return importedPackages;
    }
}
