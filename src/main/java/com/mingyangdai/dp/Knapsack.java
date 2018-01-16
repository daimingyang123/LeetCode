package com.mingyangdai.dp;

/**
 * @author mingyang.dai
 * @since 2018/1/13
 */
public class Knapsack {
	//minimum of cost
	
//	f[0]=0;g[0]=true;
//for (int i=0;i<N;i++)
//			for (int j=0;j<W;j++)
//			if (g[j]) {
//		g[j+w[i]]=true;
//		if (f[j+w[i]]==0||f[j+w[i]]>f[j]+c[i])
//			f[j+w[i]]=f[j]+c[i];
//	}
//
//if (g[W]) return f[W];
//else return 0;//impossible
	
	
	public static int knapsack(int[] weights, int target) {
		int[] num = new int[target+1];//num of stones when reach i
		num[0] = 0;
		boolean[] reach = new boolean[target+1];
		reach[0] = true;
		
		for (int weight : weights) {
			for (int i = 0; i < target; i++) {
				if (reach[i]) {
					int total = i+weight;
					if (total > target) continue;
					reach[total] = true;
					if (num[total] == 0 || num[total] > num[i] + 1) {
						num[total] = num[i] + 1;
					}
				}
			}
		}
		
		if (reach[target]) return num[target];
		return 0;
	}
	
	public static void main(String[] args) {
		int[] weights = {1,1,1,4,5};
		int target = 8;
		int res = knapsack(weights, target);
		System.out.println(res);
	}

}
