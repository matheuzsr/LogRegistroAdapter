package com.ufes.exercicio.log;

import com.opencsv.CSVWriter;
import com.ufes.exercicio.model.RegistroLog;

import java.io.FileWriter;
import java.io.IOException;

public class CSVLogAdapter extends LogAdapter {

    private CSVWriter csvWriter;

    public CSVLogAdapter(String fileName) {
        super(fileName + ".csv");
    }

    @Override
    public void escreve(RegistroLog... registrosLog) throws IOException {

        csvWriter = new CSVWriter(new FileWriter(file, true));

        adicionaCabecalho(csvWriter);

        for (RegistroLog registroLog : registrosLog) {
            String[] logString = {
                    registroLog.getTipo(),
                    registroLog.getInformacao(),
                    registroLog.getUsuario(),
                    registroLog.getDataHora()
            };
            csvWriter.writeNext(logString);
        }
        csvWriter.close();
    }

    private void adicionaCabecalho(CSVWriter csvWriter) {
        if (file.length() == 0) {
            csvWriter.writeNext(
                    new String[]{"tipo", "informacao", "usuario", "dataHora"},
                    false
            );
        }
    }

}
