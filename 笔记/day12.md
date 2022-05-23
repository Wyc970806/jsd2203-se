# day12

### java反射机制

反射是java中的动态机制，它允许我们在程序运行期间再确定类的实例化，方法的调用，属性的调用等，而不是传统意义上的在编码期间确定。

因此，反射可以大大的提高代码的灵活度，但是随之而来的是更多的系统开销和较慢的运行速度，因此不能过度的依赖反射。

#### Class类

Class的每一个实例用于表示JVM加载的一个类，所以我们也称Class的实例 为类的类对象。 当JVM加载一个类时会同时实例化一个Class的实例与之对应，这个Class实例 中会保存该类的一切信息(类名，有哪些方法，构造器，属性，注解等等) 我们在程序运行期间通过某个类的类对象来操作这个类。因此使用反射操作某个 类的第一件事就是获取该类的类对象

#### 获取一个类的类对象有三种方式:

- 1:类名.class 例如: Class cls = String.class; Class cls = int.class (基本类型只能通过这种方式获取类对象)
- 2:Class.forName(String className) 通过Class的静态方法forName，传入对应类的完全限定名(包名.类名)的 形式获取类对象 Class cls = Class.forName("java.lang.String");
- 3:通过类加载器ClassLoader加载类对象

```java
package reflect;

import java.lang.reflect.Method;

/**
 * java反射机制
 * 反射是java中的动态机制，它允许我们在程序运行期间再确定类的实例化，方法的调用，
 * 属性的调用等，而不是传统意义上的在编码期间确定。
 *
 * 因此，反射可以大大的提高代码的灵活度，但是随之而来的是更多的系统开销和较慢的
 * 运行速度，因此不能过度的依赖反射。
 */
public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        /*
            Class类
            Class的每一个实例用于表示JVM加载的一个类，所以我们也称Class的实例
            为类的类对象。
            当JVM加载一个类时会同时实例化一个Class的实例与之对应，这个Class实例
            中会保存该类的一切信息(类名，有哪些方法，构造器，属性，注解等等)
            我们在程序运行期间通过某个类的类对象来操作这个类。因此使用反射操作某个
            类的第一件事就是获取该类的类对象

            获取一个类的类对象有三种方式:
            1:类名.class
            例如:
            Class cls = String.class;
            Class cls = int.class (基本类型只能通过这种方式获取类对象)

            2:Class.forName(String className)
            通过Class的静态方法forName，传入对应类的完全限定名(包名.类名)的
            形式获取类对象
            Class cls = Class.forName("java.lang.String");

            3:通过类加载器ClassLoader加载类对象

         */

        //获取String的类对象
//        Class cls = String.class;

        /*
            Class.forName()
            该方法要求必须处理异常:ClassNotFoundException

            当指定的字符串(对应类的完全限定名)有误时会抛出该异常，或指定的
            路径下无法找到该类时也会抛出该异常(多发生于通过反射加载第三方
            jar文件里的类，有时我们忘记将该jar导入环境变量中，导致JVM无法
            通过正确的包路径找到它)。
         */
//        Class cls = Class.forName("java.lang.String");

        /*
            类加载器ClassLoader
            类加载器有很多中不同的实现，创建方式也各不相同。
            最常用的是如下方式:
            ClassLoader loader = 当前类.class.getClassLoader();
            类加载器除了可以加载类对象，还可以做很多和环境变量相关的操作，功能多。
         */
        ClassLoader classLoader = ReflectDemo1.class.getClassLoader();
        Class cls = classLoader.loadClass("java.lang.String");


        //查看类名
        //获取类的完全限定名(包名.类名)
        String className = cls.getName();
        System.out.println("类名:"+className);
        //仅获取类名
        className = cls.getSimpleName();
        System.out.println("类名:"+className);

        //通过类对象获取其表示的类的所有方法
        //获取所有公开方法和从超类继承的方法
//        Method[] methods = cls.getMethods();
//        for(Method method : methods){
//            System.out.println(method.getName());
//        }

        //获取本类定义的方法(包含私有方法，但是不含有从超类继承的方法)
        Method[] methods = cls.getDeclaredMethods();
        for(Method method : methods){
            System.out.println(method.getName());
        }
    }
}
```

