package reflect;

@AutoRunClass
public class Student {

    @AutoRunMethod
    public void study(){
        System.out.println("学生:good good study!day day up!");
    }

    public void playGame(){
        System.out.println("学生:打游戏!");
    }
}
