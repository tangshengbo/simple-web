package com.tangshengbo.aspect;

import com.tangshengbo.annotation.Aspect;
import com.tangshengbo.annotation.Controller;
import com.tangshengbo.proxy.AbstractAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * Created by TangShengBo on 2018/1/1.
 */
@Aspect(Controller.class)
public class TimerAspect extends AbstractAspect {

    private static final Logger logger = LoggerFactory.getLogger(TimerAspect.class);

    private long beginTime;

    @Override
    public void before(Class<?> cls, Method method, Object[] params) {
        logger.info("----------begin--------------");
        logger.info("class:{}, method:{}", cls.getName(), method.getName());
        beginTime = System.currentTimeMillis();
    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params) {
        logger.info("----------end--------------");
        logger.info("time:{} ms", System.currentTimeMillis() - beginTime);
        beginTime = System.currentTimeMillis();
    }

    @Override
    public boolean intercept(Class<?> cls, Method method, Object[] params) {
        logger.info("----------intercept--------------");
        return super.intercept(cls, method, params);
    }
}
