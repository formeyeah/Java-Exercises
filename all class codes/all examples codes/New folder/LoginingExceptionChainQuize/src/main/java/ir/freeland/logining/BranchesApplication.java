package ir.freeland.logining;

import ir.freeland.logining.service.exception.BrachBuildException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.LogManager;
import ir.freeland.logining.service.BranchBuilder;
import ir.freeland.logining.service.FileBranchBuilder;

public class BranchesApplication {

	public static void main(String[] args) throws BrachBuildException, SecurityException, FileNotFoundException, IOException {
		LogManager.getLogManager().readConfiguration(new FileInputStream("logging.properties"));
		BranchBuilder branchBuilder = new FileBranchBuilder();
		branchBuilder.build();
	}

}
