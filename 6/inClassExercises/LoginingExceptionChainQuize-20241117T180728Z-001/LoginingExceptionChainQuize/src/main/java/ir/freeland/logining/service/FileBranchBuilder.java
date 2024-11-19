package ir.freeland.logining.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Spliterator;
import java.util.logging.Logger;




import ir.freeland.logining.model.Branch;
import ir.freeland.logining.service.exception.BrachBuildException;

public class FileBranchBuilder implements BranchBuilder {
	private static final Logger logger = Logger.getLogger(FileBranchBuilder.class.getName());
	@Override
	public Set<Branch> build() throws BrachBuildException {
		Set<Branch> branches = new HashSet<>();//@TODO: how initial it?
		
		List<String> branhes = readFile("branches.txt");
		
		//@TODO: fill the branches set
		branhes.forEach(branch -> {
		
		String [] bakhshHa= branch.split(";");
		Branch abranch= new Branch(bakhshHa[0], bakhshHa[1], bakhshHa[2], bakhshHa[3]);
		branches.add(abranch);
		
		}
				
				
				
				);
		branches.forEach(System.out::println);
		System.out.printf("Total size of branches is %d branch(s)", branches.size());
		//@TODO: well format out put of branches
		return branches;
		
		
	}
     
    private static List<String> readFile(String filePath) throws BrachBuildException {
    	List<String> fileLines = new ArrayList<>();
        // Using try-with-resources to automatically close the resources
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read the file line by line
            while ((line = reader.readLine()) != null) {
            	//@TODO: all fileLines
            	
            	fileLines.add(line);
            }        
        } catch (Exception e) { //see the chain
        	//@TODO: all manage exception
        	logger.severe("can not find file");
        	throw new BrachBuildException("hehe", e);
        }
        return fileLines;
    }
}