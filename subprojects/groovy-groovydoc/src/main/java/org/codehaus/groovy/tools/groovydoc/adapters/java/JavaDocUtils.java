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
import com.sun.javadoc.ConstructorDoc;
import com.sun.javadoc.Doc;
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
import org.codehaus.groovy.tools.groovydoc.adapters.groovy.GroovyClassDocAdapter;
import org.codehaus.groovy.tools.groovydoc.adapters.groovy.GroovyConstructorDocAdapter;
import org.codehaus.groovy.tools.groovydoc.adapters.groovy.GroovyFieldDocAdapter;
import org.codehaus.groovy.tools.groovydoc.adapters.groovy.GroovyMethodDocAdapter;
import org.codehaus.groovy.tools.groovydoc.adapters.groovy.GroovyPackageDocAdapter;
import org.codehaus.groovy.tools.groovydoc.adapters.groovy.GroovyParameterAdapter;
import org.codehaus.groovy.tools.groovydoc.adapters.groovy.GroovyRootDocAdapter;
import org.codehaus.groovy.tools.groovydoc.adapters.groovy.GroovyTagAdapter;
import org.codehaus.groovy.tools.groovydoc.adapters.groovy.GroovyTypeAdapter;

public final class JavaDocUtils {
    public static FieldDoc toFieldDoc(GroovyFieldDoc doc) {
        if (doc == null) return null;
        if (doc instanceof JavaFieldDocAdapter) {
            return ((JavaFieldDocAdapter) doc).fieldDoc();
        }
        return new GroovyFieldDocAdapter(doc);
    }

    public static MethodDoc toMethodDoc(GroovyMethodDoc doc) {
        if (doc == null) return null;
        if (doc instanceof JavaMethodDocAdapter) {
            return ((JavaMethodDocAdapter) doc).methodDoc();
        }
        return new GroovyMethodDocAdapter(doc);
    }

    public static ClassDoc toClassDoc(GroovyClassDoc doc) {
        if (doc == null) return null;
        if (doc instanceof JavaClassDocAdapter) {
            return ((JavaClassDocAdapter) doc).classDoc();
        }
        return new GroovyClassDocAdapter(doc);
    }

    public static ConstructorDoc toConstructorDoc(GroovyConstructorDoc doc) {
        if (doc == null) return null;
        if (doc instanceof JavaConstructorDocAdapter) {
            return ((JavaConstructorDocAdapter) doc).constructorDoc();
        }
        return new GroovyConstructorDocAdapter(doc);
    }

    public static PackageDoc toPackageDoc(GroovyPackageDoc doc) {
        if (doc == null) return null;
        if (doc instanceof JavaPackageDocAdapter) {
            return ((JavaPackageDocAdapter) doc).packageDoc();
        }
        return new GroovyPackageDocAdapter(doc);
    }

    public static RootDoc toRootDoc(GroovyRootDoc doc) {
        if (doc == null) return null;
        if (doc instanceof JavaRootDocAdapter) {
            return ((JavaRootDocAdapter) doc).rootDoc();
        }
        return new GroovyRootDocAdapter(doc);
    }

    public static Type toType(GroovyType type) {
        if (type == null) return null;
        if (type instanceof JavaTypeAdapter) {
            return ((JavaTypeAdapter) type).type();
        }
        return new GroovyTypeAdapter(type);
    }

    public static Tag toTag(GroovyTag tag, Doc holder) {
        if (tag == null) return null;
        if (tag instanceof JavaTagAdapter) {
            return ((JavaTagAdapter) tag).tag();
        }
        return new GroovyTagAdapter(tag, holder);
    }

    public static Parameter toParameter(GroovyParameter parameter) {
        if (parameter == null) return null;
        if (parameter instanceof JavaParameterAdapter) {
            return ((JavaParameterAdapter) parameter).parameter();
        }
        return new GroovyParameterAdapter(parameter);
    }

    public static ConstructorDoc[] make(GroovyConstructorDoc[] input) {
        if (input == null) return new ConstructorDoc[0];
        ConstructorDoc[] output = new ConstructorDoc[input.length];
        for (int i = 0; i < input.length; i++) {
            output[i] = toConstructorDoc(input[i]);
        }
        return output;
    }

    public static MethodDoc[] make(GroovyMethodDoc[] input) {
        if (input == null) return new MethodDoc[0];
        MethodDoc[] output = new MethodDoc[input.length];
        for (int i = 0; i < input.length; i++) {
            output[i] = toMethodDoc(input[i]);
        }
        return output;
    }

    public static FieldDoc[] make(GroovyFieldDoc[] input) {
        if (input == null) return new FieldDoc[0];
        FieldDoc[] output = new FieldDoc[input.length];
        for (int i = 0; i < input.length; i++) {
            output[i] = toFieldDoc(input[i]);
        }
        return output;
    }

    public static ClassDoc[] make(GroovyClassDoc[] input) {
        if (input == null) return new ClassDoc[0];
        ClassDoc[] output = new ClassDoc[input.length];
        for (int i = 0; i < input.length; i++) {
            output[i] = toClassDoc(input[i]);
        }
        return output;
    }

    public static PackageDoc[] make(GroovyPackageDoc[] input) {
        if (input == null) return new PackageDoc[0];
        PackageDoc[] output = new PackageDoc[input.length];
        for (int i = 0; i < input.length; i++) {
            output[i] = toPackageDoc(input[i]);
        }
        return output;
    }

    public static Parameter[] make(GroovyParameter[] input) {
        if (input == null) return new Parameter[0];
        Parameter[] output = new Parameter[input.length];
        for (int i = 0; i < input.length; i++) {
            output[i] = toParameter(input[i]);
        }
        return output;
    }
}
