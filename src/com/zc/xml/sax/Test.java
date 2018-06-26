package com.zc.xml.sax;

public class Test {
	public static void main(String[] args) {
		ReflectWriteXml<Emp> test = new ReflectWriteXml<Emp>();
		test.writeEvery(new Emp(),new ReadEmp().read());
	}
}
