package com.wamgwei.enable;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

/**
 * 接口ImportSelector:通常跟@Import结合使用。作用：自定义决定需要导入哪些类到Spring容器
 */
@Component
public class MyImportSelector implements ImportSelector {
    /**
     * 返回值数组中必须是一个class(类的全路径)，返回的class会被Spring容器所托管
     * @param importingClassMetadata
     * @return
     */
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        /**
         * 获取到所有的注解类型
         */
        Set<String> annotationTypes = importingClassMetadata.getAnnotationTypes();
        for (String type : annotationTypes) {
            System.out.println("annotationType:"+type);

            /**
             * 获取指定注解的所有参数值，返回值Map
             */
            Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(type);
            System.out.println("***********"+type+"--attributes:\n "+annotationAttributes);

        }
        return new String[]{"com.wamgwei.enable.Girl",Role.class.getName()};
    }
}
