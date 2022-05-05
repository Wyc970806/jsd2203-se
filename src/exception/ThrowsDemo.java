package exception;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 子类在重写超类中含有throws声明异常抛出的方法时对throws的重写规则
 */
public class ThrowsDemo {
    public void dosome()throws IOException, AWTException {}
}

class SubClass extends ThrowsDemo{
//    public void dosome()throws IOException, AWTException {}

    //允许子类方法不再抛出任何异常
//    public void dosome(){}

    //允许子类方法抛出部分异常
//    public void dosome()throws IOException{}

    //允许子类方法抛出超类方法声明异常的子类型异常
//    public void dosome()throws FileNotFoundException {}

    //不允许子类抛出额外异常(超类方法上没有的且没有继承关系的异常)
//    public void dosome()throws SQLException {}

    //不允许子类抛出比超类方法声明的异常还大的异常
//    public void dosome()throws Exception {}

}






