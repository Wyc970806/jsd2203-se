package exception;

/**
 * 使用当前类测试异常的抛出
 */
public class Person {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age<0||age>100){
            throw new RuntimeException("年龄超过了范围!");
        }
        this.age = age;
    }
}
