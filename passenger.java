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
public class passenger {
    private String Pid;
    private int Px;
    private int Py;
    private char PLang;
    private Taxi ta=null;
    
    passenger(){}
    
    passenger(String id, int x, int y, char l){
        this.Pid=id;
        this.Px=x;
        this.Py=y;
        this.PLang=l;
    }
    
    public void setCord(int x, int y){
        this.Px=x;
        this.Py=y;
    }
    public void setLang(char l){
        this.PLang=l;
    }
    public String toString(){
        String s;
        if(ta!=null){
        s="Passenger: "+this.Pid+"- Taxi "+this.ta.getID();
        }
        else{
        s="Passenger: "+this.Pid+" has no taxi";
        }
        return s;
    }
    public int getX(){
        return Px;
    }
    public int getY(){
        return Py;
    }
    public char getL(){
        return PLang;
    }
    public String getID(){
        return Pid;
    }
    public Taxi getTaxi(){
        return this.ta;
    }
    public void setTaxi(Taxi t){
        this.ta=t;
    }
}
