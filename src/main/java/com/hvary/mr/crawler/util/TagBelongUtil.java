package com.hvary.mr.crawler.util;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * 判断tag所属类别
 */
public class TagBelongUtil {

    private static List zzList = Arrays.asList("新手", "资深干员", "高级资深干员");
    private static List postionList = Arrays.asList("远程位", "近战位");
    private static List sexList = Arrays.asList("男性干员", "女性干员");
    private static List kindList = Arrays.asList("先锋", "狙击", "医疗", "术师", "近卫", "重装", "辅助", "特种");
    private static List tagList = Arrays.asList
                     ("治疗",
                    "支援",
                    "输出",
                    "群攻",
                    "减速",
                    "生存",
                    "防护",
                    "削弱",
                    "位移",
                    "控场",
                    "爆发",
                    "召唤",
                    "快速复活",
                    "费用回复");

    public static boolean isBelongZzList(String tag) {
        return zzList.contains(tag);
    }

    public static boolean isBelongPostion(String tag) {
        return postionList.contains(tag);
    }

    public static boolean isBelongsexList(String tag) {
        return sexList.contains(tag);
    }

    public static boolean isBelongKindList(String tag) {
        return kindList.contains(tag);
    }

    public static boolean isBelongTagList(String tag) {
        return tagList.contains(tag);
    }


    public static boolean noConflictTag(Set<String> tags) {
        boolean zzExist = false;
        boolean postionExist = false;
        boolean sexExist = false;
        boolean kindExist = false;
        boolean tagExist = false;


        for (String tag : tags) {
            if (isBelongZzList(tag)) {
                if (!zzExist) {
                    zzExist = true;
                } else {
                    return false;
                }
            }

            if (isBelongPostion(tag)) {
                if (!postionExist) {
                    postionExist = true;
                } else {
                    return false;
                }
            }


            if (isBelongsexList(tag)) {
                if (!sexExist) {
                    sexExist = true;
                } else {
                    return false;
                }
            }


            if (isBelongKindList(tag)) {
                if (!kindExist) {
                    kindExist = true;
                } else {
                    return false;
                }
            }

            if (isBelongTagList(tag)) {
                if (!tagExist) {
                    tagExist = true;
                } else {
                    return false;
                }
            }

        }

        return true;
    }

}
