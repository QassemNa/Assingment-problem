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
public class Taxi {
    private String Tid;
    private int Tx;
    private int Ty;
    private char TLang;
    private boolean Nbusy=true;//not busy
    
    Taxi(){}
    
    Taxi(String id, int x, int y, char l){
        this.Tid=id;
        this.Tx=x;
        this.Ty=y;
        this.TLang=l;
    }
    
    public void setCord(int x, int y){
        this.Tx=x;
        this.Ty=y;
    }
    public void setLang(char l){
        this.TLang=l;
    }
    public void setNbusy(boolean b){
        Nbusy=b;
    }
    public int getX(){
        return Tx;
    }
    public int getY(){
        return Ty;
    }
    public char getL(){
        return TLang;
    }
    public String getID(){
        return Tid;
    }
    public boolean getNbusy(){
        return Nbusy;
    }
}
