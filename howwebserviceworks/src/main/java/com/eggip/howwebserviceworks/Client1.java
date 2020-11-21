package com.eggip.howwebserviceworks;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;
import org.apache.axis.message.SOAPHeaderElement;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.encoding.XMLType;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

public class Client1 {
    public static void main(String[] args) throws ServiceException, MalformedURLException, RemoteException {
        String endpoint = "http://localhost:8081/HelloService/?wsdl";
        Service service = new Service();
        Call call = (Call) service.createCall();
        call.setTargetEndpointAddress(new URL(endpoint));
        call.setOperationName(new QName("http://impl.service.howwebserviceworks.eggip.com/", "sayHello"));

        QName qName = new QName("http://impl.service.howwebserviceworks.eggip.com/", "user");
        call.registerTypeMapping(User.class, qName, new BeanSerializerFactory(User.class, qName), new BeanDeserializerFactory(User.class, qName));
        call.addParameter("arg0", qName, ParameterMode.IN);
        call.setReturnType(XMLType.XSD_STRING);
        User user = new User(30, "ren");
        call.addHeader(new SOAPHeaderElement("http://impl.service.howwebserviceworks.eggip.com/", "username", "test"));
        call.addHeader(new SOAPHeaderElement("http://impl.service.howwebserviceworks.eggip.com/", "password", "test123"));
        String ret = (String) call.invoke(new Object[] { user });
        System.out.println(ret);
    }
}
