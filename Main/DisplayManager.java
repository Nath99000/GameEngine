package Game.Main;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;

public class DisplayManager {

    private static final int width = 1280;
    private static final int height = 720;
    private static final int FPSCap = 120;

    public static void create(){

        ContextAttribs attribs = new ContextAttribs(3, 2)
        .withForwardCompatible(true)
        .withProfileCore(true);

        try {
            Display.setDisplayMode(new DisplayMode(width, height));
            Display.setTitle("Project Darcnia");
            Display.create(new PixelFormat());
        } catch (LWJGLException e) {
            e.printStackTrace();
        }

        GL11.glViewport(0, 0, width, height);
    }

    public static void update(){

        Display.sync(FPSCap);
        Display.update();

    }

    public static void exit(){
        Display.destroy();
    }

}
