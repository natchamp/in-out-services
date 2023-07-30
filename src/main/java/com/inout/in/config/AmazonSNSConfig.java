package com.inout.in.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSAsyncClientBuilder;
import com.amazonaws.services.sns.AmazonSNSClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AmazonSNSConfig {

    @Primary
    @Bean
    public AmazonSNSClient getSNSClient(){
        return (AmazonSNSClient) AmazonSNSAsyncClientBuilder.standard().withRegion(Regions.AP_SOUTH_1)
                .withCredentials(
                        new AWSStaticCredentialsProvider(new BasicAWSCredentials("AKIAWHMGJ7LGPRK6NIB4",
                        "CpjnNBf55V2nd7pVp136Iya0q7o21sz+KTH++GO5"))).build();
    }
}
