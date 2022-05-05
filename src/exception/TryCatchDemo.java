package exception;

/**
 * 异常处理机制中的try-catch
 * 语法:
 * try{
 *     可能出现异常的代码片段
 * }catch(XXXException e){
 *     try语句块中出现XXXException后的处理代码
 * }
 */
public class TryCatchDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了...");
        //try语句块不可以单独写，后面必须跟catch或finally
        try {
//            String str = null;
//            String str = "";
            String str = "abc";
            //出现空指针后JVM会实例化一个空指针异常实例并抛出
            System.out.println(str.length());

            System.out.println(str.charAt(0));

            System.out.println(Integer.parseInt(str));
            //注意:try语句块中出错代码以下的内容均不会执行!
            System.out.println("!!!!!!!!!!!!!!!!!");
        /*
            如果catch捕获的异常类型是try语句块中出现的错误，JVM就会将异常传
            给变量e,并执行该catch块来来完成补救措施
         */
//        } catch (NullPointerException e) {
//            System.out.println("出现了空指针异常!");
//
//            //catch是可以写多个的，针对不同异常有不同处理办法时，可以分别捕获
//        } catch (StringIndexOutOfBoundsException e) {
//            System.out.println("出现了字符串下标越界异常!");
//        }

        //当几种不同的异常的处理方式相同时，我们可以合并到一个catch中进行处理
        }catch(NullPointerException | StringIndexOutOfBoundsException e){
            System.out.println("出现了空指针或字符串下标越界异常!");

        //当异常存在继承关系时，子类异常在上先捕获，超类异常在下后捕获。
        //可以在最后一个catch处捕获最大的Exception，避免以为一个未处理的异常导致程序中断
        }catch(Exception e){
            System.out.println("反正就是出了个错!");
        }

        System.out.println("程序结束了...");
    }

}




