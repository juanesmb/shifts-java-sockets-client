package modelo;

import java.io.DataOutputStream;
import java.io.IOException;


public class Cliente extends Conexion
{
    public Cliente(String HOST) throws IOException{super("cliente",HOST);} //Se usa el constructor para cliente de Conexion

    public void enviarMensaje(String datos) 
    {
        try
        {
            //Flujo de datos hacia el servidor
            salidaServidor = new DataOutputStream(cs.getOutputStream());

            
            salidaServidor.writeUTF(datos);
            

            cs.close();//Fin de la conexión

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}