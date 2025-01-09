package Hibernate.Metodos;

import Datos.Adestrador;
import Hibernate.Utilidad.Utilidad;
import org.hibernate.query.NativeQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class MetodosAdestrador {

    public void crearAdestrador(Adestrador adestrador) {
        try (Session session = Utilidad.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(adestrador);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al crear el adestrador: " + e.getMessage());
        }
    }

    public List<Adestrador> listarAdestrador() {
        List<Adestrador> adestradores = null;
        try (Session session = Utilidad.getSessionFactory().openSession()) {
            Query<Adestrador> query= session.createQuery("from Adestrador ", Adestrador.class);
            adestradores= query.list();
            adestradores.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error al listar los adestradores: " + e.getMessage());
        }
        return adestradores;
    }


    public void modificarAdestrador(int id,String nome) {
        try (Session session = Utilidad.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Adestrador adestrador = session.get(Adestrador.class, id);
            if(adestrador!=null){
                adestrador.setNome(nome);
                session.update(adestrador);
                transaction.commit();
            } else{
                System.out.println("No se encontro al adestrador con ese id ");
            }
        } catch (Exception e) {
            System.out.println("Error al modificar el adestrador: " + e.getMessage());
        }
    }

    public void borrarTablaAdestrador(){
        try (Session session = Utilidad.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            NativeQuery query = session.createSQLQuery("DELETE FROM adestrador");
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al borrar la tabla de adestradores: " + e.getMessage());
        }
    }
}
