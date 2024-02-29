package filter;

import Game.Arena;
import Model.Object.Unit;


import java.util.ArrayList;
import java.util.List;
public abstract  class Filter {
    ArrayList<Unit> Object1=new ArrayList<>() ;
    int start_list ;
    int end_list ;
    Filter()
    {
        start_list=0 ;
        end_list =10000 ;
    }
    abstract public ArrayList isAccepted(Arena a, Unit unit) ;
    void print()
    {
        for (int i=start_list ;i<end_list ;i++)
        {
            System.out.print(Object1.get(i).getName()+" ");
        }
    }
    public int get_index()
    { return start_list ;}

    public void set_index(int start1)
    {  start_list=start1 ;}
}