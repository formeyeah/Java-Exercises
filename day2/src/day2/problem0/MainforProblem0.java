package day2.problem0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainforProblem0 {

	public static void main(String[] args) {
		//yek object account -> balance, name, branch
		//6 ta account new konid 
		//1-account haro dar yek list berizid 
		//2-account haro chap konid 
		//3-account haro sort bknid -> bar asas balance , harki balance bishtr dasht 
		//4- account sort -> reverse bar asas e balance 
		//5- ye Map tarif konid -> key -> branch number -> value : list ei az account ha 
		//msln 4 ta to branch 1 hastan , 2 ta to branch 2 
		//6- halqe for ei bnvisid ke Map ro chap kone, list ham bayad chap kone 
		//7-remove konid branch number haye 2 ro 
		
		Account account1= new Account(10, "rojina", "Tehran");
		Account account2= new Account(50, "Melika", "Toronto");
		Account account3= new Account(30, "reza", "Tehran");
		Account account4= new Account(40, "Sara", "Tehran");
		Account account5= new Account(20, "ramina", "Tehran");
		Account account6= new Account(30, "ali", "Toronto");
		Account account7= new Account(60, "alireza", "Tehran");
		Account account8= new Account(60, "ahmad", "Tehran");
		
		//this list was immutable so I needed to create an arrayList
		List<Account> accounts=List.of(account1,account2,account3,account4,account5,account6);
		//defining a mutable list or array?
		List<Account> mutableAccounts=new ArrayList<>(accounts);

		//printing account 
		for (Account account : accounts) {
			System.out.println(account);
		}
		
		//defining two diffrent lists bases on branch
		
		List<Account> accountBranchTehran=new ArrayList<>();
		List<Account> accountBranchToronto=new ArrayList<>();
		
		//setting branchNumber for each branch 
		
		for (Account account : accounts) {
			if (account.getBranch().equals("Tehran")) {
				account.setBranchNumber(1);
				accountBranchTehran.add(account);
				
			}
			else if (account.getBranch().equals("Toronto")) {
				account.setBranchNumber(2);
				accountBranchToronto.add(account);
				
			}

			
			
		}
		
		//duta list ke har kodom account haye har branch ro dare 
		//for (Account account : accounts) {
			//if (account.getBranch().equals(mutableAccounts)) {
				
		//	}
			
		//}
		
		
		
		//sort by balance 
		
		Collections.sort(mutableAccounts);
		System.out.println("accounts sorted by balance: ");
		for (Account account : mutableAccounts) {
			System.out.println(account);
		}
		
		//sort by balance reversed 
		Collections.sort(mutableAccounts,Collections.reverseOrder());
		System.out.println("accounts sorted by balance but reversed");
		for (Account account : mutableAccounts) {
			System.out.println(account);
		}
		
		//creating map -> key branch Number, value list of accounts of each branch
		Map<Integer, List<Account>> accountMap=new HashMap<>();
		accountMap.put(1, accountBranchTehran);
		accountMap.put(2, accountBranchToronto);
	
		//chap map 
		for (Map.Entry<Integer, List<Account>> entry : accountMap.entrySet()) {
			Integer key = entry.getKey();
			List<Account> val = entry.getValue();
			System.out.println("branch number: " + key + "accounts of this branch : "+ val);
			
		}
		
		for (Iterator iterator = mutableAccounts.iterator(); iterator.hasNext();) {
			Account account = (Account) iterator.next();
			if (account.getBranchNumber()==2) {
				iterator.remove();
				
			}

			

		}
		//printing after deleting branch number 2 accounts
		System.out.println(mutableAccounts);

		
		//account hayi ke ba harf A bozorg name eshon shoro mishe -> list bargardonid
		
		List<Account> listAccountNamesStartA= mutableAccounts.stream()
				.filter(t-> t.getName().toLowerCase().startsWith("r"))
				.collect(Collectors.toList());
		System.out.println("accounts starting with A : "+ listAccountNamesStartA);
		//chera ba A nmishe?
		
	
		
		//be esm account harchi hast -> uppercase konid name haro name haro uppercase konid -> list bargardonid
		
		List<Account> UppercasedAccount=mutableAccounts.stream()
				.map(account-> {account.setName(account.getName().toUpperCase());
						
						return account;
						
						
				})
				.collect(Collectors.toList());
		System.out.println("uppercased names: " + UppercasedAccount);
		
		//account hayi ke balance > 10 && name.startswithA -> be onvane ye list bargardon
		List<Account> tenAndA=mutableAccounts.stream()
				.filter(t-> t.getBalance() > 10 &&  t.getName().toLowerCase().startsWith("r"))
				.collect(Collectors.toList());
		
		

			System.out.println("Accounts with balance > 10 and name starting with 'A': " + tenAndA);

		
	}

}
