package com.ufes.exercicio.log;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.ufes.exercicio.model.RegistroLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONLogAdapter extends LogAdapter {

    public JSONLogAdapter(String fileName) {
        super(fileName + ".json");
    }

    private ObjectMapper mapper;
    private ObjectWriter writer;

    @Override
    public void escreve(RegistroLog... registrosLog) throws IOException {

        mapper = new ObjectMapper();
        writer = mapper.writer(new DefaultPrettyPrinter());
        
        List<RegistroLog> listRegistros =  leRegistrosAnteriores(mapper);

        for (RegistroLog registroLog : registrosLog) {
            listRegistros.add(registroLog);
        }

        writer.writeValue(file, listRegistros);
    }

    private List<RegistroLog> leRegistrosAnteriores(ObjectMapper mapper) {
        List<RegistroLog> listRegistros;
        try {
            listRegistros = mapper.readValue(file, new TypeReference<List<RegistroLog>>() {
            });
        } catch (Exception e) {
            listRegistros = new ArrayList<>();
        }
        return listRegistros;
    }

}
