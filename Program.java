

public class Program {
    static double k=1000;
    public static void main(String[] args) {
        FactoriesManager FM = new FactoriesManager();
        CEO ceo1 = new CEO("Fred", 40, "fred@gmail.com", Job.MARKETING_EXPERT,50*k);
        CEO ceo2 = new CEO("George", 40, "fred@gmail.com", Job.MARKETING_EXPERT,50*k,2.5*k, 5*k);
        CEO ceo3 = new CEO("Maha", 40, "fred@gmail.com", Job.MARKETING_EXPERT,50*k);
        CEO ceo4 = new CEO("Rami", 40, "fred@gmail.com", Job.MARKETING_EXPERT,50*k);



        Factory f1 = new Factory("123415", "f1", ceo1);
        FM.addFactory(f1);

        Factory f2 = new Factory("834436", "f2", ceo2);
        FM.addFactory(f2);

        Factory f3 = new Factory("845436", "f3", ceo3);
        FM.addFactory(f3);

        Factory f4 = new Factory("872896", "f4", ceo4);
        FM.addFactory(f4);

        Factory f5_with_same_name = new Factory("872896", "Osem3", ceo4);
        FM.addFactory(f5_with_same_name); //should get an error message!

        assert (FM.getFactoriesNum() == 4);
        Manager m1 = new Manager("Nuha1", 38, "nuha@gmail.com",Job.MARKETING_EXPERT, 50*k);
        Manager m2 = new Manager("Nuha2", 38, "nuha@gmail.com",Job.MARKETING_EXPERT, 50*k);
        Manager m3 = new Manager("Nuha3", 38, "nuha@gmail.com",Job.MARKETING_EXPERT, 50*k);
        Manager m4 = new Manager("Nuha4", 38, "nuha@gmail.com",Job.MARKETING_EXPERT, 50*k);
        Manager m5 = new Manager("Nuha5", 38, "nuha@gmail.com",Job.MARKETING_EXPERT, 50*k);


        Department d1 = new Department("HR_1", m1, Specialty.HR);
        FM.addDepartmentToFactory(d1, f1.getName());
        Department d2 = new Department("HR_1", m2, Specialty.HR);
        FM.addDepartmentToFactory(d2, f2.getName());

        Department d3 = new Department("HR_1", m3, Specialty.HR);
        FM.addDepartmentToFactory(d3, f3.getName());

        Department d4 = new Department("HR_1", m4, Specialty.HR);
        FM.addDepartmentToFactory(d4, f4.getName());

        Department d5 = new Department("HR_1", m5, Specialty.HR);
        FM.addDepartmentToFactory(d5, f4.getName());

        Department d6_with_same_name = new Department("HR_1", m5, Specialty.HR);
        FM.addDepartmentToFactory(d6_with_same_name, f4.getName()); //should get an error message!


        Worker w1 = new Worker("Maha1", 24, "maha@gmail.com", Job.PRODUCT_ENGINEER, 18*k);
        Worker w2 = new Worker("Maha2", 24, "maha@gmail.com", Job.PRODUCT_ENGINEER, 18*k);
        Worker w3 = new Worker("Maha3", 24, "maha@gmail.com", Job.PRODUCT_ENGINEER, 18*k);
        Worker w4 = new Worker("Maha4", 24, "maha@gmail.com", Job.PRODUCT_ENGINEER, 15*k);
        Worker w5 = new Worker("Maha5", 24, "maha@gmail.com", Job.PRODUCT_ENGINEER, 18*k);
        Worker w6 = new Worker("Maha6", 24, "maha@gmail.com", Job.MARKETING_EXPERT, 20*k);
        Worker w7 = new Worker("Maha7", 24, "maha@gmail.com", Job.PRODUCT_ENGINEER, 18*k);
        Worker w8 = new Worker("Maha8", 24, "maha@gmail.com", Job.PRODUCT_ENGINEER, 18*k);
        Worker w9 = new Worker("Maha9", 24, "maha@gmail.com", Job.PRODUCT_MANAGER, 12*k);
        Worker w10 = new Worker("Maha10", 24, "maha@gmail.com", Job.PRODUCT_ENGINEER, 18*k);

        //f1 - d1
        FM.addWorkerToDepartInFactory(w1, d1.getName(), f1.getName());
        FM.addWorkerToDepartInFactory(w2, d1.getName(), f1.getName());
        FM.addWorkerToDepartInFactory(w3, d1.getName(), f1.getName());
        //f2 - d2
        FM.addWorkerToDepartInFactory(w4, d2.getName(), f2.getName());
        FM.addWorkerToDepartInFactory(w5, d2.getName(), f2.getName());
        //f3 - d3
        FM.addWorkerToDepartInFactory(w6, d3.getName(), f3.getName());
        FM.addWorkerToDepartInFactory(w7, d3.getName(), f3.getName());
        FM.addWorkerToDepartInFactory(w8, d3.getName(), f3.getName());
        //f4 - d4, d5
        FM.addWorkerToDepartInFactory(w9, d4.getName(), f4.getName());
        FM.addWorkerToDepartInFactory(w10, d5.getName(), f4.getName());

        //printing
        System.out.println("DISPLAY FACTORIES:");
        FM.displayFactories();
        System.out.println("DISPLAY FACTORIES AVGs:");
        FM.displayFactoriesAvgSalaries();
        System.out.println("DISPLAY FACTORY 4 workers log");
        FM.displayFactoryWorkersLog(f4.getName());


        Worker updated_w9 = FM.getWorker(w9.getName(), d4.getName(), f4.getName());
        if(updated_w9 != null){
            updated_w9.setSalary(0.0);
        }
        Worker updated_w10 = FM.getWorker(w10.getName(), d5.getName(), f4.getName());
        if(updated_w10!=null){
            updated_w10.setSalary(0.0);

        }

        //print again to check avg after updating workers w4 & w5 salaries
        System.out.println("DISPLAY FACTORIES:");
        FM.displayFactories();
        System.out.println("DISPLAY FACTORIES AVGs:");
        FM.displayFactoriesAvgSalaries();
        System.out.println("DISPLAY FACTORY 4 workers log");
        FM.displayFactoryWorkersLog(f4.getName());

    }


}
