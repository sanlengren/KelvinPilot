package com.kelvin.how2jPractice.threadExperiment.CuncurrentExperiment;

import com.kelvin.how2jPractice.Hero;

public class HeroRecoverThread extends Thread{
	private Hero h;
    
	public HeroRecoverThread(Hero h)
    {     
            this.h=h;
    }
    public void run()
    {
        while(true)
        {

        	
        		try {
					h.threadSafeRecover();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        
        }
        
        
        
//        recover(h);
    }
    
    public synchronized void recover(Hero h)
    {
          
        if(h.hp== 505)
        {
        	try
        	{
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else
        {
            this.notifyAll();
        }
        h.hp = h.hp+1;
        System.out.printf(Thread.currentThread() + "%s 回血1点,增加血后，%s的血量是%d%n",h.name,h.name,h.hp);
        try
        {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
          
    }
}
