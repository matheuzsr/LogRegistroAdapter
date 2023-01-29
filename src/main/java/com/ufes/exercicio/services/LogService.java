package com.ufes.exercicio.services;

import com.ufes.exercicio.log.LogAdapter;
import com.ufes.exercicio.model.RegistroLog;
import java.io.IOException;

public class LogService {

    private LogAdapter log;

    public LogService(LogAdapter log) {
        this.log = log;
    }

    public void setLog(LogAdapter log) {
        this.log = log;
    }

    public void escrever(RegistroLog... registerLog) throws IOException {
        this.log.escreve(registerLog);
    }
}
