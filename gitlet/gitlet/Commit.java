package gitlet;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;


// this is the java file for Commit command
//Make sure that commit dictionary deletes the staging directories entries all of them:::: use STAGING_DIRECTORY.clear();
HashMap<String, Object> STAGING_DICTIONARY = new HashMap<String, Object>();

public class Commit {
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date;
    String dateMessage;
    String log;
    int id;
    Branch branch;
    boolean header;
    Commit parent;

    public Commit() { // making initial commit
        dateMessage = dateFormat.format(date);
        log = "initial commit";
        id = gitlet.Utils.sha1(log.getBytes());
        header = true;
        parent = null;
    }

    public Commit(String logMessage) { // general commit with a log message argument
        dateMessage = dateFormat.format(date);
        log = logMessage;
        id = gitlet.Utils.sha1(log.getBytes());
        snapshot();
        clearStagingArea();
        parent = currentCommit;
    }

    private void clearStagingArea() {

    }
    private void snapshot(

    ) { // save a snapshot of certain files

    }
    public static void add(String name){
        File file = new File(names); 
        File hashed_file = sha1(readContents(file));
        if(!STAGING_DICTIONARY.containskey(name)){
            STAGING_DICTIONARY.put(name,hashed_file);
        }
        else 
            STAGING_DICTIONARY.replace(name, hashed_file);
    }

    public static void log(){

        //wherever head is, system.out.println the info of the commit
        //so like commit.ref, commit.blah
        //then iterate throught the pointers til the end and null;
    }

    public static void glog(){
        //same as above except, it will print from all branches
        //it can for instance start at each branch and print out until they intersect, then one is printed then continuted until both are null
    }
    public static void remove(String name){
        File file = new File(names); 
        File hashed_file = sha1(readContents(file));
        if(STAGING_DICTIONARY.containsvalue(name)){
            STAGING_DICTIONARY.remove(name, hashed_file);
        }
        else
            STAGING_DICTIONARY.remove(name);
    }
}
