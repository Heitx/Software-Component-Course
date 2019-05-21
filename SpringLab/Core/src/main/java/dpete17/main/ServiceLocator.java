package dpete17.main;

import dpete17.data.GameData;
import dpete17.data.World;
import dpete17.services.IEntityProcessingService;
import dpete17.services.IGamePluginService;
import dpete17.services.IPostEntityProcessingService;
import java.util.Collection;

import java.util.Iterator;
import java.util.ServiceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ServiceLocator {
//    private static ServiceLocator ourInstance = new ServiceLocator();
//
//    public static ServiceLocator getInstance() {
//        if (ourInstance == null) {
//            ourInstance = new ServiceLocator();
//        }
//        return ourInstance;
//    }

    private Collection<IEntityProcessingService> entityProcessingServices;
    private Collection<IPostEntityProcessingService> postEntityProcessingServices;
    private Collection<IGamePluginService> gamePluginServices;

    public ServiceLocator() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ServiceLocatorConfig.class);
        
        entityProcessingServices = ctx.getBeansOfType(IEntityProcessingService.class).values();
        postEntityProcessingServices = ctx.getBeansOfType(IPostEntityProcessingService.class).values();
        gamePluginServices = ctx.getBeansOfType(IGamePluginService.class).values();
    }

    public void runEntityProcesses(GameData data, World world) {
        for (IEntityProcessingService entityProcessingService : entityProcessingServices) {
            entityProcessingService.process(data, world);
        }
    }

    public void runPostEntityProcesses(GameData data, World world) {
        for (IPostEntityProcessingService postEntityProcessingService : postEntityProcessingServices) {
            postEntityProcessingService.process(data, world);
        }
    }

    public void pluginStarts(GameData data, World world) {
        for (IGamePluginService gamePluginService : gamePluginServices) {
            gamePluginService.start(data, world);
        }
    }

    public void pluginEnds(GameData data, World world) {
        for (IGamePluginService gamePluginService : gamePluginServices) {
            gamePluginService.stop(data, world);
        }
    }
}
