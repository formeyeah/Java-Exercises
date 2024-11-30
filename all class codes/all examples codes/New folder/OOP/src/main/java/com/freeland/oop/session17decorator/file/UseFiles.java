package com.freeland.oop.session17decorator.file;

public class UseFiles {

	public static void main(String[] args) {
		String salaryRecords1 = "Alireza Fattahi 200,000USD at ISC";

		DataSource encoded1 = 
				new CompressionDecorator(
						new EncryptionDecorator(
								new FileDataSource("OutputDemo.txt")
								)
						);

		encoded1.writeData(salaryRecords1);
		DataSource plain1 = new FileDataSource("OutputDemo.txt");
		System.out.println("- CompressionDecorator -> EncryptionDecorator -> FileDataSource ");
		System.out.println("- Input ----------------");
		System.out.println(salaryRecords1);
		System.out.println("- Encoded --------------");
		System.out.println(plain1.readData());
		System.out.println("- Decoded --------------");
		System.out.println(encoded1.readData());
		
		DataSource encoded2 = 
				new EncryptionDecorator(
						new CompressionDecorator(
								new FileDataSource("OutputDemo2.txt")
								)
						);
		String salaryRecords2 = "Alireza Fattahi 200,000USD at ISC";
		encoded2.writeData(salaryRecords2);
		DataSource plain2 = new FileDataSource("OutputDemo2.txt");
		System.out.println("\n- EncryptionDecorator -> CompressionDecorator -> FileDataSource ");
		System.out.println("- Input ----------------");
		System.out.println(salaryRecords2);
		System.out.println("- Encoded --------------");
		System.out.println(plain2.readData());
		System.out.println("- Decoded --------------");
		System.out.println(encoded2.readData());

	}

}
