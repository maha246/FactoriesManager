public class Manager extends Worker{
    private Double bonus_sum;
    private boolean has_salary13;

    public Manager(String name, int age, String email, Job job, Double salary) {
        this(name, age, email, job, salary, 0.0, false);
    }
    public Manager(String name, int age, String email, Job job, Double salary, Double starting_bonus) {
        this(name, age, email, job, salary, starting_bonus, false);
    }

    public Manager(String name, int age, String email, Job job, Double salary, Double starting_bonus, boolean has_salary13) {
        super(name, age, email, job, salary);
        this.bonus_sum = starting_bonus;
        this.has_salary13 = has_salary13;
    }

    //----------bonus functions start--------------
    public Double getBonusSum() {
        return bonus_sum;
    }
    void grantBonus(Double amount){
        bonus_sum+=amount;
    }
    void setBonus(Double bonus){
        this.bonus_sum=bonus;
    }
    //----------bonus functions end--------------



    //----------salary13 functions start--------------
    public boolean HasSalary13(){
        return has_salary13;
    }

    public void grantSalary13() {
        this.has_salary13 = true;
    }

    //private to prevent CEO object from calling the method
    private void takeBackSalary13(){
        this.has_salary13 = false;
    }
    //----------salary13 functions end--------------



    // --------- OTHER functions -----------------

    protected double sumYearIncome(){
        double sum = 0.0;
        sum+=(12*this.getSalary());
        sum+=bonus_sum;
        if(HasSalary13()) sum+=this.getSalary();
        return sum;
    }

    @Override
    public double avgSalary() {
        return sumYearIncome()/12;
    }


}
