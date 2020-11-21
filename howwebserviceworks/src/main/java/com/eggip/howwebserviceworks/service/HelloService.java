package com.eggip.howwebserviceworks.service;


import javax.xml.stream.XMLStreamException;

public interface HelloService {
    String sayHello(User user) throws XMLStreamException;
    String sayHello1(String name);
}
