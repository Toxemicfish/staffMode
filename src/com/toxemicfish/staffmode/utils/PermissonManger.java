package com.toxemicfish.staffmode.utils;

public enum PermissonManger {
    TEST;

    private PermissonManger() {}

    public static String getPermission(PermissonManger type)
    {
        String perm = "";
        if(type == TEST) {
            perm = "test.test";
        }
        return perm;
    }
}
