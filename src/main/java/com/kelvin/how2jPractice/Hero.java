package com.kelvin.how2jPractice;

public class Hero implements Comparable<Hero> {
	public String name; //����
    
    public float hp; //Ѫ��
     
    float armor; //����
     
    int moveSpeed; //�ƶ��ٶ�
    
    public int damage;
    
    //��ʼ��name,hp,damage�Ĺ��췽��
    public Hero(String name,float hp, int damage) {
        this.name =name;
        this.hp = hp;
        this.damage = damage;
    }
    
    public Hero(){}
   
    @Override
    public int compareTo(Hero anotherHero) {
        if(damage<anotherHero.damage)
            return 1; 
        else
            return -1;
    }
   
    @Override
    public String toString() {
        return "Hero [name=" + name + ", hp=" + hp + ", damage=" + damage + "]\r\n";
    }
    
    public void attackHero(Hero h) {
        try {
            //Ϊ�˱�ʾ������Ҫʱ�䣬ÿ�ι�����ͣ1000����
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        h.hp-=damage;
        System.out.format("%s ���ڹ��� %s, %s��Ѫ����� %.0f%n",name,h.name,h.name,h.hp);
         
        if(h.isDead())
            System.out.println(h.name +"���ˣ�");
    }
 
    public boolean isDead() {
        return 0>=hp?true:false;
    }
    
//    public static void main(String[] args) {
//        Hero garen =  new Hero();
//        garen.name = "����";
//        garen.hp = 616.28f;
//        garen.armor = 27.536f;
//        garen.moveSpeed = 350;
//         
//        Hero teemo =  new Hero();
//        teemo.name = "��Ī";
//        teemo.hp = 383f;
//        teemo.armor = 14f;
//        teemo.moveSpeed = 330;
//    }  
}
