package was.httpserver.servlet.annotation;

import was.httpserver.HttpRequest;
import was.httpserver.HttpResponse;
import was.httpserver.HttpServlet;
import was.httpserver.servlet.PageNotFoundException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class AnnotationServletV2 implements HttpServlet {
    private List<Object> controllers;

    public AnnotationServletV2(List<Object> controllers) {
        this.controllers = controllers;
    }

    @Override
    public void service(HttpRequest request, HttpResponse response) throws IOException {
        String path = request.getPath();

        for (Object controller : controllers) {
            Method[] methods = controller.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if(method.isAnnotationPresent(Mapping.class)){
                    Mapping mapping = method.getAnnotation((Mapping.class));
                    String value = mapping.value();
                    if(value.equals(path)){
                        invoke(controller, method, request, response);
                        return;
                    }
                }
            }
        }
        throw new PageNotFoundException("requet = " + path);
    }

    private static void invoke(Object controller, Method method, HttpRequest request, HttpResponse response) {

        Class<?>[] parameterTypees = method.getParameterTypes();
        Object[] args = new Object[parameterTypees.length];

        for (int i = 0; i < parameterTypees.length; i++) {
            if(parameterTypees[i] == HttpRequest.class){
                args[i] = request;
            } else if(parameterTypees[i] == HttpResponse.class){
                args[i] = response;
            }else {
                throw new IllegalArgumentException("Unsupported parameter type " + parameterTypees[i]);
            }
        }

        try {
            method.invoke(controller,args );
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
