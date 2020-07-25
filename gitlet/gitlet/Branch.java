
public class Branch {
    private SLList branch;
    public String name;
    boolean master;



    public Branch() {
        //add to dictionary of branches
        master = true;
        this.name = "master";
        branch = new SLList();
        branches_dict.put(name, branch);

    }

    public Branch(String name) {
        //add to dictionary of branches
        master = false;
        this.name = name;
        branch = new SLList(); //need to implement pointing back to commit where new branch requested
        branches_dict.put(name, branch);

    }


    public void add(Object o)


}