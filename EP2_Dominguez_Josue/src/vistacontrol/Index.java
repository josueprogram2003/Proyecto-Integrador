
package vistacontrol;

import java.util.ArrayList;
import java.util.List;
import modelodao.LibrosDAO;
import utils.Leer;
import modelo.Libros;
import modelo.Autor;
import modelo.Editorial;
import modelo.Pais;
import modelodao.AutorDAO;
import modelodao.EditorialDAO;
import modelodao.PaisDAO;


public class Index {
    
     public static void BuscarEditorial(){
        int ideditorial;
        System.out.println("Ingrese el ID: ");
        ideditorial=Leer.entero();
        EditorialDAO edi = new EditorialDAO();
        List<Editorial> lista = edi.buscarEditorial(ideditorial);
        for (Editorial libros : lista) {
            System.out.println(libros.getIdeditorial()+"\t"+ libros.getNombre() + "\t" + libros.getEstado());                  
        }      
    }
    public static void listarEditorial(){
        EditorialDAO libro = new EditorialDAO();
        List<Editorial> libros = libro.listarEditorial();
        System.out.println("Listar Editorial");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Id\t\tNombre\t\t\t\tEstado");
          System.out.println("-------------------------------------------------------------");
        for (Editorial libro1 : libros) {

            String id = Integer.toString(libro1.getIdeditorial());
            System.out.println(darFormato2(id) + darFormato2(libro1.getNombre()) +darFormato2(libro1.getEstado()));   
             System.out.println("-------------------------------------------------------------");
        }
    }
    public static void AgregarEditorial(){
        String nombre;
        String estado;    
        System.out.println("Agregar Editorial");
        System.out.print("Nombre: ");
        nombre = Leer.cadena();
        System.out.print("Estado: ");
        estado = Leer.cadena();
        Editorial editorial = new Editorial(nombre, estado);
        EditorialDAO autorDAO = new EditorialDAO();
        autorDAO.agregarEditorial(editorial);
    }
    public static void EliminarEditorial(){
     listarEditorial();
    int ideditorial;
    System.out.println("Ingrese el id a eliminar: ");
    ideditorial= Leer.entero();
    EditorialDAO libro = new EditorialDAO();
        if (libro.eliminarEditorial(ideditorial)) {
            System.out.println("Eliminado");
        }else{
            System.out.println("No se elimino");
        }   
    }
    public static void EditarEditorial(){
        listarEditorial();
           int ideditorial;
        String  nombre;
         String estado;
        BuscarEditorial();
        String respuesta;
        System.out.print("¿Desea Editar si o no?: ");
        respuesta=Leer.cadena().trim();
        if (respuesta.equalsIgnoreCase("Si")) {
            System.out.print("ID Editorial: ");
            ideditorial=Leer.entero();
            System.out.print("Nombre: ");
            nombre=Leer.cadena();    
            System.out.print("Estado: ");
            estado=Leer.cadena();
            Editorial remplazo = new Editorial(ideditorial, nombre, estado);
            EditorialDAO conductor = new EditorialDAO();
            if (conductor.editarEditorial(remplazo)) {
                System.out.println("Eicion Exitosa");
            } else {
                System.out.println("Problemas en el editar");
            }
        }               
    }
    
    
     public static void editarautor(){
        listar_autor();
        buscarautor();
        String nombre;
        String apellidos;
        String estado;
        System.out.println("Editar Autor");
        System.out.print("Nombre: ");
        nombre = Leer.cadena();
        System.out.print("Apellidos: ");
        apellidos = Leer.cadena();
        System.out.print("Estado: ");
        estado = Leer.cadena();
        Autor autor = new Autor(nombre, apellidos, estado);
        AutorDAO autorDAO = new AutorDAO();
        autorDAO.editarAutor(autor);
    }
    
    public static void agregarautor(){
        String nombre;
        String apellidos;
        String estado;
        System.out.println("Agregar Autor");
        System.out.print("Nombre: ");
        nombre = Leer.cadena();
        System.out.print("Apellidos: ");
        apellidos = Leer.cadena();
        System.out.print("Estado: ");
        estado = Leer.cadena();
        Autor autor = new Autor(nombre, apellidos, estado);
        AutorDAO autorDAO = new AutorDAO();
        if (autorDAO.agregarAutor(autor)) {
            System.out.println("Registro Exitoso");
        }
        
}
    
