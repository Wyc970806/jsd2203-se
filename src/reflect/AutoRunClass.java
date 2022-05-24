package reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解
 * 注解在反射机制中被大量调用，可以便于我们更准确的使用反射机制操作一个类。
 * 注解在框架中被大量的应用。
 *
 * 注解可以通过java内置的注解:@Target标注，用于指定当前注解可以在什么地方被使用。
 * @Target的选项都被定义在ElementType中。
 *  常用的值:
 *          ElementType.TYPE:在类上可以使用当前注解
 *          ElementType.FIELD:在属性上可以使用当前注解
 *          ElementType.CONSTRUCTOR:在构造方法上可以使用当前注解
 *          ElementType.METHOD:在方法上可以使用当前注解
 *          ElementType.PACKAGE:在包上可以使用当前注解
 *          ...
 * 如果当前注解没有使用@Target注解标注，那么当前注解可以在任何注解可以使用的地方被应用。
 * 如果希望同时在几个可选地方使用时，应当如下指定:
 * @Target({ElementType.TYPE,ElementType.METHOD,...})  以数组形式包含可以指定位置的选项并传入@Target
 *
 *
 * @Retention注解，该注解用于标注当前注解的保留级别，有三个可选值
 * RetentionPolicy.CLASS    :   当前注解保留在编译后的字节码文件中，但是不可被反射机制操作。
 * RetentionPolicy.SOURCE   :   当前注解仅保留在源代码中。
 * RetentionPolicy.RUNTIME  :   当前注解保留在编译后的字节码文件中，可被反射机制操作。
 * 注意:如果@Retention不指定，默认级别为CLASS
 * 由于我们都是在反射机制中大量使用注解，因此我们通常要显示的标注注解的保留级别为RUNTIME!!!
 *
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoRunClass {
}
