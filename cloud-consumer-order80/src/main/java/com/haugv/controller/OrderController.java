package com.haugv.controller;

import com.haugv.entity.CommonResult;
import com.haugv.entity.Payment;
import com.haugv.lb.CustomLoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
public class OrderController {

    public static final String REMOTE_PAYMENT_API_URL = "http://CLOUD-PAYMENT-SERVICE";
    public static final String PAYMENT_API_CREATE = "/payment/create";
    public static final String PAYMENT_API_GET = "/payment/get";

    @Resource
    RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(REMOTE_PAYMENT_API_URL + PAYMENT_API_CREATE, payment, CommonResult.class);
    }


    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(REMOTE_PAYMENT_API_URL + PAYMENT_API_GET +"/" +id, CommonResult.class);
    }


    @GetMapping("/consumer/payment/create2")
    public CommonResult<Payment> create2(Payment payment){
        return restTemplate.postForEntity(REMOTE_PAYMENT_API_URL + PAYMENT_API_CREATE, payment, CommonResult.class).getBody();
    }

    @GetMapping("/consumer/payment/get2/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id){
        return restTemplate.getForEntity(REMOTE_PAYMENT_API_URL + PAYMENT_API_GET +"/" +id, CommonResult.class).getBody();
    }


    @Resource
    CustomLoadBalancer customLoadBalancer;

    @Resource
    DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (serviceInstances == null||serviceInstances.size()==0) {
            return null;
        }
        ServiceInstance instance = customLoadBalancer.instance(serviceInstances);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri+"/payment/lb", String.class);
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin(){
        return restTemplate.getForObject(REMOTE_PAYMENT_API_URL + "/payment/zipkin", String.class);
    }
}
