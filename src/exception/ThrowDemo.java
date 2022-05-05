package exception;

/**
 * throw关键字可以主动对外抛出一个异常实例，通常下列情况需要这样做:
 * 1:当前代码片段出现了异常，但是该异常不应当在当前代码片段被处理时，可以对外抛出，责任问题。
 *
 * 2:当前程序出现了满足语法，但是不满足业务场景时，可以当作错误抛出。本案例就是基于这种情况演示的。
 *
 */
public class ThrowDemo {
    public static void main(String[] args) {
        Person p = new Person();
//        p.setAge(20);
        p.setAge(10000);//满足语法不满足业务
        System.out.println("我今年:"+p.getAge()+"岁");
    }
}
