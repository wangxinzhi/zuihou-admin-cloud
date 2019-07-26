package com.github.zuihou.base;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

/**
 * This is a Description
 *
 * @author zuihou
 * @date 2019/07/26
 */
public interface BaseEnum {
    /**
     * 将制定的枚举集合转成 map
     * key -> name
     * value -> desc
     *
     * @param list
     * @return
     */
    static Map<String, String> getMap(BaseEnum[] list) {
        ImmutableMap<String, BaseEnum> nameMap = Maps.uniqueIndex(Arrays.asList(list), BaseEnum::getCode);
        Map<String, String> nameDescMap = new HashMap<>(nameMap.size());
        nameMap.forEach((name, desc) -> nameDescMap.put(name, desc.getDesc()));
        return nameDescMap;
    }

    /**
     * 编码重写
     *
     * @return
     */
    default String getCode() {
        return toString();
    }

    /**
     * 描述
     *
     * @return
     */
    String getDesc();
}
