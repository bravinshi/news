package com.bravin.shi.news.net;

/**
 * created by bravin on 2018/10/11.
 */
public class NetworkManager {

    private NetworkManager() {
    }

    private static class LazyHolder {
        private static final NetworkManager INSTANCE = new NetworkManager();
    }

    public static NetworkManager getInstance() {
        return LazyHolder.INSTANCE;
    }

    /**
     * 代理RetrofitAgent中的create
     */
    public static <T> T create(Class<T> service) {
        return RetrofitAgent.create(service);
    }
}
