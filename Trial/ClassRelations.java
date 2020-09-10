package Trial;
// code to try out relationships between classes
public class ClassRelations {
	public static void main(String args[]) {
		Test1 nt = new Test1();
		
		
	}

}
class Test1{
	private Test2 obj ;
	Test1(){obj = new Test2();
	//composition
	}
}
class Test2{
	private Test1 obj;	
	Test2(){}
}
class Test3{
	Test3(){}
}
