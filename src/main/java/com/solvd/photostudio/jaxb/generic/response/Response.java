package com.solvd.photostudio.jaxb.generic.response;

import com.solvd.photostudio.model.Customer;
import com.solvd.photostudio.model.GiftCertificate;
import com.solvd.photostudio.model.OrderRental;
import com.solvd.photostudio.model.ServiceOrder;
import com.solvd.photostudio.model.Subscription;
import javax.xml.bind.annotation.*;
import java.util.List;


@XmlRootElement(name = "request")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Customer.class, GiftCertificate.class, ServiceOrder.class, OrderRental.class, Subscription.class})
public class Response<T> {

    @XmlAnyElement( lax = true)
    List<T> object;

    public List<T> getObject() {
        return object;
    }

    public void setObjects(List<T> objects) {
        this.object = objects;
    }
}
