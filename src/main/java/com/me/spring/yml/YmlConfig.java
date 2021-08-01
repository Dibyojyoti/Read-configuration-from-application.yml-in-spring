package com.me.spring.yml;

import java.util.LinkedHashMap;
import java.util.Map;  
import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;  
import org.springframework.context.support.PropertySourcePlaceHolderConfigurer;  
import org.springframework.core.io.ClasspathResource ;

  @Configuration
  public class YmlConfig {
 
  @PostConstruct
  public void init() {
    initURL():
  }
 
  @Bean
  public static 
   PropertySourcePlaceHolderConfigurer  propertySourcePlaceHolderConfigurer() {
    return new  PropertySourcePlaceHolderConfigurer();
  }
 
  private void  initURL() {
    try {
      Map<String,Object> mapObject = getYmlObject();
      Map<String,Object> urlMap = null;
      Map<String,Object> prodToUrl = getBaseObject(mapObject);  
      if( prodToUrl  == null) {
        throw new Exception("some error message");
      }
      urlMap = getUrlMapForProd( prodToUrl, "PRODUCTION2");
      if( urlMap  == null) {
        throw new Exception("some error message");
      }
      String url = getUrlFromMap(urlMap);
      if(url == null || url.eqal("") ) {
        throw new Exception("some error message"); 
      }
    } catch(Exception e) {
       throw new Exception("some error message"); 
    }
  }
 
  Map<String,Object> getYmlObject() {
     YamlMapFactoryBean fBean = new  YamlMapFactoryBean();
     fBean.setResource(new ClasspathResource("application.yml"));
     fBean.setSingleton(true);
     return  fBean.getObject();
  }
 
  LinkedHashMap<String,Object> getBaseObject(Map<String,Object> mapObject) {
    return  (LinkedHashMap<String,Object>)  mapObject.get("BACKEND_URLS");
   } 
 
  LinkedHashMap<String,Object> getUrlMapForProd (Map<String,Object> prodToUrl, 
         String prod) {
    return  (LinkedHashMap<String,Object>) prodToUrl.get(prod);
  }  
 
  String  getUrlFromMap( Map<String,Object> urlMap) {
    return (String) urlMap.get("URL");
  }
}
