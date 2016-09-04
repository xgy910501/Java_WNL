package com.xue.WNL;

import java.util.Scanner;

/**
 * Created by Administrator
 * 2016/9/4.
 *
 * 1900.1.1 星期一
 *
 *
 * 星期日   星期一    ...星期六
 *
 *2016.9
 *
 * 1900.1.1-2016.9.1  共有多少天，可以计算2016.9.1是星期几   总天数%7  ，输出的空格数
 *
 *整年  1900.1.1 -2016.1.1  判断中间的每一年 有多少天  求和
 *整月  2016.1.1-2016.9.1   判断每个月份有多少天
 */
public class WanNianLi {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入年份：");
        int year= input.nextInt();
        System.out.println("请输入月份：");
        int month=input.nextInt();
        int zhengNian = 0;//年份总数
        int nianDate = 365;
        for(int nian = 1900;nian<year;nian++){
            if(nian%4==0 && nian%100!=0 || nian%400 ==0){
                nianDate=366;
            }else{
                nianDate=365;
            }
            zhengNian +=nianDate;
        }
        //System.out.println("年份共有："+zhengNian+"天");
        int zhengYue= 0;//月份总数
        int monthDate= 30;
        for(int yue = 1;yue<month;yue++){
            if(yue==4 || yue==6 || yue==9 || yue ==10){
                monthDate = 30;
            }else if(yue == 2){
                        if(year%4==0 && year%100!=0 || year%400==0){
                            monthDate=29;
                        }else{
                            monthDate=28;
                        }
            }else{
                monthDate=31;
            }
            zhengYue+=monthDate;
        }
        //System.out.println("月份共有："+zhengYue+"天");
        int allDate = zhengNian+zhengYue;
        int xingQi = allDate%7+1;
        if(xingQi==7){
            xingQi=0;
        }
        System.out.println("距1900年有："+allDate+"天");
        System.out.println("日\t一\t二\t三\t四\t五\t六");
        for(int kong=0;kong<xingQi;kong++){
            System.out.print("\t");
        }
        int date=0;//当前月天数
        switch (month){
            case 4:
            case 6:
            case 9:
            case 11:
                date=30;
                break;
            case 2:
                if(year%4==0&& year%100!=0 ||year%400==0){
                    date=29;
                }else{
                    date=28;
                }
                break;
            default:
                date=31;
                break;
        }
        for (int i=1;i<=date;i++){
            System.out.print(i+"\t");
            if((allDate+i-1)%7+1==6){//控制周六换行
                System.out.println();
            }
        }
    }
}
