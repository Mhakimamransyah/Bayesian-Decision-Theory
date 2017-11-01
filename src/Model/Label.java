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
public abstract class Label {
    double Prior_probability;
    double Likelihood_intresting;
    double Likelihood_broing;
    double Loss_function_taking;
    double Loss_function_dropping;

    public double getPosterior_probability_intresting(double evidence_interesting) {
      return (this.Likelihood_intresting*this.Prior_probability)/evidence_interesting;
    }

    public double getPosterior_probability_boring(double evidence_boring) {
       return (this.Likelihood_broing*this.Prior_probability)/evidence_boring;
    }
 
//    --------------------------------------------------------------------------------------------

    public double getPrior_probability() {
        return Prior_probability;
    }

    public double getLikelihood_intresting() {
        return Likelihood_intresting;
    }

    public double getLikelihood_broing() {
        return Likelihood_broing;
    }

    public double getLoss_function_taking() {
        return Loss_function_taking;
    }

    public double getLoss_function_dropping() {
        return Loss_function_dropping;
    }

    public void setPrior_probability(double Prior_probability) {
        this.Prior_probability = Prior_probability;
    }

    public void setLikelihood_intresting(double Likelihood_intresting) {
        this.Likelihood_intresting = Likelihood_intresting;
    }

    public void setLikelihood_broing(double Likelihood_broing) {
        this.Likelihood_broing = Likelihood_broing;
    }

    public void setLoss_function_taking(double Loss_function_taking) {
        this.Loss_function_taking = Loss_function_taking;
    }

    public void setLoss_function_dropping(double Loss_function_dropping) {
        this.Loss_function_dropping = Loss_function_dropping;
    }
    

}
