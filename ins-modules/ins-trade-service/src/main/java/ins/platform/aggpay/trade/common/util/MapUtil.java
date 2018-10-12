package ins.platform.aggpay.trade.common.util;

import ins.platform.aggpay.trade.vo.RegisterQueryVo;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class MapUtil {
	
	/**
	 * 返回一个Class的实例
	 * 实例的属性值取决于Map
	 * @param map
	 * @param cls
	 * @return
	 */
	public static <T> T map2Obj(Map<?,?> map, Class<?> cls){
		Object obj = null;
		try {
			obj = cls.newInstance();
			Field[] fields = cls.getDeclaredFields();
			for (Field field : fields) {
				int mod = field.getModifiers();
				if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){
					continue;
				}
				field.setAccessible(true);	
				if(map.get(field.getName()) instanceof Map<?, ?>){
					field.set(obj,map2Obj((Map<?, ?>)map.get(field.getName()),field.getType()));
				}else{
					Object value = map.get(field.getName());
					if(field.getType().equals(Integer.class)){
						value = Integer.parseInt((String) value);
					}
					field.set(obj, value);
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		} 
		return (T)obj;
	}
	
	/**
	 * 更改obj属性的值
	 * 取决于map的值
	 * 会覆盖旧值
	 * @param map
	 * @param obj
	 */
	public static void map2Obj(Map map, Object obj){
		try {
			Field[] fields = obj.getClass().getDeclaredFields();
			for (Field field : fields) {
				int mod = field.getModifiers();
				if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){
					continue;
				}
				field.setAccessible(true);
				if(map.get(field.getName()) instanceof Map<?, ?>){
					field.set(obj,map2Obj((Map<?, ?>)map.get(field.getName()),field.getDeclaringClass()));
				}else{
					field.set(obj, map.get(field.getName()));
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		} 
	}
	
	public static void main(String[] args) {
		RegisterQueryVo a = new RegisterQueryVo();

		Map<String,Object> map1 = new HashMap<String, Object>();
		map1.put("a", "1111");

		RegisterQueryVo b = map2Obj(map1,RegisterQueryVo.class);

		System.out.println(a.toString());
		System.out.println(b.toString());
	}
	
}
