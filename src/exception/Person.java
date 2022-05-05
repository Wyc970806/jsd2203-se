package exception;

/**
 * 使用当前类测试异常的抛出
 */
public class Person {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws Exception {
        if(age<0||age>100){
//            throw new RuntimeException("年龄超过了范围!");
            /*
                当我们使用throw主动抛出一个异常时，就必须在方法上使用throws声明该异常的抛出通知调用者
                处理该异常。RuntimeException是一个例外。
             */
            throw new Exception("年龄超过了范围!");
        }
        this.age = age;
    }
}
