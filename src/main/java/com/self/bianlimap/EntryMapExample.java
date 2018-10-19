package com.self.bianlimap;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import com.self.bianlimap.Clothes.Size;
class Clothes{
	/**
	 * {@link #SMALL} 小号
	 * {@link #MEDIUM} 中号
	 * {@link #LARGE} 大号
	 * @author cl
	 *
	 */
	public enum Size{
		/*小号*/
		SMALL,
		/*中号*/
		MEDIUM,
		/*大号*/
		LARGE
	} 
	String id;
	Size size;
	public Clothes(String id, Size size) {
		this.id = id;
		this.size = size;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	
}
/**
 * 枚举EntryMap示列
 * @author Administrator
 *
 */
public class EntryMapExample {
	public static Map<Size,Integer> countBySize(List<Clothes> clothes){
		Map<Size,Integer> map = new EnumMap<>(Size.class);
		for (Clothes c : clothes) {
			Size size = c.getSize();
			Integer count = map.get(size);
			if(count!=null){
				map.put(size, count+1);
			}else{
				map.put(size,1);
			}
		}
		return map;		
	}

	public static void main(String[] args) {
		List<Clothes> clothes = Arrays.asList(new Clothes[]{
				new Clothes("001",Size.SMALL),
				new Clothes("002",Size.LARGE),
				new Clothes("003",Size.MEDIUM),
				new Clothes("004",Size.SMALL),
				new Clothes("005",Size.LARGE),
				new Clothes("006",Size.SMALL),
				new Clothes("007",Size.SMALL)});
		System.out.println(EntryMapExample.countBySize(clothes));
	}
}
