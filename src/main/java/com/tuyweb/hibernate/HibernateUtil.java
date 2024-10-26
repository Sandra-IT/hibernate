package com.tuyweb.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Crear una instancia de Configuration
            Configuration configuration = new Configuration();

            // Añadir propiedades de configuración
             configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver"); // Cambiado a "com.mysql.cj.jdbc.Driver"
            configuration.setProperty("hibernate.connection.username", "root");
            configuration.setProperty("hibernate.connection.password", "");
            configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3308/sistema_inventario_virtual?useSSL=false&serverTimezone=UTC");
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            configuration.setProperty("hibernate.current_session_context_class", "thread");
            configuration.setProperty("hibernate.show_sql", "true");

            // Añadir anotaciones de entidades
            configuration.addAnnotatedClass(Inventario.class);
            
            
            // Crear un ServiceRegistry a partir de la configuración
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();

            // Crear un SessionFactory
            return configuration.buildSessionFactory(serviceRegistry);
        } catch (HibernateException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void shutdown() {
        // Cerrar caches y connection pools
        getSessionFactory().close();
    }

}
