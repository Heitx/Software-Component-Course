package main;

import data.GameData;
import data.World;
import services.IEntityProcessingService;
import services.IGamePluginService;
import services.IPostEntityProcessingService;

import java.util.Iterator;
import java.util.ServiceLoader;

public class ServiceLocator {
//    private static ServiceLocator ourInstance = new ServiceLocator();
//
//    public static ServiceLocator getInstance() {
//        if (ourInstance == null) {
//            ourInstance = new ServiceLocator();
//        }
//        return ourInstance;
//    }

    private ServiceLoader<IEntityProcessingService> entityProcessingServices;
    private ServiceLoader<IPostEntityProcessingService> postEntityProcessingServices;
    private ServiceLoader<IGamePluginService> gamePluginServices;

    public ServiceLocator() {
        entityProcessingServices = ServiceLoader.load(IEntityProcessingService.class);
        postEntityProcessingServices = ServiceLoader.load(IPostEntityProcessingService.class);
        gamePluginServices = ServiceLoader.load(IGamePluginService.class);
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
