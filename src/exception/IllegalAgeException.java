package exception;

/**
 * 自定义异常
 * 自定义异常通常用来表达那些满足语法但是不满足业务场景的错误
 *
 * 自定义异常需要做如下操作:
 * 1:异常的类名必须见名知义
 * 2:必须是Exception的子类(直接或间接子类都可以)
 * 3:提供超类所有种类的构造器(IDEA生成即可)
 */
public class IllegalAgeException extends Exception{
    public IllegalAgeException() {
    }

    public IllegalAgeException(String message) {
        super(message);
    }

    public IllegalAgeException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalAgeException(Throwable cause) {
        super(cause);
    }

    public IllegalAgeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
