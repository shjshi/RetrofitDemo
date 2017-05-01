package com.apple.retrofitdemo.weatherAndMovie.entity;

/**
 * Created by shj on 2017/2/11.
 * response是接口json对象
 * Retrofit这个网络框架利用泛型来获取需要的数据
 * 名字还是不要Response，容易误会
 */
public class MovieResponse<T> {
    private T subjects;
    private int count;
    private int start;
    private int total;

    public void setSubjects(T subjects) {
        this.subjects = subjects;
    }

    public T getSubjects() {

        return subjects;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
