package com.kelvin.how2jPractice.threadExperiment.CuncurrentExperiment;

import com.kelvin.how2jPractice.Hero;

public class HeroDamageThread extends Thread{
	private Hero h;
    public HeroDamageThread(Hero h)
    {
        this.h=h;
    }
    public void run()
    {
    	
//    	while(true)
//        {
//    		damage(h);
//        }
    	
    	
    	System.out.printf(Thread.currentThread() + ": Invoke");
        while(true)
        {

        		try {
					h.threadSafeHurt();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

        	}
            

    }
    public synchronized void damage(Hero h)
    {
          
        if(h.hp==1)
        {
            try
            {
            	System.out.printf(Thread.currentThread() + ": Prepare to wait");
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
        h.hp = h.hp-1;
        System.out.printf(Thread.currentThread() + "%s ��Ѫ1��,����Ѫ��%s��Ѫ����%d%n", h.name,h.name,h.hp);
        try
        {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
          
          
    }
}
