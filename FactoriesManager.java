import java.util.HashMap;

public class FactoriesManager {
    private HashMap<String, Factory> factories;

    public FactoriesManager() {
        factories = new HashMap<>();
    }

    public void addFactory(Factory f){
        if (factories.containsKey(f.getName())) {
            System.out.println("The name you provided for the factory already exists");
        }
        factories.put(f.getName(), f);
    }

    public void addDepartmentToFactory(Department d, String factory_name){
        Factory toAddTo = factories.get(factory_name);
        if (toAddTo == null) {
            System.out.println("The name you provided for the factory doesn't exists");
        }
        try {
            toAddTo.addDepartment(d);
        } catch (NameAlreadyExists e) {
            System.out.println("Department already exists");
        }
    }

    public void removeDepartmentFromFactory(String department_name, String factory_name) {
        Factory removeFrom = factories.get(factory_name);
        if (removeFrom == null) {
            System.out.println("factory doesn't exists");
        }
        try {
            removeFrom.removeDepartment(department_name);
        } catch (DepartmentDoesNotExist e) {
            System.out.println("department doesn't exists");
        }
    }

    public void addWorkerToDepartInFactory(Worker w, String department_name, String factory_name){
        Factory toAddTo = factories.get(factory_name);
        if (toAddTo == null) {
            System.out.println("factory doesn't exists");
        }
        try {
            toAddTo.addWorkerToDepartment(w, department_name);
        } catch (DepartmentDoesNotExist e) {
            System.out.println("department doesn't exists");
        } catch (NameAlreadyExists e) {
            System.out.println("worker with same name already exist in department");
            System.out.println("it is recommended to add a unique string to the worker name, like: father's name");
        }
    }

    public void removeWorkerFromDepartInFactory(String worker_name, String department_name, String factory_name){
        Factory removeFrom = factories.get(factory_name);
        if (removeFrom == null) {
            System.out.println("factory doesn't exists");
        }
        try {
            removeFrom.removeWorkerFromDepartment(worker_name, department_name);
        } catch (DepartmentDoesNotExist e) {
            System.out.println("department doesn't exists");
        } catch (WorkerDoesNotExist e) {
            System.out.println("worker doesn't exists");
        }
    }

    public Worker getWorker(String worker_name, String department_name, String factory_name){
        Factory factory = factories.get(factory_name);
        if (factory == null) {
            System.out.println("factory doesn't exists");
        }
        try {
            return factory.getWorker(worker_name, department_name);
        } catch (DepartmentDoesNotExist e) {
            System.out.println("department doesn't exists");
        } catch (WorkerDoesNotExist e) {
            System.out.println("worker doesn't exists");
        }
        return null;
    }

    public Department getDepartment(String department_name, String factory_name){
        Factory factory = factories.get(factory_name);
        if (factory == null) {
            System.out.println("factory doesn't exists");
        }
        try {
            return factory.getDepartment(department_name);
        } catch (DepartmentDoesNotExist e) {
            System.out.println("department doesn't exists");
        }
        return null;
    }

    public void displayFactories() {
        for (HashMap.Entry<String, Factory> set : this.factories.entrySet()) {
            System.out.println(set.getValue().toString());
        }
    }

    public void displayFactoryWorkersLog(String factory_name) {
        Factory factory = factories.get(factory_name);
        if (factory == null) {
            System.out.println("factory doesn't exists");
        }
        try {
            factory.display();
        } catch (DepartmentDoesNotExist e) {
            System.out.println("department doesn't exists error");
            System.out.println("THIS SHOULD NEVER HAPPEN!!");

        }
    }


    public void displayFactoriesAvgSalaries(){
        System.out.println("Factories average salaries:");
        for (HashMap.Entry<String, Factory> set : this.factories.entrySet()) {
            double factory_avgSalary = set.getValue().avgSalary();
            System.out.println(set.getValue()+", avgSalary: "+factory_avgSalary);
        }
    }

    public int getFactoriesNum(){
        return factories.size();
    }
}

