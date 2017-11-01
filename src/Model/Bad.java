/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author hp
 */
public class Bad extends Label{
    
   @Override
    public void setPrior_probability(double Prior_probability) {
        super.setPrior_probability(Prior_probability); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLikelihood_intresting(double Likelihood_intresting) {
        super.setLikelihood_intresting(Likelihood_intresting); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLikelihood_broing(double Likelihood_broing) {
        super.setLikelihood_broing(Likelihood_broing); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLoss_function_taking(double Loss_function_taking) {
        super.setLoss_function_taking(Loss_function_taking); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLoss_function_dropping(double Loss_function_dropping) {
        super.setLoss_function_dropping(Loss_function_dropping); //To change body of generated methods, choose Tools | Templates.
    }
 
    
}
