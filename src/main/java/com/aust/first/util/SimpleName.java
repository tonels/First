package com.aust.first.util;

import java.util.Random;

public class SimpleName {

	public static String main(String[] args) {
		
		Random random = new Random(System.currentTimeMillis());
		
		/* 常用姓氏 */
		String[] firstName = { "赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "白", "马", "蒋", "沈", "韩", "杨", "朱", "秦",
				"刘", "许", "张", "司马", "上官", "欧阳", "夏侯", "诸葛", "东方", "皇甫", "尉迟", "澹台", "公孙", "令狐", "宇文", "长孙", "慕容", "司徒",
				"司空", "端木", "百里", "东郭", "东门", "西门", "南宫", "太史", "司城", "贺兰", "独孤", "南郭"};
		
		/* 常用名字 */
		String[] secondName = { "莉", "多多", "阳", "洋", "芷若", "影", "若彤", "凯", "小波", "生", "浩民", "庚", "龙", "雪", "茹", "雯丽",
				"欣", "可欣", "丞琳", "雅雯", "璐", "刚", "非", "三", "懿", "云", "峰", "渊", "亮", "朔", "硕", "恭", "明", "离", "丘", "杰",
				"不败", "贺旗", "成", "成武", "嘉玲", "星辰", "力娅", };
		
		int index1 = random.nextInt(firstName.length - 1);
		String first = firstName[index1]; // 获得一个随机的姓氏
		
		int index2 = random.nextInt(secondName.length - 1);
		String second = secondName[index2]; // 获得一个随机的姓氏
		
		String name = first + second;
		
		return name;
	}
}