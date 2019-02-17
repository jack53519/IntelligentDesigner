package dump;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.lwjgl.opengl.GL20.*;

public class ShaderUtils {
    private ShaderUtils(){}

    public static int load(String vertPath, String fragPath){
        String vert = loadAsString(vertPath);
        String frag = loadAsString(fragPath);
        System.out.println(vert);
        return create(vert, frag);
    }

    public static int create(String vert, String frag){
        int program = glCreateProgram();
        int vertID = glCreateShader(GL_VERTEX_SHADER);
        int fragID = glCreateShader(GL_FRAGMENT_SHADER);
        glShaderSource(vertID, vert);
        glShaderSource(fragID, frag);

        glCompileShader(vertID);
        if (glGetShaderi(vertID, GL_COMPILE_STATUS) == GL_FALSE){
            System.err.println("Could not create Vertex Shader");
            return -1;
        }

        glCompileShader(fragID);
        if (glGetShaderi(fragID, GL_COMPILE_STATUS) == GL_FALSE){
            System.err.println("Could not create Fragmentation Shader");
            return -1;
        }
        String log;
        glGetShaderInfoLog(vertID);
        glAttachShader(program, vertID);
        glAttachShader(program, fragID);
        glLinkProgram(program);
        glValidateProgram(program);

        glDeleteShader(vertID);
        glDeleteShader(fragID);

        return program;
    }

    private static String loadAsString(String path){
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String buffer = "";
            while ((buffer = reader.readLine()) != null){
                result.append(buffer);
            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        return result.toString();
    }
}
