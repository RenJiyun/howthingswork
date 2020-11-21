package com.eggip.howwebserviceworks;

import com.eggip.howwebserviceworks.soap.ws.client.generated.HelloServiceImpl;
import com.eggip.howwebserviceworks.soap.ws.client.generated.HelloServiceImplService;
import com.eggip.howwebserviceworks.soap.ws.client.generated.User;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
        HelloServiceImplService service = new HelloServiceImplService();
        HelloServiceImpl helloService = service.getHelloServiceImplPort();
        BindingProvider bindingProvider = (BindingProvider) helloService;
        Map<String, List<String>> requestHeaders = new HashMap<>();
        requestHeaders.put("username", Arrays.asList("test"));
        requestHeaders.put("password", Arrays.asList("test"));
        bindingProvider.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, requestHeaders);
        User user = new User();
        user.setAge(30);
        user.setName("======");
        System.out.println(helloService.sayHello(user));
    }
}
