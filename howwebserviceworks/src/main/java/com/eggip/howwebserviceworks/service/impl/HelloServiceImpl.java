package com.eggip.howwebserviceworks.service.impl;

import com.eggip.howwebserviceworks.service.HelloService;
import com.eggip.howwebserviceworks.service.User;
import com.sun.xml.internal.ws.api.message.HeaderList;
import com.sun.xml.internal.ws.developer.JAXWSProperties;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.stream.XMLStreamException;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@Service
@WebService
public class HelloServiceImpl implements HelloService {

    @Resource
    private WebServiceContext webServiceContext;

    @Override
    public String sayHello(User user) throws XMLStreamException {
        MessageContext messageContext = webServiceContext.getMessageContext();
        HeaderList headers = (HeaderList) webServiceContext.getMessageContext().get(JAXWSProperties.INBOUND_HEADER_LIST_PROPERTY);
        headers.get(0).getStringContent();
        return "Hello, " + user.getName();
    }

    @Override
    public String sayHello1(String name) {
        return "Hello, " + name;
    }
}