    public static void listar_libros(){
        LibrosDAO libro = new LibrosDAO();
        ArrayList<List> reporte = libro.listarLibros();      
        System.out.println("LISTAR LIBROS");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Id\t\tApellidos\t\t\tAutor\t\t\t\tEditorial\t\t\tPais\t\t\t\tCodigo\t\t\t\tEstado");
        for (List list : reporte) {
            String id = list.get(0).toString();
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        	System.out.println("\u001B[0m" + id+"\t\t"  + darFormato(list.get(1).toString()) + darFormato(list.get(2).toString()) + 
                        darFormato(list.get(3).toString())
                      +  darFormato(list.get(4).toString()) + darFormato(list.get(5).toString())+darFormato(list.get(6).toString()) );  
        }
        System.out.println("");    
 
        }
    
    public static void listar_autor(){
        AutorDAO autor = new AutorDAO();
        List<Autor> autores = autor.listarAutor();
        System.out.println("\t\t-------------LISTAR AUTOR-----------");
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("Id\t\tNombre\t\t\t\tApellidos\t\t\tEstado");
        System.out.println("------------------------------------------------------------------------------------------------------"); 
        for (Autor autore : autores) {
            String id = Integer.toString(autore.getIdautor());
            System.out.println(darFormato(id)+darFormato(autore.getNombre())+ darFormato(autore.getApellidos())
            + darFormato(autore.getEstado()));
                     System.out.println("------------------------------------------------------------------------------------------------------");
        }
        System.out.println("");
    }
    
    public static void eliminarlibro(){
    listar_libros();
    int idlibro;
    System.out.println("Ingrese el id a eliminar: ");
    idlibro = Leer.entero();
    LibrosDAO libro = new LibrosDAO();
        if (libro.eliminarLibros(idlibro)) {
            System.out.println("Eliminado");
        }else{
            System.out.println("No se elimino");
        }   
    }
    
    public static void eliminarautor(){
    listar_autor();
    int idautor;
    System.out.println("Ingrese el id a eliminar: ");
    idautor = Leer.entero();
    AutorDAO autor = new AutorDAO();
        if (autor.eliminarAutor(idautor)) {
            System.out.println("Eliminado");
        }else{
            System.out.println("No se elimino");
        }   
    }
    
    public static void editarlibro(){
        listar_libros();
        int idlibro,idautor,ideditorial,idpais;
        String  nombre,codigo,  ISBN,  fecha_publicacion;
        String estado;
        buscarlibro();
        String respuesta;
        System.out.print("¿Desea Editar si o no?: ");
        respuesta=Leer.cadena().trim();
        if (respuesta.equalsIgnoreCase("Si")) {
            System.out.print("Id Actual: ");
            idlibro=Leer.entero();
            System.out.print("Nombre: ");
            nombre=Leer.cadena();
            System.out.print("Codigo: ");
            codigo=Leer.cadena();
            System.out.print("ISBN: ");
            ISBN=Leer.cadena();
            System.out.print("fecha_publicacion: ");
            fecha_publicacion=Leer.cadena();
           System.out.print("Id autor: ");
            idautor = Leer.entero();
           System.out.print("Id editorial: ");
            ideditorial=Leer.entero(); 
                System.out.print("Id País: ");
            idpais=Leer.entero(); 
            System.out.print("Estado: ");
            estado=Leer.cadena();
            Libros remplazo = new Libros(idlibro, nombre, codigo, ISBN, fecha_publicacion, idautor, ideditorial, idpais, estado);
            LibrosDAO conductor = new LibrosDAO();
            if (conductor.editarLibros(remplazo)) {
                System.out.println("Eicion Exitosa");
            } else {
                System.out.println("Problemas en el editar");
            }
        }               
    }
    
    public static void buscarautor(){
      int idautor;
       System.out.println("Ingrese el ID: ");
       idautor= Leer.entero();
       AutorDAO autor = new AutorDAO();
       List<Autor> lista = autor.buscarAutor(idautor);
        for (Autor autor1 : lista) {
            System.out.println(autor1.getIdautor() + "\t" + autor1.getNombre() + "\t" + autor1.getApellidos()+
                    "\t"+ autor1.getEstado());
        }
    }
    
