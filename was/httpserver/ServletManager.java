package was.httpserver;

import was.httpserver.servlet.InternalErrorServlet;
import was.httpserver.servlet.NotFoundServlet;
import was.httpserver.servlet.PageNotFoundException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ServletManager {
    private final Map<String, HttpServlet> servletMap = new HashMap<>();
    private HttpServlet defaultServlet;
    private HttpServlet notFoundServlet = new NotFoundServlet();
    private HttpServlet inernalErrorServlet = new InternalErrorServlet();

    public ServletManager() {
    }

    public void add(String path, HttpServlet servlet) {
        servletMap.put(path, servlet);
    }

    public void setDefaultServlet(HttpServlet defaultServlet) {
        this.defaultServlet = defaultServlet;
    }

    public void setNotFoundServlet(HttpServlet notFoundServlet) {
        this.notFoundServlet = notFoundServlet;
    }

    public void setInernalErrorServlet(HttpServlet inernalErrorServlet) {
        this.inernalErrorServlet = inernalErrorServlet;
    }

    public void excute(HttpRequest request, HttpResponse response) throws IOException {
        try{
            HttpServlet servlet = servletMap.getOrDefault(request.getPath(), defaultServlet);
            if(servlet == null){
                throw new PageNotFoundException("request url = " + request.getPath());
            }
            servlet.service(request, response);

        }catch (PageNotFoundException e){
            e.printStackTrace();
            notFoundServlet.service(request, response);
        }catch (Exception e){
            e.printStackTrace();
            inernalErrorServlet.service(request,response);
        }
    }
}
