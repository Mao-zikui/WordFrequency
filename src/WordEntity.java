/**
 * @ClassName World
 * @Author Maozikui
 * @Date 2023/5/11 10:48
 * @Version 1.0
 */
// 实现比较器接口
public class WordEntity implements Comparable<WordEntity> {
    // 单词
    private String key;
    // 单词出现的次数
    private Integer count;
    public WordEntity (String key, Integer count) {
        this.key = key;
        this.count = count;
    }
    @Override
    public int compareTo(WordEntity o) {
        // 按照次数从高到低排序
        int cmp = count.intValue() - o.count.intValue();
        // 当次数一样时，按照a-z排序
        return (cmp == 0 ? key.compareTo(o.key) : -cmp);
    }

    @Override
    public String toString() {
        return key + " " + count + ", ";
    }

    public String getKey() {
        return key;
    }

    public Integer getCount() {
        return count;
    }
}
