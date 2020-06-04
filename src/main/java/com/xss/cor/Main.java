package com.xss.cor;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Main
 * @Description 设计模式-责任链模式
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/6/4 4:19 PM
 * @Return
 */
public class Main {
    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好:),<script>,欢迎访问mashibing.com,大家都是996");

        FilterChain fc = new FilterChain();
        fc.add(new FaceFilter()).
                add(new IllegalFilter());
        fc.doFilter(msg);

        FilterChain fc2 = new FilterChain();
        fc2.add(new URLFilter()).add(new NumFilter());
        fc.add(fc2);
        fc.doFilter(msg);
        System.out.println(msg);
    }
}
class Msg{
    String name;
    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
interface Filter{
    boolean doFilter(Msg m);
}
class FaceFilter implements Filter{

    @Override
    public boolean doFilter(Msg m){
        String msg = m.getMsg();
        msg = msg.replace(":)","^V^");
        m.setMsg(msg);
        return true;
    }
}

class IllegalFilter implements Filter{

    @Override
    public boolean doFilter(Msg m){
        String r = m.getMsg();
        r = r.replace('<', '[');
        r = r.replace('>',']');
        m.setMsg(r);
        return false;
    }
}
class URLFilter implements Filter{

    @Override
    public boolean doFilter(Msg m){
        String r = m.getMsg();
        r = r.replace("mashibing.com", "http://www.mashibing.com");
        m.setMsg(r);
        return true;
    }
}

class NumFilter implements Filter{

    @Override
    public boolean doFilter(Msg m){
        String r = m.getMsg();
        r = r.replace("996", "955");
        m.setMsg(r);
        return true;
    }
}

class FilterChain implements Filter{
    List<Filter> filters = new ArrayList<>();

    public FilterChain add(Filter f){
        filters.add(f);
        return this;
    }

    public boolean doFilter(Msg msg){
        for (Filter filter : filters) {
            if(!filter.doFilter(msg)) return false;
        }

        return true;
    }
}