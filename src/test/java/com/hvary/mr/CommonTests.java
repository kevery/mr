package com.hvary.mr;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class CommonTests {
    @Test
    public void name() {
        String tag = "近战位，费用回复，输出，高级资深干员，女性干员";

        int positionIndex = StringUtils.indexOf(tag, "位");
        int sexIndex = StringUtils.indexOf(tag, "性干员");
        String position = StringUtils.substring(tag, positionIndex - 2, positionIndex+1);
        String sex = StringUtils.substring(tag, sexIndex - 1, sexIndex);

        System.out.println(position + sex);
    }

    @Test
    public void name1() {
        String s = "远程位，支援，治疗，高级资深干员，女性干员";

        System.out.println(s.replace(" ","").replace("，",","));

    }
}
