package pers.well.config;

import java.math.BigDecimal;

public class demo {
    public static void main(String[] args) {
        demo demo=new demo();
        demo demo1=new demo();
        demo demo2=new demo();
        demo demo3=new demo();
        //A只买了苹果和草莓
        demo.sum(1,2,0);
        //B买了苹果和草莓,和芒果
        demo1.sum(1,2,3);
        //C购买到了打折草莓，正常价格苹果和芒果
        demo2.discountsum(1,2,2,1.0,0.8,1.0,0);
        //A只买了苹果和草莓
        demo3.discountsum(1,2,5,1.0,0.8,1.0,10);
        System.out.println(demo.sum(1,2,0));
        System.out.println(demo1.sum(1,2,3));
        System.out.println(demo2.discountsum(5,2,2,1.0,0.8,1.0,null));
        System.out.println(demo3.discountsum(1,2,10,1.0,0.8,1.0,10));

    }
    public BigDecimal sum(Integer a,Integer s,Integer m){
        BigDecimal sum= BigDecimal.valueOf(0.00);
        BigDecimal apple=BigDecimal.valueOf(8);
        BigDecimal strawberriy=BigDecimal.valueOf(13);
        BigDecimal mango=BigDecimal.valueOf(20);
        BigDecimal apples=apple.multiply(BigDecimal.valueOf(a));
        BigDecimal strawberries=strawberriy.multiply(BigDecimal.valueOf(s));
        BigDecimal mangos=mango.multiply(BigDecimal.valueOf(m));
        sum=sum.add(apples).add(strawberries).add(mangos).setScale(2,BigDecimal.ROUND_UP);
        return sum;
    }
    public BigDecimal discountsum(Integer a,Integer s,Integer m,Double adiscount,Double sdiscount,Double mdiscount,Integer discuontmoney){
        BigDecimal sum= BigDecimal.valueOf(0.00);
        BigDecimal apple=BigDecimal.valueOf(8);
        BigDecimal strawberriy=BigDecimal.valueOf(13);
        BigDecimal mango=BigDecimal.valueOf(20);
        BigDecimal apples=apple.multiply(BigDecimal.valueOf(a)).multiply(BigDecimal.valueOf(adiscount));
        BigDecimal strawberries=strawberriy.multiply(BigDecimal.valueOf(s)).multiply(BigDecimal.valueOf(sdiscount));
        BigDecimal mangos=mango.multiply(BigDecimal.valueOf(m)).multiply(BigDecimal.valueOf(mdiscount));
        sum=sum.add(apples).add(strawberries).add(mangos).setScale(2,BigDecimal.ROUND_UP);
        if(discuontmoney!=null){
            if(sum.intValue()>100){
                int discount=sum.divide(new BigDecimal(100)).intValue();
                BigDecimal discountsum=BigDecimal.valueOf(discount).multiply(BigDecimal.valueOf(discuontmoney));
                sum=sum.subtract(discountsum).setScale(2,BigDecimal.ROUND_UP);
            }
        }
        return sum;
    }
}
