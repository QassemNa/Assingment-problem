/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorthim;

/**
 *
 * @author ME
 */
public class distance{
    private Taxi taxi;
    private passenger pass;
    private int dis;
    
    distance(Taxi t, passenger p){
        this.taxi=t;
        this.pass=p;
    }
    public void caldis(){
        double cX, cY, tmp;
        
        cX=Math.pow(taxi.getX()-pass.getX(), 2);//power 2 for x2-x1
        cY=Math.pow(taxi.getY()-pass.getY(), 2);//power 2 for y2-y1
        
        tmp= Math.sqrt(cX+cY);//root
        tmp= (int) tmp;
        this.dis=(int) tmp;           
                   
    }
    public String toString(){
        String s;
        s="Pasenger: "+this.pass.getID()+" Taxi: "+this.taxi.getID()+" distance: "+this.dis;
        return s;
    }
    public int getDis(){
        return this.dis;
    }
    
    public Taxi getTaxi(){
        return this.taxi;
    }
    
    public passenger getPass(){
        return this.pass;
    }
    
}
