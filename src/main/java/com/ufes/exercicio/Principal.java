package com.ufes.exercicio;

import com.ufes.exercicio.log.CSVLogAdapter;
import com.ufes.exercicio.log.JSONLogAdapter;
import com.ufes.exercicio.model.RegistroLog;
import com.ufes.exercicio.services.LogService;

public class Principal {

    public static void main(String[] args) throws Exception {

        try {

            RegistroLog[] registrosLog = new RegistroLog[]{
                new RegistroLog("FALHA", "Falha ao gravar o registro do funcionário", "admin1"),
                new RegistroLog("OPERAÇÃO", "Saldo calculado com sucesso", "balcaoA2"),
                new RegistroLog("INFORMAÇÃO", "Download concluído", "tiuser2")
            };

            CSVLogAdapter loggerToCSV = new CSVLogAdapter("log");
            JSONLogAdapter loggerToJSON = new JSONLogAdapter("log");
            
            
            LogService logService = new LogService(loggerToCSV);
            logService.escrever(registrosLog);


            logService.setLog(loggerToJSON);
            logService.escrever(registrosLog);

            logService.setLog(loggerToCSV);
            logService.escrever(registrosLog);
            

        } catch (Exception e) {
            System.out.println("Falha:\n" + e.getMessage());
        }

    }

}
