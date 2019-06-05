package lk.ijse.absd.main;


import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses()

    {
        System.out.println(" getRootConfigClasses() 1");
        return new Class[]{WebRootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println(" getServletConfigClasses() 2");

        return new Class[]{WebAppConfig.class};
    }

    @Override
    protected String[] getServletMappings(){

        System.out.println(" getServletConfigClasses() 3");
    return new String[]{"/"};
    }
    /*
     * We need to override this method inorder to set MultipartConfigElement
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        System.out.println("customizeRegistration: 1");
        registration.setMultipartConfig(new MultipartConfigElement(System.getProperty("java.io.tmpdir")));
    }


}
