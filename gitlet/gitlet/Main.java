package gitlet;
import java.io.File;
import java.util.HashMap;
import Utils.java;

/* Driver class for Gitlet, the tiny stupid version-control system.
   @author
*/
public class Main {
    HashMap<String, Object> staging_dict = new HashMap<String, Object>();

    /* Usage: java gitlet.Main ARGS, where ARGS contains
       <COMMAND> <OPERAND> .... */

    public static void init() {

        File dir = new File(".gitlet");
        if (dir.exists()) {
            System.out.println("A gitlet version-control system already exists in the current directory.");
        } else {
            dir.mkdir();
            new Branch branch("master");
            new Commit();
            // TO DO : Put as first commit in branch MAIN
        }
    }

//read in the name then hash it, then reference it to a text file and read it into a key with the object as the refernce into a staging directory
    //streamline your method!
    //
    //  public static void add(String name){
        File file = new File(names); //more efficient design, see if there is an existing mapping, if there is check if equals if not
        File hashed_file = sha1(readContents(file));
        if(!(COMMIT_DICTIONARY.containskey(name)){
            COMMIT_DICTIONARY.put(name,hashed_file);
        }
        else 
            COMMIT_DICTIONARY.replace(name, hashed_file);
    }

 /*
 //public static void add(String name){
       File file = new File(names);
       File hashed_file = sha1(readContents(file));




       // Strings[counter] hshed_names = sha1(names);
       //hashed_string = sha1(names);
       //get.files(names);
       //assign 
       //
        File name = new File(names);
        sha1(names)
        List<String> hashed_names = sha1(names);
        List<String> files = plainFilenamesIn(".gitlet/StagingDirectory");
        List<String> hashed_sd_files = sha1(files);





        while(files != null || names != null){
            if(files == names){
                branches_dict.remove(names);
                branches_dict.put(names,hshed_names);
                if(branches_dict key -> the new hashed reference)
            }
        else if(files )
        else
            branches_dict.put(names, hshed_names);

        }




        List<Strings> staging_dir = 
        readContents(File file)
        branches_dict
        s_ref = sha1(s);
        //So we need a few things:1)hashing all the file names that were inputted and put them into a string;2)Read in all of the names of the staging directory;3)Hash those names as well;4)Check if there is any matches between the names of the staging directory vs the input files, if there is check if the references are the same, if the references are the same, do nothing, else access the key and change the value to the new refernce, else you create a key in the hash with the value of reference as the value;
        //two cases, one when it already exists in the staging area, other when it doesnt;
        //create a hashmap from name which is s to the hash with is hash_s
        //snapshot and blob, hash the contnts of the file, and the name is the key, so when you add with the same key, oyou set the object to be the new hash
        //
        //save 
        //is it already there
        
    }

*/
    public static void log(){
        //wherever head is, system.out.println the info of the commit
        //so like commit.ref, commit.blah
        //then iterate throught the pointers til the end and null;
    }

    public static void glog(){
        //same as above except, it will print from all branches
        //it can for instance start at each branch and print out until they intersect, then one is printed then continuted until both are null
    }
    public static void remove(){
        //access the staging directory, and if there is any match between that and the name of the input then remove the value from the key in the dictionary.
    }

    public static void main(String... args) {
        init();
       

/*
    private static void addhelper(){
        for(int i = 1; args[i] != null; i++){
            add.(args[i]);
        }
    }
 if(args[0] == "add"){
            for(int i = 0; args[i+1] != null; i++){
                files[i] = args[i + 1];
            }
        }
       */ 