package Comunes;

import Entidades.Producto;
import Entidades.Usuario;
import Entidades.producto_venta;

import java.util.ArrayList;

public class General {
    //
    static public ArrayList<Usuario> Users = new ArrayList< Usuario >( );
    static public ArrayList<Producto> Products = new ArrayList< Producto>( );
    static public ArrayList< producto_venta > Ventas = new ArrayList< producto_venta>( );

    static public Usuario usuario = null;
    static int contador_usuarios = 0;
    static int contador_productos = 0;

    public static void add_venta( int id_producto, int monto, int cantidad ){
        Ventas.add( new producto_venta( usuario.getId(), id_producto, monto, cantidad ) );
    }

    public static Usuario get_user(String correo, String clave ){
        for ( Usuario user : Users ){
            if( user.getCorreo().equals( correo ) && user.getClave( ).equals( clave ) ){
                return user;
            }
        }

        return null;
    }

    public static Producto get_producto( int id_producto ){
        for ( Producto producto : Products ){
            if( producto.getId() == id_producto ){
                return producto;
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

    public static Producto obtener_producto_por_id( Integer id ){
        for ( Producto p : Products ){
            if( p.getId( ) == id ) return p;
        }

        return null;
    }

    public static void actualizar_producto( Producto A ){
        for( Producto p : Products ){
            if( p.getId( ) == A.getId( ) ){
                p.setPrecio( A.getPrecio( ) );
                p.setDescripcion( A.getDescripcion( ) );
                p.setNombre( A.getNombre( ) );
                p.setCantidad_disponible( A.getCantidad_disponible( ) );
                p.setImagenes( A.getImagenes( ) );

                break;
            }
        }
    }

    public static void agregar_producto( Producto p ){
        Products.add( p );
        p.setId( contador_productos );

        contador_productos++;
    }

    public int getContador_usuarios( ){
        return contador_usuarios;
    }

    public int getContador_productos( ){
        return contador_productos;
    }
}