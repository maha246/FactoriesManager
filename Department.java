import java.util.HashMap;

;
public class Department {
    private String name;
    private HashMap<String, Worker> workers;
    private Manager manager;
    private Specialty specialty;

    public Department(String name, Manager manager, Specialty specialty){
        this.name = name;
        this.manager = manager;
        this.specialty = specialty;
        workers = new HashMap<>();
    }
    //---------------------------------------
    //--------- get and set -----------------
    //---------------------------------------
    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public HashMap<String, Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(HashMap<String, Worker> workers) {
        this.workers = workers;
    }

    //---------------------------------------
    //----------OTHER FUNCTIONS--------------
    //---------------------------------------

    public void addWorker(Worker w) throws NameAlreadyExists {
        if(workers.containsKey(w.getName())){
            throw new NameAlreadyExists();
        }
        workers.put(w.getName(), w);
    }

    public void removeWorker(String worker_name) throws WorkerDoesNotExist{
        if(!workers.containsKey(worker_name)){
            throw new WorkerDoesNotExist();
        }
        workers.remove(worker_name);
    }

    public Worker getWorker(String worker_name) throws WorkerDoesNotExist{
        Worker w = workers.get(worker_name);
        if(w == null){
            throw new WorkerDoesNotExist();
        }
        return w;
    }

    public int getWorkersNum(){
        return workers.size()+1;
    }


    public void display(){
        System.out.println(this.name+ " Department:");
        System.out.println("Manager: " + manager.toString());
        for (HashMap.Entry<String, Worker> set : this.workers.entrySet()) {
            System.out.println(set.getValue().toString());
        }
    }

    public double getAvgSalary(){
        double sum = 0;
        sum+=manager.avgSalary();
        for (HashMap.Entry<String, Worker> set : this.workers.entrySet()) {
            sum+=set.getValue().avgSalary();
        }
        return sum/getWorkersNum();
    }


}
