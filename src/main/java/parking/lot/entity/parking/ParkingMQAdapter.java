package parking.lot.entity.parking;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;

public class ParkingMQAdapter<T> {
    public Object filter(String strJson, Map<String, String> link, Class<T> targetClass) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        return filter(JSON.parseObject(strJson, Map.class, Feature.SupportAutoType), link, targetClass);
    }

    public Object filter(Map<String,String> fromJsonMap, Map<String, String> link, Class<T> targetClass) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Object toObject = targetClass.newInstance();
        for (String key : link.keySet()) {
            Object val = fromJsonMap.get(link.get(key));
            targetClass.getMethod("set" + key.substring(0, 1).toUpperCase() + key.substring(1), String.class).invoke(toObject, val.toString());
        }
        return toObject;
    }
}
