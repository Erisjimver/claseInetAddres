package Controlador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class ObtenerClase0 {
 
	public final static String CLASS_A = "A";
	public final static String CLASS_B = "B";
	public final static String CLASS_C = "C";
        public static String Clase,dirIP;

        public static String getClase()
        {
            return Clase;
        }

        public static String getDirIP() 
        {
            return dirIP;
        }


        private Map<String, List<IPV4>> ips;
 
	public ObtenerClase0 () {
 
		ips = new HashMap<String, List<IPV4>>();
 
		ips.put(CLASS_A, new ArrayList<IPV4>());
		ips.put(CLASS_B, new ArrayList<IPV4>());
		ips.put(CLASS_C, new ArrayList<IPV4>());
 
	}
        
        public void sortIps() 
        {
 
		Collections.sort(ips.get(CLASS_A));
		Collections.sort(ips.get(CLASS_B));
		Collections.sort(ips.get(CLASS_C));
 
	}
 
	public void addIPV4(IPV4 ip) {
 
		short first = ip.getFirst();
 
		if(0 <= first && first <= 127) {
			ips.get(CLASS_A).add(ip);
		}else if(128 <= first && first <= 191) {
			ips.get(CLASS_B).add(ip);
		}else if(192 <= first && first <= 255) {
			ips.get(CLASS_C).add(ip);
		}
 
	}
       
        
        public void conocerIP(IPV4 ip) {
 
		short first = ip.getFirst();
                
		if(0 <= first && first <= 127) 
                {
                    Clase="Clase A";
                    ips.get(CLASS_A).add(ip);
                    //dirIP=""+ips.get(CLASS_A);
                    printIps(ips.get(CLASS_A));
		}
                else if(128 <= first && first <= 191) 
                {
                    Clase="Clase B";
                    ips.get(CLASS_B).add(ip);
                    //dirIP=""+ips.get(CLASS_B);
                    printIps(ips.get(CLASS_A));
		}
                else if(192 <= first && first <= 255) 
                {
                    Clase="Clase C";
                    ips.get(CLASS_C).add(ip);
                    //dirIP=""+ips.get(CLASS_C);
                    printIps(ips.get(CLASS_C));
		}
                    
	}
 	public void printIps(List<IPV4> list) {
                
		for(IPV4 ip :list) 
                { 
                        dirIP =""+ip; 
                      //  System.out.println(""+ip);
		}
	} 
}

 
class IPV4 implements Comparable<IPV4> {
 
	private short first;
	private short second;
	private short third;
	private short four;
 
	private final static String IPV4_SEPARATOR = ".";
 
	public IPV4(String foo) {
 
		if(null==foo) {
 
			throw new IllegalArgumentException("foo is required!");
 
		}
 
		this.setup(foo);
 
	}
 
	private void setup(String foo) {
 
		StringTokenizer tokens = new StringTokenizer(foo, IPV4_SEPARATOR);
 
		this.first = Short.parseShort(tokens.nextToken());
		this.second = Short.parseShort(tokens.nextToken());
		this.third = Short.parseShort(tokens.nextToken());
		this.four = Short.parseShort(tokens.nextToken());
 
	}
 
	@Override
	public String toString() {
 
		StringBuilder sb =  new StringBuilder();
 
		sb.append(this.first).append(IPV4_SEPARATOR);
		sb.append(this.second).append(IPV4_SEPARATOR);
		sb.append(this.third).append(IPV4_SEPARATOR);
		sb.append(this.four);
 
		return sb.toString();
 
	}
 
	@Override
	public int compareTo(IPV4 o) {
 
 
		return  this.first == o.first ? 0 :  this.first > o.first ? 1 : this.first < o.first ? -1 : Integer.MIN_VALUE;
 
	}
 
	public short getFirst() {
		return first;
	}
 
	public void setFirst(short first) {
		this.first = first;
	}
 
	public short getSecond() {
		return second;
	}
 
	public void setSecond(short second) {
		this.second = second;
	}
 
	public short getThird() {
		return third;
	}
 
	public void setThird(short third) {
		this.third = third;
	}
 
	public short getFour() {
		return four;
	}
 
	public void setFour(short four) {
		this.four = four;
	}
 
}