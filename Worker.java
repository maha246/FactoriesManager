
public class Worker {
    private String name;
    private int age;
    private String email;
    private Job job;
    private double salary;


    public Worker(String name, int age, String email, Job job, double salary) {
        this.name=name;
        this.age = age;
        this.email = email;
        this.job = job;
        this.salary = salary;
    }

    //----------name functions start--------------
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //----------name functions end--------------


    //----------age functions start--------------
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    //----------age functions end--------------


    //----------email functions start--------------
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //----------email functions end--------------


    //----------job functions start--------------
    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
    //----------job functions end--------------


    //----------salary functions start--------------
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(double amount) {
        this.salary += salary;
    }
    //----------salary functions end--------------


    //----------OTHER FUNCTIONS--------------
    public double avgSalary(){
        return salary;
    }

    public String toString(){
        return this.name + ", salary: "+ this.salary;
    }


}
