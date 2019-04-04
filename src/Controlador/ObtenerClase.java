package Controlador;


public class ObtenerClase {
    
    private String ipp,cla;

    public String getIpp() {
        return ipp;
    }

    public void setIpp(String ipp) {
        this.ipp = ipp;
    }

    public String getCla() {
        return cla;
    }

    public void setCla(String cla) {
        this.cla = cla;
    }

 
 
    ObtenerClase0 iPV4Clasification = new ObtenerClase0();

          
    
    public void Generar(){
        
            try{
                
                iPV4Clasification.conocerIP(new IPV4(this.ipp)); 
                cla=iPV4Clasification.getClase();

            }catch(Exception e){
                
            }
        }
}
