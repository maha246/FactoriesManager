public class CEO extends Manager {
     private Double extra_budget;

    public CEO(String name, int age, String email, Job job, Double salary) {
        this(name, age, email, job, salary, 0.0, 0.0 );
    }


    public CEO(String name, int age, String email, Job job, Double salary, Double starting_bonus, Double strating_extra_budget){
        super(name, age, email, job, salary, starting_bonus, true);
        this.extra_budget=strating_extra_budget;
    }

    //----------------ExtraBudget Functions Start --------------------
    public Double getExtra_budget() {
        return extra_budget;
    }

    public void setExtra_budget(Double extra_budget) {
        this.extra_budget = extra_budget;
    }

    public void increaseExtra_budget(Double amount) {
        this.extra_budget += amount;
    }
    //----------------ExtraBudget Functions end --------------------

    //----------OTHER FUNCTIONS--------------
    @Override
    public double avgSalary(){
        return (super.sumYearIncome()+extra_budget)/12;
    }

}
