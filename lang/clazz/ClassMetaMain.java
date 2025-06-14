package lang.clazz;

import java.lang.*;
import java.lang.reflect.*;

public class ClassMetaMain {

    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = String.class;
//        Class clazz = new String().getClass();
//        Class clazz = Class.forName("java.lang.String");

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field = " + field.getType() + " " + field.getName());
        }
        System.out.println(

        );
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("method = " + method);
        }
        System.out.println();

        System.out.println("Superclass: " +clazz.getSuperclass().getName());
        System.out.println();

        Class[] interfaces = clazz.getInterfaces();
        for (Class i : interfaces) {
            System.out.println("interface = " + i.getName());
        }
        System.out.println();

    }
}
