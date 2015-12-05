package Game.Main;

import Game.Main.Entity.Camera;
import Game.Main.Entity.Entity;
import Game.Render.ModelLoader;
import Game.Render.Models.Model;
import Game.Render.Models.RawModel;
import Game.Render.Models.TexturedModel;
import Game.Render.Renderer;
import Game.Render.shaders.StaticShader;
import Game.Render.textures.ModelTexture;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;


public class RunProgram {

    public static void main(String[] args){
        DisplayManager.create();
        ModelLoader loader = new ModelLoader();
        StaticShader shader = new StaticShader();
        Renderer renderer = new Renderer(shader);

        RawModel model = loader.loadToVAO(Model.squareVertices, Model.squareIndices, Model.squareTextures);
        ModelTexture texture = new ModelTexture(loader.loadTexture("image"));
        TexturedModel model1 = new TexturedModel(model, texture);

        Entity entity = new Entity(model1, new Vector3f(0.5f, 0, 0), 0, 0, 0, 1);
        Camera camera = new Camera();

        shader.getTheUniformLocations();

        while (!Display.isCloseRequested()) {
            camera.move();
            renderer.prepare();
            shader.start();
            shader.loadViewMatrix(camera);
            //ToDo: <Insert amazing game loop here>
            renderer.render(entity, shader);
            shader.stop();
            DisplayManager.update();
        }
        shader.clean();
        loader.clean();
        DisplayManager.exit();
    }

}
