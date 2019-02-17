package dump;

import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3f;

import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.Map;

import static org.lwjgl.opengl.GL20.*;

public class Shader {

    private final int ID;
    private Map<String, Integer> locationCache = new HashMap<String, Integer>();

    public Shader(String vertexPath, String fragPath){
        ID = ShaderUtils.load(vertexPath, fragPath);
    }

    public int getUniform(String name){
        if (locationCache.containsKey(name)){
            return locationCache.get(name);
        }
        int result = glGetUniformLocation(ID, name);
        if(result == -1){
            System.err.println("Couldn't find Uniform variable");
        }else{
            locationCache.put(name, result);
        }
        return result;
    }

    public void setUniform1i(String name, int value){
        glUniform1i(getUniform(name), value);
    }


    public void setUniform1f(String name, float value){
        glUniform1f(getUniform(name), value);
    }

    public void setUniform2f(String name, Vector2f vector){
        glUniform2f(getUniform(name), vector.x, vector.y);
    }

    public void setUniform3f(String name, Vector3f vector){
        glUniform3f(getUniform(name), vector.x, vector.y, vector.z);
    }

    public void setUniformMat4f(String name, Matrix4f matrix){
        FloatBuffer floatBuffer = null;
        glUniformMatrix4fv(getUniform(name), false, matrix.get(floatBuffer));
    }

    public void enable() {
        glUseProgram(ID);
        int floatSize = 4;

        int posAttrib = glGetAttribLocation(ID, "position");
        glEnableVertexAttribArray(posAttrib);
        glVertexAttribPointer(posAttrib, 3, GL_FLOAT, false, 6 * floatSize, 0);

        int colAttrib = glGetAttribLocation(ID, "color");
        glEnableVertexAttribArray(colAttrib);
        glVertexAttribPointer(colAttrib, 3, GL_FLOAT, false, 6 * floatSize, 3 * floatSize);
    }

    public void disable() {
        glUseProgram(0);
    }
}
