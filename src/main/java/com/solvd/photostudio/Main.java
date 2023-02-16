package com.solvd.photostudio;

import com.solvd.photostudio.dao.jdbc.*;
import com.solvd.photostudio.jaxb.converter.JaxbMarshall;
import com.solvd.photostudio.jaxb.converter.JaxbUnmarshall;
import com.solvd.photostudio.json.JsonDeserialization;
import com.solvd.photostudio.json.JsonSerialization;
import com.solvd.photostudio.model.Customer;
import com.solvd.photostudio.mybatis.mybatisservise.CustomerService;
import com.solvd.photostudio.sax.CustomerHandler;
import com.solvd.photostudio.service.XmlValidator;
import com.solvd.photostudio.util.PropertiesUtil;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;


public class Main {
    public static void main(String[] args) throws NullPointerException, JAXBException, IOException, ParseException, SQLException {

        //Jaxb
        //JaxbMarshall.marshalCustomer();
        //JaxbUnmarshall.unMarshalCustomer();

        //Json
        //JsonSerialization.serializationCustomer();
        //JsonDeserialization.deserializationCustomer();

        //Sax
        //CustomerHandler.parsing();

        //XmlValidator
        //XmlValidator.validator();

        //MyBatis
        //System.out.println(new CustomerService().getCustomerById(3));
        //System.out.println(new CustomerService().getAllCustomer());
        //Customer customer = new Customer("Chip", "Charlzi","0505748398", "chip@gmail.com");
        //CustomerService.insertCustomer(customer);

        //Dao
        //PropertiesUtil.loadProperties();
        //CustomerDaoImpl dao = new CustomerDaoImpl(PropertiesUtil.getHost(), PropertiesUtil.getName(), PropertiesUtil.getPassword());
        //dao.getAll();
        //dao.getById(3);
        //dao.insert(new Customer("Jeromy", "Types", "380505554455", "tim@gmail.com"));
        //dao.update(new Customer("Din", "Types", "05088855599", "din@gmail.com"), 7);
        //dao.delete(6);
        //dao.findByLastName("Jonson");
    }
}
