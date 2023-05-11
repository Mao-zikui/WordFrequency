import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @ClassName WordFrequency
 * @Author Maozikui
 * @Date 2023/5/11 10:17
 * @Version 1.0
 */
public class WordFrequency {
    public static void main(String[] args) {
        try {
            // 按照路径读取文件
            BufferedReader br = new BufferedReader(new FileReader("E:\\test.txt"));
            String s;
            StringBuffer sb = new StringBuffer();
            // 将读取到的文件字符放到StringBuffer中
            while (br.readLine() != null) {
                s = br.readLine();
                sb.append(s);
            }
            Map<String,Integer> map = new HashMap<String, Integer>();
            // 使用StringTokenizer构造方法 根据多种字符进行分割
            StringTokenizer st = new StringTokenizer(sb.toString(),",.!; \n");
            while (st.hasMoreTokens()) {
                // 将到下一个分隔符的字符串取出
                String letter = st.nextToken();
                int count;
                // 当某个单词未出现时 记下单词并加一 出现过则获取该单词对应的key 并将对应次数加一
                if (map.get(letter) == null) {
                    count = 1;
                } else {
                    count = map.get(letter).intValue() + 1;
                }
                map.put(letter,count);
            }
            // 将map中的元素放到treeset集合中进行排序
            Set<WordEntity> set = new TreeSet<WordEntity>();
            for (String key : map.keySet()) {
                // 按照单词和出现次数创建单词对象 并将对象存储在set集合中 通过比较器进行排序
                set.add(new WordEntity(key,map.get(key)));
            }
            // 将整体结果输出
            for (Iterator<WordEntity> it = set.iterator(); it.hasNext(); ) {
                WordEntity w = it.next();
                System.out.println(w.getKey() + " " + w.getCount() + " ,");
            }
            // 输出前三名
            int count = 1;
            // 将set集合中排好序的数据输出前三名
            for (Iterator<WordEntity> it = set.iterator(); it.hasNext(); ) {
                WordEntity w = it.next();
                System.out.println("第" + count + "名为单词:" + w.getKey() + " 出现的次数为： "
                        + w.getCount());
                if (count == 3)// 当输出3个后跳出循环
                    break;
                count++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("文件未找到~！");
        } catch (IOException e) {
            System.out.println("文件读异常~！");
        }
    }

}