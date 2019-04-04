package Controlador;

import java.net.*;
import java.util.ArrayList;


public class ipaddres {
    
String name,mascara,prefijo,clase, oc1,oc2,oc3,oc4;
int oct1,oct2,oct3,oct4;

     ObtenerClase ot = new ObtenerClase();

    //obtener nombre de host
    public String nombre(){
    try {
        InetAddress address=InetAddress.getLocalHost();
        name=address.getHostName();
    }
    
    catch(UnknownHostException e){
        name="imposible determinar el nombre del equipo";
    }
    return name;
    
    }

    //obtener direccion ip
    public String ip(){
    try {
        InetAddress address=InetAddress.getLocalHost();
        name=address.getHostAddress();
    }
    
    catch(UnknownHostException e){
        name="imposible determinar la IP del equipo";
    }
    return name;
    
    }

    //obtener mascara
    public void mascara() throws SocketException{
    try{
            InetAddress localHost = Inet4Address.getLocalHost();
            NetworkInterface networkInterface = NetworkInterface.getByInetAddress(localHost);
            prefijo = ""+networkInterface.getInterfaceAddresses().get(0).getNetworkPrefixLength();
            
            
                    int shft = 0xffffffff<<(32-networkInterface.getInterfaceAddresses().get(0).getNetworkPrefixLength());
                    oct1 = ((byte) ((shft&0xff000000)>>24)) & 0xff;
                    oct2 = ((byte) ((shft&0x00ff0000)>>16)) & 0xff;
                    oct3 = ((byte) ((shft&0x0000ff00)>>8)) & 0xff;
                    oct4 = ((byte) (shft&0x000000ff)) & 0xff;
                     mascara = oct1+"."+oct2+"."+oct3+"."+oct4;
                        
                    //convertir numeros binarios y enviar a metodos get
                    oc1=(obtenerBinario(oct1));
                    oc2=(obtenerBinario(oct2));
                    oc3=(obtenerBinario(oct3));
                    oc4=(obtenerBinario(oct4));
         
           ot.setIpp(localHost.getHostAddress());
           ot.Generar();
           clase=ot.getCla();
           System.out.println(""+clase);
           
    }catch(UnknownHostException e){
        System.out.println("Error: "+e);
    }
    }
    
   //convertir numeros en binario
    public String obtenerBinario(int numero){
            ArrayList<String> binario = new ArrayList<>();
            int resto;
            String binarioString = "";

            do{
                    resto = numero%2;
                    numero = numero/2;
                    binario.add(0, Integer.toString(resto));
            }while(numero > 2); //bucle hasta que el cociente no se pueda dividir mas

             binario.add(0, Integer.toString(numero)); //Cogeremos el ultimo cociente

            //Tomar cada uno de los elementos del ArrayList y los juntamos en un String
            for(int i = 0; i < binario.size(); i++){
                binarioString += binario.get(i);
            }
        return binarioString;
    }
    
    //metodos get para  que los datos puedan ser enviados independientemente hacia la interfaz grafica
    public String getOc1() {
        return oc1;
    }

    public String getOc2() {
        return oc2;
    }

    public String getOc3() {
        return oc3;
    }

    public String getOc4() {
        return oc4;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public String getMascara() {
        return mascara;
    }

    public String getClase() {
        return clase;
    }
    
    
    
    
    
}
    
    


