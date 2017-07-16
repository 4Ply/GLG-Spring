package com.netply.glc.web.rest;

import com.netply.glc.web.rest.address.AddressDatabase;
import com.netply.glc.web.rest.address.AddressDatabaseImpl;
import com.netply.glc.web.rest.address.AddressManager;
import com.netply.glc.web.rest.address.AddressManagerImpl;
import com.netply.glc.web.rest.contact.ContactDatabase;
import com.netply.glc.web.rest.contact.ContactDatabaseImpl;
import com.netply.glc.web.rest.contact.ContactManager;
import com.netply.glc.web.rest.contact.ContactManagerImpl;
import com.netply.glc.web.rest.event.EventDatabase;
import com.netply.glc.web.rest.event.EventDatabaseImpl;
import com.netply.glc.web.rest.event.EventManager;
import com.netply.glc.web.rest.event.EventManagerImpl;
import com.netply.glc.web.rest.fees.OutstandingFeesDatabase;
import com.netply.glc.web.rest.fees.OutstandingFeesDatabaseImpl;
import com.netply.glc.web.rest.fees.OutstandingFeesManager;
import com.netply.glc.web.rest.fees.OutstandingFeesManagerImpl;
import com.netply.glc.web.rest.gymnast.GymnastDatabase;
import com.netply.glc.web.rest.gymnast.GymnastDatabaseImpl;
import com.netply.glc.web.rest.gymnast.GymnastManager;
import com.netply.glc.web.rest.gymnast.GymnastManagerImpl;
import com.netply.glc.web.rest.medical.MedicalDatabase;
import com.netply.glc.web.rest.medical.MedicalDatabaseImpl;
import com.netply.glc.web.rest.medical.MedicalManager;
import com.netply.glc.web.rest.medical.MedicalManagerImpl;
import com.netply.glc.web.rest.transaction.TransactionDatabase;
import com.netply.glc.web.rest.transaction.TransactionDatabaseImpl;
import com.netply.glc.web.rest.transaction.TransactionManager;
import com.netply.glc.web.rest.transaction.TransactionManagerImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
public class AppConfig {
    @Value("${mysql_host}")
    private String mysqlIp;

    @Value("${mysql_port}")
    private int mysqlPort;

    @Value("${mysql_db}")
    private String mysqlDb;

    @Value("${mysql_user}")
    private String mysqlUser;

    @Value("${mysql_password}")
    private String mysqlPassword;


    @Bean
    public GymnastDatabase gymnastDatabase() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        return new GymnastDatabaseImpl(mysqlIp, mysqlPort, mysqlDb, mysqlUser, mysqlPassword);
    }

    @Bean
    public GymnastManager gymnastManager() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        return new GymnastManagerImpl(gymnastDatabase());
    }

    @Bean
    public AddressDatabase addressDatabase() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        return new AddressDatabaseImpl(mysqlIp, mysqlPort, mysqlDb, mysqlUser, mysqlPassword);
    }

    @Bean
    public AddressManager addressManager() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        return new AddressManagerImpl(addressDatabase());
    }

    @Bean
    public MedicalDatabase medicalDatabase() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        return new MedicalDatabaseImpl(mysqlIp, mysqlPort, mysqlDb, mysqlUser, mysqlPassword);
    }

    @Bean
    public MedicalManager medicalManager() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        return new MedicalManagerImpl(medicalDatabase());
    }

    @Bean
    public ContactDatabase contactDatabase() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        return new ContactDatabaseImpl(mysqlIp, mysqlPort, mysqlDb, mysqlUser, mysqlPassword);
    }

    @Bean
    public ContactManager contactManager() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        return new ContactManagerImpl(contactDatabase());
    }

    @Bean
    public TransactionDatabase transactionDatabase() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        return new TransactionDatabaseImpl(mysqlIp, mysqlPort, mysqlDb, mysqlUser, mysqlPassword);
    }

    @Bean
    public TransactionManager transactionManager() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        return new TransactionManagerImpl(transactionDatabase());
    }

    @Bean
    public OutstandingFeesDatabase outstandingFeesDatabase() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        return new OutstandingFeesDatabaseImpl(mysqlIp, mysqlPort, mysqlDb, mysqlUser, mysqlPassword);
    }

    @Bean
    public OutstandingFeesManager outstandingFeesManager() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        return new OutstandingFeesManagerImpl(outstandingFeesDatabase(), transactionManager(), eventManager());
    }

    @Bean
    public EventDatabase eventDatabase() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        return new EventDatabaseImpl(mysqlIp, mysqlPort, mysqlDb, mysqlUser, mysqlPassword);
    }

    @Bean
    public EventManager eventManager() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        return new EventManagerImpl(eventDatabase());
    }
}
