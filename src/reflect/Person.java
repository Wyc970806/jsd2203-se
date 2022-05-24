package reflect;

/**
 * 使用当前类测试反射机制
 */

@AutoRunClass
public class Person {

    private String name = "张三";
    private int age = 22;

    public Person(){}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void sayHello(){
        System.out.println(name+":Hello!");
    }

    public void sayHi(){
        System.out.println(name+":Hi!");
    }

    public void watchTV(){
        System.out.println(name+":正在看电视");
    }

    public void sing(){
        System.out.println(name+":在唱歌");
    }

    public void say(String info){
        System.out.println(name+":"+info);
    }

    public void say(String info, int count){
        for(int i=0;i<count;i++){
            System.out.println(name+":"+info);
        }
    }

    private void heihei(){
        System.out.println("我是Person的私有方法!!!!!!!!!!!!!");
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}