    public static void buscarlibro(){
        int idlibro;
        System.out.println("Ingrese el ID: ");
        idlibro=Leer.entero();
        LibrosDAO libro = new LibrosDAO();
        List<Libros> lista = libro.buscarLibros(idlibro);
        for (Libros libros : lista) {
            System.out.println(libros.getIdlibro()+"\t"
                    +libros.getNombre()+"\t"+libros.getCodigo()+
                    "\t"+libros.getISBN()+"\t"+libros.getFecha_publicacion()+ "\t " + libros.getIdautor() + " \t " + libros.getIdeditorial()
                    + "\t " + libros.getIdpais()+
                    "\t" +libros.getEstado());
        }      
    }
     public static void Agregarlibro() {
        System.out.println("Agregar Libro");
        String nombre,  codigo, ISBN,  fecha_publicacion;
        int idautor, ideditorial,idpais;
        String estado;
        System.out.print("Nombre: ");
        nombre = Leer.cadena();
        System.out.print("Codigo: ");
        codigo=Leer.cadena();
        System.out.print("ISBN: ");
        ISBN=Leer.cadena();
        System.out.print("Fecha_Publicacion: ");
        fecha_publicacion=Leer.cadena();
        System.out.print("Id Autor: ");
        idautor=Leer.entero();
        System.out.print("Id Editorial: ");
        ideditorial=Leer.entero(); 
         System.out.print("Id País: ");
        idpais=Leer.entero(); 
        System.out.print("Estado: ");
        estado=Leer.cadena();
        Libros libros = new Libros(nombre, codigo, ISBN, fecha_publicacion, idautor, ideditorial, idpais, estado);
        LibrosDAO agregar = new LibrosDAO();
        if (agregar.agregarLibros(libros)) {
            System.out.println("Registro Exitoso");
        } else {
            System.out.println("Nose Registro");
        }
    }
     
     public static void listar_pais(){
           PaisDAO pais = new PaisDAO();
        List<Pais> paises = pais.listarPais();
        System.out.println("\t  ----------LISTAR PAÍS------------");
            System.out.println("-----------------------------------------------------------------");
        System.out.println("Id\t\tNombre\t\t\t\tEstado");
         System.out.println("-----------------------------------------------------------------");
         for (Pais p : paises) {
             String id = Integer.toString(p.getIdpais());
            System.out.println(darFormato2(id) + darFormato2(p.getNombre()) +darFormato2(p.getEstado()));  
              System.out.println("-----------------------------------------------------------------");
         }
         System.out.println("");
   
     }
     
      public static void Eliminar_pais(){
         listar_pais();
         int idpais;
    System.out.println("Ingrese el id a eliminar: ");
    idpais= Leer.entero();
    PaisDAO p = new PaisDAO();
        if (p.eliminarPais(idpais)) {
            System.out.println("Eliminado");
        }else{
            System.out.println("No se elimino");
        }   
     }
      
       public static void Editar_pais(){
           listar_pais();
        Buscar_pais();
        int idpais;
        String  nombre;
        String estado;
        String respuesta;
        System.out.print("¿Desea Editar si o no?: ");
        respuesta=Leer.cadena().trim();
        if (respuesta.equalsIgnoreCase("Si")) {
            System.out.print("Id Actual: ");
            idpais=Leer.entero();
            System.out.print("Nombre: ");
            nombre=Leer.cadena();
            System.out.print("Estado: ");
            estado=Leer.cadena();
            Pais remplazo = new Pais(idpais,nombre, estado);
           PaisDAO conductor = new PaisDAO();
            if (conductor.editarPais(remplazo)) {
                System.out.println("Eicion Exitosa");
            } else {
                System.out.println("Problemas en el editar");
            }
        }               
     }
       
        public static void Agregar_pais(){
         String nombre;
        String estado;    
        System.out.println("Agregar Pais");
        System.out.print("Nombre: ");
        nombre = Leer.cadena();
        System.out.print("Estado: ");
        estado = Leer.cadena();
       Pais p = new Pais(nombre, estado);
        PaisDAO pdao = new PaisDAO();
       pdao.agregarPais(p);
     }
        
