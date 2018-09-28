package com.xiaomi;

import java.util.HashSet;

/**
 * @author mingyang.dai
 * @since 2018/8/4
 */
public class NumToChinese {
	private static String solution(String line) {
		// 在此处理单行数据
		if (line.equals("0")) return "零元整";
		
		StringBuilder builder = new StringBuilder();
		if (line.length() > 8) {
			int pre = Integer.parseInt(line.substring(0, line.length() - 8));
			String prefix = get(pre);
			if (prefix.endsWith("零")) prefix = prefix.substring(0, prefix.length() - 1);
			builder.append(prefix).append("亿");
			
			int post = Integer.parseInt(line.substring(line.length() - 8));
			if (post < 10000000) {
				builder.append("零");
			}
			builder.append(get(post));
		} else {
			builder.append(get(Integer.parseInt(line)));
		}
		String res = builder.toString();
		if (res.endsWith("零")) res = res.substring(0, res.length() - 1);
		// 返回处理后的结果
		return res + "元整";
	}
	
	private static String[] map = new String[]{"","壹","贰","叁","肆","伍","陆","柒","捌","玖","拾"};
	
	private static String get(int num) {
		StringBuilder res = new StringBuilder();
		if (num < 10) return map[num];
		
		int r;
		if (num >= 10000) {
			String prefix = get(num/10000);
			if (prefix.endsWith("零")) prefix = prefix.substring(0, prefix.length() - 1);
			res.append(prefix).append("万");
			r = num % 10000;
			if (r < 1000) res.append("零");
		} else if (num >= 1000) {
			res.append(map[(num/1000)]).append("仟");
			r = num % 1000;
			if (r < 100) res.append("零");
		} else if (num >= 100) {
			res.append(map[(num/100)]).append("佰");
			r = num % 100;
			if (r < 10) res.append("零");
		} else {
			res.append(map[(num/10)]).append("拾");
			r = num % 10;
		}
		return res.append(get(r)).toString();
	}
	
	public static void main(String args[]) {
		String[] array = new HashSet<String>().toArray(new String[1]);
		String line = "20076677373";
		String res = solution(line);
		System.out.println(res);
	}
}
