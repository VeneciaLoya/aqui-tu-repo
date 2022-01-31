package Singlenton;

import conexiondb.conexion;

public class conexionSinglenton {

    private static conexionSinglenton conexionsinglenton;
    private conexion Conexion;

    private conexionSinglenton(String url, String user, String passWord){
        Conexion = new conexion(url, user, passWord);
    }
    public static conexionSinglenton getInstance(String url, String user, String passWord){
        if(conexionsinglenton == null){
            conexionsinglenton = new conexionSinglenton(url, user, passWord);
        }
            return conexionsinglenton;
    }
    public conexion getConexion(){
        return Conexion;
    }
}
