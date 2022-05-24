package reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)

public @interface AutoRunMethod {
    /*
        注解可以定义参数。格式:类型 参数名() [default 默认值]
        如下:
            int value()
        当定义了该参数后，那么使用注解时可以为其传递参数值，如:
            @AutoRunMethod(8)   此时value参数值为:8


        参数可以声明默认值，如：
            int value() default 1;
        当使用该注解不传入参数时，该参数采取默认值。
            @AutoRunMethod  此时value参数默认值就是1
        如果没有指定默认值，那么参数必须传值！！

        注意:如果当前注解仅指定了一个参数，那么参数名尽量使用value。这样外面给该参数传值时可省去参数名。
        如:
        @AutoRunMethod(8) 此时value参数的值为8
        否则，正常使用注解传参的语法格式为:@注解名(参数名=参数值)
        例如:
        当前注解中指定的参数为:
        int count;
        此时使用当前注解并传参时应当写为:
        @AutoRunMethod(count=2)

        两个异常参数时，无论哪个参数的名字叫value都要用name=value的格式传递参数。
        例如当前注解定义了两个参数:
        int count();
        String name();

        那么使用当前注解传参时的格式:
        @AutoRunMethod(count=7,name="张三")
        注意:这里传参的顺序可以和参数定义的顺序不一致。即:
         @AutoRunMethod(name="张三",count=7)也是允许的。

     */
    int value() default 1;

//    int count();
//    String name();
}








