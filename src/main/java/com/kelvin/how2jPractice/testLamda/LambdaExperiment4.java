package com.kelvin.how2jPractice.testLamda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.kelvin.how2jPractice.Hero;

public class LambdaExperiment4 {
	public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("��ʼ����ļ��ϣ�");
        System.out.println(heros);
        System.out.println("ʹ��������ķ�ʽ��ɸѡ�� hp>100 && damange<50��Ӣ��");
        
        // �����������д��
        HeroChecker c1 = new HeroChecker() {
            @Override
            public boolean test(Hero h) {
                return (h.hp > 100 && h.damage < 50);
            }
        };
        
        // ��new HeroChcekcer������������������������Ϣȥ��
        // ֻ�������������ͷ�����
        // �����ͷ�����֮����Ϸ��� ->
        HeroChecker c2 = (Hero h) -> {
            return h.hp > 100 && h.damage < 50;
        };
 
        // ��return��{}ȥ��
        HeroChecker c3 = (Hero h) -> h.hp > 100 && h.damage < 50;
 
        // �� �������ͺ�Բ����ȥ��
        HeroChecker c4 = h -> h.hp > 100 && h.damage < 50;
 
        // ��c4��Ϊ�������ݽ�ȥ
        filter(heros, c4);
         
        // ֱ�Ӱѱ��ʽ���ݽ�ȥ
        filter(heros, h -> h.hp > 100 && h.damage < 50);
    }
 
    private static void filter(List<Hero> heros, HeroChecker checker) {
        for (Hero hero : heros) {
            if (checker.test(hero))
                System.out.print(hero);
        }
    }
 
}
