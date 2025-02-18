import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;

public class Ackermann {
	public static int ack(int n){
		return ack(n,n);
	}
	
	public static int ack(int m, int n){
		if (m==0)
			return n+1;
		
		if (n==0)
			return ack(m-1,1);
		
		return ack(m-1,ack(m,n-1));		
	}
	
	public static void main(String[] args) {

	    // Afficher les arguments de la machine virtuelle
		RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
		List<String> arguments = runtimeMxBean.getInputArguments();
		System.out.println("VM Arguments: " + arguments);
		
		int m=3;
		int n=16;
		System.out.println("ack("+m+","+n+") = "+ack(m,n));					
	}
}
