package com.luxhouse.main.interceptor;

import com.luxhouse.main.repository.CategoryRepository;
import com.luxhouse.main.service.CategoryProductService;
import com.luxhouse.main.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class GlobalInterceptor implements HandlerInterceptor {

    @Autowired
    CategoryService categoryService;
    @Autowired
    CategoryProductService categoryProductService;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        request.setAttribute("cates", categoryService.findAll());
        request.setAttribute("cate_pro", categoryProductService.findAll());
    }
}