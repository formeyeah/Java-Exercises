package ir.freeland.logining.service;

import java.util.Set;

import ir.freeland.logining.model.Branch;
import ir.freeland.logining.service.exception.BrachBuildException;

public interface BranchBuilder {
	Set<Branch> build() throws BrachBuildException; //The order is not important
}
