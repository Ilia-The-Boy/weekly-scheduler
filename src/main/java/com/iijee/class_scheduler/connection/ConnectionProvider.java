package com.iijee.class_scheduler.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionProvider {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("tamrin1PU");

    public EntityManager getEntityManager(){
        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }

    public static void close(){
        if (ENTITY_MANAGER_FACTORY.isOpen())
            ENTITY_MANAGER_FACTORY.close();
    }

}
