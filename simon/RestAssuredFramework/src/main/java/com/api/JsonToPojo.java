package com.api;
import com.sun.codemodel.JCodeModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.jsonschema2pojo.*;
import org.jsonschema2pojo.rules.RuleFactory;

import java.io.File;
import java.net.URL;

public class JsonToPojo {
    public static final Logger LOGGER = LogManager.getLogger(JsonToPojo.class);
        public static void convertFromJsonFile(URL jsonURL, File outputDirectory, String packageName, String className){
            try{
                JCodeModel model = new JCodeModel();
                DefaultGenerationConfig config = new DefaultGenerationConfig(){
                    @Override
                    public boolean isGenerateBuilders(){return true;}
                    @Override
                    public SourceType getSourceType(){return SourceType.JSON;}
                };
                SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(config),
                        new SchemaStore()),
                        new SchemaGenerator());
                mapper.generate(model,className,packageName,jsonURL);
                model.build(outputDirectory);

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        public static void convertFromJsonObj(JSONObject json,File outputDirectory, String packageName, String className){
            try{
                JCodeModel model = new JCodeModel();
                DefaultGenerationConfig config = new DefaultGenerationConfig(){
                    @Override
                    public boolean isGenerateBuilders(){return true;}
                    @Override
                    public SourceType getSourceType(){return SourceType.JSON;}
                };
                SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(config),
                        new SchemaStore()),
                        new SchemaGenerator());
                mapper.generate(model,className,packageName,json.toString());
                model.build(outputDirectory);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
}
