package it.unibo.mvc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigReader {

    private final String path;

    public ConfigReader(final String percorso) {
        this.path = percorso;
    }

    public Map<String,Integer> mapGen(){
        Map<String,Integer> map = new HashMap<>();
        try( BufferedReader reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(path)))){
            List<String> righe = reader.lines().toList();
            String[] rigaDivisa;
            for(String s : righe){
                rigaDivisa = s.split(": ");
                map.put(rigaDivisa[0], Integer.valueOf(rigaDivisa[1]));
            }
        }catch (IOException fe){
            fe.printStackTrace();
        }
        return map;
    }
    
    
}
