/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpete17.main;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import dpete17.services.IEntityProcessingService;
import dpete17.services.IGamePluginService;
import java.util.Collection;
import java.util.ServiceLoader;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author dennis
 */
@Configuration
@ComponentScan(basePackages = "dpete17")
public class ServiceLocatorConfig {

}
