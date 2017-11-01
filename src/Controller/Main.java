/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import View.*;
import Model.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author M.Hakim Amransyah
 */
public class Main {
    
    double evidence_interesting;
    double evidence_boring;
    Good good = new Good();
    Fair fair = new Fair();
    Bad bad = new Bad();
    
    
    public static void main(String[] args) {
       Home gui;
       gui = new Home();
       gui.setVisible(true);
    }
    
    public void setData(ArrayList data_good,ArrayList data_fair,ArrayList data_bad){

       System.out.println("Good Class \n"+data_good.toString());
       this.setModelDataLabelGood((Double.parseDouble(data_good.get(0).toString())),Double.parseDouble(data_good.get(1).toString()),
               Double.parseDouble(data_good.get(2).toString()),Double.parseDouble(data_good.get(3).toString()),
               Double.parseDouble(data_good.get(4).toString()));
      
       System.out.println("Fair Class \n"+data_fair.toString());
       this.setModelDataLabelFair((Double.parseDouble(data_fair.get(0).toString())),Double.parseDouble(data_fair.get(1).toString()),
               Double.parseDouble(data_fair.get(2).toString()),Double.parseDouble(data_fair.get(3).toString()),
               Double.parseDouble(data_fair.get(4).toString()));
   
       
       System.out.println("Fair Class \n"+data_bad.toString());
       this.setModelDataLabelBad((Double.parseDouble(data_bad.get(0).toString())),Double.parseDouble(data_bad.get(1).toString()),
               Double.parseDouble(data_bad.get(2).toString()),Double.parseDouble(data_bad.get(3).toString()),
               Double.parseDouble(data_bad.get(4).toString()));

       this.setEvidence();
       this.showResult();
    }
    
    private void showResult(){
        Result result = new Result();
        result = this.interestingResult(result);
        result = this.boringResult(result);
        result.setVisible(true);
        
        
       
    }
    
    private Result interestingResult(Result result){ 
        double taking,droping;
        
        result.setPosteriorInteresting(this.good.getPosterior_probability_intresting(evidence_interesting),this.fair.getPosterior_probability_intresting(evidence_interesting),
                this.bad.getPosterior_probability_intresting(evidence_interesting));
       
        taking = (good.getLoss_function_taking()*good.getPosterior_probability_intresting(evidence_interesting)+
                (fair.getLoss_function_taking()*fair.getPosterior_probability_intresting(evidence_interesting))+
                (bad.getLoss_function_taking()*bad.getPosterior_probability_intresting(evidence_interesting)));
       
        droping = (good.getLoss_function_dropping()*good.getPosterior_probability_intresting(evidence_interesting)+
                (fair.getLoss_function_dropping()*fair.getPosterior_probability_intresting(evidence_interesting))+
                (bad.getLoss_function_dropping()*bad.getPosterior_probability_intresting(evidence_interesting)));
        
        result.setRiskInteresting(taking, droping);
        return result;
    }
    
    private Result boringResult(Result result){
        double taking,droping;
        
        result.setPosteriorBoring(this.good.getPosterior_probability_boring(evidence_boring),this.fair.getPosterior_probability_boring(evidence_boring), 
                this.bad.getPosterior_probability_boring(evidence_boring));
        
        taking = (good.getLoss_function_taking()*good.getPosterior_probability_boring(evidence_boring)+
                (fair.getLoss_function_taking()*fair.getPosterior_probability_boring(evidence_boring))+
                (bad.getLoss_function_taking()*bad.getPosterior_probability_boring(evidence_boring)));
        
        droping = (good.getLoss_function_dropping()*good.getPosterior_probability_boring(evidence_boring)+
                (fair.getLoss_function_dropping()*fair.getPosterior_probability_boring(evidence_boring))+
                (bad.getLoss_function_dropping()*bad.getPosterior_probability_boring(evidence_boring)));
        result.setRiskBoring(taking, droping);
        return result;
    }
    
    public void setTableData(DefaultTableModel table,ArrayList taking,ArrayList droping){
        
        this.good = new Good();
        this.fair = new Fair();
        this.bad = new Bad();
        
        Table data_table = new Table(table);
        System.out.println("prior probability good: "+data_table.getPriorProbability("Good"));
        System.out.println("prior probability bad : "+data_table.getPriorProbability("Fair"));
        System.out.println("prior probability fair: "+data_table.getPriorProbability("Bad"));
        
        System.out.println("P(Boring|Good) : "+data_table.getLikeliHood("Boring","Good"));
        
        this.setModelDataLabelGood(data_table.getPriorProbability("Good"),data_table.getLikeliHood("Interesting","Good"),
                data_table.getLikeliHood("Boring","Good"),Double.parseDouble(taking.get(0).toString()),
                Double.parseDouble(droping.get(0).toString()));
        
        this.setModelDataLabelFair(data_table.getPriorProbability("Fair"),data_table.getLikeliHood("Interesting","Fair"),
                data_table.getLikeliHood("Boring","Fair"),Double.parseDouble(taking.get(1).toString()),
                Double.parseDouble(droping.get(1).toString()));
        
        this.setModelDataLabelBad(data_table.getPriorProbability("Bad"),data_table.getLikeliHood("Interesting","Bad"),
                data_table.getLikeliHood("Boring","Bad"),Double.parseDouble(taking.get(2).toString()),
                Double.parseDouble(droping.get(2).toString()));
        this.setEvidence();
        this.showResult();
    }
    
    private void setEvidence(){
        this.evidence_interesting = (good.getLikelihood_intresting()*good.getPrior_probability())+
               (fair.getLikelihood_intresting()*fair.getPrior_probability()+
               bad.getLikelihood_intresting()*bad.getPrior_probability());
       
       this.evidence_boring = (good.getLikelihood_broing()*good.getPrior_probability())+
               (fair.getLikelihood_broing()*fair.getPrior_probability()+
               (bad.getLikelihood_broing()*bad.getPrior_probability()));
       
       System.out.println("evidence interesting : "+this.evidence_interesting+" evidence boring: "+this.evidence_boring);
    }
    
    
    private void setModelDataLabelGood(double prior_p,double likelihood_intresting,double likelihood_boring,
            double loss_function_taking,double loss_function_droping){
        this.good.setPrior_probability(prior_p);
        this.good.setLikelihood_intresting(likelihood_intresting);
        this.good.setLikelihood_broing(likelihood_boring);
        this.good.setLoss_function_taking(loss_function_taking);
        this.good.setLoss_function_dropping(loss_function_droping);
    }
    
    private void setModelDataLabelFair(double prior_p,double likelihood_intresting,double likelihood_boring,
            double loss_function_taking,double loss_function_droping){
        this.fair.setPrior_probability(prior_p);
        this.fair.setLikelihood_intresting(likelihood_intresting);
        this.fair.setLikelihood_broing(likelihood_boring);
        this.fair.setLoss_function_taking(loss_function_taking);
        this.fair.setLoss_function_dropping(loss_function_droping);
    }
    
    private void setModelDataLabelBad(double prior_p,double likelihood_intresting,double likelihood_boring,
            double loss_function_taking,double loss_function_droping){
        this.bad.setPrior_probability(prior_p);
        this.bad.setLikelihood_intresting(likelihood_intresting);
        this.bad.setLikelihood_broing(likelihood_boring);
        this.bad.setLoss_function_taking(loss_function_taking);
        this.bad.setLoss_function_dropping(loss_function_droping);
    }
    
    
    
    

    
    
}
