package com.kelvin.how2jPractice;

public class Hero implements Comparable<Hero> {
	public String name; //姓名
    
    public int hp; //血量
     
    float armor; //护甲
     
    int moveSpeed; //移动速度
    
    public int damage;
    
    //初始化name,hp,damage的构造方法
    public Hero(String name,int hp, int damage) {
        this.name =name;
        this.hp = hp;
        this.damage = damage;
    }
    
    public Hero(){}
   
    public Hero(String name,int hp)
    {
        this.name = name;
        this.hp=hp;
    }
    
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
    
    public synchronized int gethp(){
    	return this.hp;
    }
    public void attackHero(Hero h) {
        try {
            //为了表示攻击需要时间，每次攻击暂停1000毫秒
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        h.hp-=damage;
        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n",name,h.name,h.name,h.hp);
         
        if(h.isDead())
            System.out.println(h.name +"死了！");
    }
 
    public boolean isDead() {
        return 0>=hp?true:false;
    }
    
    public synchronized void recover(){
        hp=hp+1;
    }
    
    public synchronized void hurt(){
        hp=hp-1;
    }
    
    public synchronized void threadSafeRecover() throws InterruptedException {
    	

    		 if (hp <500){
    	        	hp = hp + 1;
    	            System.out.printf(Thread.currentThread() + "%s 回血1点,增加血后，%s的血量是%d%n", name, name, hp);
    		 }
    		 else{
    			 notifyAll();
    			 wait();
    		 }

    	
//        if (hp <500){
//        	hp = hp + 1;
//            System.out.printf(Thread.currentThread() + "%s 回血1点,增加血后，%s的血量是%d%n", name, name, hp);
//            notifyAll();
//        }else{
//        	wait();
//        }
        
        
//    	
        // 通知那些等待在this对象上的线程，可以醒过来了，如第20行，等待着的减血线程，苏醒过来
//        this.notify();
    }
 
    public synchronized void threadSafeHurt() throws InterruptedException {
    	

    		 if (hp > 1) {
    	            hp = hp - 1;
    	            System.out.printf(Thread.currentThread() + "%s 减血1点,减少血后，%s的血量是%d%n", name, name, hp);
    		 }
    		 else{
    			 notifyAll();
    			 wait();
    		 }

    	
//        if (hp > 1) {
//            hp = hp - 1;
//            System.out.printf(Thread.currentThread() + "%s 减血1点,减少血后，%s的血量是%d%n", name, name, hp);
//            notifyAll();
//        }else{
//        	wait();
//        }
        	
        
    }
//    public static void main(String[] args) {
//        Hero garen =  new Hero();
//        garen.name = "盖伦";
//        garen.hp = 616.28f;
//        garen.armor = 27.536f;
//        garen.moveSpeed = 350;
//         
//        Hero teemo =  new Hero();
//        teemo.name = "提莫";
//        teemo.hp = 383f;
//        teemo.armor = 14f;
//        teemo.moveSpeed = 330;
//    }  
}
