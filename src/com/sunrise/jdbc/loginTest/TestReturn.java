package com.sunrise.jdbc.loginTest;

public class TestReturn {
    public static void main(String[] args) {
        TestReturn tr = new TestReturn();
        Boolean judge = tr.judge(3, 2);
        System.out.println(judge);

    }

    public Boolean judge(int a, int b) {
        if (a == 0 || b == 0) {
            System.out.println("有数字为0");
            return false;
        }
        try {
            if (a > b) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("异常部分捕捉成功！");
        }
        //代表其他情况，如果有0返回if部分，如果a>b返回false，其他情况返回true
        return true;
    }
}
