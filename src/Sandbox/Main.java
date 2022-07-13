package Sandbox;

import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        HashMap<String, String> hm = new HashMap<>();
        hm.put("code", "some code");
        hm.put("123", "more code");
        System.out.println(hm.get("code"));
    }

}

