package reflect;

/**
 * 在反射机制中访问注解
 */
public class ReflectDemo8 {
    public static void main(String[] args) throws Exception {
        //如何知道一个类是否被某个注解标注?
        Class cls = Class.forName("reflect.Person");
//        Class cls = Class.forName("reflect.Student");
        /*
            实际上除了Class之外，其他几个反射对象:
            Method,Constructor,Field等都有这个方法:boolean isAnnotationPresent(Class cls)
            用于判断:方法，构造器，属性等是否又被某个特定的构造器标注
         */
        //当前Person类是否被注解@AutoRunClass标注了?
        boolean mark = cls.isAnnotationPresent(AutoRunClass.class);
        if(mark){
            System.out.println("被标注了!");
        }else{
            System.out.println("没有被标注!");
        }

    }
}