       public static void Buscar_pais(){
         int idpais;
        System.out.println("Ingrese el ID: ");
        idpais=Leer.entero();
        PaisDAO libro = new PaisDAO();
        List<Libros> lista = libro.buscarPais(idpais);
        for (Libros libros : lista) {
            System.out.println(libros.getIdpais()+"\t"
                    +libros.getNombre()+
                    "\t" +libros.getEstado());
        }      
     }
     
    public static String darFormato(String cadena){
        if (cadena.length()>=31) {
            cadena = cadena.substring(0,28) + "..  ";
        }else if (cadena.length()>=23) {
        	cadena = cadena + "\t";
              }else if (cadena.length()>=16) {
            cadena = cadena + "\t\t";
             }else if (cadena.length()==15) {
            cadena = cadena + "\t\t\t";
             }else if (cadena.length()>12 && cadena.length()<15) {
            cadena = cadena + "\t\t\t";
        }else if (cadena.length()>=8 && cadena.length()<=12){
            cadena = cadena + "\t\t\t";
            }else if (cadena.length()>=3){
            cadena = cadena + "\t\t\t\t";
            }else{
            cadena = cadena + "\t\t";
        }
        return cadena;
    }
     public static String darFormato2(String cadena){
        if (cadena.length()>=31) {
            cadena = cadena.substring(0,28) + "..  ";
        }else if (cadena.length()>=23) {
        	cadena = cadena + "\t";
        }else if(cadena.length()>=17){
            cadena = cadena + "\t\t";
        }else if (cadena.length()>=16 && cadena.length()<17) {
            cadena = cadena + "\t\t";
        }else if(cadena.length()==15){
            cadena =cadena+"\t\t\t";
        }else if (cadena.length()>=8){
            cadena = cadena + "\t\t\t";
        }else if(cadena.length()==7){
            cadena = cadena + "\t\t\t\t";
            }else if (cadena.length()>=3){
            cadena = cadena + "\t\t\t\t";
            }else{
            cadena = cadena + "\t\t";
        }
        return cadena;
    }
    
    public static void menu(){
        System.out.println("--------Menu de Principal-------");
        System.out.println("1. Listar País");
        System.out.println("2. Eliminar País");
        System.out.println("3. Editar País");
        System.out.println("4. Agregar País");
        System.out.println("5. Listar Libros");
        System.out.println("6. Eliminar Libros");
        System.out.println("7. Editar Libros");
        System.out.println("8. Agregar Libros");
        System.out.println("9. Listar Autor");
        System.out.println("10. Eliminar Autor");
        System.out.println("11. Editar Autor");
        System.out.println("12. Agregar Autor");
        System.out.println("13. Listar Editorial");
        System.out.println("14. Eliminar Editorial");
        System.out.println("15. Editar Editorial");
        System.out.println("16. Agregar Editorial");
        System.out.println("17. Salir");
        System.out.print("Elige una de las opciones[1-16]:");
    }
    
    public static void configuracion(){
    int opcion;
         do {     
             menu();
             opcion=Leer.entero();
             switch(opcion){
                 case 1:
                   listar_pais();
                     break;
                 case 2:
                    Eliminar_pais();
                     break;
                 case 3:
                    Editar_pais();
                     break;
                 case 4:
                     Agregar_pais();
                     break;
                 case 5:
                     listar_libros();
                     break;
                 case 6:
                    eliminarlibro();
                     break; 
                 case 7:
                     editarlibro();
                     break;
                 case 8:
                     Agregarlibro();
                     break;
                 case 9:
                    listar_autor();
                     break;
                 case 10:
                     eliminarautor();
                     break;
                 case 11:
                   editarautor();
                     break;
                 case 12:
                    agregarautor();
                     break;
                 case 13:
                    listarEditorial();
                     break;
                 case 14:
                     EliminarEditorial();
                     break; 
                 case 15:
                     EditarEditorial();
                     break;
                 case 16:
                     AgregarEditorial();
                     break;
                 case 17:
                     System.out.println("Gracias por su visita........");
                     break;
                 default:
                     System.out.println("Error ...............escoja bien las opciones");                   
             }
         } while (opcion!=17);
    }
    
    public static void main(String[] args) {
        configuracion();
    }
}
