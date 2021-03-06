package me.sandlz.chatuidemo.manager;

import android.graphics.Color;
import android.os.Handler;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.sandlz.chatuidemo.entity.ChatMutiItems;
import me.sandlz.chatuidemo.entity.SearchMsgEntity;

/**
 * Created by liuzhu on 2016/11/22.
 * Description :
 * Usage :
 */
public class DataManager {

    private List times = new ArrayList();

    private List<String> names = new ArrayList<>();
    private DataCallBackListener listener;

    public DataManager() {
        initChatTimelist();
        initNamesData();
    }

    public List<ChatMutiItems> getMutiItems() {
        Random random = new Random();

        List<ChatMutiItems> data = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            ChatMutiItems items = null;
            if (i % 2 == 0) {
                // 我发的文字
                items = new ChatMutiItems(1, 1);
                items.setUserHeadUrl("http://7xsap2.com1.z0.glb.clouddn.com/favicon200.png");
                items.setUserName("zliu");
                items.setContent("我是第" + i + "条内容");
            } else if (i % 3 == 0) {
                // 别人发的文字
                items = new ChatMutiItems(2, 1);
                items.setUserHeadUrl("http://up.qqjia.com/z/25/tu32703_10.png");
                items.setUserName("ywang");
                items.setContent("我是第" + i + "条内容");
            } else if (i % 5 == 0) {
                // 我发的图片
                items = new ChatMutiItems(3, 1);
                int pos = random.nextInt(10);
                String url = getRandomImageUrl(pos);
                items.setImageUrl(url);
                items.setUserHeadUrl("http://7xsap2.com1.z0.glb.clouddn.com/favicon200.png");
                items.setUserName("zliu");
            } else {
                // 别人发的图片
                items = new ChatMutiItems(4, 1);
                int pos = random.nextInt(10);
                String url = getRandomImageUrl(pos);
                items.setImageUrl(url);
                items.setUserHeadUrl("http://up.qqjia.com/z/25/tu32703_10.png");
                items.setUserName("ywang");
            }
            data.add(items);
        }
        return data;
    }

    private void initChatTimelist() {
        long sTime = Long.parseLong("1479669923387");// 2016-11-21 03:25:23
        for (int i = 0; i < 50; i++) {
            long tempTime = sTime + 1000 * 60 * 15;
            times.add(tempTime);
        }
    }

    private String getRandomImageUrl(int pos) {
        List<String> dataList = new ArrayList<>();
        dataList.add("http://img1.niutuku.com/design/1207/2312/ntk-2312-38pogdiczbqu1.jpg");
        dataList.add("http://img3.duitang.com/uploads/item/201507/30/20150730163111_YZT5S.thumb.700_0.jpeg");
        dataList.add("http://sc.jb51.net/uploads/allimg/150703/14-150F3164339355.jpg");
        dataList.add("http://t1.niutuku.com/960/10/10-202370.jpg");
        dataList.add("http://h.hiphotos.baidu.com/zhidao/pic/item/6d81800a19d8bc3ed69473cb848ba61ea8d34516.jpg");
        dataList.add("http://img1.niutuku.com/design/1207/2312/ntk-2312-38pogdiczbqu1.jpg");
        dataList.add("http://a.hiphotos.baidu.com/zhidao/pic/item/f9dcd100baa1cd11aa2ca018bf12c8fcc3ce2d74.jpg");
        dataList.add("http://h.hiphotos.baidu.com/zhidao/pic/item/0eb30f2442a7d9334f268ca9a84bd11372f00159.jpg");
        dataList.add("http://t-1.tuzhan.com/3e1771aeb810/c-2/l/2013/07/10/01/403e940d4d20464282ba291fad64a49c.jpg");
        dataList.add("http://img.wadongxi.net/shop/15/46/2502566dcf9f146.jpg");

        return dataList.get(pos);
    }

    // 模拟搜索
    public List<SearchMsgEntity> getSearchReuslt(String key) {
        List<SearchMsgEntity> results = new ArrayList<>();
        List<SearchMsgEntity> source = getFakeData();

        for (SearchMsgEntity s : source) {
            if (s.getName().contains(key)) {
                s.setNameStyle(getStyle(Color.BLUE, s.getName(), key));
                results.add(s);
            }
            if (s.getContent().contains(key)) {
                s.setContentStyle(getStyle(Color.BLUE, s.getContent(), key));
                results.add(s);
            }
        }
        return results;
    }

    public List<SearchMsgEntity> getFakeData() {
        List<SearchMsgEntity> results = new ArrayList<>();
        SearchMsgEntity entity = new SearchMsgEntity(getRandomImageUrl(0), "第一小组", "群成员:xxx,uuu,yyy");
        SearchMsgEntity entity2 = new SearchMsgEntity(getRandomImageUrl(1), "第二小组", "群成员:ooo,qqq,yyy");
        SearchMsgEntity entity3 = new SearchMsgEntity(getRandomImageUrl(2), "zliu", "第一组已到达");
        SearchMsgEntity entity4 = new SearchMsgEntity(getRandomImageUrl(3), "ywang", "3条搜索激励");
        SearchMsgEntity entity5 = new SearchMsgEntity(getRandomImageUrl(4), "jjz", "2条搜索记录");
        SearchMsgEntity entity6 = new SearchMsgEntity(getRandomImageUrl(5), "gcheng", "2条搜索记录");
        SearchMsgEntity entity7 = new SearchMsgEntity(getRandomImageUrl(6), "yzhan", "2条搜索记录");
        SearchMsgEntity entity8 = new SearchMsgEntity(getRandomImageUrl(7), "test", "2条搜索记录");
        SearchMsgEntity entity9 = new SearchMsgEntity(getRandomImageUrl(8), "test01", "2条搜索记录");
        SearchMsgEntity entity10 = new SearchMsgEntity(getRandomImageUrl(9), "test02", "2条搜索记录");
        SearchMsgEntity entity11 = new SearchMsgEntity(getRandomImageUrl(1), "test03", "2条搜索记录");
        SearchMsgEntity entity12 = new SearchMsgEntity(getRandomImageUrl(2), "test04", "2条搜索记录");
        results.add(entity);
        results.add(entity2);
        results.add(entity3);
        results.add(entity4);
        results.add(entity5);
        results.add(entity6);
        results.add(entity7);
        results.add(entity8);
        results.add(entity9);
        results.add(entity10);
        results.add(entity11);
        results.add(entity12);
        return results;
    }

    public List<SearchMsgEntity> getFakeData(int size) {
        return getFakeData().subList(0, size - 1);
    }

    private void initNamesData() {
        for (int i = 0; i < 34; i++) {
            String temp = "";
            if (i < 9) {
                temp += "0" + (i+1);
            } else {
                temp += "" + (i+1);
            }
            names.add("位置-" + temp);
        }
    }

    public void getNamesByPage(int page) {
        List<String> data = new ArrayList<>();
        if (page == 1) {
            data = names.subList(0, 10);
        } else if (page == 2) {
            data = names.subList(10, 20);
        } else if (page == 3) {
            data = names.subList(20, 30);
        } else if (page == 4) {
            data = names.subList(30, 33);
        }
        if (null != listener) {
            final List<String> finalData = data;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    listener.callBackDataList(finalData);
                }
            }, 1000);


        }
    }

    private SpannableStringBuilder getStyle(int color, String content, String key) {
        SpannableStringBuilder style = new SpannableStringBuilder(content);
        int fstart = content.indexOf(key);
        int fend = fstart + key.length();
        style.setSpan(new ForegroundColorSpan(color), fstart, fend, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        return style;
    }

    public void setListener(DataCallBackListener listener) {
        this.listener = listener;
    }
}
