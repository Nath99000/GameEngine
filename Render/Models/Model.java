package Game.Render.Models;

public class Model {

    public static final float[] squareVertices = {
            -0.3f, 0.5f, 0f,//v0
            -0.3f, -0.5f, 0f,//v1
            0.3f, -0.5f, 0f,//v2
            0.3f, 0.5f, 0f//v3
    };

    public static final int[] squareIndices = {
            0,1,3,
            3,2,1
    };

    public static final float[] squareTextures = {
            0,0,
            0,1,
            1,1,
            1,0
    };

}