#### 使用反射机制进行对象的实例化

##### Class提供的方法:

Object newInstance()

该方法可以使用其表示的类的无参构造器进行对象实例化

```java
package reflect;

/**
 * 使用反射机制进行对象的实例化
 */
public class ReflectDemo2 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Person p = new Person();//硬编码，编码期间确定实例化那个类
        System.out.println(p);

        /*
            使用反射机制实例化
            1:获取要实例化类的类对象
            2:通过类对象的newInstance方法实例化
         */
        //1加载类对象
//        Class cls = Class.forName("reflect.Person");

        ClassLoader classLoader = ReflectDemo2.class.getClassLoader();
        Class cls = classLoader.loadClass("reflect.Person");

        //2通过类对象实例化
        Object o = cls.newInstance();//调用无参构造器
        System.out.println(o);

    }
}
```

##### 使用有参构造器实例化对象

```java
package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 使用有参构造器实例化对象
 */
public class ReflectDemo3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Person p = new Person("刘苍松",55);
        System.out.println(p);

        //加载类对象
        Class cls = Class.forName("reflect.Person");
        //获取无参构造器
//        Constructor c = cls.getConstructor();
//        Object o  = c.newInstance();

        //先获取指定的构造器：Person(String name,int age)
        Constructor c = cls.getConstructor(String.class,int.class);
        Object o  = c.newInstance("刘苍松",55);
        System.out.println(o);
    }
}
```

#### 使用反射机制调用方法

##### 调用无参数方法:

```java
package reflect;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * 使用反射机制调用方法
 */
public class ReflectDemo4 {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
        p.sayHello();


        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入类名:");
        String className = scanner.nextLine();
        System.out.println("请输入方法名:");
        String methodName = scanner.nextLine();

        //实例化
        ClassLoader classLoader = ReflectDemo4.class.getClassLoader();
//        Class cls = classLoader.loadClass("reflect.Person");
        Class cls = classLoader.loadClass(className);
        Object o = cls.newInstance();//new Person()

        //调用方法
        //1通过类对象获取要调用的方法
//        Method method = cls.getMethod("sayHello");//获取无参方法sayHello
        Method method = cls.getMethod(methodName);
        //2通过方法对象执行该方法
        method.invoke(o);//o.sayHello()   o实际上是一个Person对象
    }
}
```

##### 调用有参方法:

```java
package reflect;


import java.lang.reflect.Method;

/**
 * 调用有参方法
 */
public class ReflectDemo5 {
    public static void main(String[] args) throws Exception {
        Class cls = Class.forName("reflect.Person");
        Object o = cls.newInstance();

        //say(String info)
        Method m = cls.getMethod("say",String.class);
        m.invoke(o,"hello~~");//p.say("hello~~")

        //say(String info,int sum)
        Method m2 = cls.getMethod("say",String.class,int.class);
        m2.invoke(o,"嘿嘿",5);

    }
}
```

##### 访问私有方法:

```java
package reflect;

import java.lang.reflect.Method;

/**
 * 使用反射机制调用私有方法
 */
public class ReflectDemo6 {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
//        p.hehe();//编译不通过!

        Class cls = Class.forName("reflect.Person");
        Object o = cls.newInstance();

        //获取私有方法:private void hehe()
//        Method m = cls.getMethod("hehe");
        //获取私有方法不能用getMethod,(这用来获取公开方法)
        Method m = cls.getDeclaredMethod("hehe");
        m.setAccessible(true);//强制访问
        m.invoke(o);//o.hehe()
    }
}
```