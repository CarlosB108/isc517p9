package Comunes;

import Entidades.Usuario;
import Entidades.Producto;

import java.util.ArrayList;

public class General {
    //
    static public ArrayList<Usuario> Users = new ArrayList< Usuario >( );
    static public ArrayList<Producto> Products = new ArrayList< Producto>( );
    static public Usuario usuario = null;
    static int contador_usuarios = 0;

    public static Usuario get_user(String correo, String clave ){
        for ( Usuario user : Users ){
            if( user.getCorreo().equals( correo ) && user.getClave( ).equals( clave ) ){
                return user;
            }
        }

        return null;
    }

    public static Usuario agregar_usuario( String nombre, String correo, String clave, Boolean admin ){
        Usuario user = new Usuario( General.contador_usuarios, nombre, correo, clave );
        user.setAdmin( admin );
        General.contador_usuarios++;
        return user;

    }
}