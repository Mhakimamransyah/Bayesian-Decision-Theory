/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author M.Hakim Amransyah
 */
public class Table {
    
    DefaultTableModel table;
        
    public Table(DefaultTableModel dm){
        this.table = new DefaultTableModel();
        this.table = dm;
    }

    
    public double getPriorProbability(String label){
        double prior_p = 0;
        double count = 0;
        for(int i=0;i<this.table.getRowCount();i++){
            if(this.table.getValueAt(i, 1).toString().equalsIgnoreCase(label)){
                count++;
            }
        }
        prior_p = count/table.getRowCount();
        return prior_p;
    }
    
    public double getLikeliHood(String atribute,String label){
        double count_correct_attribut= 0;
        double count_label = 0;
        
        for(int i=0;i<this.table.getRowCount();i++){
            if(table.getValueAt(i, 1).toString().equalsIgnoreCase(label)){
                count_label++;
            }
        }
        
        for(int i=0;i<this.table.getRowCount();i++){
           if(this.table.getValueAt(i, 0).toString().equalsIgnoreCase(atribute)){
               if(this.table.getValueAt(i, 1).toString().equalsIgnoreCase(label)){
                  count_correct_attribut++;    
               }
           }    
        }
        
        return count_correct_attribut/count_label;
    }
    
    

}
