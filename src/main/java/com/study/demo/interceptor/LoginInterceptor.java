package com.study.demo.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.kit.StrKit;
import com.study.demo.io.Result;
import com.study.demo.model.User;


/**
 * 管理员权限拦截器
 *
 * @author
 */
public class LoginInterceptor implements Interceptor {

    public void intercept(Invocation inv) {
        Controller controller = inv.getController();
        Boolean isAjax = !StrKit.isBlank(controller.getRequest().getHeader("X-Requested-With"));
        String methodName = inv.getMethodName();

        if ("login".equals(methodName)  || "logout".equals(methodName) || "removeAllLoginUser".equals(methodName)) {
            inv.invoke();
        } else {
            User user = controller.getSessionAttr("user");
            if (user == null) {
                if (isAjax) {
                    Result result = new Result();
                    result.setCode(8);
                    controller.renderJson(result);
                    return;
                }
                controller.setSessionAttr("url", inv.getActionKey());
                controller.render("/view/login.html");
                return;
            }
            controller.setSessionAttr("url", inv.getActionKey());
            controller.setAttr("user", controller.getSessionAttr("user"));
            inv.invoke();
        }
    }

}
