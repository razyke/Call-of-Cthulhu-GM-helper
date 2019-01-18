package ru.orbot90.com.coc.gmhelper.core.dao

import org.hibernate.SessionFactory
import org.hibernate.boot.MetadataSources
import org.hibernate.boot.registry.StandardServiceRegistry
import org.hibernate.boot.registry.StandardServiceRegistryBuilder
import java.lang.Exception

object HibernateUtil {

    private val registry: StandardServiceRegistry = StandardServiceRegistryBuilder()
            .configure()
            .build()

    private val sessionFactory: SessionFactory by lazy{
        try {
            MetadataSources(registry).buildMetadata().buildSessionFactory()
        } catch (e: Exception){
            StandardServiceRegistryBuilder.destroy(registry)
        }
        throw IllegalStateException("Could not initialize Hibernate Session Factory")
    }
}