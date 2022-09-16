package es.kiwi.mybatis.sqlsession.proxy;

import es.kiwi.mybatis.cfg.Mapper;
import es.kiwi.mybatis.utils.Executor;
import lombok.AllArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

@AllArgsConstructor
public class MapperProxy implements InvocationHandler {

    private Map<String, Mapper> mappers;
    private Connection conn;


    /**
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        String methodName = method.getName();
        String className = method.getDeclaringClass().getName();
        String key = className + "." +methodName;
        Mapper mapper = mappers.get(key);
        if (mapper ==  null) {
            throw new IllegalArgumentException("传入的参数有误");
        }

        return new Executor().selectList(mapper, conn);
    }
}
