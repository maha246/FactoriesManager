import java.util.HashMap;

public class Factory {
    private String registration_number;
    private String name;
    private CEO ceo;
    private HashMap<String, Department> departments;

    public Factory(String reg_num, String name, CEO ceo){
        this.registration_number = reg_num;
        this.name = name;
        this.ceo = ceo;
        this.departments = new HashMap<>();

    }


    //---------------------------------------
    //--------- get and set -----------------
    //---------------------------------------
    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public CEO getCeo() {
        return ceo;
    }

    public void setCeo(CEO ceo) {
        this.ceo = ceo;
    }

    private HashMap<String, Department> getDepartments(){
        return departments;
    }

    public void setDepartments(HashMap<String, Department> departments){
        this.departments = departments;
    }

    public String getRegistration_number() {
        return registration_number;
    }


    //---------------------------------------
    //----------OTHER FUNCTIONS--------------
    //---------------------------------------

    public void addDepartment(Department d) throws NameAlreadyExists {
        if(departments.containsKey(d.getName())){
            throw new NameAlreadyExists();
        }
        departments.put(d.getName(), d);
    }

    public void removeDepartment(String department_name) throws DepartmentDoesNotExist {
        if(!departments.containsKey(department_name)){
            throw new DepartmentDoesNotExist();
        }
        departments.remove(department_name);
    }

    public void addWorkerToDepartment(Worker w, String department_name) throws DepartmentDoesNotExist, NameAlreadyExists {
        Department toAddTo = departments.get(department_name);
        if(toAddTo==null){
            throw new DepartmentDoesNotExist();
        }
        toAddTo.addWorker(w);
    }

    public void removeWorkerFromDepartment(String worker_name, String department_name) throws DepartmentDoesNotExist, WorkerDoesNotExist {
        Department toRemoveFrom = departments.get(department_name);
        if(toRemoveFrom==null){
            throw new DepartmentDoesNotExist();
        }
        toRemoveFrom.removeWorker(worker_name);
    }

    public Worker getWorker(String worker_name, String department_name) throws DepartmentDoesNotExist, WorkerDoesNotExist {
        Department department = departments.get(department_name);
        if(department==null){
            throw new DepartmentDoesNotExist();
        }
        return department.getWorker(worker_name);
    }

    public Department getDepartment(String department_name) throws DepartmentDoesNotExist{
        Department department = departments.get(department_name);
        if(department==null){
            throw new DepartmentDoesNotExist();
        }
        return department;
    }


    public int getWorkersNumber(){
        int sum=0;
        for (HashMap.Entry<String, Department> d : this.getDepartments().entrySet()) {
            sum = sum + d.getValue().getWorkersNum();
        }

        return sum+1;
    }

    public String toString(){
        return "Factory: "+this.name + ", "
                + "regNum: "+this.registration_number + ", "
                +"CEO: "+this.ceo.getName() + ", "
                +this.getWorkersNumber() + " workers";
    }


    public void display() throws DepartmentDoesNotExist{
        System.out.println(this.name+ " Factory workers log:");
        System.out.println("CEO: " + ceo.toString());
        System.out.println();

        for (HashMap.Entry<String, Department> set : this.departments.entrySet()) {
            set.getValue().display();
            System.out.println();

        }
    }

    public double avgSalary(){
        double sum = 0;
        sum+= ceo.avgSalary();
        for (HashMap.Entry<String, Department> set : this.departments.entrySet()){
            sum+=set.getValue().getAvgSalary();
        }
        return sum/getWorkersNumber();
    }


}
