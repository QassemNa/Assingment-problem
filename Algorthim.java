
package algorthim;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author ME
 */
public class Algorthim {
    
    public int caldis(Taxi taxi, passenger pass){
        double cX, cY, tmp;
        
        cX=Math.pow(taxi.getX()-pass.getX(), 2);//power 2 for x2-x1
        cY=Math.pow(taxi.getY()-pass.getY(), 2);//power 2 for y2-y1
        
        tmp= Math.sqrt(cX+cY);//root
        return (int)tmp;//to return tmp as an int
        
    }
    public ArrayList<distance> maketable(ArrayList p, ArrayList t, int n, int m){
       passenger pa;
       Taxi ta;
       ArrayList<distance> list = new ArrayList<>();
       
       for(int i=0; i<n; i++){
           pa=(passenger) p.get(i);
           
           for(int j=0; j<m; j++){
               ta=(Taxi) t.get(j);
               
               distance d= new distance(ta,pa);
               d.caldis();
               list.add(d);
           }//end of inner loop
       }//outer loop
       
        Collections.sort(list, (distance a1, distance a2) -> a1.getDis() - a2.getDis());
        //this will sort the arraylist according to distance   
        
           return list;
    }
    
    public void assign(ArrayList<distance> list){
        passenger pa;
        Taxi ta;
        distance da;
        for(int i=0; i<list.size(); i++){
            da=list.get(i);
            ta=da.getTaxi();
            pa=da.getPass();
            if(ta.getNbusy()&&pa.getTaxi()==null){//CHECKS IF THEY ARE FREE OR NOT
                pa.setTaxi(ta);
                ta.setNbusy(false);
            }
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Algorthim a = new Algorthim();
        ArrayList<passenger> apass = new ArrayList<>();
        ArrayList<passenger> fpass = new ArrayList<>();
        ArrayList<Taxi> ataxi = new ArrayList<>();
        ArrayList<Taxi> ftaxi = new ArrayList<>();
        ArrayList<distance> adis;
        ArrayList<distance> fdis;
        
        Scanner input = new Scanner(new File("location.txt"));
        
        String id;
        char lang;
        int x, y;
        int n = input.nextInt();
        int m = input.nextInt();
        for(int i=0; i<n; i++){
            id=input.next();
            x=input.nextInt();
            y=input.nextInt();
            lang=input.next().charAt(0);
            passenger p1 = new passenger(id, x, y, lang);
            if(lang=='A'){
                apass.add(p1);
            }
            else fpass.add(p1);
        }
        for(int i=0; i<m; i++){
            id=input.next();
            x=input.nextInt();
            y=input.nextInt();
            lang=input.next().charAt(0);
            Taxi t1= new Taxi(id, x, y, lang);
            if(lang=='A'){
                ataxi.add(t1);
            }
            else ftaxi.add(t1);
        }
     
        //make a table with all the drivers and passengers combined and sort it
        adis=a.maketable(apass, ataxi, apass.size(), ataxi.size());
        fdis=a.maketable(fpass, ftaxi, fpass.size(), ftaxi.size());
        //assign the drivers from top to bottom accroding to the sorted array
        a.assign(adis);
        a.assign(fdis);
        
        for (passenger pa : fpass) {
               System.out.println(pa.toString());
        }
        for (passenger pa : apass) {
               System.out.println(pa.toString());
        }
        
    }
}
