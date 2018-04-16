package com.mingyangdai.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mingyang.dai
 * @since 2018/4/10
 */
public class Keyboard {
    public class Param {
        public int n;
        public int cur;
        public int buffer;
    
        public Param(int n, int cur, int buffer) {
            this.n = n;
            this.cur = cur;
            this.buffer = buffer;
        }
    
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
        
            Param param = (Param) o;
        
            if (n != param.n) return false;
            if (cur != param.cur) return false;
            return buffer == param.buffer;
        }
    
        @Override
        public int hashCode() {
            int result = n;
            result = 31 * result + cur;
            result = 31 * result + buffer;
            return result;
        }
    }
    
    private int max = 0;
    private static Map<Param, Integer> map = new HashMap<>();
    
    private int print(Param param) {
        Integer count = map.get(param);
        if (count != null) return count;
        
        int n = param.n, cur = param.cur, buffer = param.buffer;
        if (n == 0) return cur;
        
        count = buffer > 1 ? print(new Param(n - 1, cur + buffer, buffer)) :
                print(new Param(n - 1, cur + 1, buffer));
        if (n >= 3) count = Math.max(cur, print(new Param(n - 3, cur + cur, cur)));
        max = Math.max(max, count);
        map.put(param, count);
        return count;
    }
    
    public int maxA(int N) {
        int[] best = new int[N+1];
        for (int k = 1; k <= N; ++k) {
            best[k] = best[k-1] + 1;
            for (int x = 0; x < k-1; ++x)
                best[k] = Math.max(best[k], best[x] * (k-x-1));
        }
        return best[N];
    }
    
    public static void main(String[] args) {
        int N = 3;
        int res = new Keyboard().maxA(N);
        System.out.println(res);
    }
}
