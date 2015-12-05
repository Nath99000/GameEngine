package Game.Main.Entity;

import Game.Main.DisplayManager;
import Game.Main.RunProgram;
import Game.Render.ModelLoader;
import Game.Render.shaders.StaticShader;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

        public class Camera {

private Vector3f position = new Vector3f(0, 0, 0);
private float pitch;
private float yaw;
private float roll;

public Camera() {

}
            public void move() {
                if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
            			position.z -= 0.02f;
            		}
        		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
            			position.x += 0.02f;
            		}
        		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
            			position.x -= 0.02f;
            		}
				if (Keyboard.isKeyDown(Keyboard.KEY_S)){
					position.z += 0.02f;
				}
				if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
					RunProgram.shouldClose = true;
				}
				if (Keyboard.isKeyDown(Keyboard.KEY_R)){
					this.position.setX(0);
					this.position.setY(0);
					this.position.setZ(0);
				}
        	}

            	public Vector3f getPosition() {
        		return position;
        	}

            	public float getPitch() {
        		return pitch;
        	}

            	public float getYaw() {
        		return yaw;
        	}

            	public float getRoll() {
                    		return roll;
        	}
        }
