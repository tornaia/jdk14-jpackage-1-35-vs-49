### Repro case for a Java issue

https://bugs.openjdk.java.net/browse/JDK-8231924

The changes in JDK 14 via JDK-8212117 to align Class.forName with its specification may need follow on work in the core reflection code that obtains the Type of a field with parameterized type.

The sighting on core-libs-dev is here:
  https://mail.openjdk.java.net/pipermail/core-libs-dev/2019-October/062747.html

In the example, Service can be loaded but not linked. It may be that makeNamedType needs to catch NoClassDefFoundError so that TypeNotPresentException can be thrown.

### Compile and run with jpackage+1-35

Output
```
c:\Private\jdk14-jpackage-1-35-vs-49>java Main
14-jpackage+1-35
```


### Compile and run with jpackage+1-49

Output
```
c:\Private\jdk14-jpackage-1-35-vs-49>java Main
14-jpackage+1-49
Exception in thread "main" java.lang.NoClassDefFoundError: OptionalService
        at java.base/java.lang.Class.forName0(Native Method)
        at java.base/java.lang.Class.forName(Class.java:420)
        at java.base/sun.reflect.generics.factory.CoreReflectionFactory.makeNamedType(CoreReflectionFactory.java:114)
        at java.base/sun.reflect.generics.visitor.Reifier.visitClassTypeSignature(Reifier.java:125)
        at java.base/sun.reflect.generics.tree.ClassTypeSignature.accept(ClassTypeSignature.java:49)
        at java.base/sun.reflect.generics.visitor.Reifier.reifyTypeArguments(Reifier.java:68)
        at java.base/sun.reflect.generics.visitor.Reifier.visitClassTypeSignature(Reifier.java:138)
        at java.base/sun.reflect.generics.tree.ClassTypeSignature.accept(ClassTypeSignature.java:49)
        at java.base/sun.reflect.generics.repository.FieldRepository.computeGenericType(FieldRepository.java:90)
        at java.base/sun.reflect.generics.repository.FieldRepository.getGenericType(FieldRepository.java:82)
        at java.base/java.lang.reflect.Field.getGenericType(Field.java:266)
        at Main.main(Main.java:12)
Caused by: java.lang.ClassNotFoundException: OptionalService
        at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:602)
        at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:178)
        at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:521)
        ... 12 more
```
