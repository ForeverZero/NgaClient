package org.zhd.ngaclient.common;

import java.util.HashMap;
import java.util.Map;

public class NgaUrl {
    private NgaUrl() {

    }

    public static final String BASE = "https://ngabbs.com/";

    public static class Api {
        public static final String APP_API = "app_api.php";
        public static final String NUKE = "nuke.php";
    }

    public static class Key {
        public static final String LIBRARY = "__lib";
        public static final String ACTION = "__act";
        public static final String VERSION = "_v";
        public static final String OUTPUT = "__output";

    }

    public static class Library {
        public static final String LOGIN = "login";
        public static final String USER = "user";
        public static final String APP_INNER = "app_inner";
        public static final String NGA_INDEX = "nga_index";
        public static final String NOTIFY = "notify";
        public static final String LOAD_TOPIC = "load_topic";
        public static final String UCP = "ucp";
        public static final String HOME = "home";
        public static final String FORUM_FAVOR_2 = "forum_favor2";
        public static final String SUBJECT = "subject";
        public static final String POST = "post";
    }

    public static class Action {
        public static final String IF_LOGIN = "iflogin";
        public static final String DETAIL = "detail";
        public static final String BANNER_LIST = "banner_list";
        public static final String GET_EVENT_APP = "get_event_app";
        public static final String LIST = "list";
        public static final String LOAD_TOPIC_REPLY_LADDER = "load_topic_reply_ladder";
        public static final String RECOMMEND_TOPIC = "recmd_topic";
        public static final String GET_BLOCK_WORD = "get_block_word";
        public static final String CATEGORY = "category";
        public static final String GET = "get";
        public static final String SEARCH = "search";
    }

    public static NgaUrlBuilder builder() {
        return new NgaUrlBuilder();
    }

    public static class NgaUrlBuilder {
        private String api;
        private Map<String, String> urlParamMap = new HashMap<>();

        public NgaUrlBuilder api(String api) {
            this.api = api;
            return this;
        }

        public NgaUrlBuilder library(String library) {
            urlParamMap.put(Key.LIBRARY, library);
            return this;
        }

        public NgaUrlBuilder action(String action) {
            urlParamMap.put(Key.ACTION, action);
            return this;
        }

        public NgaUrlBuilder version(String version) {
            urlParamMap.put(Key.VERSION, version);
            return this;
        }

        public NgaUrlBuilder output(String output) {
            urlParamMap.put(Key.OUTPUT, output);
            return this;
        }

        public String build() {
            StringBuilder sb = new StringBuilder(BASE + api + "?");
            if (urlParamMap.isEmpty()) {
                return sb.toString();
            }

            for (Map.Entry<String, String> entry : urlParamMap.entrySet()) {
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            return sb.substring(0, sb.length() - 1);
        }
    }
}
