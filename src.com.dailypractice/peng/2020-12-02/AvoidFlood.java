import java.util.*;

public class AvoidFlood {

    public static void main(String[] args) {
        AvoidFlood af = new AvoidFlood();
        int[] rains = {0, 1, 1};
        int[] res = af.avoidFlood(rains);
        if (res == null) {
            System.out.println("");
            return;
        }
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public int[] avoidFlood(int[] rains) {
        int len = rains.length;

        //存储可以 rains[i] == 0 的索引位置（这里使用 TreeSet 是为了方便查找 适合 排空湖泊 的索引天数）
        TreeSet<Integer> set = new TreeSet<>();

        //记录某个湖泊最后一次下雨的日期
        Map<Integer, Integer> map = new HashMap<>();

        int[] res = new int[len];

        for(int i = 0; i < len; i++){
            if(rains[i] == 0){
                set.add(i);
            }else{
                //如果之前下过雨
                if(map.containsKey(rains[i])){
                    //获取上一次下雨的时间
                    int preIdx = map.get(rains[i]);
                    //获取比 preIdx 大并且离 preIdx 最近的日期来抽空湖泊
                    Integer zeroIdx = set.higher(preIdx);
                    if(zeroIdx == null){
                        return new int[0];
                    }
                    res[zeroIdx] = rains[i];
                    set.remove(zeroIdx);
                }
                map.put(rains[i], i);
                res[i] = -1;
            }
        }
        for(int i = 0; i < len; i++){
            if(res[i] == 0){
                res[i] = 1;
            }
        }
        return res;
    }

}
