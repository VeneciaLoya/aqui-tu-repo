import java.sql.ResultSet;
import java.sql.SQLException;

import Singlenton.conexionSinglenton;
import java.util.Scanner;
public class Main{
    public static void main(String args[]){
        try{
            conexionSinglenton ConexionSinglenton = conexionSinglenton.getInstance(
                "jdbc:mysql://localhost:3306/ine"
                , "root"
                , "123");
                Scanner entrada = new Scanner(System.in);

                //Scanner entrada;
                entrada = new Scanner(System.in);
                String nombre;
                int opc;
                int table;
                int fin;
                String tabl;
                ResultSet rs;
                int turno;
                String nam;
                do{    
                System.out.print("Que opción quieres:\n 1: Ver registros \n 2:Insertar registros \n 3:Editar registros \n 4: Eliminar registros ");

                opc = entrada.nextInt();

                        switch(opc){
                            case 1:
                                System.out.print("¿De que tabla?:\n 1: Personal \n 2: Turno \n ");
                                table = entrada.nextInt();
                                switch(table){
                                    case 1:
                                         rs = ConexionSinglenton.getConexion().query("select * from cuidado");
                                         while (rs.next()) {
                                             System.out.println(rs.getString(1));
                                         }
                                    break;
                                    case 2:
                                         rs = ConexionSinglenton.getConexion().query("select * from turno");
                                         while (rs.next()) {
                                             System.out.println(rs.getString(1));
                                         }
                                    break;
                                    default:
                                         System.out.print("Esa no es una opción ");
                                    break;
                                }

                               
                            break;
                            case 2:
                                System.out.print("¿De que tabla?:\n 1: Personal \n 2: Turno \n ");
                                table = entrada.nextInt();
                                switch (table) {
                                    case 1:
                                        System.out.print("Ingresa el nombre\n");
                                        nombre = entrada.next();
                                        ConexionSinglenton.getConexion().ejecutar("INSERT INTO `cuidado`(`name`) VALUES ('" + nombre + "')");

                                    break;
                                    case 2:
                                        System.out.print("Ingresa el turno ( con un numero )\n");
                                        nombre = entrada.next();
                                        ConexionSinglenton.getConexion().ejecutar("INSERT INTO `turno`(`turno`) VALUES (" + nombre + ")");

                                    break;
                                    default:
                                        System.out.print("Esa no es una opción ");
                                    break;
                                }
                            break;
                            case 3:
                            System.out.print("¿De que tabla?:\n 1: Personal \n 2: Turno \n ");
                            table = entrada.nextInt();
                            switch (table) {
                                case 1:
                                    System.out.print("Ingresa el nombre a cambiar\n");
                                    nam = entrada.next();
                                    System.out.print("Ingresa el nuevo nombre\n");
                                    nombre = entrada.next();
                                    ConexionSinglenton.getConexion()
                                            .ejecutar("UPDATE `cuidado` SET name = '"+nombre+"' WHERE name LIKE '%"+nam+"%'");

                                    break;
                                case 2:
                                    System.out.print("Ingresa el turno a cambiar\n");
                                    nam = entrada.next();
                                    System.out.print("Ingresa el nuevo turno\n");
                                    nombre = entrada.next();
                                    ConexionSinglenton.getConexion()
                                            .ejecutar("UPDATE `turno` SET turno = " + nombre + " WHERE turno = "+ nam );

                                    break;
                                default:
                                    System.out.print("Esa no es una opción ");
                                    break;
                            }
                            break;
                            case 4:
                                System.out.print("¿De que tabla?:\n 1: Personal \n 2: Turno \n ");
                                table = entrada.nextInt();
                                switch (table) {
                                    case 1:
                                        System.out.print("Ingresa el nombre a cambiar\n");
                                        nam = entrada.next();
                                        
                                        ConexionSinglenton.getConexion()
                                                .ejecutar("DELETE FROM cuidado  WHERE name LIKE '%" + nam + "%'");

                                        break;
                                    case 2:
                                        System.out.print("Ingresa el turno a cambiar\n");
                                        nam = entrada.next();
                                        ConexionSinglenton.getConexion()
                                                .ejecutar("DELETE FROM turno WHERE turno = " + nam);

                                        break;
                                    default:
                                        System.out.print("Esa no es una opción ");
                                        break;
                                }
                            break;
                        }
                        System.out.print("¿Gusta realizar otra petición?\n 1: Si \n 2: No ");
                        fin = entrada.nextInt();

                }while(fin == 1);
        
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

}