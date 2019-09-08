package wang.sunnly.enable.chat.words.controller;

import com.alibaba.fastjson.JSON;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * WordsController
 *
 * @author Sunnly
 * @create 2019/8/18 0018 13:43
 */
@RestController
public class WordsController {

    private static String[] words =
            ("六用先乡七八九十上下左右" +
             "大多少土个入人儿文木禾无")
            .split("");
    private static String begin = "2019-8-20";
    private static int index = 0;

    @GetMapping("/words/list")
    public String getWords() throws IOException {
        String s = genWords();
        index = 0;
        return s;
    }

    public static void main(String[] args) throws IOException {

        System.out.println(genWords());
    }

    private static String genWords() throws IOException {
        DateFormat df = new SimpleDateFormat("");
        Date beginDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.set(
                Integer.parseInt(begin.split("-")[0]),
                Integer.parseInt(begin.split("-")[1])-1,
                Integer.parseInt(begin.split("-")[2]));


        List<Map<String, String>> words = genWords("data.txt");
        words.addAll(genWords("data1.txt"));

        List<Map<String, Object>> wordsList = new ArrayList<>();
        //拆分成6页 24个
        for (int i = 0; i < 6; i++) {
            int week = calendar.get(Calendar.DAY_OF_WEEK);
            String weekStr = "";
            switch (week) {
                case 1:
                    weekStr = "日";
                    break;
                case 2:
                    weekStr = "一";
                    break;
                case 3:
                    weekStr = "二";
                    break;
                case 4:
                    weekStr = "三";
                    break;
                case 5:
                    weekStr = "四";
                    break;
                case 6:
                    weekStr = "五";
                    break;
                case 7:
                    weekStr = "六";
                    break;
                default:
                    break;
            }
            Map<String, Object> wordsMap = new HashMap<>();
            wordsMap.put("date", String.format("%s年%s月%s日星期%s",
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH)+1 > 9 ? (calendar.get(Calendar.MONTH)+1): "0"+(calendar.get(Calendar.MONTH)+1),
                    calendar.get(Calendar.DATE) > 9 ? calendar.get(Calendar.DATE) : "0"+calendar.get(Calendar.DATE),
                    weekStr));
            wordsMap.put("list",words.subList(i * 4, i * 4 + 4));
            wordsList.add(wordsMap);
            calendar.add(Calendar.DATE, 1);
        }
        return JSON.toJSONString(wordsList);
    }

    private static List<Map<String, String>> genWords(String f) throws IOException {
        List<Map<String, String>> wordsList = new ArrayList<>();

        Document parse = Jsoup.parse(WordsController.getHtml(f), "UTF-8");

        Elements li = parse.getElementsByTag("li");
        for (Element element : li) {
            Elements pinyinElements = element.select(".pinyin-box .font");
            if (pinyinElements != null && pinyinElements.size() == 1) {
                Map<String, String> wordsMap = new HashMap<>();
                String pinyin = pinyinElements.get(0).text();
                wordsMap.put("s", words[index++]);
                wordsMap.put("py", pinyin);
//                System.out.println(pinyin);
                Elements chineseElements = element.select(".chinese-box svg path");
                if (chineseElements != null && chineseElements.size() == 1) {
                    String path = chineseElements.get(0).attr("d");
//                    System.out.println(path);
                    wordsMap.put("hz", path);
                    wordsList.add(wordsMap);
                }
            }
        }
        return wordsList;
    }

    private static File getHtml(String f) {
        return new File("F:\\work\\ideaspace\\sunnly-demo\\enable\\sunnly-websocket\\src\\main\\resources\\resources\\datas\\" + f);
    }
}
