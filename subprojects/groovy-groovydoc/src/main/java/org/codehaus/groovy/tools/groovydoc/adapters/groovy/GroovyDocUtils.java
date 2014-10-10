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
import com.sun.javadoc.ConstructorDoc;
import com.sun.javadoc.FieldDoc;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.PackageDoc;
import com.sun.javadoc.Parameter;
import com.sun.javadoc.RootDoc;
import com.sun.javadoc.Tag;
import com.sun.javadoc.Type;
import org.codehaus.groovy.groovydoc.GroovyClassDoc;
import org.codehaus.groovy.groovydoc.GroovyConstructorDoc;
import org.codehaus.groovy.groovydoc.GroovyFieldDoc;
import org.codehaus.groovy.groovydoc.GroovyMethodDoc;
import org.codehaus.groovy.groovydoc.GroovyPackageDoc;
import org.codehaus.groovy.groovydoc.GroovyParameter;
import org.codehaus.groovy.groovydoc.GroovyRootDoc;
import org.codehaus.groovy.groovydoc.GroovyTag;
import org.codehaus.groovy.groovydoc.GroovyType;
import org.codehaus.groovy.tools.groovydoc.adapters.java.JavaClassDocAdapter;
import org.codehaus.groovy.tools.groovydoc.adapters.java.JavaConstructorDocAdapter;
import org.codehaus.groovy.tools.groovydoc.adapters.java.JavaFieldDocAdapter;
import org.codehaus.groovy.tools.groovydoc.adapters.java.JavaMethodDocAdapter;
import org.codehaus.groovy.tools.groovydoc.adapters.java.JavaPackageDocAdapter;
import org.codehaus.groovy.tools.groovydoc.adapters.java.JavaParameterAdapter;
import org.codehaus.groovy.tools.groovydoc.adapters.java.JavaRootDocAdapter;
import org.codehaus.groovy.tools.groovydoc.adapters.java.JavaTagAdapter;
import org.codehaus.groovy.tools.groovydoc.adapters.java.JavaTypeAdapter;

public final class GroovyDocUtils {
    public static GroovyFieldDoc toGroovyFieldDoc(FieldDoc doc) {
        if (doc == null) return null;
        if (doc instanceof GroovyFieldDocAdapter) {
            return ((GroovyFieldDocAdapter) doc).groovyFieldDoc();
        }
        return new JavaFieldDocAdapter(doc);
    }

    public static GroovyMethodDoc toGroovyMethodDoc(MethodDoc doc) {
        if (doc == null) return null;
        if (doc instanceof GroovyMethodDocAdapter) {
            return ((GroovyMethodDocAdapter) doc).groovyMethodDoc();
        }
        return new JavaMethodDocAdapter(doc);
    }

    public static GroovyClassDoc toGroovyClassDoc(ClassDoc doc) {
        if (doc == null) return null;
        if (doc instanceof GroovyClassDocAdapter) {
            return ((GroovyClassDocAdapter) doc).groovyClassDoc();
        }
        return new JavaClassDocAdapter(doc);
    }

    public static GroovyConstructorDoc toGroovyConstructorDoc(ConstructorDoc doc) {
        if (doc == null) return null;
        if (doc instanceof GroovyConstructorDocAdapter) {
            return ((GroovyConstructorDocAdapter) doc).groovyConstructorDoc();
        }
        return new JavaConstructorDocAdapter(doc);
    }

    public static GroovyPackageDoc toGroovyPackageDoc(PackageDoc doc) {
        if (doc == null) return null;
        if (doc instanceof GroovyPackageDocAdapter) {
            return ((GroovyPackageDocAdapter) doc).groovyPackageDoc();
        }
        return new JavaPackageDocAdapter(doc);
    }

    public static GroovyRootDoc toGroovyRootDoc(RootDoc doc) {
        if (doc == null) return null;
        if (doc instanceof GroovyRootDocAdapter) {
            return ((GroovyRootDocAdapter) doc).groovyRootDoc();
        }
        return new JavaRootDocAdapter(doc);
    }

    public static GroovyType toGroovyType(Type type) {
        if (type == null) return null;
        if (type instanceof GroovyTypeAdapter) {
            return ((GroovyTypeAdapter) type).groovyType();
        }
        return new JavaTypeAdapter(type);
    }

    public static GroovyTag toGroovyTag(Tag tag) {
        if (tag == null) return null;
        if (tag instanceof GroovyTagAdapter) {
            return ((GroovyTagAdapter) tag).groovyTag();
        }
        return new JavaTagAdapter(tag);
    }

    public static GroovyParameter toGroovyParameter(Parameter parameter) {
        if (parameter == null) return null;
        if (parameter instanceof GroovyParameterAdapter) {
            return ((GroovyParameterAdapter) parameter).groovyParameter();
        }
        return new JavaParameterAdapter(parameter);
    }

    public static GroovyConstructorDoc[] make(ConstructorDoc[] input) {
        if (input == null) return new GroovyConstructorDoc[0];
        GroovyConstructorDoc[] output = new GroovyConstructorDoc[input.length];
        for (int i = 0; i < input.length; i++) {
            output[i] = toGroovyConstructorDoc(input[i]);
        }
        return output;
    }

    public static GroovyMethodDoc[] make(MethodDoc[] input) {
        if (input == null) return new GroovyMethodDoc[0];
        GroovyMethodDoc[] output = new GroovyMethodDoc[input.length];
        for (int i = 0; i < input.length; i++) {
            output[i] = toGroovyMethodDoc(input[i]);
        }
        return output;
    }

    public static GroovyFieldDoc[] make(FieldDoc[] input) {
        if (input == null) return new GroovyFieldDoc[0];
        GroovyFieldDoc[] output = new GroovyFieldDoc[input.length];
        for (int i = 0; i < input.length; i++) {
            output[i] = toGroovyFieldDoc(input[i]);
        }
        return output;
    }

    public static GroovyClassDoc[] make(ClassDoc[] input) {
        if (input == null) return new GroovyClassDoc[0];
        GroovyClassDoc[] output = new GroovyClassDoc[input.length];
        for (int i = 0; i < input.length; i++) {
            output[i] = toGroovyClassDoc(input[i]);
        }
        return output;
    }

    public static GroovyPackageDoc[] make(PackageDoc[] input) {
        if (input == null) return new GroovyPackageDoc[0];
        GroovyPackageDoc[] output = new GroovyPackageDoc[input.length];
        for (int i = 0; i < input.length; i++) {
            output[i] = toGroovyPackageDoc(input[i]);
        }
        return output;
    }

    public static GroovyParameter[] make(Parameter[] input) {
        if (input == null) return new GroovyParameter[0];
        GroovyParameter[] output = new GroovyParameter[input.length];
        for (int i = 0; i < input.length; i++) {
            output[i] = toGroovyParameter(input[i]);
        }
        return output;
    }
}
