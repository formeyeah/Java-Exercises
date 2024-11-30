package ir.freeland.logining.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import ir.freeland.logining.model.Branch;
import ir.freeland.logining.service.exception.BrachBuildException;

public class FileBranchBuilder implements BranchBuilder {
	private static final Logger logger = Logger.getLogger(FileBranchBuilder.class.getName());
	@Override
	public Set<Branch> build() throws BrachBuildException {
		Set<Branch> branchesSet= new HashSet<>();
	
		List<String> branhes = readFile("branches.txt");
		branhes.forEach( branch -> {
						String[] prop = branch.split(";");
						Branch aBranch = new Branch( prop[0],prop[1], prop[2], prop[3] );
						branchesSet.add(aBranch);
				
			});
		System.out.printf("Total %d branch(s) found.%nObject(s) are ready:%n %s", 
				branchesSet.size(), branchesSet);
		return branchesSet;
	}

    private static List<String> readFile(String filePath) throws BrachBuildException {
    	List<String> fileLines = new ArrayList<>();
        // Using try-with-resources to automatically close the resources
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read the file line by line
            while ((line = reader.readLine()) != null) {
            	logger.info("line readed: " + line);
            	fileLines.add(line);
            }        
        } catch (Exception e) { //see the chain
        	logger.severe("Could not find file " + filePath);
        	throw new BrachBuildException("could not build",e);
        }
        return fileLines;
    }
}
