package dison.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.io.PrintWriter;
import java.io.StringWriter;

@ControllerAdvice
public class ContorllerInterceptor {

    /**
     * 在页面打印异常日志
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView handle(Exception e) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        printWriter.flush();
        e.printStackTrace(printWriter);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", e.getMessage());
        modelAndView.addObject("stackTrace", stringWriter.toString());
        modelAndView.setViewName("error");
        return modelAndView;
    }

}
