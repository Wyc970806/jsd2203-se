package exception;

/**
 * 面试题
 * 1:分别说明final,finally,finalize
 *  finalize是Object中的一个方法，所有的类都有该方法。它是被GC调用的，当GC即将释放一个对象时会调用该方法，调用
 *  后对象被回收。注意：该方法若重写，不应当有耗时的操作。
 */
public class FinallyDemo3 {
    public static void main(String[] args) {
        System.out.println(
                test("0")+","+test(null)+","+test("")
        );//0,1,2
    }
    public static int test(String str){
        try{
            return str.charAt(0) - '0';
        }catch(NullPointerException e){
            return 1;
        }catch(Exception e){
            return 2;
        }finally {
            return 3;
        }
    }

}







