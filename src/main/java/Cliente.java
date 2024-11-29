/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Eduardo
 */
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;



public class Cliente extends Conexion
{
    public Cliente() throws IOException{super("cliente");} //Se usa el constructor para cliente de Conexion

    public void startClient() //Método para iniciar el cliente
    {
        try
        {
            //Flujo de datos hacia el servidor
            salidaServidor = new DataOutputStream(cs.getOutputStream());

            //Se enviarán dos mensajes
            for (int i = 0; i < 2; i++)
            {
                Scanner entrada = new Scanner(System.in);
                String texto = entrada.next();
                
                //Se escribe en el servidor usando su flujo de datos
                salidaServidor.writeUTF(texto);
            }

            cs.close();//Fin de la conexión

        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}