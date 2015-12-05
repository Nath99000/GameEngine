package Game.Main;

import Game.Main.Entity.Camera;
import Game.Main.Entity.Entity;
import Game.Render.ModelLoader;
import Game.Render.Models.Model;
import Game.Render.Models.OBJLoader;
import Game.Render.Models.RawModel;
import Game.Render.Models.TexturedModel;
import Game.Render.Renderer;
import Game.Render.shaders.StaticShader;
import Game.Render.textures.ModelTexture;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import java.util.Random;


public class RunProgram {

    public static boolean shouldClose = false;

    public static void main(String[] args) {

        DisplayManager.create();
        ModelLoader loader = new ModelLoader();
        StaticShader shader = new StaticShader();
        Renderer renderer = new Renderer(shader);

        RawModel model = OBJLoader.loadObjModel("model", loader);
        TexturedModel staticModel = new TexturedModel(model, new ModelTexture(loader.loadTexture("image")));

        Entity entity = new Entity(staticModel, new Vector3f(0, 0, -5), 0, 0, 0, 0.3f);
        Random rand = new Random();
        Camera camera = new Camera();

        while (!Display.isCloseRequested() && !shouldClose) {
            entity.increaseRotation(0, 0.01f, 0);
            camera.move();
            renderer.prepare();
            shader.start();
            shader.loadViewMatrix(camera);
            renderer.render(entity, shader);
            shader.stop();
            DisplayManager.update();
        }

        shader.clean();
        loader.clean();
        DisplayManager.exit();

    }

}