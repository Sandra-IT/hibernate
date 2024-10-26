package com.tuyweb.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Hibernate {
    
     public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            // Iniciar una transacción
            transaction = session.beginTransaction();

            // Crear una instancia de la entidad Usuario
            Inventario inventario1 = new Inventario("Producto1", "Categoría1", "Descripción del producto 1", "Ubicación1");
            session.save(inventario1);
            System.out.println("Producto guardado: " + inventario1.getNombre());

            Inventario inventario2 = new Inventario("Producto2", "Categoría2", "Descripción del producto 2", "Ubicación2");
            session.save(inventario2);
            System.out.println("Producto guardado: " + inventario2.getNombre());

            Inventario inventario3 = new Inventario("Producto3", "Categoría1", "Descripción del producto 3", "Ubicación3");
            session.save(inventario3);
            System.out.println("Producto guardado: " + inventario3.getNombre()); 

            // Guardar la entidad en la base de datos
            //session.save(inventario);

            // Commit de la transacción
            transaction.commit();

            System.out.println("producto guardado con éxito");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // Cerrar el SessionFactory al final del programa
            HibernateUtil.shutdown();
        }
    }
}
